package reporting.test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private ExtentTest test;
    private WebDriver driver;

    public HomePage(WebDriver driver, ExtentTest test) {
        this.test = test;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "comp-iiqg1vggactionTitle")
    private WebElement signupLink;

    @FindBy(id="signUpDialogswitchDialogLink")
    private WebElement loginLink;

    @FindBy(xpath = "//div[@id='memberLoginDialogemail']//input")
    private WebElement emailField;

    @FindBy(xpath = "//div[@id='memberLoginDialogpassword']//input")
    private WebElement passwordField;

    @FindBy(id="memberLoginDialogokButton")
    private WebElement goButton;

    public void clickSignupLink() {
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on Signup Link");
    }

    public void clickLoginLink() {
        loginLink.click();
        test.log(LogStatus.INFO, "Clicked on login link");
    }

    public void enterEmail(String value) {
        emailField.sendKeys(value);
        test.log(LogStatus.INFO, "Entered email");
    }

    public void enterPassword(String value) {
        passwordField.sendKeys(value);
        test.log(LogStatus.INFO, "Entered password");
    }

    public void clickGoButton() {
        goButton.click();
        test.log(LogStatus.INFO, "Clicked Go Button");
    }

    public boolean isWelcomeTextPresent() {
        WebElement welcomeText;
        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
            return welcomeText != null;
        }catch (Exception e) {
            test.log(LogStatus.FAIL, "Test is Failed");
            return false;
        }
    }

    public void login(String email, String password) {
        clickSignupLink();
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        clickGoButton();
    }
}
