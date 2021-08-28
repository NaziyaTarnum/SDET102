package com.vitiger.comcast.utilities;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pomclass.CreatingNewOrganizationPage;
/**
 * 
 * @author Naziya
 *
 */

public class WebDriverUtility {

	/**
	 * This method wait for 20 seconds for page loading
	 * @param driver
	 */
	public  void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
/**
 * This method wait for the element to be visible
 * @param driver
 */
	public void waitForElementVisiblity(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/** This method select element from drop down using visible Text
	 * 
	 * @param element
	 * @param option
	 */
	
	public static void select(WebElement element,String option)
	{
		Select s=new Select(element);
		s.selectByVisibleText(option);
	}
	/**
	 * This method select element from drop down using index
	 * @param element
	 * @param index
	 */
	
	
	public void select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method perform the actions by using mouseover
	 * @param driver
	 * @param element
	 */
	public static void mouseOver(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * This method switch one window to another by using windowId
	 * @param driver
	 * @param createorg
	 */
	public void switchToWindow(WebDriver driver,String createorg)
	{
		
		Set<String> window=driver.getWindowHandles();
		Iterator<String> lt=window.iterator();
		while(lt.hasNext())
		{
			String winid=lt.next();
			String title=driver.switchTo().window(winid).getTitle();
			if(title.contains(createorg))
			{
				break;
			}
		}
		
	}
	
	/**
	 * This method switch one window to another by using windowId
	 * @param driver
	 * @param createorg
	 */
	public void switchToWindowOnUrl(WebDriver driver,String url)
	{
		
		Set<String> window=driver.getWindowHandles();
		Iterator<String> lt=window.iterator();
		while(lt.hasNext())
		{
			String winid=lt.next();
			String currentUrl=driver.switchTo().window(winid).getCurrentUrl();
			if(currentUrl.contains(url))
			{
				break;
			}
		}
		
	}
	
	
	/**
	 * THis method press Enter key using robot
	 * @throws Throwable
	 */
	public void pressEnterKey() throws Throwable
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * THis method press Tab key using robot
	 * @throws Throwable
	 */
	public void pressTABKey() throws Throwable
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_TAB);
		rc.keyRelease(KeyEvent.VK_TAB);
	}

	
	
	
	
}
