package Account;

import initEnvironement.BaseTest;
import initEnvironement.Constants;
import org.testng.annotations.*;
import screenObjects.AccountPage;
import screenObjects.HomePage;
import screenObjects.LoginPage;
import utility.entity.Account;
import utility.helper.DateTime;

import static Customer.TestCustomer.*;
import static SignUp.TestSignUp.UserName;
import static SignUp.TestSignUp.Password;
import static utility.PropertiesUtils.urlWebsiteLoginPro;

public class TestAccount extends BaseTest {
    
    private LoginPage loginPage;
    private HomePage homePage;
    private AccountPage accountPage;
    public static String accId;
    private Account account;
    
    /*
     SCENARIO: TC004_create_new_account_successfully
     Precondition: Account guru99 created from TestSignUp & Customer cusId from TestCustomer suite "cusId"
     1: Login guru99/v4 by guru99 Account
     2: Goes to Create Account page
     3: Verify UI of Create Account page
     4: Input valid data & submit
     5: Verify Account created successfully
     6: Get Account ID for next suite
     */
    
    @BeforeClass
    public void beforeClass() {
        super.setUp(urlWebsiteLoginPro);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);        
    }

    @Test
    public void TC004_CreateNewAccountSuccessfully() throws InterruptedException {
    
        loginPage.Login(UserName, Password);
        homePage.ClickLinkNewAccount();
        accountPage.VerifyAccountPageAllElements();
        accountPage.TheAccountFormTitleShouldBe("Add new account form");
        account = createAccountData();
        accountPage.CreateNewAccount(account);
        Thread.sleep(2000);
        accountPage.TheAccountFormTitleShouldBe("Account Generated Successfully!!!");
        accountPage.TheTableContentTextShouldBe("Created Account details are as follows:");
        accId = accountPage.GetAccountId();
        account.accId = accId;
        accountPage.VerifyAccountCreatedSuccessfully(account);
    }

    public Account createAccountData() {
        account = new Account();
        account.cusId = cusId;
        account.cusName = cusName;
        account.cusEmail = cusEmail;
        String[] accTypes = {"Savings", "Current"};
        account.accType = getHelper().getRandomStringArray(accTypes);
        account.dateOpening = DateTime.getCurrentTime("yyyy-MM-dd");
        account.currentAmount = getHelper().randomNumber(5);
        return account;
    }

    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}