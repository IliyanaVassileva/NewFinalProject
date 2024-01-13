import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/posts/all";

    private final WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "app-all-posts app-post-detail:first-child")
    private WebElement FirstPost;

    @FindBy (css = "app-post-modal .like.far.fa-heart.fa-2x")
    private WebElement LikePost;

    @FindBy (css = "div.post-modal-container i.fa-thumbs-down")
    private WebElement UnLikePost;

    @FindBy(css = "app-comment-form input")
    private WebElement commentInput;

    @FindBy(css = "app-post-modal .post-user")
    private WebElement User;




    public boolean isURLLoaded (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.urlToBe(PAGEURL));
    }
    public void navigateTo(){
        this.driver.get(PAGEURL);
    }

    public void FirstPostOpen(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(FirstPost));
        FirstPost.click();
    }

    public void LikePost(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(LikePost)).click();
        String classAttribute = LikePost.getAttribute("class");
        if (!classAttribute.contains("liked")) {
            LikePost.click();
        }

    }

    public void UnLikePost(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", UnLikePost);
    }

    public void CommentThePost() {
        commentInput.sendKeys("Test to comment post!");
    }

    public void OpenUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(User));
        User.click();
    }

}
