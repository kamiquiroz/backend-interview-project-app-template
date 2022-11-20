package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.CustomerRepository;
import com.ninjaone.backendinterviewproject.model.Customer;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository customerRepository;

  @Autowired
  public void setCustomerRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public Optional<Customer> getCustomer(Long id) {
    return customerRepository.findById(id);
  }

  @Override
  public Customer addCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public Optional<Customer> updateCustomer(Long id, Customer customer) {
    Optional<Customer> currentCustomerOptional = customerRepository.findById(id);
    if (currentCustomerOptional.isPresent()) {
      Customer currentCustomer = currentCustomerOptional.get();
      currentCustomer.setName(customer.getName());
      return Optional.of(customerRepository.save(currentCustomer));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }
}
