package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By myAccountLink = By.linkText("My account");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void clickMyAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLink)).click();
    }
    
    public String getTitle() {
        return driver.getTitle();
    }
}