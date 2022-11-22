package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.api.DeviceApi;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController implements DeviceApi {

  private DeviceService deviceService;

  @Autowired
  public void setDeviceService(DeviceService deviceService) {
    this.deviceService = deviceService;
  }

  public ResponseEntity<Device> findDevice(@PathVariable Long id) {
    return deviceService.getDevice(id).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Override
  public List<Device> findAllDevices() {
    return deviceService.getAllDevices();
  }

  @ResponseStatus(HttpStatus.CREATED)
  public Device createDevice(@RequestBody Device device) {
    return deviceService.addDevice(device);
  }

  public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device device) {
    Optional<Device> deviceOptional = deviceService.updateDevice(id, device);
    return deviceOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  public void deleteDevice(@PathVariable Long id) {
    deviceService.deleteDevice(id);
  }

}
