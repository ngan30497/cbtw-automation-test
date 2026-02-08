package ctflearn.com.tests.challenges;

import ctflearn.com.data.challenge.ChallengeData;
import ctflearn.com.data.challenge.ChallengeDataFactory;
import ctflearn.common.pages.CreateChallengesPage;
import ctflearn.common.pages.DashboardPage;
import ctflearn.com.base.BaseTest;
import static org.testng.Assert.*;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class CreateChallengesTests extends BaseTest {
    ChallengeData validChallengeData = ChallengeDataFactory.validChallenge();
    ChallengeData invalidChallengeData = ChallengeDataFactory.challengeWithoutTitle();

//    @Test
    public void TC_UI_01_CreateChallenge_Success(){
        DashboardPage dashboardPage = loginPage.logIntoApplication("ngan304", "Password#123");
        assertTrue(dashboardPage.isDashboardDisplayed());
        CreateChallengesPage createChallengesPage = dashboardPage.clickCreateChallenge();
        createChallengesPage.fillTitle(validChallengeData.getTitle());
        createChallengesPage.fillFlag(validChallengeData.getFlag());
        createChallengesPage.fillDescription(validChallengeData.getDescription());
//        attach file
//        category
//        Points
        createChallengesPage.fillHowToSolve(validChallengeData.getSolution());
        createChallengesPage.clickSubmitForVerification();
        assertTrue(createChallengesPage.isSubmitChallengeSuccessful());

    }

    @Test(description = "Create challenge not successfully")
    @Story("User creates a new challenge")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that user cannot create a challenge missing title")
    public void TC_UI_02_CreateChallenge_MissingTitle(){
        DashboardPage dashboardPage = loginPage.logIntoApplication("ngan304", "Password#123");
        assertTrue(dashboardPage.isDashboardDisplayed());
        CreateChallengesPage createChallengesPage = dashboardPage.clickCreateChallenge();
        createChallengesPage.fillFlag(validChallengeData.getFlag());
        createChallengesPage.fillDescription(validChallengeData.getDescription());
        createChallengesPage.fillHowToSolve(validChallengeData.getSolution());
        createChallengesPage.clickSubmitForVerification();
        assertTrue(createChallengesPage.isInlineErrorExistTitleDisplayed());

    }

}
