package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init 
{
protected static WebDriver driver;
protected static Properties prop;
protected static Log4j log4j = new Log4j();
protected static Logger log = log4j.getLogger();
protected static String randomText;

protected Init(){
}

public static WebDriver getDriver(){
	System.setProperty("webdriver.chrome.driver","F:\\eclipse-workspace\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	return driver;
	}



public static Properties loadProperties(String fileName){
	try{
		prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//"+fileName);
		prop.load(file);
	}catch(FileNotFoundException e){log.debug("FileNotFoundException", e);} 
	catch (IOException e) {log.debug("IOException", e);}
	return prop;
}

public static Properties loadpom(String fileName){
	try{
		prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//"+fileName);
		prop.load(file);
	}catch (FileNotFoundException e){log.debug("FileNotFoundException", e);} 
	catch (IOException e) {log.debug("IOException", e);}
	return prop;
}

public static void implicitWait(WebDriver driver,int seconds){
	driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

public static String decode64(String str){
	byte[] byteArray = Base64.decodeBase64(str.getBytes());
    return new String(byteArray);
    }

public static String genRanString(int n) {
    String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                + "0123456789"
                                + "abcdefghijklmnopqrstuvxyz"; 
    StringBuilder sb = new StringBuilder(n); 
    for (int i = 0; i < n; i++) { 
    	int index= (int)(alphaNumericString.length() * Math.random()); 
    	sb.append(alphaNumericString.charAt(index)); 
    	} 
    randomText= sb.toString(); 
    return randomText;
    }
}