package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceServiceCostRepository;
import com.ninjaone.backendinterviewproject.model.DeviceServiceCost;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceCostServiceImpl implements DeviceServiceCostService {

  private DeviceServiceCostRepository deviceServiceCostRepository;

  @Autowired
  public void setDeviceServiceCostRepository(
      DeviceServiceCostRepository deviceServiceCostRepository) {
    this.deviceServiceCostRepository = deviceServiceCostRepository;
  }

  @Override
  public List<DeviceServiceCost> getDeviceServiceCost() {
    return (List<DeviceServiceCost>) deviceServiceCostRepository.findAll();
  }

  @Override
  public DeviceServiceCost addDeviceCost(DeviceServiceCost deviceServiceCost) {
    return deviceServiceCostRepository.save(deviceServiceCost);
  }

  @Override
  public Double calculateTotalCost() {
    return null;
  }
}
