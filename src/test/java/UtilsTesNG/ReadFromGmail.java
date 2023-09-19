package UtilsTesNG;

import Utilities.FileReaderCucumber;
import org.testng.annotations.Test;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

public class ReadFromGmail extends TestBase {

    String bodyMessage = ConfigReader.getProperty("bodyMessage");
    String from = "no-reply@rpxqa.com";

    @Test(testName = "Send mail to Fax", groups = {"RegressionNotWorking"})
    void sendMailToFaxForPortal() throws Exception {
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        List<String> faxNumbers = FileReaderTestNG.convertToList(CsvUtils.readAllLines(ResourceUtils.getResourceFilePathAbsPath(data.get("faxNumFileLoc"))));

        // loop to send email based on of times provided in the scenario
        for (int i = 1; i <= Integer.parseInt(data.get("times")); i++) {
            System.out.println("Iteration time of sendmail in the loop :" + i);

            String faxNumber;
            String toEmail;
            //Checking whether to contains FaxNumber in scenario,
            if (data.get("to").contains("@")) {
                //Get FaxNumber if already exist in the 'to' field+
                faxNumber = data.get("to").split("@")[0];
                toEmail = data.get("to");
            } else {
                //If FaxNumber is blank, get the Fax number from file randomly and generate 'to' address
                faxNumber = faxNumbers.get(ThreadLocalRandom.current().nextInt(faxNumbers.size()));
                toEmail = faxNumber + "@" + data.get("to"); // result: 1234567891@auto1.rpxqa.com
            }

            //Read the subject string and add the FaxNumber into the string
            String emailSubject = ConfigReader.getProperty(data.get("subject")); // result: Inbound Fax to 11111111111, Unassigned Faxes (Received)
            File file = FileReader.getFileUsingPageSize(data.get("pageSize"), "pdf");
            System.out.println("to: " + toEmail);
            System.out.println("file: " + file.getAbsolutePath());

            Date startTime = Calendar.getInstance().getTime();

            SendMail.sendFromGMail(toEmail, bodyMessage, file, Boolean.parseBoolean(data.get("sendBody")));

            Boolean result = ReceiveMail.receiveEmail(from, emailSubject);

            if (!result) {

                System.out.println("*** after 5 min iteration, there is not a expected notification");

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String startTimeString = formatter.format(startTime);
                Date endTime = Calendar.getInstance().getTime();
                String endTimeString = formatter.format(endTime);

                String EmailToFaxQuery = String.format("select JobStatus,FaxNumber from auto1.sendstatus where (CreateTime between '%s' and '%s') order by JobID desc limit 1;", startTimeString, endTimeString);

                List<Map<String, Object>> results = DataBaseUTIL.executeSQLQueryRecvD(EmailToFaxQuery);
                if (results.size() == 0) {
                    fail("***:No record present in the Database for the fax email sent");
                }
                System.out.println(results);
                assertEquals("Sent", results.get(0).get("JobStatus"));
            }
        }
    }

}
