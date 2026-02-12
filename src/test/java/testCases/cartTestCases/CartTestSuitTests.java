package testCases.cartTestCases;

import engine.BaseCartScreenTests;
import generalStoreScreens.CartScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTestSuitTests extends BaseCartScreenTests {
    @Test
    public void verifySendEmailCheckBoxIsCheckedAfterClick() {
        String actualCheckButtonStatus =
                new CartScreen(driver).checkSendEmail()
                        .GetSendEmailChechBoxStatus();
        String expectedCheckButtonStatus = "true";
        Assert.assertEquals(actualCheckButtonStatus, expectedCheckButtonStatus, "checkbox status mismatch");

    }

    @Test
    public void verifyProductPriceInCartByName() {
        String productName = "Jordan 6 Rings";
        Double expectedProductInCartPrice = 165.0;
        Double actualProductInCartPrice =
                new CartScreen(driver)
                        .getCartProductPriceByName(productName);
        Assert.assertEquals(actualProductInCartPrice, expectedProductInCartPrice, productName + "product price mismatch");

    }
    @Test
    public void verifyTermsPopUpSuccessfully(){
        boolean isTermsPopUpDisplayed= new CartScreen(driver)
                .longClickOnTermsAndConditions()
                .verifyTermsPopUDisplayed();
        Assert.assertTrue(isTermsPopUpDisplayed,"pop up not displayed");
    }
}
