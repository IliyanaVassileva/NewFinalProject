import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class EditProfileTest extends BaseClass{
    private WebDriver driver;

    public static void main(String[] args) {
    }


    @DataProvider(name = "UserInformation")
    public Object[][] UserInformation() {
        File postProfilePicture = new File("src/main/resources/Upload/download.jpg");
        return new Object[][]{
                {"Iliyana4", "123456", postProfilePicture}
        };
    }

    @Test(dataProvider = "UserInformation",invocationCount = 5)
    public void EditProfile(String username, String password, File postProfilePicture) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();
        homePage.isURLLoaded();

        HeaderMenu headerMenu = new HeaderMenu(getDriver());
        headerMenu.ClickLoginLink();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username, password);

        headerMenu.ClickProfileLink();



        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.getUsername();


        profilePage.UploadPicture(postProfilePicture);
        profilePage.InputAfterUpload();

    }





}