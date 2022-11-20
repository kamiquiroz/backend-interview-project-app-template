package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.DeviceAssignment;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface DeviceAssignmentService {

  Optional<DeviceAssignment> getDeviceAssignment(Long id);

  DeviceAssignment addDeviceAssignment(DeviceAssignment deviceAssignment);

  Optional<DeviceAssignment> updateDeviceAssignment(Long id, DeviceAssignment deviceAssignment);

  void deleteDeviceAssignment(Long id);

}
