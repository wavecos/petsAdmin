package com.truextend.pets.admin.service;

import com.truextend.pets.admin.domain.Pet;
import com.truextend.pets.admin.enums.AnimalType;
import com.truextend.pets.admin.enums.Gender;

import java.util.List;

/**
 * Created by onix on 6/9/16.
 */
public interface PetAdminService {

  List<Pet> allPets();
  List<Pet> searchPetsByName(String name);
  List<Pet> searchPetsByType(AnimalType type);
  List<Pet> searchPetsByTypeAndGender(AnimalType type, Gender gender);
  void saveAllPets(List<Pet> pets);

  // TODO: implement other service methods

}
