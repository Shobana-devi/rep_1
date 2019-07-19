package testmeapp.test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {
	WebDriver w;
	ExtentReports report;
	ExtentTest test;
  
	//USER REGISTRATION
	@Test(priority=1)
	 public void testRegistration() throws InterruptedException {
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\s.sivapragasam\\Downloads\\chromedriver_win32\\\\chromedriver.exe");
		   	w=new ChromeDriver();
		   	w.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		   	w.findElement(By.partialLinkText("SignUp")).click();
		   	w.findElement(By.name("userName")).click();
		   	w.findElement(By.name("userName")).sendKeys("lalitha");
		   	w.findElement(By.name("firstName")).click();
		   	Thread.sleep(5000);
		   	String r=w.findElement(By.id("err")).getText();
		   	if(r.equals("Name Already Exists"))
		   	{
		   		System.out.println("username exist");
		   		w.findElement(By.partialLinkText("Home")).click();
		    	Assert.assertEquals(w.getTitle(), "Home");
		   	}
		   	else
		   	{
		   		w.findElement(By.name("userName")).click();
			   	w.findElement(By.name("userName")).sendKeys("Chimpunk");
			   	w.findElement(By.name("firstName")).click();
		   		w.findElement(By.name("firstName")).sendKeys("Gorila");
		   		w.findElement(By.name("lastName")).click();
		   		w.findElement(By.name("lastName")).sendKeys("Hien");
		   		w.findElement(By.name("password")).click();
		   		w.findElement(By.name("password")).sendKeys("hien123");
		   		w.findElement(By.name("confirmPassword")).click();
		   		w.findElement(By.name("confirmPassword")).sendKeys("hien123");
		   		w.findElement(By.xpath("//input[@value='Female']")).click();
		   		w.findElement(By.name("emailAddress")).click();
		   		w.findElement(By.name("emailAddress")).sendKeys("hien@gmail.com");
		   		w.findElement(By.name("mobileNumber")).click();
		   		w.findElement(By.name("mobileNumber")).sendKeys("9876556789");
		   		w.findElement(By.name("dob")).click();
		   		w.findElement(By.name("dob")).sendKeys("07/07/1995");
		   		w.findElement(By.name("address")).click();
		   		w.findElement(By.name("address")).sendKeys("California");
		   		Select vr=new Select(w.findElement(By.id("securityQuestion")));
		   	    vr.selectByIndex(3);
		   	    w.findElement(By.name("answer")).click();
		   	    w.findElement(By.name("answer")).sendKeys("hien");
		   	    w.findElement(By.name("Submit")).click();
		   	    w.findElement(By.partialLinkText("Home")).click();
		   	    Assert.assertEquals(w.getTitle(), "Home");
		   	}
	  }
	
     //USER LOGIN
	 @Test(priority=2)
	  public void testLogin() {
		     w.findElement(By.partialLinkText("SignIn")).click();
		  	 w.findElement(By.name("userName")).sendKeys("lalitha");
		  	 w.findElement(By.name("password")).sendKeys("password123");
		  	 w.findElement(By.name("Login")).click();
		  	 Assert.assertEquals(w.getTitle(), "Home");
	  }
	  
     //ADD TO CART
     @Test(priority=3)
      public void testCart() throws InterruptedException {
	        w.findElement(By.name("products")).sendKeys("Travel");
	        w.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
	        w.findElement(By.partialLinkText("Add")).click();
	        w.findElement(By.partialLinkText("Cart")).click();
	        Thread.sleep(5000);
	        String res=w.findElement(By.className("nomargin")).getText();
	        Assert.assertEquals("Travel 30", res);
	        
	      }
  
  
      //PAYMENT
      @Test(priority=4)
       public void testPayment() throws InterruptedException {
    	    w.findElement(By.partialLinkText("Checkout")).click();
	        w.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	        Thread.sleep(4000);
	        w.findElement(By.id("btn")).click();
	        w.findElement(By.name("username")).sendKeys("lalitha");
	        w.findElement(By.name("password")).sendKeys("password123");
	        w.findElement(By.xpath("//input[@value='LOGIN']")).click();
            Assert.assertEquals(w.getTitle(), "Order Details");
        }
 
      @AfterMethod
      public void getResultAfterMethod(ITestResult result) throws IOException{
	   if(result.getStatus()==ITestResult.FAILURE)
	   {
		   test.log(LogStatus.FAIL, test.addScreenCapture(shot.screen(w)),"FAILED");
	   }
	   else
	   {
		   test.log(LogStatus.PASS,"PASSED","Successful" );
	   }
      }

      @BeforeTest
      public void startReportBeforeTest() {
	    report=new ExtentReports("C:\\testMeReport.html",false);
	    test=report.startTest("Reportcreation");
      }

      @AfterTest
      public void endReportAfterTest() {
	    report.flush();
	    report.endTest(test);
      }

}
