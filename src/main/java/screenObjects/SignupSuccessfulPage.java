package screenObjects;

import models.SignupSuccessfulElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;

public class SignupSuccessfulPage extends CommonPage {
    SignupSuccessfulElement signupSuccessfulElement;

    public SignupSuccessfulPage(WebDriver driver) {
        super(driver);
        signupSuccessfulElement = new SignupSuccessfulElement();
    }
    
     //Create an Account
     
    public String GetAccountName() {
        String accName = "";
        try {
            accName = getHelper().getTextElement(signupSuccessfulElement.ele_label_id_value);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
        return accName;
    }
  
     //Create Account Password
    
    public String GetAccountPassword() {
        String passWord = "";
        try {
            passWord = getHelper().getTextElement(signupSuccessfulElement.ele_label_password_value);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
        return passWord;
    }
    
     //Verify All elements in Create Account Successful Page
     
    public void VerifyCreatedAccountSuccessfulPageAllElements() {
       
        try {
            getHelper().waitForControlVisible(signupSuccessfulElement.ele_table_title);
            Assert.assertTrue(getHelper().isElementPresent(signupSuccessfulElement.ele_table_title));
            Assert.assertTrue(getHelper().isElementPresent(signupSuccessfulElement.ele_label_id_text));
            Assert.assertTrue(getHelper().isElementPresent(signupSuccessfulElement.ele_label_id_value));
            Assert.assertTrue(getHelper().isElementPresent(signupSuccessfulElement.ele_label_password_text));
            Assert.assertTrue(getHelper().isElementPresent(signupSuccessfulElement.ele_label_password_value));
            Assert.assertTrue(getHelper().isElementPresent(signupSuccessfulElement.ele_label_note));
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }
   
     //Verify the bar text in SignUp Page
     
    public void TheBarTextShouldBe(String guruBarText) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(signupSuccessfulElement.ele_label_guru_bar, guruBarText));
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }
  
     //Verify Account
     
    public void VerifyAccount(String accName, String passWord) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(signupSuccessfulElement.ele_label_id_value, accName));
            Assert.assertTrue(getHelper().elementTextShoudlBe(signupSuccessfulElement.ele_label_password_value, passWord));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
   
     //Verify the table text in SignUp Page Successfully
     
    public void TheTableTextShouldBe(String guruTableText) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(signupSuccessfulElement.ele_table_title, guruTableText));
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }

   
     //Verify the user cusId text in SignUp Page Successfully
     
    public void TheUserIdTextShouldBe(String guruUserIdText) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(signupSuccessfulElement.ele_label_id_text, guruUserIdText));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
    
     //Verify the pass word text in SignUp Page Successfully
     
    public void ThePassWordTextShouldBe(String guruPasswordText) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(signupSuccessfulElement.ele_label_password_text, guruPasswordText));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
    
     //Verify the note text in SignUp Page Successfully
     
    public void TheNoteTextShouldBe(String guruNoteText) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(signupSuccessfulElement.ele_label_note, guruNoteText));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
}
