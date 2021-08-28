package Mytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tester1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		Actions action=new Actions(driver);
		action.click().perform();
		driver.findElement(By.xpath("//label[@for='departure']//span[contains(@class,'lbl_input latoBold appendBottom10')]")).click();
		driver.findElement(By.xpath("//div[@class='dateInnerCell']//p[text()='18']")).click();

	}

}
