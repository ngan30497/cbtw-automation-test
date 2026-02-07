package common.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private By userNameField = By.id("identifier");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.className("invalid-feedback");

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

    public DashboardPage logIntoApplication(String username, String password){
        setUserName(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage(){
        return find(errorMessage).getText();
    }
}
