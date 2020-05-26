package amzn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver;
	By usernameText = By.id("ap_email");
	By continueButton = By.id("continue");
	By passwordText = By.id("ap_password");
	By signInSubmit = By.id("signInSubmit");
	
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameText).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordText).sendKeys(password);
	}
	
	public void clickOnContinue() {
		driver.findElement(continueButton).click();
	}
	
	public void clickOnSignInSubmit() {
		driver.findElement(signInSubmit).click();
	}
}
