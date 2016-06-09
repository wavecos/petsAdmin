package com.truextend.pets.admin.service;

import com.truextend.pets.admin.domain.Pet;
import com.truextend.pets.admin.enums.AnimalType;
import com.truextend.pets.admin.enums.Gender;
import com.truextend.pets.admin.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by onix on 6/9/16.
 */
@Service
public class PetAdminServiceImpl implements PetAdminService {

  @Autowired
  private PetRepository petRepository;

  @Override
  public List<Pet> allPets() {
    return petRepository.findAll();
  }

  @Override
  public List<Pet> searchPetsByName(String name) {
    return petRepository.findAllByName(name);
  }

  @Override
  public List<Pet> searchPetsByType(AnimalType type) {
    return petRepository.findAllByType(type);
  }

  @Override
  public List<Pet> searchPetsByTypeAndGender(AnimalType type, Gender gender) {
    return petRepository.findAllByTypeAndGender(type, gender);
  }

  @Override
  public void saveAllPets(List<Pet> pets) {
    petRepository.save(pets);
  }

}
