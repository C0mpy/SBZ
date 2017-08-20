package app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dto.ArticleCategoryDTO;
import app.dto.LimitDTO;
import app.dto.MessageDTO;
import app.dto.SaleDTO;
import app.models.Article;
import app.models.ArticleCategory;
import app.models.Category;
import app.models.Receipt;
import app.models.Sale;
import app.models.SpendingLimit;
import app.repository.ArticleCategoryRepository;
import app.repository.CategoryRepository;
import app.repository.SaleRepository;
import app.repository.SpendingLimitRepository;

@RestController
@RequestMapping(value = "/api/manager")
public class ManagerController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SpendingLimitRepository spendingLimitRepository;
	
	@Autowired
	private ArticleCategoryRepository articleCategoryRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@RequestMapping(value = "/getUserCategories", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUserCategories() {
		ArrayList<Category> categories = (ArrayList<Category>) categoryRepository.findAll();
		
		return new ResponseEntity(categories, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/saveLimits", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity saveLimits(@RequestBody ArrayList<LimitDTO> limits) {
		
		ArrayList<SpendingLimit> saveLimits = new ArrayList<SpendingLimit>();
		for(LimitDTO l : limits)
			saveLimits.add(new SpendingLimit(l));
		
		spendingLimitRepository.save(saveLimits);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getArticleCategories", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getArticleCategories() {
		ArrayList<ArticleCategory> categories = (ArrayList<ArticleCategory>) articleCategoryRepository.findAll();
		
		return new ResponseEntity(categories, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/addArticleCategory", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity addArticleCategory(@RequestBody ArticleCategoryDTO articleCategoryDTO) {
		ArticleCategory parent = articleCategoryRepository.findOneByName("Goods of Broad Consumption");
		
		ArticleCategory category = new ArticleCategory(articleCategoryDTO.getCode(), articleCategoryDTO.getName(), articleCategoryDTO.getMaxDiscount(), 
				new ArrayList<Article>(), parent, new ArrayList<Sale>());
		
		articleCategoryRepository.save(category);
		return new ResponseEntity(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/saveArticleCategories", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity saveArticleCategories(@RequestBody ArrayList<ArticleCategoryDTO> categories) {
		for(ArticleCategoryDTO acdto : categories) {
			ArticleCategory ac = articleCategoryRepository.findOneByCode(acdto.getCode());
			ac.setName(acdto.getName());
			ac.setMaxDiscount(acdto.getMaxDiscount());
			articleCategoryRepository.save(ac);
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addSale", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity addSale(@RequestBody SaleDTO saleDTO) {
		ArrayList<ArticleCategory> categories = new ArrayList<ArticleCategory>();
		
		for(String c : saleDTO.getCategories()) {
			categories.add(articleCategoryRepository.findOneByCode(c));
		}
		
		Sale sale = new Sale(saleDTO.getCode(), saleDTO.getName(), saleDTO.getFromDate(), saleDTO.getToDate(), saleDTO.getDiscount(), categories);
		saleRepository.save(sale);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getSales", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getSales() {
		ArrayList<Sale> sales = (ArrayList<Sale>) saleRepository.findAll();
		
		return new ResponseEntity(sales, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/saveSales", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity saveSales(@RequestBody ArrayList<SaleDTO> sales) {
		for(SaleDTO sdto : sales) {
			Sale sale = saleRepository.findOneByCode(sdto.getCode());
			sale.setName(sdto.getName());
			sale.setFromDate(sdto.getFromDate());
			sale.setToDate(sdto.getToDate());
			sale.setDiscount(sdto.getDiscount());
			saleRepository.save(sale);
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}

}
