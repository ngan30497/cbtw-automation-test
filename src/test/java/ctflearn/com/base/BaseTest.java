package ctflearn.com.base;

import ctflearn.com.listeners.AllureTestListener;
import ctflearn.common.pages.BasePage;
import ctflearn.common.pages.DashboardPage;
import ctflearn.common.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(AllureTestListener.class)
public class BaseTest {

    public WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    private String url = "https://ctflearn.com";

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }

//    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
