# PET ADMIN - Demo App

This is a command line app written in Java using Spring Boot, the business logic is to handle pets that are loaded via CSV file.

## Requisites
* Java 8 (for the search used Lambdas instead Apache commons collections)
* Maven 3

## How to run ?

1) From the command line execute to generate the Jar file.

```
mvn package
```

To install all dependencies (the first time maybe take some time)

2) You can run the command line app, for instance:

```
java -jar target/petsAdmin-0.0.1-SNAPSHOT.jar "pet-data.csv" "name=Jerry"
```

to get all pets with name "Jerry".

Other examples:

```
java -jar target/petsAdmin-0.0.1-SNAPSHOT.jar "pet-data.csv" "type=DOG"
```

```
java -jar target/petsAdmin-0.0.1-SNAPSHOT.jar "pet-data.csv" "type=CAT" "gender=F"
```

## Note
