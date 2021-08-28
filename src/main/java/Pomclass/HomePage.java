package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitiger.comcast.utilities.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(linkText="Organizations")
private WebElement Organizationlink;

@FindBy(xpath="//img[@src=\'themes/softed/images/user.PNG\']")
public WebElement logoutimg;

@FindBy(linkText="Sign Out")
public WebElement signout;

public WebElement getOrganizationlink() {
	return Organizationlink;
}

public WebElement getSignout() {
	return signout;
}

public WebElement getLogoutimg() {
	return logoutimg;
}

public void logout()
{
	WebDriverUtility.mouseOver(driver,logoutimg);
	signout.click();
}


}
