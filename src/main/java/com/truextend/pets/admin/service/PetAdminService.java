package com.truextend.pets.admin.service;

import com.truextend.pets.admin.domain.Pet;

import java.util.List;

/**
 * Created by onix on 6/9/16.
 */
public interface PetAdminService {

  List<Pet> allPets();
  void saveAllPets(List<Pet> pets);

}
