package com.ninjaone.backendinterviewproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

  public static final Long ID = 1L;

  @Mock
  private DeviceRepository deviceRepository;

  @InjectMocks
  private DeviceServiceImpl deviceService;

  private Device device;

  private Device updatedDevice;

  @BeforeEach
  void setup() {
    device = new Device(ID, "Mac", "Device");
    updatedDevice = new Device(ID, "Windows", "Device");
  }

  @Test
  void getDeviceData() {
    when(deviceRepository.findById(ID)).thenReturn(Optional.of(device));
    Optional<Device> deviceOptional = deviceService.getDevice(ID);
    Device currentDevice = deviceOptional.orElse(null);
    assert currentDevice != null;
    assertEquals(device.getSystemName(), currentDevice.getSystemName());
    assertEquals(device.getType(), currentDevice.getType());
  }

  @Test
  void saveDeviceData() {
    when(deviceRepository.save(device)).thenReturn(device);
    assertEquals(device, deviceService.addDevice(device));
  }

  @Test
  void updateDeviceData() {
    when(deviceRepository.findById(ID)).thenReturn(Optional.of(device));
    when(deviceRepository.save(device)).thenReturn(device);
    Device resultDevice = deviceService.updateDevice(ID, updatedDevice).get();
    assertEquals(updatedDevice.getSystemName(), resultDevice.getSystemName());
    assertEquals(updatedDevice.getType(), resultDevice.getType());
  }

  @Test
  void deleteDeviceData() {
    doNothing().when(deviceRepository).deleteById(ID);
    deviceService.deleteDevice(ID);
    verify(deviceRepository, times(1)).deleteById(ID);
  }
}
