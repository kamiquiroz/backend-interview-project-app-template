package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.TypeRepository;
import com.ninjaone.backendinterviewproject.model.Type;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

  private TypeRepository typeRepository;

  @Autowired
  public void setTypeRepository(TypeRepository typeRepository) {
    this.typeRepository = typeRepository;
  }

  @Override
  public Optional<Type> getTypeById(Long id) {
    return typeRepository.findById(id);
  }

  @Override
  public Type addType(Type type) {
    return typeRepository.save(type);
  }

  @Override
  public Optional<Type> updateType(Long id, Type type) {
    Optional<Type> currentSolutionOptional = typeRepository.findById(id);
    if (currentSolutionOptional.isPresent()) {
      Type currentType = currentSolutionOptional.get();
      currentType.setTypeName(type.getTypeName());
      return Optional.of(typeRepository.save(currentType));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteType(Long id) {
    typeRepository.deleteById(id);
  }

  @Override
  public List<Type> getAllTypes() {
    return (List<Type>) typeRepository.findAll();
  }
}
