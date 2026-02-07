package ctflearn.common.pages;

import org.openqa.selenium.By;

public class CreateChallengesPage extends BasePage {

    private By textbox_Title =By.id("title");
    private By textbox_Flag = By.id("flag");
    private By textbox_Description = By.name("description");
    private By textbox_HowToSolve = By.id("howtosolve");
    private By button_SubmitForVerification = By.xpath("//button[text()='Submit for Verification']");
    private By alert_SummitSuccessull = By.xpath("//strong[text()='Submitted for verification!']");
    private By text_InlineErrorExistTitle = By.xpath("//div[normalize-space()='Challenge with this title already exists.']");


    public void fillTitle(String title){
        set(textbox_Title, title);
    }

    public void fillFlag(String flad){
        set(textbox_Flag, flad);
    }

    public void fillDescription(String description){
        set(textbox_Description, description);
    }

    public void fillHowToSolve(String howToSolve){
        set(textbox_HowToSolve, howToSolve);
    }

    public void clickSubmitForVerification(){
        click(button_SubmitForVerification);
    }

    public boolean isSubmitChallengeSuccessful(){
        return find(alert_SummitSuccessull).isDisplayed();
    }

    public boolean isInlineErrorExistTitleDisplayed(){
        waitForElementVisible(text_InlineErrorExistTitle);
        return find(text_InlineErrorExistTitle).isDisplayed();
    }
}
