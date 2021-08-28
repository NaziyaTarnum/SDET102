package Mytrip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Terster2 {

	public static void main() {
		String day="20";
		String monthyear="December 2021";
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://www.makemytrip.com/");
Actions action=new Actions(driver);
action.click().perform();
driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
String datemonth = "//div[text()='"+monthyear+"']//ancestor::div[@class='DayPicker-Month']//p[text()='"+day+"']";

for(;;)
{
try {
	
driver.findElement(By.xpath("datemonth"));
break;

}
catch(Exception e)
{
	
	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
}
	
}
driver.quit();

	}

}
