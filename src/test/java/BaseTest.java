import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    protected String url = "https://rozetka.com.ua/";

    @BeforeSuite
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void teardown(){
        driver.quit();
    }

}
