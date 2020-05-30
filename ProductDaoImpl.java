package com.capgemini.inventorymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.capgemini.inventorymanagementsystem.dto.ProductBean;
import com.capgemini.inventorymanagementsystem.exception.ProductNotFoundException;
import com.capgemini.inventorymanagementsystem.utility.ProductUtility;

public class ProductDaoImpl implements ProductDao {

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	
	private Logger logger = Logger.getLogger(ProductDaoImpl.class);
	
	
	@Override
	public int addProduct(ProductBean product) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		logger.info("in add product method");
		factory =ProductUtility.getEntityManagerFactory();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		Integer ProductId = 0;

		transaction.begin();

		try {
			manager.persist(product);
			transaction.commit();

			ProductId = product.getProduct_id();
			logger.info("id generated " + ProductId);

		} catch (PersistenceException e) {
			logger.error(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
			factory.close();
		}

		return ProductId;
	}

	@Override
	public List<ProductBean> getAllProducts() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		logger.info("in get all products method");
		factory = ProductUtility.getEntityManagerFactory();
		logger.info("factory created");
		manager = factory.createEntityManager();
		logger.info("manager created");
		Query query = manager.createQuery(QueryConstant.GET_PRODUCTS);
		return query.getResultList();

		
	}

	
	public ProductBean getProduct(int id) throws ProductNotFoundException  {
		// TODO Auto-generated method stub
		logger.info("in get product method id is: " + id);
		factory = ProductUtility.getEntityManagerFactory();
		manager = factory.createEntityManager();
		ProductBean product = null;

		product = manager.find(ProductBean.class, id);
		logger.debug(product);

		if (product == null) {
			logger.error("no product present");
			throw new ProductNotFoundException("No product present with the given id");
		}

		return product;
	}

	@Override
	public ProductBean getProduct(Integer id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
