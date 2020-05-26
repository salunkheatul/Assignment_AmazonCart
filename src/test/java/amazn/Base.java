package amazn;


import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amzn.Index;
import amzn.Login;
import util.Init;

public class Base extends Init{
	Index index;
	Login login;
	
	@BeforeClass
	public void driverInit() {
		driver = Init.getDriver();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		driver.close();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void getUrl() {
		prop=Init.loadProperties("cred.properties");
	}
	
	@AfterMethod(alwaysRun=true)
	public void driverTeardown() {
		driver.navigate().to(prop.getProperty("url"));
	}
	
	@Test(enabled=false)
	public void test() {
		driver.get(prop.getProperty("url"));
		index = new Index(driver);
		index.goToLogin();
		log.info("Landed on login page");
		/*
		login = new Login(driver);
		login.enterUsername(decode64(prop.getProperty("username")));
		login.clickOnContinue();
		login.enterPassword(decode64(prop.getProperty("password")));
		login.clickOnSignInSubmit();
		*/
	}
	
	@Test(expectedExceptions= TimeoutException.class)
	public void scenarioOne() {
		//driver.get(prop.getProperty("url"));
		index = new Index(driver);
		index.clearSearchBox();
		index.search(genRanString(5));
		log.info("Search Successful");
		index.clearSearchBox();
		index.search("oppo f11");
		log.info("Search Successful");
		boolean status= index.validateSearch("oppo f11");
		if (status == true) {log.info("Search Result Matched");}
		else {log.info("Search Result Not Matched");}
	}
	
	@Test
	public void scenarioTwo() {
		//driver.get(prop.getProperty("url"));
		index = new Index(driver);
		index.search("oppo f11");
		index.selectProduct();
		log.info("Added in cart");
		boolean status= index.increaseQuantity();
		if (status == true) {log.info("quantity increased");}
		else {log.info("quantity not increased");}
	}
}