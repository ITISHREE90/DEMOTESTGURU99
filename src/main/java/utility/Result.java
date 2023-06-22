package utility;

import initEnvironement.Constants;
import org.testng.Assert;

public class Result {
    public static boolean bResult = true;
    public static boolean bSkip = true;
    public static String sErrorLog;
    public String sResult = Constants.PASS;

    public void setResult(String result) {
        this.sResult = result;
    }

    public String getResult() {
        return sResult;
    }

    private static void check(String message) {
        if (!bResult) {
            LogUtils.error(message);
            LogUtils.addLog(message);
            Result.sErrorLog = message;
        }
        Assert.assertEquals(bResult, true, message);
    }

    public static void checkFail(String setObservation) {
        Result.bResult = false;
        Result.check(setObservation);
    }

}
