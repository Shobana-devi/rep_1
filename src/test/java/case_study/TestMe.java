package case_study;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestMe {
  WebDriver w;
  @Test
  public void Login() throws InterruptedException {
	  w.findElement(By.partialLinkText("SignIn")).click();
  	  w.findElement(By.name("userName")).sendKeys("lalitha");
  	  w.findElement(By.name("password")).sendKeys("password123");
  	  w.findElement(By.name("Login")).click();
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\s.sivapragasam\\Downloads\\chromedriver_win32\\\\chromedriver.exe");
  	w=new ChromeDriver();
  	w.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
