package com.example.bai2;

import com.example.bai2.controllers.CustomerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bai2Application {
	static CustomerController customerController;

	public Bai2Application(CustomerController customerController) {
		this.customerController = customerController;
	}

	public static void main(String[] args) {
		SpringApplication.run(Bai2Application.class, args);
		customerController.customerOrderAndPay();
	}
}
