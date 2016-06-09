package com.truextend.pets.admin.repository;

import com.truextend.pets.admin.domain.Pet;
import com.truextend.pets.admin.enums.AnimalType;
import com.truextend.pets.admin.enums.Gender;

import java.util.List;

/**
 * Created by onix on 6/9/16.
 */
public interface PetRepository {

  List<Pet> findAll();
  List<Pet> findAllByName(String name);
  List<Pet> findAllByType(AnimalType type);
  List<Pet> findAllByTypeAndGender(AnimalType type, Gender gender);
  Pet findOne(int id);
  void save(Pet pet);
  void save(List<Pet> pets);
  void delete(Pet pet);
  void deleteAll();
  long count();

}
