package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

  private DeviceRepository deviceRepository;

  @Autowired
  public void setDeviceRepository(
      DeviceRepository deviceRepository) {
    this.deviceRepository = deviceRepository;
  }

  @Override
  public Optional<Device> getDevice(Long id) {
    return deviceRepository.findById(id);
  }

  @Override
  public Device addDevice(Device device) {
    return deviceRepository.save(device);
  }

  @Override
  public Optional<Device> updateDevice(Long id, Device device) {
    Optional<Device> currentDeviceOptional = deviceRepository.findById(id);
    if (currentDeviceOptional.isPresent()) {
      Device currentDevice = currentDeviceOptional.get();
      currentDevice.setSystemName(device.getSystemName());
      currentDevice.setType(device.getType());
      return Optional.of(deviceRepository.save(currentDevice));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteDevice(Long id) {
    deviceRepository.deleteById(id);
  }

  @Override
  public List<Device> getAllDevices() {
    return (List<Device>) deviceRepository.findAll();
  }
}
