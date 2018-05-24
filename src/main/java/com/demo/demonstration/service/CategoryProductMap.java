package com.demo.demonstration.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.demonstration.model.Product;

@Service
public class CategoryProductMap {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryProductMap.class);
	public CategoryProductMap() {}

	static LinkedHashMap<String, ArrayList<Product>> productList = new LinkedHashMap<>();



	public LinkedHashMap<String, ArrayList<Product>> getProductList() {
		return productList;
	}










	public static void setProductList(LinkedHashMap<String, ArrayList<Product>> productList) {
		CategoryProductMap.productList = productList;
	}










	public void addObj(String category, Product pm) {
		List<Product> list = CategoryProductMap.productList.get(category);
		if(null == list)
		{
			list = new ArrayList<Product>();
			list.add(pm);
			CategoryProductMap.productList.put(category, (ArrayList<Product>) list);
		}
		else
		list.add(pm);	
		
	}
	
	public ArrayList<Product> getProductsByCategory(String category)
	{
		return CategoryProductMap.productList.get(category);
	}


	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> al = new ArrayList<>();
		for(Entry<String, ArrayList<Product>> entry : (CategoryProductMap.productList).entrySet())
		{
			for(Product pm : entry.getValue()) {
				al.add(pm);
				LOGGER.info("Value of Id is {}",pm.getId());
			}
		}
		return al;
	}
	
	public ArrayList<Product> getAllProductsAfterDeleting(int id, String category)
	{
		LinkedHashMap<String, ArrayList<Product>> map = getProductList();
		ArrayList<Product> list = map.get(category);
		Iterator<Product> iterator = list.iterator();
		while(iterator.hasNext()) {
			Product p = iterator.next();
			if(id == p.getId())
			{
				iterator.remove();
			}
		}
		
		return getAllProducts();
	}










	public void addProduct(String name, int productId, String productDescription, String relatedProducts,
			String productCategory, String productImageUrl) {
		Product p = new Product();
		p.setCategory(productCategory);
		p.setDescription(productDescription);
		p.setId(productId);
		p.setImageUrl(productImageUrl);
		p.setName(name);
		String[] t = relatedProducts.split(",");
		List<String> l = new ArrayList<>();
		for(String x : t)
		{
		l.add(x);
		}
		p.setRelatedProducts(l);
		
		List<Product> list = CategoryProductMap.productList.get(productCategory);
		if(null != list)
		{
			list.add(p);
		}
		else
		{
			list= new ArrayList<Product>();
			list.add(p);
			CategoryProductMap.productList.put(productCategory, (ArrayList<Product>) list);
		}
		
		
	}
	
	
	public Product getProductByCategoryAndId(int id, String category) {
		List<Product> list = CategoryProductMap.productList.get(category);
		Product productToReturn = null;
		for(Product p : list) {
			if(p.getId() == id)
			{
				productToReturn = p;
				break;
			}
		}
		
		return productToReturn;
	}
	
	
	
	
}
