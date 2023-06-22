package initEnvironement;

import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);

            extent
                    .addSystemInfo("User Name", "Itishree")
                    .addSystemInfo("Host Name", "Iti")
                    .addSystemInfo("Environment", "QA");

            extent.loadConfig(new File("Extent-Config.xml"));
        }

        return extent;
    }
}
