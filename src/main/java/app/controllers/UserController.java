package app.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dto.FilterDTO;
import app.dto.LoginDTO;
import app.dto.PageableDTO;
import app.dto.RegisterDTO;
import app.models.Article;
import app.models.ArticleCategory;
import app.models.Category;
import app.models.Customer;
import app.models.Manager;
import app.models.Receipt;
import app.models.Sale;
import app.models.User;
import app.repository.ArticleCategoryRepository;
import app.repository.ArticleRepository;
import app.repository.CategoryRepository;
import app.repository.SaleRepository;
import app.repository.UserRepository;
import app.util.ConfigData;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private ArticleCategoryRepository articleCategoryRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ConfigData configData;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
		
		User user = repository.findOneByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
		Map<String, Object> data = new HashMap<String, Object>();
		if(user == null)
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		else {
			data.put("user", user);
			if(user instanceof Customer)
				data.put("type", "Customer");
			else if (user instanceof Manager)
				data.put("type", "Manager");
			else
				data.put("type", "Salesman");
			return new ResponseEntity(data, HttpStatus.OK);
		}
        
    }
	
	@RequestMapping(value = "/register")
	public ResponseEntity register(@RequestBody RegisterDTO registerDTO) throws IOException {
		
		User check = repository.findOneByUsername(registerDTO.getUsername());
		if (check != null) 
			return new ResponseEntity("User already registered with the same username!", HttpStatus.BAD_REQUEST);
		else {
			Category category = categoryRepository.findOneByName("NORMAL");
			Customer c = new Customer(registerDTO.getUsername(), registerDTO.getPassword(), registerDTO.getFirstName(), registerDTO.getLastName(), 
					registerDTO.getPicture(), registerDTO.getAddress(), category, new ArrayList<Receipt>());
			repository.save(c);
			return new ResponseEntity(c, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value = "/articles", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	public ResponseEntity getArticles(@RequestBody FilterDTO filter) {		
		
		if(filter.getCode() != null)
			if(filter.getCode().equals(""))
				filter.setCode(null);
		
		if(filter.getName() != null)
			if(filter.getName().equals(""))
				filter.setName(null);
		
		if(filter.getMinPrice() == null)
			filter.setMinPrice(0.0);
		
		if(filter.getMaxPrice() == null)
			 filter.setMaxPrice(0.0);
		
		if(filter.getStatus() != null)
			if(filter.getStatus().equals(""))
				filter.setStatus(null);
		
		Page<Article> page = articleRepository.findArticle(filter.getCode(), filter.getName(), filter.getMinPrice(), filter.getMaxPrice(),
				filter.getCategory(), filter.getStatus(), new PageRequest(filter.getPage(), filter.getCount()));
		List<Article> articles = page.getContent();
		return new ResponseEntity(articles, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/articles/count", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity countArticles(@RequestBody FilterDTO filter) {
		
		if(filter.getCode() != null)
			if(filter.getCode().equals(""))
				filter.setCode(null);
		
		if(filter.getName() != null)
			if(filter.getName().equals(""))
				filter.setName(null);
		
		if(filter.getMinPrice() == null)
			filter.setMinPrice(0.0);
		
		if(filter.getMaxPrice() == null)
			 filter.setMaxPrice(0.0);
		
		if(filter.getStatus() != null)
			if(filter.getStatus().equals(""))
				filter.setStatus(null);
		
		return new ResponseEntity(articleRepository.countArticle(filter.getCode(), filter.getName(), filter.getMinPrice(), filter.getMaxPrice(), filter.getCategory(), filter.getStatus()).size(), HttpStatus.OK);
		
	}
}
