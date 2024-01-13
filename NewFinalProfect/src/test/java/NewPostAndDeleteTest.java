import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.File;
import java.time.Duration;

public class NewPostAndDeleteTest extends BaseClass {
    private WebDriver driver;

    public static void main(String[] args) {

    }

    @DataProvider(name = "UserInformation")
    public Object[][] UserInformation() {
        File postPicture = new File("src/main/resources/Upload/au9i1g9hn-1200x595.jpg");
        String caption = "Test caption";
        return new Object[][]{
                {"Iliyana1", "123456", postPicture, caption}
        };
    }

    @Test(dataProvider = "UserInformation", invocationCount = 5)
    public void testUploadImage(String username, String password, File postPicture, String caption){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();
        homePage.isURLLoaded();

        HeaderMenu headerMenu = new HeaderMenu(getDriver());
        headerMenu.ClickLoginLink();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.isURLLoaded();
        loginPage.login(username,password);

        headerMenu.ClickNewPostLink();

        PostPage postPage = new PostPage(getDriver());
        Assert.assertTrue(postPage.isURLLoaded());

        postPage.uploadPicture(postPicture);

        Assert.assertTrue(postPage.IsImageVisible(), "The image is not upload!");

        Assert.assertEquals(postPage.GetImageName(), postPicture.getName());

        postPage.populateCaption(caption);

        postPage.clickCreateButton();

        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.ClickOpenPost();

        postPage.clickDeleteButton();

        postPage.confirmDelete();






    }
}
