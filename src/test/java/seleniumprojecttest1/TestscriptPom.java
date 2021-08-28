package seleniumprojecttest1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vitiger.comcast.utilities.ExcelUtility;
import com.vitiger.comcast.utilities.FileUtility;
import com.vitiger.comcast.utilities.JavaUtlity;
import com.vitiger.comcast.utilities.WebDriverUtility;

import Pomclass.BaseClasspage;
import Pomclass.CreatingNewOrganizationPage;
import Pomclass.HomePage;
import Pomclass.LoginPage;
import Pomclass.OrganizationInfo;
import Pomclass.OrganizationPage;



public class TestscriptPom extends BaseClasspage{
@Test
	//public void createTypeVerify() throws Throwable {
	public static void main(String[] arg) throws Throwable {
		JavaUtlity jlib=new JavaUtlity();
		//int randamint = jlib.getRandomnumber();
		//common data
		FileUtility fis=new FileUtility();
		ExcelUtility efc=new ExcelUtility();
		String Username = fis.getPropertyKeyValue("Username");
		String password = fis.getPropertyKeyValue("password");
		String Browser = fis.getPropertyKeyValue("Browser");
		String Url = fis.getPropertyKeyValue("Url");
		//test script data
		//String orgname=efc.getDataFromExcel("Sheet1",7, 2)+ randamint;
		
		//String Type=efc.getDataFromExcel("Sheet1",7, 4);
		
		WebDriver driver=new ChromeDriver();
		WebDriverUtility waitforimplicity=new WebDriverUtility();	
		waitforimplicity.waitUntilPageLoad(driver);
	
		driver.get(Url);
		LoginPage loginpage=new LoginPage(driver);
loginpage.loginApp(Username,password);
HomePage homepage=new HomePage(driver);
homepage.getOrganizationlink().click();
	int randamint = jlib.getRandomnumber();
	String orgname=efc.getDataFromExcel("Sheet1",7, 2)+ randamint;
	
	String Type=efc.getDataFromExcel("Sheet1",7, 4);
OrganizationPage organization=new OrganizationPage(driver);
organization.getCreteOrganization().click();

CreatingNewOrganizationPage createorg=new  CreatingNewOrganizationPage(driver);

createorg.createorg(orgname,Type);
createorg.getSave().click();
OrganizationInfo orginfo= new OrganizationInfo(driver);
String actualorginfo = orginfo.getSuccessfulmsg().getText();
String actualtype=orginfo.getSuccessfulType().getText();
if(actualorginfo.contains(orgname))
{
	System.out.println("organization name created succesfully");
}else
{
	System.out.println("organization name not created succesfully");
}


if(actualtype.contains(Type))
{
	
	System.out.println("Type drop down succesfully working");
	}else
	{
		System.out.println("Type  drop down not working");
	}

homepage.logout();
}
}


