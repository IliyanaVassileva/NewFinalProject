import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FollowAndUnfollowUserTest extends BaseClass{

    private WebDriver driver;

    public static void main(String[] args) {
    }

    @DataProvider(name = "UserInformation")
    public Object[][] UserInformation() {
        return new Object[][]{
                {"Iliyana4", "123456"}
        };
    }

    @Test(dataProvider = "UserInformation",invocationCount = 5)
    public void FollowAndUnfollowUser(String username, String password){

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();
        homePage.isURLLoaded();

        HeaderMenu headerMenu = new HeaderMenu(getDriver());
        headerMenu.ClickLoginLink();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username,password);

        homePage.FirstPostOpen();

        homePage.OpenUser();

        UserPage userPage = new UserPage(getDriver());
        userPage.FollowButtonClick();
        userPage.UnfollowUser();
    }
}
