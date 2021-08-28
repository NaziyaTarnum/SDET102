package com.comcast.createcontact;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Organizationframework {
	public WebDriver driver;
	public ExtentHtmlReporter report;
public ExtentReports reports;
public ExtentTest test;

	@BeforeSuite
		public void organizationBS()
		{
		report=new ExtentHtmlReporter("./SDETTest/Extentreport/Sdate.html");
		System.out.println("the data base is connected");
		report.config().setDocumentTitle("SDET");
		report.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(report);
	}
		@BeforeClass
		public void orglunched()
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		
		@BeforeMethod
		public void orglogin()
		{
			driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");;
			driver.findElement(By.name("user_password")).sendKeys("admin");;
			driver.findElement(By.id("submitButton")).click();
			
			
		}
		@Test
		public void login() {
			test=reports.createTest("login");
			String expectedtitle =driver.getTitle();
			System.out.println(expectedtitle);
			String expected="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
			Assert.assertEquals(expectedtitle,expected);
		}
		
		@Test
		public void home() {
			test=reports.createTest("home");
		 driver.findElement(By.linkText("Organizations")).click();
		 String expectedtitle=driver.getTitle();
		 System.out.println(expectedtitle);
			String expected="Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
			Assert.assertEquals(expectedtitle,expected);
		}

		
		
		@AfterMethod
		public void orglogout()
		{
			WebElement actionorg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions action=new Actions(driver);
			action.moveToElement(actionorg).perform();
			
			driver.findElement(By.linkText("Sign Out")).click();
		}
@AfterClass
public void orgclose()
{
	driver.close();
}
@AfterSuite
public void closesuit()
{
	reports.flush();
	System.out.println("the data base is connected");
}

}
	


	


