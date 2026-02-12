package generalStoreScreens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screenEngine.BaseScreen;
import screenEngine.Gestures;

import java.util.List;

public class ProductListScreen extends BaseScreen {

    //xpaths
    By screenTitle = AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
    By addToCartButton = AppiumBy.id("com.androidsample.generalstore:id/productAddCart");
    By productPriceLocator = AppiumBy.id("com.androidsample.generalstore:id/productPrice");
    By cartLocator = AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart");
    By cartCounterLocator = AppiumBy.id("com.androidsample.generalstore:id/counterText");

    //By genericXpath=AppiumBy.xpath("//android.widget.TextView [@text='product']");
    public ProductListScreen(AndroidDriver driver) {
        super(driver);

    }

    public boolean verifyGetProductListScreen() {
        return elementAction.waitAndCheckDisplayed(screenTitle);
    }

    public ProductListScreen addProductToCart(String product) {
        wait.until(d -> {
            new Gestures(driver).scrollAction(product);
            return true;
        });
        wait.until(d -> {
            // find element container then get any add to cart button id by chainning
            driver.findElement(
                    AppiumBy.xpath("//android.widget.TextView[@text='" + product + "']/..")
            ).findElement(addToCartButton).click();
            return true;
        });

        return this;
    }

    public String getAddToCartButtonText(String product) {
        new Gestures(driver).scrollAction(product);
        // find element container then get any add to cart button id by chainning
        return driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@text='" + product + "']/..")
        ).findElement(addToCartButton).getText();
    }

    public CartScreen navigateToCart() {
        driver.findElement(cartLocator).click();
        return new CartScreen(driver);
    }

    public String getProductPrice(String product) {
        return driver.findElement(productPriceLocator).getText();
    }

    public int getCartCounter() {
        return Integer.parseInt(driver.findElement(cartCounterLocator).getText());
    }

    public ProductListScreen addProductListToCart(List<String> productList) {
        for (String product : productList) {
            wait.until(d -> {
                new Gestures(driver).scrollAction(product);
                return true;
            });
            wait.until(d -> {
                // find element container then get any add to cart button id by chainning
                driver.findElement(
                        AppiumBy.xpath("//android.widget.TextView[@text='" + product + "']/..")
                ).findElement(addToCartButton).click();
                return true;
            });
        }
return this;
    }
}


