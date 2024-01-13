import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/users/login";

    private final WebDriver driver;

    @FindBy(xpath = "//*[text()='Sign in']" )
    private WebElement signInForm;

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement UserName;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement Password;

    @FindBy(id = "sign-in-button")
    private  WebElement SignInButton;

    @FindBy(css = "a[href*='/users/register'")
    private WebElement RegisterButton;

    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void navigateTo(){
        this.driver.get(LoginPage.PAGEURL);
    }

    public boolean isURLLoaded (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.urlToBe(PAGEURL));
    }

    public String getSignInText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        return signInForm.getText();
    }

    public void login(String username, String password ){
        InputUsername(username);

        InputPassword(password);

        ClickSignIn();
    }

    public void InputUsername(String username){

        UserName.sendKeys(username);
    }

    public void InputPassword(String password){

        Password.sendKeys(password);
    }

    public void ClickSignIn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
        SignInButton.click();
    }

    public void ClickRegistrationLink(){
        RegisterButton.click();

    }



}
