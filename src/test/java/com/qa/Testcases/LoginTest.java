package com.qa.Testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.Homepage;
import pages.LoginPage;

public class LoginTest {
	
	public WebDriver driver;
	public Homepage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		homepage = new Homepage(driver);
	}
	@Test
	public void loginWithValidCredentials() {
		loginpage = new LoginPage(driver);
		homepage.selectAccountDropdown();
		accountpage = homepage.selectLogin();
		loginpage.enterEmail();
		loginpage.enterPassword();
		accountpage = loginpage.loginButton();
		Assert.assertTrue(accountpage.elementVerifaction());
		driver.quit();
		
		
	}

}
