package com.capgemini.inventorymanagementsystem.service;

import java.util.List;

import com.capgemini.inventorymanagementsystem.dto.ProductBean;
import com.capgemini.inventorymanagementsystem.exception.ProductNotFoundException;

public interface ProductService {
	public boolean validateName(String name) throws ProductNotFoundException;

	public boolean validateCost(double salary)throws ProductNotFoundException;

	public int addProduct(ProductBean product)throws ProductNotFoundException;

	public boolean validateUnits(int units) throws ProductNotFoundException;

	public List<ProductBean> getAllProducts()throws ProductNotFoundException;

	public ProductBean getProduct(int id) throws ProductNotFoundException;

}
