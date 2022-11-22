package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.ServiceCost;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ServiceCostService {

  List<ServiceCost> getDeviceServiceCost();

  ServiceCost addDeviceCost(ServiceCost serviceCost);

  Double calculateTotalCost();

}
