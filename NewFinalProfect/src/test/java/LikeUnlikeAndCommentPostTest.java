import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LikeUnlikeAndCommentPostTest extends BaseClass {

    private WebDriver driver;

    public static void main(String[] args) {
    }


    @DataProvider(name = "UserInformation")
    public Object[][] UserInformation() {
        return new Object[][]{
                {"Iliyana1", "123456"}
        };
    }

    @Test(dataProvider="UserInformation", invocationCount = 5)
    public void LikeUnlikeCommentPost(String username, String password){

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();
        homePage.isURLLoaded();

        HeaderMenu headerMenu = new HeaderMenu(getDriver());
        headerMenu.ClickLoginLink();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username,password);

        homePage.FirstPostOpen();

        homePage.LikePost();

        homePage.UnLikePost();

        homePage.CommentThePost();



    }

}




