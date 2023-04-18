package TestSuiteSel;

import JSonUtilsTesNG.FileReader;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class LoginTest extends TestBase {

   @Test()
    public void sendFaxDataFromPortal() {
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReader.getDataBasedOnTestCaseName(testName);
        assert data != null;

    }
}
// @Test(testName = "Send Fax from portal with valid credentials", groups = {"smoke"})