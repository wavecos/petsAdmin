package com.truextend.pets.admin.domain;

import com.truextend.pets.admin.domain.enums.AnimalType;
import com.truextend.pets.admin.domain.enums.Gender;

import java.util.Date;

/**
 * Created by onix on 6/9/16.
 */
public class Pet {

  private AnimalType type;
  private String name;
  private Gender gender;
  private Date timeStamp;

  public Pet(AnimalType type, String name, Gender gender, Date timeStamp) {
    this.type = type;
    this.name = name;
    this.gender = gender;
    this.timeStamp = timeStamp;
  }

  public AnimalType getType() {
    return type;
  }

  public void setType(AnimalType type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pet pet = (Pet) o;

    if (type != pet.type) return false;
    if (name != null ? !name.equals(pet.name) : pet.name != null) return false;
    if (gender != pet.gender) return false;
    return timeStamp != null ? timeStamp.equals(pet.timeStamp) : pet.timeStamp == null;

  }

  @Override
  public int hashCode() {
    int result = type != null ? type.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (gender != null ? gender.hashCode() : 0);
    result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Pet{" +
            "type=" + type +
            ", name='" + name + '\'' +
            ", gender=" + gender +
            ", timeStamp=" + timeStamp +
            '}';
  }
}
