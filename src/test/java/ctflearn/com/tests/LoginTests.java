package ctflearn.com.tests;

import ctflearn.com.base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginSucess(){
        loginPage.setUserName("ngan304");
        loginPage.setPassword("Password#12345");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Wrong password"));
    }
}
