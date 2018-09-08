package com.craftsvilla.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.utilities.BasePage;

public class HomePage extends BasePage
{
	
	//Declaration
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement signIn;

	
	@FindBy(xpath = "//span[text()='Cart ']")
	private WebElement cart;
	
	@FindBy(xpath="//a[@href='/womens-clothing/sarees/?MID=megamenu_sarees_seeall']")
	private WebElement sarees;
	
	@FindBy(xpath="(//a[contains(@href,'megamenu_lehengas_seeall')])[1]")
	private WebElement lehengas;
	
	@FindBy(xpath = "//a[@href='#' and @data-toggle='dropdown']")
	private WebElement userAccount;
	
	@FindBy(xpath="//a[@href='https://cvaccount.craftsvilla.com/customer/account/logout']")
	private WebElement logoutBtn;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
		
		
	}
	
	
	//utilization
	public void clickOnSignIn()
	{
		verifyElementPresent(signIn);
		signIn.click();
	}
	
	public void clickOnCart()
	{
		verifyElementPresent(cart);
		cart.click();
	}
	
	public void goToSarees()
	{
		verifyElementPresent(sarees);
		mouseHover(driver, sarees);
	}

	public void goToLehengas()
	{
		verifyElementPresent(lehengas);
		mouseHover(driver, lehengas);
	}
	
	public void goToAccount()
	{
		verifyElementPresent(userAccount);
		mouseHover(driver, userAccount);
	}
	
	public void clickLogout()
	{
		verifyElementPresent(logoutBtn);
		logoutBtn.click();
	}
	
	
}
