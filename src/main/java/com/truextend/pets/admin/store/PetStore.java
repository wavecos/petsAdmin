package com.truextend.pets.admin.store;

import com.truextend.pets.admin.domain.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by onix on 6/9/16.
 */
@Service
public class PetStore {
  private static PetStore singletonInstance;

  private List<Pet> data;

  private PetStore(){
    data = new ArrayList<>();
  }

  public static synchronized PetStore getInstance(){
    if(singletonInstance == null){
      singletonInstance = new PetStore();
    }
    return singletonInstance;
  }

  public List<Pet> getData() {
    return data;
  }

  public void setData(List<Pet> data) {
    this.data = data;
  }
}
