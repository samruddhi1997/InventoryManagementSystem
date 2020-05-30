package com.capgemini.inventorymanagementsystem.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.PropertyNotFoundException;

import com.capgemini.inventorymanagementsystem.dao.ProductDao;
import com.capgemini.inventorymanagementsystem.dao.ProductDaoImpl;
import com.capgemini.inventorymanagementsystem.dto.ProductBean;
import com.capgemini.inventorymanagementsystem.exception.ProductNotFoundException;
import com.capgemini.inventorymanagementsystem.service.ProductService;
import com.capgemini.inventorymanagementsystem.service.ProductServiceImpl;

public class ProductController {
	public static ProductBean addProduct() {
        int id =0;
		Scanner scanner = null;
		String name = "";
		boolean nameFlag = false;

		ProductService service = new ProductServiceImpl();

		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter Name"); // BR
			name = scanner.nextLine();
			try {
				service.validateName(name);
				nameFlag = true;
			} catch (ProductNotFoundException e) {
				nameFlag = false;
				System.err.println(e.getMessage());
			}
		} while (!nameFlag);

		double cost = 0;
		boolean costFlag = false;

		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter Cost"); // BR
			try {
				cost = scanner.nextDouble();
				service.validateCost(cost);
				costFlag = true;
			} catch (ProductNotFoundException e) {
				costFlag = false;
				System.out.println("cost should contain only digits");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		} while (!costFlag);

		String date = null;
		boolean dateFlag = false;
		LocalDate localDate = null;

		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter Date(yyyy-MM-dd)");
			date = scanner.next();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			try {
				localDate = LocalDate.parse(date, formatter);
				dateFlag = true;
			} catch (DateTimeParseException e) {
				dateFlag = false;
				System.err.println("date should be in the format of yyyy-MM-dd");
			}

		} while (!dateFlag);
		
		

		int units = 0;
		boolean unitsFlag = false;
		
		do {
			scanner = new Scanner(System.in);
			System.out.println("Enter units");
			try {
				units = scanner.nextInt();
				service.validateUnits(units);
				unitsFlag = true;
			} catch (InputMismatchException e) {
				unitsFlag = false;
				System.out.println("units should contain only digits");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		} while (!unitsFlag);

		
		Date mfgDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date expDate =Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		ProductBean product = new ProductBean(null, name, cost, units, mfgDate, expDate);

		return product;
	}

}
