package com.truextend.pets.admin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetsAdminApplication {

  public static final Log log = LogFactory.getLog(PetsAdminApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PetsAdminApplication.class, args);

    log.info("**** PETS ADMIN ****");
	}
}
