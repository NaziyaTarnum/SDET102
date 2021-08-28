package Pomclass;

import java.sql.Connection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vitiger.comcast.utilities.ExcelUtility;
import com.vitiger.comcast.utilities.FileUtility;
import com.vitiger.comcast.utilities.JavaUtlity;
import com.vitiger.comcast.utilities.WebDriverUtility;

public class BaseClasspage {
		public	JavaUtlity jlib=new JavaUtlity();
		public FileUtility fis=new FileUtility();
		public	ExcelUtility efc=new ExcelUtility();
		public int randamint = jlib.getRandomnumber();



			public WebDriver driver;
			 public Connection connection;
			 public static WebDriver sdriver;
			
			/*@BeforeSuite
			public void JdbcConnecttest() throws Throwable {
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
				
				Statement statement = connection.createStatement();
			
			
			}*/
			// @Parameters("BROWSER")
			/*@BeforeClass(groups={"smokeTest","regressionTest"})
			public void configBC(String BROWSER) throws Throwable
			{
				//String BROWSER = fis.getPropertyKeyValue("Browser");
				 if(BROWSER.equals("chrome"))
				 {
					 driver=new ChromeDriver();
				 }else if(BROWSER.equals("firefox"))
				 {
					 driver=new FirefoxDriver(); 
				 }else if(BROWSER.equals("ie"))
						 {
					 driver=new InternetExplorerDriver();
						 }
				 sdriver=driver;
				// String BROWSER = fis.getPropertyKeyValue("Browser");
				WebDriverUtility waitforimplicity=new WebDriverUtility();	
				waitforimplicity.waitUntilPageLoad(driver);
				driver.manage().window().maximize();
			}*/
			@BeforeClass(groups={"smokeTest","regressionTest"})
			 public void configBC() throws Throwable
				{
					String BROWSER = fis.getPropertyKeyValue("Browser");
					 if(BROWSER.equals("ChromeDriver"))
					 {
						 driver=new ChromeDriver();
					 }else if(BROWSER.equals("firefox"))
					 {
						 driver=new FirefoxDriver(); 
					 }else if(BROWSER.equals("ie"))
							 {
						 driver=new InternetExplorerDriver();
							 }
					 sdriver=driver;
					 //String BROWSER = fis.getPropertyKeyValue("Browser");
					WebDriverUtility waitforimplicity=new WebDriverUtility();	
					waitforimplicity.waitUntilPageLoad(driver);
					driver.manage().window().maximize();
				}
				
			@BeforeMethod(groups={"smokeTest","regressionTest"})
			public void comfigBM() throws Throwable
			{
				
				String Username = fis.getPropertyKeyValue("Username");
				String password = fis.getPropertyKeyValue("password");
				String Url = fis.getPropertyKeyValue("Url");
				driver.get(Url);
				
				//test script data
				
				LoginPage loginpage=new LoginPage(driver);
				loginpage.loginApp(Username,password);
				
			}
			
			@AfterMethod(groups={"smokeTest","regressionTest"})
			public void configAM()
			{
				HomePage homepage=new HomePage(driver);
				
				homepage.logout();
				
			}
			
			@AfterClass(groups={"smokeTest","regressionTest"})
			public void configAc()
			{
				
		driver.close();
			}
			
			/*
			@AfterSuite
			public void configAs() throws Throwable {
				connection.close();
			}
			*/
		}


