package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.CustomerRepository;
import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.database.ServiceCostRepository;
import com.ninjaone.backendinterviewproject.model.Customer;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.ServiceCost;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository customerRepository;
  private DeviceRepository deviceRepository;

  private ServiceCostRepository serviceCostRepository;

  @Autowired
  public void setCustomerRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Autowired
  public void setDeviceRepository(
      DeviceRepository deviceRepository) {
    this.deviceRepository = deviceRepository;
  }

  @Autowired
  public void setServiceCostRepository(
      ServiceCostRepository serviceCostRepository) {
    this.serviceCostRepository = serviceCostRepository;
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
      currentCustomer.setCustomerName(customer.getCustomerName());
      return Optional.of(customerRepository.save(currentCustomer));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }

  @Override
  public List<Customer> findAllCustomers() {
    return (List<Customer>) customerRepository.findAll();
  }

  @Override
  public Double getMonthlyCostByCustomerName(String customerName) {
    Customer customer = customerRepository.getCustomerByCustomerName(customerName);
    List<Device> customerDevices = deviceRepository.getCustomerDevices(customer.getId());
    Double totalDeviceCost = customerDevices.stream().mapToDouble(Device::getCost).sum();

    Double totalServiceCost = 0D;
    for (Device device : customerDevices) {
      totalServiceCost += serviceCostRepository.getAllServiceCostByDevice(
          device.getId(), device.getType().getTypeName());
    }

    return totalDeviceCost + totalServiceCost;
  }
}
