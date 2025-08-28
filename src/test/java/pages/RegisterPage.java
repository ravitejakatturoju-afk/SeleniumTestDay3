package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By registerLink = By.linkText("Register");
    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By telephoneField = By.id("input-telephone");
    private By passwordField = By.id("input-password");
    private By confirmPasswordField = By.id("input-confirm");
    private By agreeCheckbox = By.name("agree");
    private By continueButton = By.cssSelector("input[value='Continue']");
    private By successMessage = By.cssSelector("div#content h1");
    
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }
    
    public void fillRegistrationForm(String firstName, String lastName, String email, String telephone, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        
        WebElement checkbox = driver.findElement(agreeCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        
        driver.findElement(continueButton).click();
    }
    
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
}