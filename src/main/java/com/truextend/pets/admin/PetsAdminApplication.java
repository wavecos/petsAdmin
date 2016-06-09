package com.truextend.pets.admin;

import com.truextend.pets.admin.domain.Pet;
import com.truextend.pets.admin.service.PetAdminService;
import com.truextend.pets.admin.util.CSVPetParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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

    if (strings != null && strings.length != 0) {
      String fileName = strings[0];

      CSVPetParser parser = new CSVPetParser(fileName, ",");
      List<Pet> petList = parser.getPetList();

      petAdminService.saveAllPets(petList);

      for (Pet pet : petAdminService.allPets()) {
        log.info(pet);
      }


    } else {
      log.info("Please supply a CSV file containing Pets definitions...");
    }

  }
}


