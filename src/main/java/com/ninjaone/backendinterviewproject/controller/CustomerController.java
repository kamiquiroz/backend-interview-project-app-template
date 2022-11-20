package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Customer;
import com.ninjaone.backendinterviewproject.service.CustomerService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private CustomerService customerService;

  @Autowired
  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{id}")
  public Optional<Customer> findCustomer(@PathVariable Long id) {
    return customerService.getCustomer(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerService.addCustomer(customer);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
      @RequestBody Customer customer) {
    Optional<Customer> customerOptional = customerService.updateCustomer(id, customer);
    return customerOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }

}
