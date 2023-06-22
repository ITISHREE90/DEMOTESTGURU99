package utility;

import initEnvironement.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import screenObjects.CommonPage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static initEnvironement.BaseTest.reportFolder;

public class ScreenshotUtils extends CommonPage {

    public ScreenshotUtils(WebDriver driver) {
        super(driver);
    }

    public String takeScreenshot(String ClassNames, String fileName) {
        try {
            String sProjectPath = new File("test-reports/").getAbsolutePath().concat(File.separator);
            DateFormat dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
            //To get current date time with Date()
            Date date = new Date();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileScrShot = sProjectPath.concat(reportFolder).concat(File.separator).concat(ClassNames) + File.separator + fileName + "_" + dateFormat.format(date).toString() + ".png";
            try {
                FileUtils.copyFile(scrFile, new File(fileScrShot));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.err.println(e);
            }

            LogUtils.info("Captured a screenshot to: " + fileScrShot);
            return fileScrShot;
        } catch (Exception e) {
            Result.checkFail("Class ScreenshotUtils | Method takeScreenshot | Exception desc : " + e.getMessage());
            return null;
        }
    }
}
