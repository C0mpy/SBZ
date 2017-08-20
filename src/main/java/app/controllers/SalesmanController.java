package app.controllers;

import java.util.ArrayList;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dto.ItemDTO;
import app.dto.MessageDTO;
import app.dto.OrderSupplyDTO;
import app.models.Article;
import app.models.Item;
import app.models.Receipt;
import app.repository.ArticleRepository;
import app.repository.ReceiptRepository;


@RestController
@RequestMapping(value = "/api/salesman")
public class SalesmanController {
	

	@Autowired
	private KieContainer kieContainer;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/checkSupplies", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity checkSupplies() {
		
		ArrayList<Article> articles = articleRepository.findAllByStatus("ACTIVE");
		KieSession kieSession = kieContainer.newKieSession("ShopSession");
		for(Article a : articles)
			kieSession.insert(a);
		kieSession.setGlobal("result", new ArrayList<Article>());
		
		kieSession.getAgenda().getAgendaGroup("supplies").setFocus();
		kieSession.fireAllRules();	
		
		ArrayList<Article> articlesToOrder = (ArrayList<Article>) kieSession.getGlobal("result");
		articleRepository.save(articlesToOrder);
		kieSession.dispose();
		return new ResponseEntity(articlesToOrder, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/orderArticles", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity orderArticles(@RequestBody OrderSupplyDTO order) {
		Article article = articleRepository.findOneByCode(order.getCode());
		int amount = article.getCount();
		amount += order.getAmount();
		article.setCount(amount);
		article.setOrdered(false);
		
		articleRepository.save(article);
		return new ResponseEntity(article, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/receiptState", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity receiptState(@RequestBody MessageDTO messageDTO) {
		ArrayList<Receipt> receipts = receiptRepository.findAllByState(messageDTO.getMessage());
		
		return new ResponseEntity(receipts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/accept", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity accept(@RequestBody MessageDTO messageDTO) {
		Receipt receipt = receiptRepository.findOneByCode(messageDTO.getMessage());
		KieSession kieSession = kieContainer.newKieSession("ShopSession");
		kieSession.insert(receipt);
		kieSession.setGlobal("result", new ArrayList<Item>());
		
		kieSession.getAgenda().getAgendaGroup("receipt-status").setFocus();
		kieSession.fireAllRules();	
		
		ArrayList<Item> lowNumber = (ArrayList<Item>) kieSession.getGlobal("result");
		kieSession.dispose();
		
		if(lowNumber.size() == 0) {
			receipt.setState("ACCEPTED");
			
			int pointsToAdd = receipt.getEarnedPoints();
			int customersPoints = receipt.getCustomer().getPoints();
			customersPoints += pointsToAdd;
			receipt.getCustomer().setPoints(customersPoints);
			
			refreshAmounts(receipt);
			
			receiptRepository.save(receipt);
		}
		
		return new ResponseEntity(lowNumber, HttpStatus.OK);
	}
	
	public void refreshAmounts(Receipt receipt) {
		
		for(Item i : receipt.getItems()) {
			int currentAmount = i.getArticle().getCount();
			int newAmount = currentAmount - i.getAmount();
			i.getArticle().setCount(newAmount);
		}
	}
	
	@RequestMapping(value = "/reject", method = RequestMethod.POST, consumes = "application/json")
	public void reject(@RequestBody MessageDTO messageDTO) {
		Receipt receipt = receiptRepository.findOneByCode(messageDTO.getMessage());
		receipt.setState("REJECTED");
		receiptRepository.save(receipt);
	}

}
