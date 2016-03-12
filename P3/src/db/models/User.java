package db.models;

import java.sql.Date;

public class User {
  public String email;
  public String password;
  public String firstName;
  public String lastName;
  public Date birthdate;
  public boolean isCustomer;
  public boolean isHost;
}
