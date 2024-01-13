import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class RegisterUserTest extends BaseClass {
    private WebDriver driver;

    public static void main(String[] args) {

    }

    @Test(invocationCount = 5)
    public void registrationUser() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();
        homePage.isURLLoaded();

        HeaderMenu headerMenu = new HeaderMenu(getDriver());
        headerMenu.ClickLoginLink();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.ClickRegistrationLink();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.isURLLoaded();
        registerPage.UserInformation();

        headerMenu.ClickProfileLink();

        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.isURLLoaded();
        profilePage.getUsername();

        headerMenu.LogOut();
        loginPage.isURLLoaded();







    }
}
