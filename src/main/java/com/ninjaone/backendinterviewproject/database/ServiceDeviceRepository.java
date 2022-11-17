package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import org.springframework.data.repository.CrudRepository;

public interface ServiceDeviceRepository extends CrudRepository<ServiceDevice, Long> {

}
