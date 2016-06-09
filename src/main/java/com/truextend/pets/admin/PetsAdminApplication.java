package com.truextend.pets.admin;

import com.truextend.pets.admin.domain.Pet;
import com.truextend.pets.admin.enums.AnimalType;
import com.truextend.pets.admin.enums.Gender;
import com.truextend.pets.admin.service.PetAdminService;
import com.truextend.pets.admin.util.CSVPetParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class PetsAdminApplication implements CommandLineRunner {

  @Autowired
  private PetAdminService petAdminService;

  public static final Log log = LogFactory.getLog(PetsAdminApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PetsAdminApplication.class, args);
	}

  @Override
  public void run(String... strings) throws Exception {

    log.info("**** PETS ADMIN ****");

    if (strings != null && strings.length > 0) {
      String fileName = strings[0];

      // 1. Parse CSV file
      CSVPetParser parser = new CSVPetParser(fileName, ",");
      List<Pet> petList = parser.getPetList();

      // 2. Persist Pets Data
      petAdminService.saveAllPets(petList);

      // 3. Evaluate Search Criteria
      List<Pet> searchResults = new ArrayList<>();

      if ( strings.length == 2 ) {
        String[] arg1 = strings[1].split("=");
        String arg1Key = arg1[0];
        String arg1Val = arg1[1];

        if ("name".equals(arg1Key)) {
          searchResults = petAdminService.searchPetsByName(arg1Val);
        } else if ("type".equals(arg1Key)) {
          AnimalType type = AnimalType.valueOf(arg1Val);
          searchResults = petAdminService.searchPetsByType(type);
        }
      } else if (strings.length == 3) {

        String[] arg1 = strings[1].split("=");
        String arg1Key = arg1[0];
        String arg1Val = arg1[1];

        String[] arg2 = strings[2].split("=");
        String arg2Key = arg2[0];
        String arg2Val = arg2[1];

        if ("type".equals(arg1Key) && "gender".equals(arg2Key)) {
          AnimalType type = AnimalType.valueOf(arg1Val);
          Gender gender = Gender.valueOf(arg2Val);
          searchResults = petAdminService.searchPetsByTypeAndGender(type, gender);
        }
      }

      // 4. Print Search Results in Console
      printPetsToConsole(searchResults);

    } else {
      System.out.println("**************************************** NOTICE *****************************************");
      System.out.println("Usage: java -jar jarfile \"filename.csv\" \"name=search name\"");
      System.out.println("Or:    java -jar jarfile \"filename.csv\" \"type=some pet's type\"");
      System.out.println("Or:    java -jar jarfile \"filename.csv\" \"type=some pet's type\" \"gender=some gender\"");
      System.out.println("*****************************************************************************************");
    }

  }

  public void printPetsToConsole(List<Pet> pets) {

    System.out.println("::: PET SEARCH RESULTS :::");

    for (Pet pet : pets) {
      System.out.println(pet);
    }

    System.out.println("Total Pets Found = " + pets.size());
  }

}


