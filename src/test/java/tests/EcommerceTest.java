package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceTest extends BaseTest {
    private String testEmail;
    private String testPassword;
    
    @Test(priority = 1)
    public void testUserRegistration() {
        testEmail = TestUtils.generateRandomEmail();
        testPassword = TestUtils.generateRandomPassword();
        String firstName = TestUtils.generateRandomName();
        String lastName = TestUtils.generateRandomName();
        
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        
        homePage.clickMyAccount();
        registerPage.clickRegister();
        registerPage.fillRegistrationForm(firstName, lastName, testEmail, "1234567890", testPassword);
        
        String successMessage = registerPage.getSuccessMessage();
        Assert.assertEquals(successMessage, "Your Account Has Been Created!", "Registration failed");
    }
    
    @Test(priority = 2, dependsOnMethods = "testUserRegistration")
    public void testUserLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        
        homePage.clickMyAccount();
        loginPage.clickLogin();
        loginPage.login(testEmail, testPassword);
        
        String accountHeading = loginPage.getAccountPageHeading();
        Assert.assertEquals(accountHeading, "My Account", "Login failed");
    }
    
    @Test
    public void testHomePageTitle() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getTitle().contains("Your Store"), "Home page title is incorrect");
    }
}