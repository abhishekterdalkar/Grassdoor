package grassdorAutomation;

import org.testng.annotations.Test;

import utility.Log;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.testng.annotations.AfterTest;

public class TempTest {
  @Test
  public void f() {
	  UserData data = new UserData();
	  String fullname = data.firstName + " " + data.lastName;
	 // Log.info(fullName);
	  System.out.println(fullname);
	  System.out.println(data.email);
	  System.out.println(data.age);
	  System.out.println(data.phoneNumber);
	  System.out.println("role name" + data.roleName);
  }
  
  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
