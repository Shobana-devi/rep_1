package testmeapp.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class shot {
	@Test
	  public static String screen(WebDriver driver) throws IOException {
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File src=ts.getScreenshotAs(OutputType.FILE);
		  String des=("C:\\Users\\s.sivapragasam\\Documents\\shot.html");
		  FileUtils.copyFile(src, new File(des));
		  return des;
	  }
}
