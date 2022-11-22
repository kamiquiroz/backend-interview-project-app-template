package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceCostRepository;
import com.ninjaone.backendinterviewproject.model.ServiceCost;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCostServiceImpl implements ServiceCostService {

  private ServiceCostRepository serviceCostRepository;

  @Autowired
  public void setDeviceServiceCostRepository(
      ServiceCostRepository serviceCostRepository) {
    this.serviceCostRepository = serviceCostRepository;
  }

  @Override
  public List<ServiceCost> getDeviceServiceCost() {
    return (List<ServiceCost>) serviceCostRepository.findAll();
  }

  @Override
  public ServiceCost addDeviceCost(ServiceCost serviceCost) {
    return serviceCostRepository.save(serviceCost);
  }

  @Override
  public Double calculateTotalCost() {
    return null;
  }

  @Override
  public Optional<ServiceCost> getServiceCostById(Long id) {
    return serviceCostRepository.findById(id);
  }

  @Override
  public ServiceCost addServiceCost(ServiceCost serviceCost) {
    return serviceCostRepository.save(serviceCost);
  }

  @Override
  public Optional<ServiceCost> updateServiceCost(Long id, ServiceCost serviceCost) {
    Optional<ServiceCost> currentSolutionOptional = serviceCostRepository.findById(id);
    if (currentSolutionOptional.isPresent()) {
      ServiceCost currentServiceCost = currentSolutionOptional.get();
      currentServiceCost.setService(serviceCost.getService());
      currentServiceCost.setCost(serviceCost.getCost());
      currentServiceCost.setType(serviceCost.getType());
      return Optional.of(serviceCostRepository.save(currentServiceCost));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteServiceCost(Long id) {
    serviceCostRepository.deleteById(id);
  }

  @Override
  public List<ServiceCost> getAllServiceCost() {
    return (List<ServiceCost>) serviceCostRepository.findAll();
  }


}
