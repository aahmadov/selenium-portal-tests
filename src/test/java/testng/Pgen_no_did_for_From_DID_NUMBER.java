package testng;

import Pages.WelcomeMail;
import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.FileReaderTestNG;
import UtilsTesNG.RestRequestUtils;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Pgen_no_did_for_From_DID_NUMBER extends TestBase {

    @Test(priority = 1, testName = "If user dosen't hava a DID number Cover Page to be empty)", groups = {"Regression84123"})
    public void cpgen_no_did_1_User_has_a_DID_number() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;
        driver.get("http://10.250.1.84:80/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);
        Oj.UsernameTextBox.sendKeys(data.get("UserName"));
        Oj.PasswordTextBox.sendKeys(data.get("Password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.SubMenuManage.click();
        Oj.Users.click();
        Thread.sleep(1000 * 2);
        Oj.faxsendingEditBTN.click();
        Thread.sleep(1000 * 2);
        Oj.numberChange.click();
        Thread.sleep(1000 * 2);
        Oj.numberChange.clear();
        Thread.sleep(1000 * 2);
        Oj.SaveBTN.click();
        Thread.sleep(1000 * 3);
        Oj.faxAdminDropdown.click();
        Thread.sleep(1000 * 3);
        Oj.Logout.click();
        String Deletequery = "delete from auto1.settings where sname= 'cpgen.no_did';";
        DataBaseUTIL.executeSQLUpdateRecvD81(Deletequery);

        String Insertquery2 = "INSERT INTO auto1.settings (sname, svalue) VALUES ('cpgen.no_did', '1');";
        DataBaseUTIL.executeSQLUpdateRecvD81(Insertquery2);

        Response response = RestRequestUtils.sendFaxwithoutAttachment_withTiff_81(
                data.get("post_call_Url"), data.get("CoverPage"), data.get("faxNumber"), data.get("credentials"));

        assertEquals(Integer.parseInt(data.get("expectedStatusCode")), response.getStatusCode());
        String resp = response.prettyPrint();
        String faxId = JsonPath.read(resp, "$.FaxInfo[0].FaxId").toString();
        assertTrue(resp.contains(faxId));
        // Wait for the fax to be processed
        Thread.sleep(1000 * 30);

        String coverpageJobId = String.format("SELECT * FROM auto1.coverpage WHERE JobId = '%s'", faxId); ;
        DataBaseUTIL.executeSQLQuery84Database(coverpageJobId);
        Thread.sleep(1000*5);

        String Deletequery3 = "delete from auto1.settings where sname= 'cpgen.no_did';";
        DataBaseUTIL.executeSQLUpdateRecvD81(Deletequery3);

        String Insertquery4 = "INSERT INTO auto1.settings (sname, svalue) VALUES ('cpgen.no_did', '0');";
        DataBaseUTIL.executeSQLUpdateRecvD81(Insertquery4);

        driver.get("http://10.250.1.84:80/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        Oj.UsernameTextBox.sendKeys(data.get("UserName"));
        Oj.PasswordTextBox.sendKeys(data.get("Password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.SubMenuManage.click();
        Oj.Users.click();
        Thread.sleep(1000 * 2);
        Oj.faxsendingEditBTN.click();
        Thread.sleep(1000 * 2);
        Oj.numberChange.click();
        Thread.sleep(1000 * 2);
        Oj.numberChange.sendKeys(data.get("recipient"));
        Thread.sleep(1000 * 2);
        Oj.SaveBTN.click();


    }
    @Test(priority = 1, testName = "If user dosen't hava a DID number Cover Page to be empty)", groups = {"Regression4612"})
    public void cpgen_no_did_1_User_has_a_DID_number46() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;
        driver.get("http://10.250.1.46:8585/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);
        Oj.UsernameTextBox.sendKeys(data.get("UserName"));
        Oj.PasswordTextBox.sendKeys(data.get("Password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.SubMenuManage.click();
        Oj.Users.click();
        Thread.sleep(1000 * 2);
        Oj.faxsendingEditBTN.click();
        Thread.sleep(1000 * 2);
        Oj.numberChange.click();
        Thread.sleep(1000 * 2);
        Oj.numberChange.clear();
        Thread.sleep(1000 * 2);
        Oj.SaveBTN.click();
        Thread.sleep(1000 * 3);
        Oj.faxAdminDropdown.click();
        Thread.sleep(1000 * 3);
        Oj.Logout.click();
        String Deletequery = "delete from auto1.settings where sname= 'cpgen.no_did';";
        DataBaseUTIL.executeSQLUpdateRecvD46(Deletequery);

        String Insertquery2 = "INSERT INTO auto1.settings (sname, svalue) VALUES ('cpgen.no_did', '1');";
        DataBaseUTIL.executeSQLUpdateRecvD46(Insertquery2);

        Response response = RestRequestUtils.sendFaxwithoutAttachment_withTiff_81(
                data.get("post_call_Url"), data.get("CoverPage"), data.get("faxNumber"), data.get("credentials"));

        assertEquals(Integer.parseInt(data.get("expectedStatusCode")), response.getStatusCode());
        String resp = response.prettyPrint();
        String faxId = JsonPath.read(resp, "$.FaxInfo[0].FaxId").toString();
        assertTrue(resp.contains(faxId));
        // Wait for the fax to be processed
        Thread.sleep(1000 * 30);

        String coverpageJobId = String.format("SELECT * FROM auto1.coverpage WHERE JobId = '%s'", faxId); ;
        DataBaseUTIL.executeSQLQuery46Database(coverpageJobId);
        Thread.sleep(1000*5);

        String Deletequery3 = "delete from auto1.settings where sname= 'cpgen.no_did';";
        DataBaseUTIL.executeSQLUpdateRecvD46(Deletequery3);

        String Insertquery4 = "INSERT INTO auto1.settings (sname, svalue) VALUES ('cpgen.no_did', '0');";
        DataBaseUTIL.executeSQLUpdateRecvD46(Insertquery4);

        driver.get("http://10.250.1.46:8585/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        Oj.UsernameTextBox.sendKeys(data.get("UserName"));
        Oj.PasswordTextBox.sendKeys(data.get("Password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.SubMenuManage.click();
        Oj.Users.click();
        Thread.sleep(1000 * 2);
        Oj.faxsendingEditBTN.click();
        Thread.sleep(1000 * 2);
        Oj.numberChange.click();
        Thread.sleep(1000 * 2);
        Oj.numberChange.sendKeys(data.get("recipient"));
        Thread.sleep(1000 * 2);
        Oj.SaveBTN.click();


    }

}