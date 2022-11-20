package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.DeviceAssignment;
import com.ninjaone.backendinterviewproject.service.DeviceAssignmentService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device-assignment")
public class DeviceAssignmentController {

  private DeviceAssignmentService deviceAssignmentService;

  @Autowired
  public void setDeviceAssignmentService(DeviceAssignmentService deviceAssignmentService) {
    this.deviceAssignmentService = deviceAssignmentService;
  }

  @GetMapping("/{id}")
  public Optional<DeviceAssignment> findDeviceAssignment(@PathVariable Long id) {
    return deviceAssignmentService.getDeviceAssignment(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public DeviceAssignment createDeviceAssignment(@RequestBody DeviceAssignment deviceAssignment) {
    return deviceAssignmentService.addDeviceAssignment(deviceAssignment);
  }

  @PutMapping("/{id}")
  public ResponseEntity<DeviceAssignment> updateDeviceAssignment(@PathVariable Long id, @RequestBody DeviceAssignment deviceAssignment) {
    Optional<DeviceAssignment> deviceAssignmentOptional = deviceAssignmentService.updateDeviceAssignment(id, deviceAssignment);
    return deviceAssignmentOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public void deleteDeviceAssignment(@PathVariable Long id) {
    deviceAssignmentService.deleteDeviceAssignment(id);
  }
}
