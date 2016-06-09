package com.truextend.pets.admin;

import com.truextend.pets.admin.domain.Pet;
import com.truextend.pets.admin.util.CSVPetParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PetsAdminApplication {

  public static final Log log = LogFactory.getLog(PetsAdminApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PetsAdminApplication.class, args);

    log.info("**** PETS ADMIN ****");

    if (args != null && args.length != 0) {
      String fileName = args[0];

      CSVPetParser parser = new CSVPetParser(fileName, ",");
      List<Pet> petList = parser.getPetList();

    } else {
      log.info("Please supply a CSV file containing Pets definitions...");
    }


	}
}
