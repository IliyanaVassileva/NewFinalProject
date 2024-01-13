import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    public static final String PAGEURL = "http://training.skillo-bg.com:4200/users/register";

    private final WebDriver driver;


    public RegisterPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement UserNameRegister;

    @FindBy(css = "[formcontrolname='email']")
    private WebElement EmailRegister;

    @FindBy(name = "password")
    private WebElement PasswordRegister;

    @FindBy(name = "verify-password")
    private WebElement ConfirmPasswordRegister;

    @FindBy(id = "sign-in-button")
    private WebElement SignInButton;

    private String RandomString(int minLenghtInclusive, int maxLenghtInclusive) {
        return RandomStringUtils.randomAlphabetic(minLenghtInclusive, maxLenghtInclusive);

    }

    private String RandomStringEmail(int minLenghtInclusive, int maxLenghtInclusive) {
        return RandomStringUtils.randomAlphabetic(minLenghtInclusive, maxLenghtInclusive) + "@gmail.com";

    }


    public boolean isURLLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlToBe(PAGEURL));
    }

    public void EnterUserName() {
        //UserNameRegister.sendKeys("iliyana2");
        String username = RandomString(5, 7);
        UserNameRegister.sendKeys(username);
        System.out.println("Username is " + username);

    }

    public void EnterEmail() {
//        EmailRegister.sendKeys("iliyana2@bg.bg");
        String Email = RandomStringEmail(5, 8);
        EmailRegister.sendKeys(Email);
        System.out.println("Email is " + Email);
    }

    public void EnterPassword() {
        PasswordRegister.sendKeys("123456");
    }

    public void ConfirmPassword() {
        ConfirmPasswordRegister.sendKeys("123456");
    }

    public void UserInformation() {
        EnterUserName();
        EnterEmail();
        EnterPassword();
        ConfirmPassword();
        ClickSignInButton();
    }

    public void ClickSignInButton() {
        SignInButton.click();
    }

}



