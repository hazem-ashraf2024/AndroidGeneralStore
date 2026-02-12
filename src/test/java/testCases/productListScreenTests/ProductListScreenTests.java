package testCases.productListScreenTests;

import engine.BaseProductListScreenTests;
import generalStoreScreens.ProductListScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductListScreenTests extends BaseProductListScreenTests {
    @Test
    public void verifyAddToCartButtonNameChangedAfterClick(){
        String productName="Jordan 6 Rings";
     String actualJordan6RingsAddToCartButton=new ProductListScreen(driver)
                .addProductToCart(productName)
                .getAddToCartButtonText(productName);
        String expectedJordan6RingsAddToCartButton="ADDED TO CART";
        Assert.assertEquals(actualJordan6RingsAddToCartButton,expectedJordan6RingsAddToCartButton,"add to cart button name not changed");
    }
    @Test
    public void verifyClickedAddToCartButtonNameResetAfterClick(){
        String productName="Jordan 6 Rings";
        String actualJordan6RingsAddToCartButton=new ProductListScreen(driver)
                .addProductToCart(productName)
                .addProductToCart(productName)
                .getAddToCartButtonText(productName);
        String expectedJordan6RingsAddToCartButton="ADD TO CART";
        Assert.assertEquals(actualJordan6RingsAddToCartButton,expectedJordan6RingsAddToCartButton,"add to cart button name not changed");
    }
    @Test
    public void verifyCartSymbolCounterIncreaseByOneWhenAddProductToCart(){
        List<String> productList=new ArrayList<>();
        productList.add("Jordan 6 Rings");
        productList.add("PG 3");
       int actualCartCounter= productList.size();
        new ProductListScreen(driver)
                .addProductListToCart(productList)
                .getCartCounter();
        Assert.assertEquals(actualCartCounter,2,"cart counter mismacth");

    }


}
