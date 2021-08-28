package seleniumprojecttest1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Testcases {
@Test
public void createorg() throws Throwable {
	//public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./data/Test1.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		 String Browser=pobj.getProperty("Browser");
		 String Url=pobj.getProperty("Url");
		 String Username=pobj.getProperty("Username");
		 String Password=pobj.getProperty("password");
		 String OrganizationName=pobj.getProperty("OrganizationName");
		 String Type=pobj.getProperty("Type");
		 WebDriver driver=null;
		  if(Browser.equals("ChromeDriver"))
		  {
			  driver= new ChromeDriver();
		  } else if(Browser.equals("firefox"))
			  {
				 driver=new FirefoxDriver(); 
			  }else if(Browser.equals("ie")) {
				  {
					  driver=new InternetExplorerDriver();
				  }
		  }
		  
		  
		  driver.get(Url);
		  driver.findElement(By.name("user_name")).sendKeys(Username);
		  driver.findElement(By.name("user_password")).sendKeys(Password);
		  driver.findElement(By.id("submitButton")).click();
		  driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		  driver.findElement(By.xpath("//img[contains(@alt,'Create Organization...')]")).click();
		   driver.findElement(By.className("detailedViewTextBox")).sendKeys(OrganizationName);
		   Thread.sleep(5000);
		 WebElement Typedropdown=driver.findElement(By.name("accounttype"));
		 
		 //WebElement actualelement=Typedropdown;
		 
		if(Typedropdown.isDisplayed())
		// if(actualelement.equals(Typedropdown))
		 {
		  Select s1=new Select(Typedropdown);
		  
			  
		  
		   List<WebElement> option1 = s1.getOptions();
		   for(WebElement ele:option1)
		   {
		   	String element1 = ele.getText();
		    
		   	if(element1.equals(Type))
		   	{
		   		s1.selectByVisibleText(element1);
		   		
		   	}
		   	
		   }
		   System.out.println("pass:: Type Drop Down is Working");
		   }
		  else
		  {
			  System.out.println("Fail:: Type Drop Down is not working");
		  }	   
		driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();

	}

}
	


