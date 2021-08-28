package seleniumprojecttest1;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestcasesTest3 {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("./data/Test1.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		 String Browser=pobj.getProperty("Browser");
		 String Url=pobj.getProperty("Url");
		 String Username=pobj.getProperty("Username");
		 String Password=pobj.getProperty("password");
		 String OrganizationName=pobj.getProperty("OrganizationName");
		 String memberof=pobj.getProperty("memberof");
		 
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
	 String parentid = driver.getWindowHandle();
		 
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[contains(@alt,'Create Organization...')]")).click();
		 driver.findElement(By.className("detailedViewTextBox")).sendKeys(OrganizationName);
		 driver.findElement(By.cssSelector("img[alt='Select']")).click();

		
		List<String> allwindowlist = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allwindowlist.get(1));
		List<WebElement> list=driver.findElements(By.xpath("//a[contains(@href,'javascript:window.close();')]"));
		 
		 for(WebElement ele:list)
		 {
		 
			if(ele.getText().equals(memberof)) 
			{
			ele.click();
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
				break;
				
			}
			
		 }
		 driver.close();
		driver.switchTo().window(parentid);
		 driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]")).click();
		 driver.findElement(By.linkText("Sign Out")).click();
		  driver.quit();
	}
}

		 






	
