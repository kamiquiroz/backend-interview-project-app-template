package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.Type;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public interface TypeService {

  Optional<Type> getTypeById(Long id);

  Type addType(Type type);

  Optional<Type> updateType(Long id, Type type);

  void deleteType(Long id);

  List<Type> getAllTypes();

}
