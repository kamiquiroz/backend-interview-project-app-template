package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

  Optional<Customer> getCustomer(Long id);

  Customer addCustomer(Customer customer);

  Optional<Customer> updateCustomer(Long id, Customer customer);

  void deleteCustomer(Long id);

  List<Customer> findAllCustomers();

  Double getMonthlyCostByCustomerName(String customerName);
}
