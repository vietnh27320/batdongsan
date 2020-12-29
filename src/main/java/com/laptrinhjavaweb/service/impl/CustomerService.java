package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.ICustomerRepository;
import com.laptrinhjavaweb.repository.impl.CustomerRepository;
import com.laptrinhjavaweb.service.ICustomerService;

public class CustomerService implements ICustomerService {
	private ICustomerRepository customerRepository = new CustomerRepository();

	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerDTO> results = new ArrayList<>();
//		List<CustomerEntity> customerEntities = customerRepository.findAll();
//		for (CustomerEntity item : customerEntities) {
//			CustomerDTO customerDTO = new CustomerDTO();
//			customerDTO.setFullName(item.getFullName());
//			customerDTO.setPhone(item.getPhone());
//			results.add(customerDTO);
//		}
		return results;
	}

}
