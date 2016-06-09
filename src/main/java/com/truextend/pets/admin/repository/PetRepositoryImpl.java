package com.truextend.pets.admin.repository;

import com.truextend.pets.admin.domain.Pet;
import com.truextend.pets.admin.store.PetStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by onix on 6/9/16.
 */
@Repository
public class PetRepositoryImpl implements PetRepository {

  @Autowired
  private PetStore petStore;

  @Override
  public List<Pet> findAll() {
    return petStore.getInstance().getData();
  }

  @Override
  public Pet findOne(int id) {
    // TODO: Review this, we can use a HashMap
    return petStore.getInstance().getData().get(id);
  }

  @Override
  public void save(Pet pet) {
    petStore.getInstance().getData().add(pet);
  }

  @Override
  public void save(List<Pet> pets) {
    petStore.getInstance().getData().addAll(pets);
  }

  @Override
  public void delete(Pet pet) {
    petStore.getInstance().getData().remove(pet);
  }

  @Override
  public void deleteAll() {
    petStore.getInstance().getData().clear();
  }

  @Override
  public long count() {
    return petStore.getInstance().getData().size();
  }
}
