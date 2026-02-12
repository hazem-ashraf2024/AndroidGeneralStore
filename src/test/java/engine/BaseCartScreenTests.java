package engine;

import generalStoreScreens.LandingScreen;
import generalStoreScreens.ProductListScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public abstract class BaseCartScreenTests extends BaseTestScenario {
    String country="Albania";
    String userName="test user name";
    String product="Jordan 6 Rings";
    String expectedAddToCartButonText="ADDED TO CART";
    String expectedScreenTitle = "Cart";
@BeforeMethod
    public void beforeCartScreenSetup(){
    //fill the form > navigate to product list
    Assert.assertTrue(
            new LandingScreen(driver)
                    .fillLandingScreenForm(country,userName)
                    .verifyGetProductListScreen(),
            "product screen not displayed"
    );
    //add product to cart > cart screen
    String actualAddToCartButonText= new ProductListScreen(driver)
            .addProductToCart(product)
            .getAddToCartButtonText(product);
    Assert.assertEquals(actualAddToCartButonText,expectedAddToCartButonText,"add to cart button name mismatch");
    // verify land on cart screen
    String actualScreenTitle=
            new ProductListScreen(driver)
                    .navigateToCart()
                    .getCartScreenTitle();

    Assert.assertEquals(actualScreenTitle,expectedScreenTitle,"cart screen title mismatch");

}
}
