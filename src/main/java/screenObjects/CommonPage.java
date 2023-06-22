package screenObjects;

import org.openqa.selenium.WebDriver;
import utility.helper.Helper;

public class CommonPage {
    public WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public Helper getHelper() {
        return new Helper(driver);
    }

}
