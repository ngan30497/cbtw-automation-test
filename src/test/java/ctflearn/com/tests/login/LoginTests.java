package ctflearn.com.tests.login;

import ctflearn.com.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void testLoginSucess(){
        loginPage.clickLogin();
        loginPage.setUserName("ngan304");
        loginPage.setPassword("Password#12345");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Wrong password"));
    }
}
