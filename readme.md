# COMP 421: Apartment Rental Service

## Instructions

## Installation

To test the program, the database needs to have the correct schema. The scripts in the `schema` folder will set up everything correctly. Note that this schema does not contain the changes from the other problems in this assignment. There are no major additions other than a few minor fixes (primary key of bookings is now serial).

It was chosen to keep all SQL outside of the actual java code. The sql commands required for the execution of the application are located in the `res` folder. The **contents** of this folder need to be copied inside of the `bin` folder. Upon execution, the bin folder should look like the following:

- ApartmentRental.class
- bookings/
- db/
- reviews/
- users/
- address/
- creditCard/
- lodgings/
- ui/

## Execution

Database user name and password are provided as command line arguments. The application can be run from the command line using the following command:

```
java -cp ./lib/postgresql-9.4.1208.jre7.jar:./bin ApartmentRental username password
```

Note that this needs to be executed from the folder containing the `bin` and `lib` folders, in order for the class paths to work.

