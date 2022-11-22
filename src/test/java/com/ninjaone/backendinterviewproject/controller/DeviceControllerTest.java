package com.ninjaone.backendinterviewproject.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninjaone.backendinterviewproject.BackendInterviewProjectApplication;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.Type;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import com.ninjaone.backendinterviewproject.service.DeviceServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BackendInterviewProjectApplication.class})
@WebMvcTest(DeviceController.class)
@AutoConfigureMockMvc
@AutoConfigureDataJpa
public class DeviceControllerTest {

  public static final Long ID = 1L;

  @MockBean
  private DeviceService deviceService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  private Device device;

  private Device updatedDevice;

  @BeforeEach
  void setup() {
    device = new Device();
    device.setSystemName("Mac");
    device.setId(ID);
    device.setType(new Type());
    device.setCost(4D);
    updatedDevice = new Device();
    updatedDevice.setSystemName("Windows");
    updatedDevice.setId(ID);
    updatedDevice.setType(new Type());
    updatedDevice.setCost(5D);
  }

  @Test
  void getDeviceData() throws Exception {
    when(deviceService.getDevice(ID)).thenReturn(Optional.of(device));

    mockMvc.perform(get("/devices/" + ID))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().string(objectMapper.writeValueAsString(device)));
  }

  @Test
  void saveDeviceData() throws Exception {
    when(deviceService.addDevice(any())).thenReturn(device);

    String deviceString = objectMapper.writeValueAsString(device);

    mockMvc.perform(post("/devices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(deviceString))
        .andExpect(status().isCreated())
        .andExpect(content().string(deviceString));
  }

  @Test
  void updateDeviceData() throws Exception {
    when(deviceService.updateDevice(ID, device)).thenReturn(Optional.ofNullable(updatedDevice));

    String deviceString = objectMapper.writeValueAsString(updatedDevice);

    mockMvc.perform(put("/devices/" + ID)
            .contentType(MediaType.APPLICATION_JSON)
            .content(deviceString))
        .andExpect(status().isOk())
        .andExpect(content().string(deviceString));
  }

  @Test
  void deleteDeviceData() throws Exception {
    doNothing().when(deviceService).deleteDevice(ID);

    mockMvc.perform(delete("/devices/" + ID))
        .andExpect(status().isOk());
  }
}
