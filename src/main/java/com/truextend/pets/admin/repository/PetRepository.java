package com.truextend.pets.admin.repository;

import com.truextend.pets.admin.domain.Pet;

import java.util.List;

/**
 * Created by onix on 6/9/16.
 */
public interface PetRepository {

  List<Pet> findAll();
  Pet findOne(int id);
  void save(Pet pet);
  void save(List<Pet> pets);
  void delete(Pet pet);
  void deleteAll();
  long count();

}
