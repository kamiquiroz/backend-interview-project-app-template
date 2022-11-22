package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.Device;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.stereotype.Service;

@Service
public interface DeviceService {

  Optional<Device> getDevice(Long id);

  Device addDevice(Device device);

  Optional<Device> updateDevice(Long id, Device device);

  void deleteDevice(Long id);

  List<Device> getAllDevices();
}
