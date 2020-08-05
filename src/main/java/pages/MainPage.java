package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage  {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By searchInput = By.name("search");
    private By firstProductAddToCartButton = By.cssSelector("app-buy-button > button:nth-child(1)");
    private By cartButton = By.xpath("//a[contains(@href,'/cart')]");
    private By productWrapper = By.className("goods-tile__inner");

    public void selectPhoneModel(String modelName){
        WebElement phoneModel = driver.findElement(By.xpath("//a[contains(@title,'"+modelName+"')]/..//button[contains(@class,'buy')]"));
        phoneModel.click();
    }
    public void searchProduct(String productName){

        findElement(searchInput).clear();
        findElement(searchInput).sendKeys(productName);
        findElement(searchInput).sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productWrapper));
    }
    public void addFirstProductToCart(){
        findElement(firstProductAddToCartButton).click();
    }
    public void clickCart(){
        findElement(cartButton).click();
    }

}
