package com.demo.demonstration.restController;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.demonstration.model.Product;
import com.demo.demonstration.service.CategoryProductMap;

@RestController
public class DemonstrationRestController {
	
	@Autowired
	CategoryProductMap cpm;

	
	@GetMapping("/productsWithCategory")
	public LinkedHashMap<String, ArrayList<Product>> getProducts() {
		return cpm.getProductList();
	}

	@GetMapping("/products")
	public ArrayList<Product> getAllProducts() {
		return cpm.getAllProducts();
	}
	
	@GetMapping("/products/{category}")
	public ArrayList<Product> getProductsByCategory(@PathVariable String category) {
		
		return cpm.getProductsByCategory(category);
		
		
	}
	
	@RequestMapping("/update")
	public ModelAndView update(ModelAndView model, @RequestParam String msg)
	{
		
		
	    //model.addObject("exception", msg);
		model.setViewName("error");
		return model;
	}
	
	@RequestMapping("/delete")
	public ArrayList<Product> delete(ModelAndView model, @RequestParam int id, @RequestParam String category)
	{
		return cpm.getAllProductsAfterDeleting(id, category);
	}
}
