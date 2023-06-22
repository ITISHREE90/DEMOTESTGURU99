package screenObjects;

import models.HomeElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;


public class HomePage extends CommonPage {
    
    HomeElement homePageElement;

    public HomePage(WebDriver driver) {
        super(driver);
        homePageElement = new HomeElement();
    }

    //Click menu link New Customer
     
    public CustomerPage ClickLinkNewCustomer() {
        try {
            getHelper().waitForControlVisible(homePageElement.ele_link_menu_manager);
            getHelper().findElement(homePageElement.ele_link_menu_new_customer).click();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
        return new CustomerPage(driver);
    }

    
     //Click menu link New Account
     
    public AccountPage ClickLinkNewAccount() {
        try {
            getHelper().waitForControlVisible(homePageElement.ele_link_menu_manager);
            getHelper().findElement(homePageElement.ele_link_menu_new_account).click();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
        return new AccountPage(driver);
    }

    //Click menu link Deposit
     
    public DepositPage ClickLinkDeposit() {
        try {
            getHelper().waitForControlVisible(homePageElement.ele_link_menu_manager);
            getHelper().findElement(homePageElement.ele_link_menu_deposit).click();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
        return new DepositPage(driver);
    }

    
     //Verify All elements in Home Page
     
    public void VerifyHomePageAllElements() {
        try {
            getHelper().waitForControlVisible(homePageElement.ele_img_content_1);
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_img_content_1));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_img_content_2));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_img_content_3));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_label_welcome));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_label_manager_id));
            VerifyVerticalHomePage();
        } catch (Exception e) {
            Result.checkFail("Class HomePage | Method VerifyHomePageAllElements | Exception desc : " + e.getMessage());
        }
    }

    
     //Verify Vertical Menu in Home Page
     
    public void VerifyVerticalHomePage() {
        try {
            getHelper().waitForControlVisible(homePageElement.ele_link_menu_manager);
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_new_customer));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_edit_customer));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_delete_customer));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_delete_customer));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_new_account));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_edit_account));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_delete_account));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_deposit));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_with_drawal));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_fund_transfer));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_password_input));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_balance_enquiry));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_mini_statement));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_customised_statement));
            Assert.assertTrue(getHelper().isElementPresent(homePageElement.ele_link_menu_logout));
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }
}
