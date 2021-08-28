package seleniumprojecttest1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class TestscriptPom3 {
@Test
	//public void creatingMemberOfTest()throws Throwable {
public static void main(String[] args) throws Throwable
{
	
		
		JavaUtlity jlib=new JavaUtlity();
		int randamint = jlib.getRandomnumber();
		FileUtility fis=new FileUtility();
		ExcelUtility Fis=new ExcelUtility();
		
		String username=fis.getPropertyKeyValue("Username");
		String password=fis.getPropertyKeyValue("password");
		String url=fis.getPropertyKeyValue("Url");
		
		String Browser=fis.getPropertyKeyValue("ChromeDriver");
		
		
		
		 String orgname = Fis.getDataFromExcel("Sheet1",4,2)+randamint;
		 String Type = Fis.getDataFromExcel("Sheet1",4,4);
		String member= Fis.getDataFromExcel("Sheet1",4,3);
		
		WebDriver driver=new ChromeDriver();
		
		
		WebDriverUtility ImplicitelyWait=new WebDriverUtility();
		ImplicitelyWait.waitUntilPageLoad(driver);
		
		
		driver.get(url);
		
		
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginApp(username, password);
		
		HomePage homepage=new HomePage(driver);
		homepage.getOrganizationlink().click();
		
		OrganizationPage organization=new OrganizationPage(driver);
		organization.getCreteOrganization().click();	
		 
		CreatingNewOrganizationPage createorg=new  CreatingNewOrganizationPage(driver);
		createorg.createorg(orgname,Type);
	
		String parentid = driver.getWindowHandle();
        
        createorg.getMemberofimg().click();
       // List<String> allwindowlist = new ArrayList<String>(driver.getWindowHandles());
    	//driver.switchTo().window(allwindowlist.get(1));
        WebDriverUtility stiwchmethodchild=new WebDriverUtility();
	    stiwchmethodchild.switchToWindow(driver, member);
    
    	
    	createorg.createorg(member,true);
    	
    	
    	stiwchmethodchild.pressTABKey();
    	stiwchmethodchild.pressEnterKey();
    	
    	
    	//driver.close();
    	driver.switchTo().window(parentid);
    	createorg.getSave().click();
    	
    	OrganizationInfo orginfo= new OrganizationInfo(driver);
        String actualtype=orginfo.getSuccessfulType().getText();
        if(actualtype.contains(Type))
        {
        	
        	System.out.println("member creation is succesfully");
        	}else
        	{
        		System.out.println("member creation is unsuccesfully");
        	}
    	homepage.logout();

	}

}
