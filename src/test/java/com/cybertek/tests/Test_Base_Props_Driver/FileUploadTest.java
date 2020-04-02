package com.cybertek.tests.Test_Base_Props_Driver;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FileUploadTest extends TestBase {
      @Test
    public void fileUploadTests(){
          String url = ConfigurationReader.getProperty("url");
          driver.get(url);

          driver.findElement(By.linkText("File Upload")).click();
          driver.findElement(By.id("file-upload")).sendKeys("/Users/alinapopescu/Desktop/Selenium/my_file.txt");
          driver.findElement(By.id("file-submit")).click();
          driver.findElement(By.id("uploaded-files"));
          Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"my_file.txt" );


      }
}
