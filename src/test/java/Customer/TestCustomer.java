package Customer;

import initEnvironement.BaseTest;
import initEnvironement.Constants;
import org.testng.annotations.*;
import screenObjects.CustomerPage;
import screenObjects.HomePage;
import screenObjects.LoginPage;
import utility.LogUtils;
import utility.entity.Customer;
import utility.helper.DateTime;

import java.lang.reflect.Method;
import java.util.Random;

import static SignUp.TestSignUp.UserName;
import static SignUp.TestSignUp.Password;
import static utility.PropertiesUtils.urlWebsiteLoginPro;

public class TestCustomer extends BaseTest {
    
    private LoginPage loginPage;
    private HomePage homePage;
    private CustomerPage customerPage;
    private Customer customer;
    public static String cusId;
    public static String cusName;
    public static String cusEmail;
    
    /*
     SCENARIO: TC003_create_new_customer_successfully
     Precondition: Account guru99 created from TestSignUp
     1: Login guru99/v4 by guru99 Account
     2: Goes to Create Customer page
     3: Verify UI of Create Customer page
     4: Input valid data & submit
     5: Verify Customer created successfully
     6: Get Customer ID, Name & Email for next suite run
     */
    
    @BeforeClass
    public void beforeClass() {
        super.setUp(urlWebsiteLoginPro);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        customerPage = new CustomerPage(driver);
    }

    @Test
    public void TC003_CreateNewCustomerSuccessfully() throws InterruptedException {

        loginPage.Login(UserName, Password);
        homePage.ClickLinkNewCustomer();
        customerPage.VerifyCustomerPageAllElements();
        customer = createCustomerData();
        customerPage.CreateNewCustomer(customer);
        Thread.sleep(2000);
        customerPage.TheTableHeaderTextShouldBe("Customer Registered Successfully!!!");
        customerPage.TheTableContentTextShouldBe("Registered Customer details are as follows:");
        customerPage.VerifyCustomerCreatedSuccessfully(customer);
        cusId = customerPage.GetCustomerId();
        cusName = customer.name;
        cusEmail = customer.email;

    }

    public Customer createCustomerData() {
        customer = new Customer();
        customer.name = ("Customer ".concat(getHelper().randomString()));
        String[] genders = {"m", "f"};
        customer.gender = getRandomStringArray(genders);
        customer.dateOfBirth = DateTime.getCurrentTime("MM/dd/yyyy");
        customer.address = getHelper().randomChars(10);
        String[] cities = {"AP", "Bengaluru", "Bbsr"};
        customer.city = getRandomStringArray(cities);
        String[] states = {"District A", "District B", "District C"};
        customer.state = getRandomStringArray(states);
        customer.pin = getHelper().randomNumber(6);
        customer.telephone = "99".concat(getHelper().randomNumber(8));
        customer.email = "iti" + System.currentTimeMillis() + "@gmail.com";
        customer.passWord = "123456";
        return customer;
    }

    public String getRandomStringArray(String[] strings) {
        Random ran = new Random();
        return strings[ran.nextInt(strings.length)];
    }


    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}