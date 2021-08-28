package Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
@FindBy(name="user_name")
private WebElement Username;

@FindBy(name="user_password")
private WebElement Password;

@FindBy(id="submitButton")
private WebElement loginButton;

public WebElement getUsername() {
	return Username;
}

public WebElement getPassword() {
	return Password;
}

public WebElement getLoginButton() {
	return loginButton;
}
public void loginApp(String user,String passwd)
{
	Username.sendKeys(user);
	Password.sendKeys(passwd);
	loginButton.click();
}


	
}



