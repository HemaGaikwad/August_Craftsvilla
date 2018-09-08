package com.craftsvilla.testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.craftsvilla.pompages.HomePage;
import com.craftsvilla.pompages.SignInPage;
import com.craftsvilla.utilities.BaseTest;
import com.craftsvilla.utilities.ReadExcel;

public class SignUpScripts extends BaseTest
{
	HomePage homepage = null;
	SignInPage signinpage = null;
	
	@Test
	public void signUp()
	{
		
		homepage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		
		String[][] credentials= ReadExcel.getData(filePath, "User_SignUp");
		
		try
		{
			for( int i =1; i<credentials.length; i++)
			{
				String email = credentials[i][0];
				String password = credentials[i][1];
				
				homepage.clickOnSignIn();
				signinpage.setEmailAddress(email);
				signinpage.clickContinue();
				signinpage.setNewPassword(password);
				signinpage.clickRegister();
				homepage.goToAccount();
				homepage.clickLogout();
				homepage.verifyTitle("Ethnic Wear - Buy Ethnic Wear in Latest Designs Online at Craftsvilla");
				
			}
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
			try
			{
				
			}
			catch (Exception e1) 
			{
				
			}
		}
	
	}
}
