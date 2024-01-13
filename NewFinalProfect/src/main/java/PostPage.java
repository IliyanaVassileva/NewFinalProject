import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PostPage {

    private WebDriver driver;

    public static String PAGEURL = "http://training.skillo-bg.com:4200/posts/create";

    public PostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".file[type='file']")
    private WebElement uploadPicture;

    @FindBy(css = "img.image-preview")
    private WebElement ImageVisible;

    @FindBy(css = "input.input-lg")
    private WebElement ImageName;

    @FindBy(name = "caption")
    private WebElement Caption;

    @FindBy(id = "create-post")
    private WebElement CreatePostButton;

    @FindBy(css = ".fa-trash-alt")
    private WebElement DeletePostButton;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement ConfirmDeleteYes;

    @FindBy(xpath = "//button[text()='No']")
    private WebElement DeclineDeleteNo;


    public boolean isURLLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlToBe(PostPage.PAGEURL));
    }

    public void setUploadPicture() {
        uploadPicture.sendKeys();
    }

    public void uploadPicture(File postpicture) {

        uploadPicture.sendKeys(postpicture.getAbsolutePath());
    }

    public boolean IsImageVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            return wait.until(ExpectedConditions.visibilityOf(ImageVisible)).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String GetImageName() {
        String imageName = ImageName.getAttribute("placeholder");
        return imageName;
    }


    public void populateCaption(String caption) {
        Caption.sendKeys(caption);

    }

    public void clickCreateButton() {
        CreatePostButton.click();
    }

    public void clickDeleteButton() {
        DeletePostButton.click();
    }

    public void confirmDelete() {
        ConfirmDeleteYes.click();
    }

}


