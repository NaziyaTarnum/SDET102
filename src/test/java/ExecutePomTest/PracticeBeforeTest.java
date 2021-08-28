package ExecutePomTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vitiger.comcast.utilities.WebDriverUtility;

import Pomclass.BaseClasspage;
import Pomclass.CreatingNewOrganizationPage;
import Pomclass.HomePage;
import Pomclass.OrganizationInfo;
import Pomclass.OrganizationPage;
 @Listeners(com.vitiger.comcast.utilities.createtakeshot.class)
public class PracticeBeforeTest extends BaseClasspage {
	
	@Test(groups={"smokeTest"})
	public void createTypeVerify() throws Throwable {
	

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
	boolean ceateorga=actualorginfo.contains(orgname);
	boolean creattype = actualtype.contains(Type);	
	
//Assert.assertEquals(actualorginfo,orgname);
	Assert.assertTrue(creattype);
	}
	@Test
	public void Cratetypetest() throws Throwable {
		
	String orgname=efc.getDataFromExcel("Sheet1",7, 2)+ randamint;
	
	String Type=efc.getDataFromExcel("Sheet1",7, 4);
	String member= efc.getDataFromExcel("Sheet1",7,3);
	String parentUrl = "module=Accounts&action=EditView";
	String childUrl = "module=Accounts&action=Popup";	
		HomePage homepage=new HomePage(driver);
	homepage.getOrganizationlink().click();
	OrganizationPage organization=new OrganizationPage(driver);
	organization.getCreteOrganization().click();	
	CreatingNewOrganizationPage createorg=new  CreatingNewOrganizationPage(driver);
	createorg.createorg(orgname,Type);
//	String parentid = driver.getWindowHandle();
    createorg.getMemberofimg().click();
   
    WebDriverUtility stiwchmethodchild=new WebDriverUtility();
    stiwchmethodchild.switchToWindowOnUrl(driver,childUrl);
    
	createorg.createorg(member,true);
	
	stiwchmethodchild.pressTABKey();
	stiwchmethodchild.pressEnterKey();
	
	stiwchmethodchild.switchToWindowOnUrl(driver,parentUrl);
//	driver.switchTo().window(parentid);
	//stiwchmethodchild.switchToWindow(driver,orgname);
	createorg.getSave().click();
	OrganizationInfo orginfo= new OrganizationInfo(driver);
	
	
    String actualtype1=orginfo.getSuccessfulType().getText();
    AssertJUnit.assertEquals(actualtype1,Type);
  
	}
    
    @Test (groups= {"regressionTest"})   
    public void createmembrertest() throws Throwable
    {
    	
    	HomePage homepage=new HomePage(driver);
    
	homepage.getOrganizationlink().click();
	
	OrganizationPage organization=new OrganizationPage(driver);
	organization.getCreteOrganization().click();		
	String orgname=efc.getDataFromExcel("Sheet1",1,2)+ randamint;
	
	String Type=efc.getDataFromExcel("Sheet1",1,4);
	 CreatingNewOrganizationPage createorg=new  CreatingNewOrganizationPage(driver);
     createorg.createorg(orgname,Type);
     
     
     createorg.getSave().click();
     OrganizationInfo orginfo= new OrganizationInfo(driver);
     String actualtype=orginfo.getSuccessfulType().getText();
     AssertJUnit.assertEquals(actualtype,Type);
 
    
	}
}

