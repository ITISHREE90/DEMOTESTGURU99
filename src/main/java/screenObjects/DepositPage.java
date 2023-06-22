package screenObjects;

import models.DepositElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;
import utility.entity.Deposit;

public class DepositPage extends CommonPage {

    DepositElement depositElement;

    public DepositPage(WebDriver driver) {
        super(driver);
        depositElement = new DepositElement();
    }

    //Input Account ID
    public void InputAccountId(String accId) {
        try {
            getHelper().findElement(depositElement.ele_input_acc_id).sendKeys(accId);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    //Input deposit amount  
    public void InputAmount(String amount) {
        try {
            getHelper().findElement(depositElement.ele_input_amount).sendKeys(amount);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    //Input deposit description
     
    public void InputDescription(String description) {
        try {
            getHelper().findElement(depositElement.ele_input_description).sendKeys(description);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
  
     //Click button Submit
     
    public void ClickButtonSubmit() {
        try {
            getHelper().findElement(depositElement.ele_btn_submit).click();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
   
     //Click button Reset   
    public void ClickButtonReset() {
        try {
            getHelper().findElement(depositElement.ele_btn_reset).click();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Input all data & Submit at Deposit Page
     
    public void AddNewDeposit(Deposit deposit) {
        try {
            InputAccountId(deposit.accId);
            InputAmount(deposit.amount);
            InputDescription(deposit.description);
            ClickButtonSubmit();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    //Get new Transaction ID
     
    public String GetTransactionId() {
        String cusId = "";
        try {
            cusId = getHelper().getTextElement(depositElement.ele_label_table_transaction_id_value);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
        return cusId;
    }

    
    //Verify All elements in Deposit Page
     
    public void VerifyDepositPageAllElements() {
        try {
            getHelper().waitForControlVisible(depositElement.ele_input_acc_id);
            Assert.assertTrue(getHelper().isElementPresent(depositElement.ele_label_deposit_title));
            Assert.assertTrue(getHelper().isElementPresent(depositElement.ele_label_acc_id));
            Assert.assertTrue(getHelper().isElementPresent(depositElement.ele_input_acc_id));
            Assert.assertTrue(getHelper().isElementPresent(depositElement.ele_label_amount));
            Assert.assertTrue(getHelper().isElementPresent(depositElement.ele_input_amount));
            Assert.assertTrue(getHelper().isElementPresent(depositElement.ele_label_description));
            Assert.assertTrue(getHelper().isElementPresent(depositElement.ele_input_description));
            Assert.assertTrue(getHelper().isElementPresent(depositElement.ele_btn_submit));
            Assert.assertTrue(getHelper().isElementPresent(depositElement.ele_btn_reset));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    //Verify the header form add new Account
     
    public void TheDepositFormTitleShouldBe(String formTitle) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(depositElement.ele_label_deposit_title, formTitle));
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }

    
     //Verify new Deposit is added successfully
     
    public void VerifyDepositAddedSuccessfully(Deposit deposit) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(depositElement.ele_label_table_transaction_id_value, deposit.transId));
            Assert.assertTrue(getHelper().elementTextShoudlBe(depositElement.ele_label_table_acc_id_value, deposit.accId));
            Assert.assertTrue(getHelper().elementTextShoudlBe(depositElement.ele_label_table_amount_value, deposit.amount));
            Assert.assertTrue(getHelper().elementTextShoudlBe(depositElement.ele_label_table_type_transaction_value, deposit.typeOfTransaction));
            Assert.assertTrue(getHelper().elementTextShoudlBe(depositElement.ele_label_table_description_value, deposit.description));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
}
