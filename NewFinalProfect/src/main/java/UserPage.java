import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {
    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/users/";
    private final WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".profile-edit-btn.ng-star-inserted")
    private WebElement FollowButton;

    @FindBy (css = ".profile-edit-btn.ng-star-inserted")
    private WebElement UnfollowButton;

    public void FollowButtonClick() {
        FollowButton.click();
        if (FollowButton.getText().equals("Unfollow")) {
            System.out.println("The user is follow.");
        } else {
            System.out.println("The user is not follow");
        }
    }
    public void UnfollowUser(){

        UnfollowButton.click();
        if (FollowButton.getText().equals("Follow")) {
            System.out.println("The user is unfollow.");
        } else {
            System.out.println("The user is not unfollow");
        }

    }


}
