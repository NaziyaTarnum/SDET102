package Pomclass;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vitiger.comcast.utilities.WebDriverUtility;
@Test
public class CreatingNewOrganizationPage  {
	
	
	
	WebDriver driver;
	public  CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationname;
	
	@FindBy(name="accounttype")
	private WebElement TypeDrop;
	
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement Memberofimg;
	
	
	
	
	@FindBy(xpath="//a[contains(@href,'javascript:window.close();')]")
	private List<WebElement> memberof;

	

	public WebElement getMemberofimg() {
		return Memberofimg;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	public List<WebElement> getMemberof() {
		return memberof;
	}

	public WebElement getSave() {
		return save;
	}
	
	

	public WebElement getOrganizationname() {
		return organizationname;
	}
	
	public WebElement getTypeDrop() {
		return TypeDrop;
	}
	
	public void createorg(String orgname)
	{
		organizationname.sendKeys(orgname);
		save.click();
		
	}
	
	public void createorg(String orgname,String Type)
	{
		
		organizationname.sendKeys(orgname);
			
	WebDriverUtility.select(TypeDrop,Type);
	
	}

	public void createorg(String member,boolean flag) 
	{
		
		 for(WebElement ele:memberof)
		 {
		 
			if(ele.getText().equals(member)) 
			{
			ele.click();
			break;
			}	
			}
		 
			
		 }

	
	
		
	}
	
	
	
	
	


