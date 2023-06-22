package utility.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import screenObjects.CommonPage;
import utility.Result;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Helper extends CommonPage {
    public Helper(WebDriver driver) {
        super(driver);
    }

    protected Wait<WebDriver> wait;

    public enum enumOsType {
        Windows, Linux, MacOS, Unknown;
    }

    public String jsColorBorderElement = "arguments[0].style='border: 1px solid; border-color: blue'";

    public class Constant {
        public static final int TIME_WAIT = 30;
        public static final int TIME_SLEEP = 5000;
    }

    /*
     * By locator
     */
    private By byLocator(String selectorTypeStr, String value) {
        By e = null;
        UISelectorType selector = UISelectorType.fromString(selectorTypeStr);
        switch (selector) {
            case ID:
                e = By.id(value);
                break;
            case TEXT_CONTAINS:
                e = By.xpath("//*[contains(@text, '" + value + "']");
                break;
            case TEXT:
                e = By.xpath("//*[@text = '" + value + "']");
                break;
            case TEXT_START_WITH:
                e = By.xpath("//*[starts-with(@text, '" + value + "']");
                break;
            case CLASS_NAME:
                e = By.className(value);
                break;
            case XPATH:
                e = By.xpath(value);
                break;
            case NAME:
                e = By.name(value);
                break;
            case LINK_TEXT:
                e = By.partialLinkText(value);
                break;
        }
        return e;
    }

    private By byLocator(String locator) {
        try {
            return byLocator(split(locator)[0], split(locator)[1]);
        } catch (Exception ex) {
            Result.checkFail("Exception desc : " + ex.getMessage());
            return null;
        }
    }

    public String[] split(String str) {
        try {
            return str.split(":::");
        } catch (Exception ex) {
            Result.checkFail("Exception desc : " + ex.getMessage());
            return null;
        }
    }

    public WebElement findElement(String locator) {
        try {
            WebElement e = driver.findElement(byLocator(locator));
            ((JavascriptExecutor) driver).executeScript(jsColorBorderElement, e);
            return e;
        } catch (Exception ex) {
            Result.checkFail("Exception desc : " + ex.getMessage()
                    + " \n Unable found locator: " + locator);
            return null;
        }
    }

    public List<WebElement> findElements(String locator) {
        try {
            List<WebElement> e = driver.findElements(byLocator(locator));
            for (WebElement el : e) {
                ((JavascriptExecutor) driver).executeScript(jsColorBorderElement, el);
            }
            return e;
        } catch (Exception ex) {
            Result.checkFail("Exception desc : " + ex.getMessage());
            return null;
        }
    }

    /*
     * Navigate back of browser
     */
    public void backButton() {
        try {
            driver.navigate().back();
        } catch (Exception ex) {
            Result.checkFail("Exception desc : " + ex.getMessage());
        }
    }

    /*
     * Refresh current page
     */
    public void refreshPage() {
        try {
            driver.navigate().refresh();
        } catch (Exception ex) {
            Result.checkFail("Exception desc : " + ex.getMessage());
        }
    }
    
    /*
     * Quit current page
     */
    public void quitPage() {
        try {
            driver.quit();
        } catch (Exception ex) {
            Result.checkFail("Exception desc : " + ex.getMessage());
        }
    }

    /*
     * Wait element by ID
     */
    public Boolean waitElementByID(String locationID) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locationID)));
        return element.isEnabled();
    }

    /*
     * Wait until element clickable
     */
    public void waitElementIsDisplayed(String locator) {
        WebElement el = findElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    /**
     * Verify element text
     *
     * @param locator
     * @return
     */
    public Boolean elementTextShoudlBe(String locator, String value) {
        Boolean isTextExists = false;
        try {
            WebElement el = findElement(locator);
            String actualValue = el.getText();
            isTextExists = actualValue.equals(value);
        } catch (NoSuchElementException e) {
            Result.checkFail("Exception desc : " + e.getMessage());
            return Result.bResult = false;
        }
        Result.bResult = isTextExists;
        return isTextExists;
    }

    /**
     * get exactly element text
     *
     * @param locator
     * @return
     */
    public String getTextElement(String locator) {
        WebElement el = findElement(locator);
        return el.getText();
    }

    /**
     * get exactly value of text field (txt/input)
     *
     * @param locator
     * @return
     */
    public String getValue(String locator) {
        WebElement el = findElement(locator);
        return el.getAttribute("value");
    }

    /**
     * get exactly value of text field (txt/input)
     *
     * @param locator
     * @param attribute
     * @return
     */
    public String getTextElementAttribute(String locator, String attribute) {
        WebElement el = findElement(locator);
        return el.getAttribute(attribute);
    }

    /*
     * Get Os Type
     */
    protected enumOsType getOsType() {
        enumOsType osType = enumOsType.Unknown;
        String osname = System.getProperty("os.name").toLowerCase();
        if (osname.contains("unix") || osname.contains("linux")) {
            osType = enumOsType.Linux;
        } else if (osname.contains("windows")) {
            osType = enumOsType.Windows;
        } else if (osname.contains("mac os")) {
            osType = enumOsType.MacOS;
        }
        return osType;
    }

    public WebDriver getDriver() {
        return driver;
    }

    /*
     * Add Log
     */
    public void addLog(String logmsg) {
        Reporter.log(logmsg + "</br>", true);

    }

    /*
     * Random a string with length = 6
     */
    public String randomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    /*
     * Random a random number in size
     */
    public int getRandomIndex(int size) {
        int random = 0;
        try {
            random = new Random().nextInt(size);
        } catch (Exception e) {
            Result.checkFail("Class Helper | Method getRandomIndex | Exception desc : " + e.getMessage());
            e.printStackTrace();
        }
        return random;
    }

    /*
     * Random string number length input
     */
    public String randomNumber(int numberChars) {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < numberChars) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    /*
     * Random a char with length input
     */
    public String randomChars(int numberChars) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < numberChars) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    /*
     * Wait until Jquery active
     */
    public void waitForAjax() {
        System.err.println("Checking active ajax calls by calling jquery.active ...");
        try {
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
                for (int i = 0; i < Constant.TIME_WAIT; i++) {
                    Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
                    // return should be a number
                    if (numberOfAjaxConnections instanceof Long) {
                        Long n = (Long) numberOfAjaxConnections;
                        System.err.println("Number of active jquery ajax calls: " + n);
                        if (n.longValue() == 0L)
                            break;
                    }
                    Thread.sleep(3000);
                }
            } else {
                System.err.println("Web driver: " + driver + " cannot execute javascript");
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    /*
     * Check element present or not
     */
    public Boolean isElementPresent(String locator) {
        Boolean isPresent = Boolean.FALSE;
        try {
            jsColorBorderElement = "arguments[0].style='border: 2px solid; border-color: green'";
            isPresent = findElements(locator).size() > 0;
            Result.bResult = isPresent;
            return isPresent;
        } catch (NoSuchElementException ex) {
            Result.checkFail("Class Helper | Method isElementPresent | Exception desc : " + ex.getMessage());
            Result.bResult = isPresent;
            return isPresent;
        }
    }

    /*
     * Scroll visible element
     */
    public void scrollByVisibleElement(WebElement element) {
        try {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            // now execute query which actually will scroll until that element is not
            // appeared on page.
            je.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception ex) {
            Result.checkFail("Class Helper | Method scrollByVisibleElement | Exception desc : " + ex.getMessage());
        }
    }

    /*
     * Scroll element by Pixel
     */
    public void scrollByPixel(int xPixel, int yPixel) {
        try {
            // Create instance of Javascript executor
            JavascriptExecutor je = (JavascriptExecutor) driver;
            // This will scroll down the page by 1000 pixel vertical
            je.executeScript("window.scrollBy(" + xPixel, yPixel + ")");
        } catch (Exception ex) {
            Result.checkFail("Class Helper | Method scrollByPixel | Exception desc : " + ex.getMessage());
        }
    }

    /*
     * Hover element
     */
    public void hover(String locator) {
        Actions action = new Actions(driver);
        WebElement e = findElement(locator);
        try {
            action.moveToElement(e).build().perform();
        } catch (NoSuchElementException ex) {
            addLog("\n[######### HOVER ELEMENT FAILED =========> The element NOT EXIST or NOT CLICKABLE\n] "
                    + ex.getMessage());
        }
    }

    /*
     * Wait for a element is visible
     */
    public void waitForControlVisible(String locator) {
        WebDriverWait waitVisible = new WebDriverWait(driver, 30);
        waitVisible.until(ExpectedConditions.visibilityOfElementLocated(byLocator(locator)));
    }

    /*
     * Wait for a element show in limit (s) time.
     */
    public void waitForElementDisplay(String element, int limit) {
        int count = 0;
        boolean found = false;
        do {
            try {
                findElement(element);
                found = true;
            } catch (Exception ex) {
                count++;
                System.out.println("Element with locator: " + element + " does not show");
            }
        } while (count <= limit && !found);

    }

    /*
     * Confirm the alert of browser
     */
    public void confirmAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception ex) {
            Result.checkFail("Class Helper | Method ConfirmAlert | Exception desc : " + ex.getMessage());
        }
    }

    /*
     * Get random a value from String[]
     */
    public String getRandomStringArray(String[] strings) {
        Random ran = new Random();
        return strings[ran.nextInt(strings.length)];
    }
}
