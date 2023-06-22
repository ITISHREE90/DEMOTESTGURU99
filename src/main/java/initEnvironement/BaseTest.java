package initEnvironement;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
//import org.testng.Reporter;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utility.*;
import utility.helper.DateTime;
import utility.helper.Helper;
import java.util.concurrent.TimeUnit;

public class BaseTest {
	
    public static WebDriver driver;
    
    public static String currentDir;
    public static String reportFolder = "";
    public ExtentTest test;

    public ScreenshotUtils getScreenshot() {
        return new ScreenshotUtils(driver);
    }

    public Helper getHelper() {
        return new Helper(driver);
    }

    protected static ExtentReports extent;
    final String reportPath = "./Extent.html";

    @BeforeSuite
    public void beforeSuite() {
        //Main Directory of the project
        currentDir = System.getProperty("user.dir");
        PropertiesUtils.readGlobalPropertyFile();
        extentReport();
    }

    public void setUp(String url) {
        openBrowser(url);
    }

    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void openBrowser(String url) {
        try {
            if (PropertiesUtils.getBrowserPro.equalsIgnoreCase(BrowserType.FIREFOX)) {
                FirefoxDriverManager.getInstance().version(PropertiesUtils.FFVersionPro).setup();
                driver = new FirefoxDriver();
                LogUtils.info("---Firefox browser started----");
            } else if (PropertiesUtils.getBrowserPro.equalsIgnoreCase(BrowserType.IE)) {
                InternetExplorerDriverManager.getInstance().version(PropertiesUtils.IEVersionPro).setup();
                driver = new InternetExplorerDriver();
                LogUtils.info("---IE browser started----");
            } else if (PropertiesUtils.getBrowserPro.equalsIgnoreCase(BrowserType.CHROME)) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");      
                ChromeDriverManager.getInstance().version(PropertiesUtils.ChromeVersionPro).setup();
                driver = new ChromeDriver(options);
                LogUtils.info("----Chrome browser started---");
            }
            
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().fullscreen();
            driver.get(url);
            
        } catch (Exception e) {
            Result.checkFail("Exception desc : " + e.getMessage());
        }
    }

    private void extentReport() {
        reportFolder = DateTime.getCurrentTime("yyyy_MM_dd_HH_mm_ss");
        String reportPath = "test-reports/" + reportFolder;
        FolderFile.createMutilFolder(reportPath);
        extent = ExtentManager.getReporter("test-reports/" + reportFolder + "/ExtentReport.html");
    }
}
