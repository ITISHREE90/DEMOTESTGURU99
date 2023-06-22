
package screenObjects;

import models.AccountElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utility.Result;
import utility.entity.Account;


public class AccountPage extends CommonPage {

    AccountElement accountElement;

    public AccountPage(WebDriver driver) {
        super(driver);
        accountElement = new AccountElement();
    }

     //Input Customer ID

    public void InputCustomerId(String cusId) {
        try {
            getHelper().findElement(accountElement.ele_input_cus_id).sendKeys(cusId);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

     //Select Account Type
   
    public void SelectAccountType(String accType) {
        try {
            Select accs = new Select(getHelper().findElement(accountElement.ele_dropdown_account_type));
            accs.selectByValue(accType);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Input Initial deposit
     
    public void InputInitialDeposit(String initDept) {
        try {
            getHelper().findElement(accountElement.ele_input_init_deposit).sendKeys(initDept);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Click button Submit
    
    public void ClickButtonSubmit() {
        try {
            getHelper().findElement(accountElement.ele_btn_submit).click();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Click button Reset
     
    public void ClickButtonReset() {
        try {
            getHelper().findElement(accountElement.ele_btn_reset).click();
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }

    
     //Input all data & Submit at Account Page
    
    public void CreateNewAccount(Account acc) {
        try {
            InputCustomerId(acc.cusId);
            SelectAccountType(acc.accType);
            InputInitialDeposit(acc.currentAmount);
            ClickButtonSubmit();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
 
     //Get new Account ID
    
    public String GetAccountId() {
        String cusId = "";
        try {
            cusId = getHelper().getTextElement(accountElement.ele_label_table_acc_id_value);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
        return cusId;
    }

    
      //Verify All elements in Account Page
     
    public void VerifyAccountPageAllElements() {
        try {
            getHelper().waitForControlVisible(accountElement.ele_input_cus_id);
            Assert.assertTrue(getHelper().isElementPresent(accountElement.ele_label_account_title));
            Assert.assertTrue(getHelper().isElementPresent(accountElement.ele_label_cus_id));
            Assert.assertTrue(getHelper().isElementPresent(accountElement.ele_input_cus_id));
            Assert.assertTrue(getHelper().isElementPresent(accountElement.ele_label_dropdown_account_type));
            Assert.assertTrue(getHelper().isElementPresent(accountElement.ele_dropdown_account_type));
            Assert.assertTrue(getHelper().isElementPresent(accountElement.ele_label_init_deposit));
            Assert.assertTrue(getHelper().isElementPresent(accountElement.ele_input_init_deposit));
            Assert.assertTrue(getHelper().isElementPresent(accountElement.ele_btn_submit));
            Assert.assertTrue(getHelper().isElementPresent(accountElement.ele_btn_reset));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
    //Verify the header form add new Account
    
    public void TheAccountFormTitleShouldBe(String formTitle) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(accountElement.ele_label_account_title, formTitle));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Verify the table content new Account successfully
     
    public void TheTableContentTextShouldBe(String tableContentText) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(accountElement.ele_label_created_acc_detail, tableContentText));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
    //Verify new Account created successfully
     
    public void VerifyAccountCreatedSuccessfully(Account acc) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(accountElement.ele_label_table_acc_id_value, acc.accId));
            Assert.assertTrue(getHelper().elementTextShoudlBe(accountElement.ele_label_table_cus_id_value, acc.cusId));
            Assert.assertTrue(getHelper().elementTextShoudlBe(accountElement.ele_label_table_cus_name_value, acc.cusName));
            Assert.assertTrue(getHelper().elementTextShoudlBe(accountElement.ele_label_table_cus_email_value, acc.cusEmail));
            Assert.assertTrue(getHelper().elementTextShoudlBe(accountElement.ele_label_table_acc_type_value, acc.accType));
            Assert.assertTrue(getHelper().elementTextShoudlBe(accountElement.ele_label_table_acc_current_amount_value, acc.currentAmount));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
}
