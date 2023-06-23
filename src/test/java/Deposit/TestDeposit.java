package Deposit;

import initEnvironement.BaseTest;
import initEnvironement.Constants;
import org.testng.annotations.*;
import screenObjects.DepositPage;
import screenObjects.HomePage;
import screenObjects.LoginPage;
import utility.LogUtils;
import utility.entity.Deposit;

import java.lang.reflect.Method;

import static Account.TestAccount.accId;
import static SignUp.TestSignUp.UserName;
import static SignUp.TestSignUp.Password;
import static utility.PropertiesUtils.urlWebsiteLoginPro;

public class TestDeposit extends BaseTest {
  
    private LoginPage loginPage;
    private HomePage homePage;
    private DepositPage depositPage;
    public static String transId;
    private Deposit deposit;
    
    /*
    SCENARIO: TC005_add_new_deposit_successfully
    Precondition: Acc guru99 created from TestSignUp & Account ID from TestAccount suite "cusId"
    1: Login guru99/v4 by guru99 Account
    2: Goes to Deposit page
    3: Verify UI of Deposit page
    4: Input valid data & submit
    5: Verify Deposit is added successfully
    */

    @BeforeClass
    public void beforeClass() {
        super.setUp(urlWebsiteLoginPro);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        depositPage = new DepositPage(driver);
    }

    @Test(priority=5)
    public void TC005_AddNewDepositSuccessfully() throws InterruptedException {
    
        loginPage.Login(UserName, Password);
        homePage.ClickLinkDeposit();

        depositPage.VerifyDepositPageAllElements();
        depositPage.TheDepositFormTitleShouldBe("Amount Deposit Form");

        deposit = createDepositData();
        depositPage.AddNewDeposit(deposit);
        
        Thread.sleep(2000);
        
        depositPage.TheDepositFormTitleShouldBe("Transaction details of Deposit for Account ".concat(deposit.accId));
        transId = depositPage.GetTransactionId();
        deposit.transId = transId;
        depositPage.VerifyDepositAddedSuccessfully(deposit);

    }

    public Deposit createDepositData() {
        deposit = new Deposit();
        deposit.accId = accId;
        deposit.amount = getHelper().randomNumber(5);
        deposit.typeOfTransaction = "Deposit";
        deposit.description = getHelper().randomString();
        return deposit;
    }

    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
}