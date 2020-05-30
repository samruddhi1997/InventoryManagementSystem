package com.capgemini.inventorymanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.inventorymanagementsystem.dto.ProductBean;
import com.capgemini.inventorymanagementsystem.exception.ProductNotFoundException;
import com.capgemini.inventorymanagementsystem.service.ProductService;
import com.capgemini.inventorymanagementsystem.service.ProductServiceImpl;

public class Controller {
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/resource/log4j.properties");
		Scanner scanner = null;
		String reChoice = "";

		do {
			// scanner = new Scanner(System.in);
			System.out.println(" *** Welcome to Product Management System *** ");
			System.out.println("1.Add Product");
			System.out.println("2.Update Product");
			System.out.println("3.Remove Product");
			System.out.println("4.Get Product");
			System.out.println("5.Get All Product");
			System.out.println("6.Exit");

			int choice = 0;
			boolean choiceFlag = false;
			ProductService service = new ProductServiceImpl();

			do {
				scanner = new Scanner(System.in);
				System.out.println("select your choice:");

				try {
					choice = scanner.nextInt();
					choiceFlag = true;

					switch (choice) {
					case 1:

						ProductBean product = ProductController.addProduct();
						try {
							int productId = service.addProduct(product);
							System.out.println("product inserted with the given id: " + productId);
						} catch (ProductNotFoundException e) {
							System.err.println(e.getMessage());
						}

						break;

					case 2:
						break;

					case 4:

						System.out.println("Enter id");
						int id = scanner.nextInt();

						ProductBean productInfo;
						try {
							productInfo = service.getProduct(id);
							System.out.println(productInfo);
						} catch (ProductNotFoundException e1) {
							System.err.println(e1.getMessage());
						}

						break;

					case 5:
						try {
							List<ProductBean> products = service.getAllProducts();

							for (ProductBean data : products) {
								System.out.println(data);
							}

						} catch (ProductNotFoundException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 6:
						System.out.println("thank you");
						System.exit(0);
					default:
						choiceFlag = false;
						System.out.println("Input should be in the range of 1-6");
						break;
					}

				} catch (InputMismatchException e) {
					choiceFlag = false;
					System.err.println("Input should contain only digits");
				}
			} while (!choiceFlag);

			System.out.println("do you want to continue? (yes/no)");
			reChoice = scanner.next();
		} while (reChoice.equalsIgnoreCase("yes"));

		scanner.close();
	}

	}

