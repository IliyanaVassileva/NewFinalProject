import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ProfilePage {
    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/users/";
    private final WebDriver driver;

    @FindBy(tagName = "h2")
    private WebElement loggedInUser;

    @FindBy(css = "app-profile-posts-section app-post:last-child")
    private WebElement OpenPost;

    @FindBy(css = ".profile-image-source")
    private WebElement ProfilePictureOpen;

    @FindBy(css = "input[type='file']")
    private WebElement ProfilePictureClick;

    @FindBy(id = "upload-img")
    private WebElement InputAfterUpload;



    public ProfilePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isURLLoaded (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.urlContains(PAGEURL));
    }
    public String getUsername(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loggedInUser));
        return loggedInUser.getText();

    }

    public void ClickOpenPost(){
        OpenPost.click();
    }


    public void UploadPicture(File postProfilePicture) {
        ProfilePictureClick.sendKeys(postProfilePicture.getAbsolutePath());
    }

    public void InputAfterUpload(){
        if(!InputAfterUpload.isDisplayed()){
            System.out.println("The image is upload.");
        } else {
            System.out.println("The image is not upload.");
        }
    }


}
