package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceAssignmentRepository;
import com.ninjaone.backendinterviewproject.model.DeviceAssignment;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class DeviceAssignmentServiceImpl implements DeviceAssignmentService{

  private DeviceAssignmentRepository deviceAssignmentRepository;

  @Autowired
  public void setDeviceAssignmentRepository(
      DeviceAssignmentRepository deviceAssignmentRepository) {
    this.deviceAssignmentRepository = deviceAssignmentRepository;
  }
  @Override
  public Optional<DeviceAssignment> getDeviceAssignment(Long id) {
    return deviceAssignmentRepository.findById(id);
  }

  @Override
  public DeviceAssignment addDeviceAssignment(DeviceAssignment deviceAssignment) {
    return deviceAssignmentRepository.save(deviceAssignment);
  }

  @Override
  public Optional<DeviceAssignment> updateDeviceAssignment(Long id, DeviceAssignment deviceAssignment) {
    Optional<DeviceAssignment> currentDeviceAssignmentOptional = deviceAssignmentRepository.findById(id);
    if (currentDeviceAssignmentOptional.isPresent()) {
      DeviceAssignment currentDeviceAssignment = currentDeviceAssignmentOptional.get();
      currentDeviceAssignment.setDevice(deviceAssignment.getDevice());
      currentDeviceAssignment.setCustomer(deviceAssignment.getCustomer());
      currentDeviceAssignment.setDate(deviceAssignment.getDate());
      return Optional.of(deviceAssignmentRepository.save(currentDeviceAssignment));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteDeviceAssignment(Long id) {
    deviceAssignmentRepository.deleteById(id);
  }
}