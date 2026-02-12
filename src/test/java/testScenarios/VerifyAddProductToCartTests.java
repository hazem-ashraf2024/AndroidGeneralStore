package testScenarios;

import engine.BaseTestScenario;
import generalStoreScreens.CartScreen;
import generalStoreScreens.LandingScreen;
import generalStoreScreens.ProductListScreen;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class VerifyAddProductToCartTests extends BaseTestScenario {
    @Test
    public void fillingTheForm() {
        Assert.assertTrue(
                new LandingScreen(driver)
                        .fillLandingScreenForm("Albania", "test user name")
                        .verifyGetProductListScreen(),
                "product screen not displayed");
    }

    @Test(dependsOnMethods = {"fillingTheForm"})
    public void addProductToCart() {
        List<String> productList = new ArrayList<>();
        productList.add("Jordan 6 Rings");
        productList.add("PG 3");
        int actualCartCounter = productList.size();
        new ProductListScreen(driver)
                .addProductListToCart(productList)
                .getCartCounter();
        Assert.assertEquals(actualCartCounter, 2, "cart counter mismacth");
    }

    @Test(dependsOnMethods = {"fillingTheForm", "addProductToCart"})
    public void navigateToCartSuccessfully() {
        String actualScreenTitle =
                new ProductListScreen(driver)
                        .navigateToCart()
                        .getCartScreenTitle();
        String expectedScreenTitle = "Cart";
        Assert.assertEquals(actualScreenTitle, expectedScreenTitle, "cart screen title mismatch");

    }


    @Test(dependsOnMethods = {"fillingTheForm", "addProductToCart", "navigateToCartSuccessfully"})
    public void verifyTotalAmount() {
        double cartTotalCartAmount = new CartScreen(driver).getTotalCartAmount();
        double calculatedCartAmount = new CartScreen(driver).getTotalAmountCalculated();
        System.out.println("cart total= " + cartTotalCartAmount);
        System.out.println("calculated= " + calculatedCartAmount);
        Assert.assertEquals(cartTotalCartAmount, calculatedCartAmount, "calulated= " + calculatedCartAmount + "while cart amount= " + cartTotalCartAmount);
    }
    @Test(dependsOnMethods = {"fillingTheForm", "addProductToCart", "navigateToCartSuccessfully","verifyTotalAmount"})
public void verifyPurchase(){
        Assert.assertTrue(new CartScreen(driver)
                .completePurchase()
                .isAfterPurchaseDisplayed());
        new CartScreen(driver)
                .inAppBrowserHandle();
    }

}
