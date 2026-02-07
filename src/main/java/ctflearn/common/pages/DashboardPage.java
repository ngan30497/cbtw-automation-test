package ctflearn.common.pages;

import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private By DashboardHeader = By.xpath("//a[normalize-space()='Dashboard']");
    private By ChallengesMenu = By.xpath("//a[text()='Create Challenge']//parent::div//preceding::a[contains(@class,'dropdown-toggle-split')]");
    private By CreateChallenges = By.xpath("//a[@href='/challenge/create']");


    public boolean isDashboardDisplayed(){
       return find(DashboardHeader).isDisplayed();
    }

    public CreateChallengesPage clickCreateChallenge(){
        click(ChallengesMenu);
        click(CreateChallenges);
        return new CreateChallengesPage();
    }


}
