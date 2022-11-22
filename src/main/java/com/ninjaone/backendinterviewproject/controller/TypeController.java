package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.api.TypeApi;
import com.ninjaone.backendinterviewproject.model.Type;
import com.ninjaone.backendinterviewproject.service.TypeService;
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
public class TypeController implements TypeApi {

  private TypeService typeService;

  @Autowired
  public void setTypeService(TypeService typeService) {
    this.typeService = typeService;
  }

  public ResponseEntity<Type> findType(@PathVariable Long id) {
    return typeService.getTypeById(id).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Override
  public List<Type> findAllTypes() {
    return typeService.getAllTypes();
  }

  @ResponseStatus(HttpStatus.CREATED)
  public Type createType(@RequestBody Type type) {
    return typeService.addType(type);
  }

  public ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type type) {
    Optional<Type> typeOptional = typeService.updateType(id, type);
    return typeOptional.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  public void deleteType(@PathVariable Long id) {
    typeService.deleteType(id);
  }

}
