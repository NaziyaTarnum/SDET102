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

public class TestscriptPom2 extends BaseClasspage{
@Test
	public static void createType() throws Throwable {
//public static void main(String[] args) throws Throwable {
	
	JavaUtlity jU =new JavaUtlity();
	int randomint = jU.getRandomnumber();
	FileUtility fis=new FileUtility();
	ExcelUtility Fis=new ExcelUtility();
	
	String username=fis.getPropertyKeyValue("Username");
	String password=fis.getPropertyKeyValue("password");
	String url=fis.getPropertyKeyValue("Url");
	String Browser=fis.getPropertyKeyValue("ChromeDriver");
	
	
	
	 String orgname = Fis.getDataFromExcel("Sheet1",1,2)+randomint;
	String Type = Fis.getDataFromExcel("Sheet1",1,4);
	
		WebDriver driver=new ChromeDriver();
		WebDriverUtility ImplicitelyWait=new WebDriverUtility();
		ImplicitelyWait.waitUntilPageLoad(driver);
		
		
		driver.get(url);
		
	
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginApp(username,password);
		
		HomePage homepage=new HomePage(driver);
		homepage.getOrganizationlink().click();
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreteOrganization().click();		

        CreatingNewOrganizationPage createorg=new  CreatingNewOrganizationPage(driver);
        createorg.createorg(orgname,Type);
        
        
        createorg.getSave().click();
        OrganizationInfo orginfo= new OrganizationInfo(driver);
        String actualtype=orginfo.getSuccessfulType().getText();
        if(actualtype.contains(Type))
        {
        	
        	System.out.println("Type drop down succesfully");
        	}else
        	{
        		System.out.println("Type  drop down unsuccesfully");
        	}
        

       homepage.logout();

	}

}
