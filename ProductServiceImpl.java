package com.capgemini.inventorymanagementsystem.service;

import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.inventorymanagementsystem.dao.ProductDao;
import com.capgemini.inventorymanagementsystem.dao.ProductDaoImpl;
import com.capgemini.inventorymanagementsystem.dto.ProductBean;
import com.capgemini.inventorymanagementsystem.exception.ProductNotFoundException;

public class ProductServiceImpl implements ProductService {

	ProductDao pd = new ProductDaoImpl();
	@Override
	public boolean validateName(String name) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		boolean nameFlag = false;
		String nameRegEx = "[A-Z]{1}[A-Za-z\\s]{4,19}";

		if (Pattern.matches(nameRegEx, name)) {
			nameFlag = true;
		} else {
			throw new ProductNotFoundException("First letter should be capital and length must be in the range of 5 to 20");
		}
		return nameFlag;
	
	}

	@Override
	public boolean validateCost(double salary) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		boolean costFlag = false;

		if (salary > 5000) {
			costFlag = true;
		} else {
			throw new ProductNotFoundException("cost should be greater than 5000");
		}

		return costFlag;

	}

	@Override
	public int addProduct(ProductBean product) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return pd.addProduct(product);

	}

	@Override
	public boolean validateUnits(int units) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		boolean unitsFlag = false;

		if (units > 2) {
			unitsFlag = true;
		} else {
			throw new ProductNotFoundException("units should be greater than 2");
		}

		return unitsFlag;

	}

	@Override
	public List<ProductBean> getAllProducts() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return pd.getAllProducts();
	}

	@Override
	public ProductBean getProduct(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return pd.getProduct(id);

	}
	}
