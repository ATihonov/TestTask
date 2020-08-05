package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }
    private By cartWrapper = By.className("overflow-hidden");
    private By products = By.cssSelector("a[class='cart-product__title']");

    public void waitCartToLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartWrapper));
    }
    public List<String> getProductsNames(){
        ArrayList<String> productsNames = new ArrayList<>();
        List<WebElement> productsList = findElements(products);
        for (int i = 0; i < productsList.size(); i++) {
            productsNames.add(productsList.get(i).getAttribute("title"));
        }
        return productsNames;

    }
}
