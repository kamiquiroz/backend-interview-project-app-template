package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.DeviceServiceCost;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface DeviceServiceCostService {

  List<DeviceServiceCost> getDeviceServiceCost();

  DeviceServiceCost addDeviceCost(DeviceServiceCost deviceServiceCost);

  Double calculateTotalCost();

}
