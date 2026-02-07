package ctflearn.common.pages;

import ctflearn.common.pages.DashboardPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private By loginLabel = By.xpath("//a[text()='Login']");
    private By userNameField = By.xpath("//input[@id='identifier']");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.className("invalid-feedback");

    public void clickLogin(){
        click(loginLabel);
    }
    public void setUserName(String userName){
        set(userNameField, userName);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public DashboardPage clickLoginButton(){
        click(loginButton);
        return new DashboardPage();
    }

    @Step("Login with username: {username}")
    public DashboardPage logIntoApplication(String username, String password){
        clickLogin();
        setUserName(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage(){
        return find(errorMessage).getText();
    }
}
