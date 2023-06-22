package screenObjects;

import models.CustomerElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Result;
import utility.entity.Customer;
import utility.helper.DateTime;

public class CustomerPage extends CommonPage {
    public boolean LogoutSuccess = true;
    CustomerElement customerElement;

    public CustomerPage(WebDriver driver) {
        super(driver);
        customerElement = new CustomerElement();
    }

    //Input Customer Name
    public void InputCustomerName(String cusName) {
        try {
            getHelper().findElement(customerElement.ele_input_cus_name).sendKeys(cusName);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
  
     // Select Customer Gender
    public void SelectCustomerGender(String cusGenderCharacter) {
        try {
            getHelper().findElement(String.format(customerElement.ele_input_cus_gender, cusGenderCharacter)).click();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Input Customer Date of Birth
     
    public void InputCustomerBirthDay(String birthDate) {
        try {
            getHelper().findElement(customerElement.ele_input_cus_birth_day).sendKeys(birthDate);
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }

    
     //Input Customer Address
     
    public void InputCustomerAddress(String address) {
        try {
            getHelper().findElement(customerElement.ele_input_cus_address).sendKeys(address);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    //Input Customer City
     
    public void InputCustomerCity(String city) {
        try {
            getHelper().findElement(customerElement.ele_input_cus_city).sendKeys(city);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Input Customer State
     
    public void InputCustomerState(String state) {
        try {
            getHelper().findElement(customerElement.ele_input_cus_state).sendKeys(state);
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }

    
     //Input Customer PIN
     
    public void InputCustomerPin(String pin) {
        try {
            getHelper().findElement(customerElement.ele_input_cus_pin).sendKeys(pin);
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }

     //Input Customer Phone Number
     
    public void InputCustomerPhoneNumber(String pin) {
        try {
            getHelper().findElement(customerElement.ele_input_cus_telephone).sendKeys(pin);
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }

    //Input Customer Email
     
    public void InputCustomerEmail(String email) {
        try {
            getHelper().findElement(customerElement.ele_input_cus_email).sendKeys(email);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

     //Input Customer Password
     
    public void InputCustomerPassword(String password) {
        try {
            getHelper().findElement(customerElement.ele_input_cus_password).sendKeys(password);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

     //Click button Submit
     
    public void ClickButtonSubmit() {
        try {
            getHelper().findElement(customerElement.ele_btn_submit).click();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Click button Reset
     
    public void ClickButtonReset() {
        try {
            getHelper().findElement(customerElement.ele_btn_reset).click();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Input all data to Customer Page
     
    public void CreateNewCustomer(Customer cus) {
        try {
            InputCustomerName(cus.name);
            SelectCustomerGender(cus.gender);
            InputCustomerBirthDay(cus.dateOfBirth);
            InputCustomerAddress(cus.address);
            InputCustomerCity(cus.city);
            InputCustomerState(cus.state);
            InputCustomerPin(cus.pin);
            InputCustomerPhoneNumber(cus.telephone);
            InputCustomerEmail(cus.email);
            InputCustomerPassword(cus.passWord);
            ClickButtonSubmit();
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Get new Customer ID
     
    public String GetCustomerId() {
        String cusId = "";
        try {
            cusId = getHelper().getTextElement(customerElement.ele_label_table_cus_id_value);
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
        return cusId;
    }

    
     //Verify All elements in Customer Page
     
    public void VerifyCustomerPageAllElements() {
        try {
            getHelper().waitForControlVisible(customerElement.ele_label_new_customer_title);
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_label_cus_name));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_name));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_lbl_cus_gender));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_gender_m));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_gender_f));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_label_cus_birth_day));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_birth_day));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_label_cus_address));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_address));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_label_cus_city));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_city));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_label_cus_state));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_state));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_label_cus_pin));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_pin));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_label_cus_telephone));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_telephone));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_label_cus_email));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_email));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_label_cus_password));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_input_cus_password));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_btn_submit));
            Assert.assertTrue(getHelper().isElementPresent(customerElement.ele_btn_reset));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    
     //Verify the table header create new Customer successfully
    
    public void TheTableHeaderTextShouldBe(String tableHeaderText) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_new_customer_title, tableHeaderText));
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }
 
    //Verify the table content new Customer successfully
     
    public void TheTableContentTextShouldBe(String tableContentText) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_registered_cus_detail, tableContentText));
        } catch (Exception e) {
            Result.checkFail(" Exception desc : " + e.getMessage());
        }
    }

   // Verify new Customer created successfully
     
    public void VerifyCustomerCreatedSuccessfully(Customer cus) {
        try {
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_name_value, cus.name));
            if (cus.gender.equals("f"))
                Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_gender_value, "female"));
            else
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_gender_value, "male"));
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_birth_date_value, DateTime.convertDateToNewFormat(cus.dateOfBirth, "MM/dd/yyyy", "yyyy-MM-dd")));
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_address_value, cus.address));
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_city_value, cus.city));
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_state_value, cus.state));
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_pin_value, cus.pin));
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_telephone_value, cus.telephone));
            Assert.assertTrue(getHelper().elementTextShoudlBe(customerElement.ele_label_table_cus_email_value, cus.email));
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }
}
