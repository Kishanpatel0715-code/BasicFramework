package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
//import utilities.Xls_Reader;

import org.testng.annotations.BeforeMethod;

//import java.io.FileNotFoundException;
import java.io.IOException;

//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
  LoginPage lp = new LoginPage();
  DataFile df = new DataFile();
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.openBrowser();
	  lp.openYahoo();
  }

  @AfterMethod
  public void afterMethod() {
	lp.closeBrowser();
  }

  @Test(priority=1)
  public void loginwithWrongPasswordTest() throws InterruptedException {
	  lp.enterEmail(df.correctEmail);
	  lp.enterPassword(df.wrongPassword);
	  String expectedErr = df.passwordErr;
	  String actualErr = lp.readPasswordError();
	  Assert.assertEquals(actualErr, expectedErr);
	
  }
  
  @Test(priority=2)
  public void loginwithWrongEmail() throws InterruptedException {
	  	lp.enterEmail(df.wrongEmail);
		String expectedErr = df.emailErr;
		String actualErr = lp.readEmailError();
		Assert.assertEquals(actualErr, expectedErr);
		
  }
}
