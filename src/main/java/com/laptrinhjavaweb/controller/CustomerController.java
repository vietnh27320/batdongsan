package com.laptrinhjavaweb.controller;

import java.util.List;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.impl.CustomerService;

public class CustomerController {
	public static void main(String[] args) {
		ICustomerService customerService = new CustomerService();
		List<CustomerDTO> results = customerService.findAll();
		for (CustomerDTO item : results) {
			System.out.println("Họ tên: " + item.getFullName());
			System.out.println("SĐT: " + item.getPhone());
			System.out.println("-------------------");
		}
	}
}
