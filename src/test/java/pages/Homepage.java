package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText = "Login")
	private WebElement selectLoginOption;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void selectAccountDropdown() {
		myAccountDropdown.click();
	}
	public AccountPage selectLogin() {
		selectLoginOption.click();
		return new AccountPage(driver);
	}

}
