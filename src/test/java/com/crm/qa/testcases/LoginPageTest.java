package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		Initialization();
		loginpage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title =loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO Log In Screen");
		System.out.println(title);
		System.out.println("Priority-1: Login Page Title is Tested.");
	}
	
	@Test(priority=2)
	public void validateCRMImage() {
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
		System.out.println(flag);
		System.out.println("Priority-2: validate CRM Image is Tested.");
	}
	
	@Test(priority=3)
	public void loginTest() {
		homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println("Priority-3: Login Test is Tested.");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		System.out.println("The Driver has Quit.");
	}
	
	
	
	
	

}
