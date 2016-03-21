package db.models;

import java.util.Date;
import java.sql.ResultSet;

import db.util.QueryHelper;
import db.util.StringHelper;

public class User {
  public String email;
  public String password;
  public String firstName;
  public String lastName;
  public Date birthdate;
  public boolean isCustomer;
  public boolean isHost;
  
  public User() {}
  
  public User(ResultSet rs) {
	  email = QueryHelper.readString(rs, "email");
	  password = QueryHelper.readString(rs, "password");
	  firstName = QueryHelper.readString(rs, "fname");
	  lastName = QueryHelper.readString(rs, "lname");
	  birthdate = QueryHelper.readDate(rs, "birthday");
	  isCustomer = QueryHelper.readBoolean(rs, "is_customer");
	  isHost = QueryHelper.readBoolean(rs, "is_host");
  }
  
  public boolean isLoggedIn() {
	  return !StringHelper.IsNullOrEmpty(email);
  }
}
