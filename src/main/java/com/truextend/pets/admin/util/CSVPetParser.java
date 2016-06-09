package com.truextend.pets.admin.util;

import com.truextend.pets.admin.domain.Pet;
import com.truextend.pets.admin.enums.AnimalType;
import com.truextend.pets.admin.enums.Gender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by onix on 6/9/16.
 */
public class CSVPetParser {

  public static final Log log = LogFactory.getLog(CSVPetParser.class);

  private String fileName;
  private String separator;

  public CSVPetParser(String fileName, String separator) {
    this.fileName = fileName;
    this.separator = separator;
  }

  public List<Pet> getPetList() {

    BufferedReader reader = null;
    String line = "";
    List<Pet> pets = new ArrayList<>();

    try {
      reader = new BufferedReader(new FileReader(fileName));

      while ( (line = reader.readLine()) != null ) {
        String[] fields = line.split(separator);

        AnimalType type = AnimalType.valueOf(fields[0]);
        String name = fields[1];
        Gender gender = Gender.valueOf(fields[2]);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmdd-HHmmss");
        Date timeStamp = dateFormat.parse(fields[3].trim());

        Pet pet = new Pet(type, name, gender, timeStamp);
        pets.add(pet);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    } finally {
      if ( reader != null ) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    log.info("Pet List :: " + pets);

    return pets;
  }

}
