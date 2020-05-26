package amzn;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Index {
	WebDriver driver;
	WebDriverWait wait;
	By navToLogin = By.id("nav-link-accountList");
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchClick = By.className("nav-input");
	By searchResult = By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div/div/div[2]/div[1]/div/div/span/a/div/img");
	By addToCart = By.id("add-to-cart-button");
	By viewCart = By.xpath("//*[@id=\"nav-cart\"]");
	By quantitySelection = By.id("a-autoid-0-announce");
	By quantityValue = By.id("dropdown1_2");
	By cartValue = By.id("sc-subtotal-amount-activecart");
	By cart = By.xpath("//*[@id=\"nav-cart\"]");
	
	public Index(WebDriver driver) {
		this.driver=driver;
	}
	
	public void goToLogin() {
		driver.findElement(navToLogin).click();
	}
	
	public void search(String searchText) {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		driver.findElement(searchBox).click();
		driver.findElement(searchBox).sendKeys(searchText);
		driver.findElement(searchClick).click();
	}
	
	public void clearSearchBox() {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		driver.findElement(searchBox).click();
		driver.findElement(searchBox).clear();
	}
	
	public boolean validateSearch(String searchText) {
		if (driver.getPageSource().contains(searchText)) {
			return true;
		}else {return false;}
	}
	
	public void selectProduct() {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
		driver.findElement(searchResult).click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
		driver.findElement(addToCart).click();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart));
		driver.findElement(viewCart).click();
	}
	
	public void viewCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
		driver.findElement(cart).click();
	}
	
	public boolean increaseQuantity() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartValue));
		String cartVal= driver.findElement(cartValue).getText();
		wait.until(ExpectedConditions.visibilityOfElementLocated(quantitySelection));
		driver.findElement(quantitySelection).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(quantityValue));
		driver.findElement(quantityValue).click();
		if (driver.findElement(cartValue).getText() != cartVal) {
			return true;
		}else {return false;}
	}
}
