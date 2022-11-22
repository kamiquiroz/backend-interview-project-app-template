package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceCostRepository;
import com.ninjaone.backendinterviewproject.model.ServiceCost;
import java.util.List;
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
}
