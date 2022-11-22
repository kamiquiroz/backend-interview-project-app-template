package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.ServiceCost;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface ServiceCostService {

  List<ServiceCost> getDeviceServiceCost();

  ServiceCost addDeviceCost(ServiceCost serviceCost);

  Double calculateTotalCost();

  Optional<ServiceCost> getServiceCostById(Long id);

  ServiceCost addServiceCost(ServiceCost serviceCost);

  Optional<ServiceCost> updateServiceCost(Long id, ServiceCost serviceCost);

  void deleteServiceCost(Long id);

  List<ServiceCost> getAllServiceCost();
}
