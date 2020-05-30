package com.capgemini.inventorymanagementsystem.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductUtility {
	private static EntityManagerFactory factory = null;

	static {

		factory = Persistence.createEntityManagerFactory("JPA-PU");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
}
