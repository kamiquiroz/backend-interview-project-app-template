package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.service.DeviceService;
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
@RequestMapping("/devices")
public class DeviceController {

  private DeviceService deviceService;

  @Autowired
  public void setDeviceService(DeviceService deviceService) {
    this.deviceService = deviceService;
  }

  @GetMapping("/{id}")
  public Optional<Device> findDevice(@PathVariable Long id) {
    return deviceService.getDevice(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Device createDevice(@RequestBody Device device) {
    return deviceService.addDevice(device);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device device) {
    Optional<Device> deviceOptional = deviceService.updateDevice(id, device);
    return deviceOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public void deleteDevice(@PathVariable Long id) {
    deviceService.deleteDevice(id);
  }

}
