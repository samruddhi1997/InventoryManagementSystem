package com.capgemini.inventorymanagementsystem.dao;

import java.util.List;

import com.capgemini.inventorymanagementsystem.dto.ProductBean;
import com.capgemini.inventorymanagementsystem.exception.ProductNotFoundException;


public interface ProductDao {
	public int addProduct(ProductBean product) throws ProductNotFoundException;

	public List<ProductBean> getAllProducts() throws ProductNotFoundException ;

	public ProductBean getProduct(Integer id) throws ProductNotFoundException;

}
