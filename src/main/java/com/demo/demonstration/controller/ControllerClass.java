package com.demo.demonstration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.demonstration.model.Product;
import com.demo.demonstration.service.CategoryProductMap;

@Controller
public class ControllerClass {
	
	@Autowired
	CategoryProductMap cpm;


	@RequestMapping("/index")
	public ModelAndView returnHomePage(ModelAndView model)
	{
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping("/login")
	public ModelAndView returnLoginPage(ModelAndView model)
	{
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView returnDashboardPage(ModelAndView model)
	{
		model.setViewName("dashboard");
		return model;
	}
	
	
	@RequestMapping("/addProduct")
	public ModelAndView returnAddProductPage(ModelAndView model)
	{
		model.setViewName("addProduct");
		return model;
	}
	
	@RequestMapping(value="/productAddition", method=RequestMethod.POST)
	public String returnDashboardAfterCreatingProduct(ModelAndView model, @RequestParam String name,
			@RequestParam int productId, @RequestParam String productDescription, @RequestParam String relatedProducts,
			@RequestParam String productCategory, @RequestParam String productImageUrl)
	{
		cpm.addProduct(name, productId, productDescription, relatedProducts, productCategory, productImageUrl);
		return "redirect:/dashboard";
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public ModelAndView returnUpdatePage(ModelAndView model, @RequestParam int cid,
			@RequestParam String category)
	{
		Product p = cpm.getProductByCategoryAndId(cid, category);
		model.addObject("name", p.getName());
		model.addObject("description", p.getDescription());
		model.addObject("id", p.getId());
		
		List<String> list = p.getRelatedProducts();
		StringBuilder sb = new StringBuilder("");
		for (String s : list) {
		    sb.append(s).append(",");
		}
		String s = sb.substring(0, sb.length() - 1);
		model.addObject("relatedProducts", s);
		model.addObject("category", p.getCategory());
		model.addObject("imageUrl", p.getImageUrl());
		
		model.setViewName("updateProduct");
		return model;
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String returnDashboardAfterUpdation(ModelAndView model, @RequestParam String name,
			@RequestParam int productId, @RequestParam String productDescription, @RequestParam String relatedProducts,
			@RequestParam String productCategory, @RequestParam String productImageUrl)
	{
		cpm.getAllProductsAfterDeleting(productId, productCategory);
		cpm.addProduct(name, productId, productDescription, relatedProducts, productCategory, productImageUrl);
		return "redirect:/dashboard";
	}
	
	
	
	@RequestMapping("/error")
	public ModelAndView returnErrorPage(ModelAndView model, @RequestParam String msg)
	{
		String error = msg;
		if(null != error)
			model.addObject("exception", error);
		model.setViewName("error");
		return model;
	}
	
}
