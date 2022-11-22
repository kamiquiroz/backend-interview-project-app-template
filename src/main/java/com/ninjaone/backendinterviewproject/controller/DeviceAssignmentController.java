package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.api.DeviceAssignmentApi;
import com.ninjaone.backendinterviewproject.model.DeviceAssignment;
import com.ninjaone.backendinterviewproject.service.DeviceAssignmentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceAssignmentController implements DeviceAssignmentApi {

  private DeviceAssignmentService deviceAssignmentService;

  @Autowired
  public void setDeviceAssignmentService(DeviceAssignmentService deviceAssignmentService) {
    this.deviceAssignmentService = deviceAssignmentService;
  }

  public ResponseEntity<DeviceAssignment> findDeviceAssignment(@PathVariable Long id) {
    return deviceAssignmentService.getDeviceAssignment(id).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Override
  public List<DeviceAssignment> findAllDeviceAssignments() {
    return deviceAssignmentService.getAllDeviceAssignments();
  }

  @ResponseStatus(HttpStatus.CREATED)
  public DeviceAssignment createDeviceAssignment(@RequestBody DeviceAssignment deviceAssignment) {
    return deviceAssignmentService.addDeviceAssignment(deviceAssignment);
  }

  public ResponseEntity<DeviceAssignment> updateDeviceAssignment(@PathVariable Long id,
      @RequestBody DeviceAssignment deviceAssignment) {
    Optional<DeviceAssignment> deviceAssignmentOptional = deviceAssignmentService.updateDeviceAssignment(
        id, deviceAssignment);
    return deviceAssignmentOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  public void deleteDeviceAssignment(@PathVariable Long id) {
    deviceAssignmentService.deleteDeviceAssignment(id);
  }
}
