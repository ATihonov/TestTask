import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.MainPage;
import java.util.List;

public class TestTask extends BaseTest {


    @Test
    public void addToCartTest() {

        String XiaomiModel = "Redmi 8A";
        driver.navigate().to(url);
        MainPage mainPage = new MainPage(driver);

        mainPage.searchProduct("Xiaomi");
        mainPage.selectPhoneModel(XiaomiModel);
        mainPage.searchProduct("iPhone");
        mainPage.addFirstProductToCart();
        mainPage.clickCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.waitCartToLoad();
        List<String> productsInCart = cartPage.getProductsNames();

        Assert.assertTrue( productsInCart.size() == 2);
        Assert.assertTrue(productsInCart.get(0).contains("iPhone"));
        Assert.assertTrue(productsInCart.get(1).contains("Xiaomi"));
    }
}
