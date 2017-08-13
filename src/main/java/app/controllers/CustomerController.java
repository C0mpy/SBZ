package app.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dto.ItemDTO;
import app.dto.MessageDTO;
import app.dto.ReceiptDTO;
import app.models.Article;
import app.models.ArticleCategory;
import app.models.Customer;
import app.models.Item;
import app.models.Receipt;
import app.repository.ArticleCategoryRepository;
import app.repository.ArticleRepository;
import app.repository.ItemRepository;
import app.repository.ReceiptRepository;
import app.repository.UserRepository;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private KieContainer kieContainer;
	
	@Autowired
	private ArticleCategoryRepository articleCategoryRepository;
	
	@RequestMapping(value = "/{customerId}/findReceipts", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity findReceipts(@PathVariable Long customerId) {
		
		ArrayList<Receipt> receipts = receiptRepository.findAllByCustomerId(customerId);
		return new ResponseEntity(receipts, HttpStatus.OK);
		
    }
	
	@RequestMapping(value = "/{customerId}/getOldReceipt", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getOldReceipt(@PathVariable Long customerId) {
		
		Receipt receipt = receiptRepository.findOneByCustomerIdAndState(customerId, "NEW");
		return new ResponseEntity(receipt, HttpStatus.OK);
		
    }
	
	// create a new receipt if you selected the first item for the cart, and there is no old receipt
	@RequestMapping(value = "/createNewReceipt", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity createNewReceipt(@RequestBody MessageDTO messageDTO) {
		Customer customer = (Customer) userRepository.findOneCustomerById(Long.valueOf(messageDTO.getMessage()));
		Receipt receipt = new Receipt(customer);
		
		receipt = receiptRepository.save(receipt);
		return new ResponseEntity(receipt, HttpStatus.OK);
    }
	
	
	// adds an item to the receipt and returns receipt containing all of its items
	@RequestMapping(value = "/addItem", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity addItem(@RequestBody ItemDTO itemDTO) {
		
		Receipt receipt = receiptRepository.findOneByCode(itemDTO.getReceipt());
		Article article = articleRepository.findOneByCode(itemDTO.getArticle());
		
		Item item = null;
		
		// if receipt already contains the same item you are trying to buy, just add ammount to the existing receipt item
		for(Item i : receipt.getItems()) {
			if(i.getArticle().getCode().equals(article.getCode())) {
				receipt.getItems().remove(i);
				
				int currentAmmount = i.getAmount();
				currentAmmount += itemDTO.getAmmount();
				i.setAmount(currentAmmount);
				
				i.setTotalPrice(currentAmmount * i.getArticlePrice());
				
				item = i;
				break;
			}
		}
		// if this is the first occurance of the item in the receipt, add item
		if(item == null)
			item = new Item(article, itemDTO.getArticlePrice(), itemDTO.getAmmount(), itemDTO.getTotalPrice());
		
		itemRepository.save(item);

		receipt.getItems().add(item);
		receipt.setTotalPrice(getNewTotalPrice(receipt));
		
		receiptRepository.save(receipt);
		receipt = receiptRepository.findOneByCode(receipt.getCode());
		
		return new ResponseEntity(receipt, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/calculateDiscounts", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity calculateDiscounts(@RequestBody MessageDTO messageDTO) {
		Receipt receipt = receiptRepository.findOneByCode(messageDTO.getMessage());
		List<Receipt> receipts = receiptRepository.findAllByCustomerId(receipt.getCustomer().getId());
		receipt.getCustomer().setReceipts(receipts);
		KieSession kieSession = kieContainer.newKieSession("ShopSession");
		kieSession.insert(receipt);
		
		kieSession.setGlobal("currentDate", new Date());
		kieSession.getAgenda().getAgendaGroup("discounts").setFocus();
		kieSession.fireAllRules();
		System.out.println(receipt);
		return new ResponseEntity(HttpStatus.OK);
	}

	private Double getNewTotalPrice(Receipt receipt) {
		
		double sum = 0;
		
		for(Item i : receipt.getItems()) {
			sum += i.getTotalPrice();
		}
		
		return sum;
	}

}
