package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Map;

public class PdfScan_1_100 extends TestBase {
    @Test(testName = "Send Fax from portal with valid credentials", groups = {"Regression10012"})
    public void sendFaxForPDFScale() throws InterruptedException, AWTException, SQLException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.84");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        Thread.sleep(1000 * 3);
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxingButton.click();
        loginPageObj.sendFaxButton.click();
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 3);
        loginPageObj.uploadPage.click();
        Thread.sleep(1000 * 5);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display = 'block';", loginPageObj.uploadPage); // Make the element visible
//        loginPageObj.uploadPage.sendKeys(" C:\\Users\\Administrator\\workspace\\com-selenium-test\\src\\test\\resources\\requestBody\\2page.pdf");
        //driver.findElement(By.xpath("//input[@type=\"file\"]"));
        //find_element_by_xpath('//input[@type="file"]').get_attribute('outerHTML')
        //File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
        File pagesSize = FileReader.readfile2("8-5by5-5");
        Robot rb = new Robot();
        rb.delay(1000 * 2);
        //put the path to file in clipboard
        StringSelection Filepath = new StringSelection(pagesSize.toString());
        System.out.println("File Name: " + pagesSize.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
        Thread.sleep(1000 * 3);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(1000);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(1000);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(300);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(1000 * 5);

        loginPageObj.ClickSendButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.confirmationButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxesBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.OutboundRadiobox.click();
        Thread.sleep(1000 * 3);
        loginPageObj.searchBTN.click();

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 3000)");
        // Define the timeout duration in seconds
        int timeoutInSeconds = 180; // Adjust the timeout as needed

        // Loop until the info button is visible or timeout occurs
        long startTime = System.currentTimeMillis();
        boolean PdfButton = false;

        while (!PdfButton && (System.currentTimeMillis() - startTime) < timeoutInSeconds * 1000) {
            // Click the search button
            WebElement clickSearchBtn = driver.findElement(By.xpath("//*[@id='SearchForFaxes']"));
            clickSearchBtn.click();

            // Wait for info btn to be visible
            try {
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds for the info btn to appear
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[1]")));
                PdfButton = true; // Exit the loop if Info btn is found
            } catch (org.openqa.selenium.TimeoutException e) {
                // info btn is not found yet, continue the loop
            }
        }
        // Click on info btn if found
        if (PdfButton) {
            WebElement PdfBtn = driver.findElement(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[1]"));
            PdfBtn.click();
        } else {
            System.out.println("Timeout: PDF button not found within " + timeoutInSeconds + " seconds.");
        }
        Thread.sleep(1000 * 5);
        loginPageObj.InboundRadiobox.click();
        Thread.sleep(1000 * 5);
        loginPageObj.searchBTN.click();
        Thread.sleep(1000 * 3);
        WebElement PDFBtnInbound = driver.findElement(By.xpath("//table[@id='inboundFaxes']/tbody/tr[1]//button[1]"));
        Thread.sleep(1000 * 3);
        PDFBtnInbound.click();
        Thread.sleep(1000 * 10);
        String query = "SELECT JobID FROM auto1.recvstatus order by JobID desc limit 1;";
        String jobId = DataBaseUTIL.executeSQLQueryRecvD(query).toString();
        String JobIdTrimed = jobId.replace("JobID=", "");
        String username = "Administrator";
        String password = "Auto*1234!";
        String remoteFilePath = "\\\\10.250.1.67\\c$\\Users\\Administrator\\Downloads\\_recv-fax-"+JobIdTrimed.replace("[{", "").replace("}]", "")+".pdf.crdownload";
//        String remoteFilePath = "\\\\10.250.1.100\\c$\\Users\\Administrator\\Downloads\\recv-fax-1149.pdf";
        FileSystemManager fsManager = null;
        FileObject remoteFile = null;
        StaticUserAuthenticator auth = null;
        FileSystemOptions opts = new FileSystemOptions();

        try {
            // Set up the file system manager
            fsManager = VFS.getManager();

            // Set up the authenticator
            auth = new StaticUserAuthenticator(null, username, password);
            DefaultFileSystemConfigBuilder defaultConfigBuilder = DefaultFileSystemConfigBuilder.getInstance();
            defaultConfigBuilder.setUserAuthenticator(opts, auth);

            // Directly use the fully qualified SMB URI
            remoteFile = fsManager.resolveFile(remoteFilePath, opts);


            if (remoteFile.exists()) {
                try (PDDocument document = PDDocument.load(remoteFile.getContent().getInputStream())) {
                    measurePdfSize(document);
                }
            } else {
                System.out.println("The specified file does not exist: " + remoteFilePath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void measurePdfSize(PDDocument document) {
        try {
            int pageCount = document.getNumberOfPages();
            System.out.println("Total number of pages: " + pageCount);

            double desiredWidthInches = 8.5;
            double desiredHeightInches = 11.00;
            int resolution = calculateResolution(document, desiredWidthInches, desiredHeightInches);

            for (int i = 0; i < pageCount; i++) {
                PDFRenderer renderer = new PDFRenderer(document);
                BufferedImage image = renderer.renderImageWithDPI(i, resolution);

                int widthPixels = image.getWidth();
                int heightPixels = image.getHeight();

                double widthInches = widthPixels / (double) resolution;
                double heightInches = heightPixels / (double) resolution;
                System.out.println("Page " + (i + 1) + " size: " + widthInches + "x" + heightInches + " inches");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateResolution(PDDocument document, double desiredWidthInches, double desiredHeightInches) {
        int pageWidthPoints = (int) document.getPage(0).getMediaBox().getWidth();
        int pageHeightPoints = (int) document.getPage(0).getMediaBox().getHeight();
        int resolutionWidth = (int) (pageWidthPoints / desiredWidthInches);
        int resolutionHeight = (int) (pageHeightPoints / desiredHeightInches);
        return Math.min(resolutionWidth, resolutionHeight);

    }
}


//        String user = "Administrator";  // Your SSH username
//        String host = "10.250.1.84";    // The IP address or hostname of your remote machine
//        int port = 22;                  // SSH port, usually 22
//        String password = "5yeDJH4el!#hW";  // Password for the SSH account
//        String remoteFilePath = "/cygdrive/c/Users/Administrator/Downloads/_recv-fax-"+JobIdTrimed.replace("[{}],","")+".pdf";  // Path to the file in Cygwin
//        String localFilePath = "C:/Users/Administrator/Downloads/";
//        try {
//            // Step 1: Set up JSch and configure the session
//            JSch jsch = new JSch();
//            Session session = jsch.getSession(user, host, port);
//            session.setPassword(password);
//
//            // Configure to skip host key checking (not recommended for production)
//            session.setConfig("StrictHostKeyChecking", "no");
//
//            // Step 2: Connect to the remote machine
//            System.out.println("Connecting to the remote machine...");
//            session.connect();
//            System.out.println("Connected!");
//
//            // Step 3: Open an SFTP channel
//            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
//            sftpChannel.connect();
//            System.out.println("SFTP channel opened.");
//
//            // Step 4: Download the file from the remote machine to the local machine
//            try (InputStream inputStream = sftpChannel.get(remoteFilePath);
//                 FileOutputStream outputStream = new FileOutputStream(new File(localFilePath))) {
//
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
//                System.out.println("File downloaded to: " + localFilePath);
//            }
//
//            // Step 5: Measure the PDF size using the method you provided
//            File localFile = new File(localFilePath);
//            measurePdfSize(localFile);
//
//            // Step 6: Disconnect from the remote machine
//            sftpChannel.disconnect();
//            session.disconnect();
//            System.out.println("Disconnected from the remote machine.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Method to measure PDF size
//    private static void measurePdfSize(File pdfFile) {
//        try {
//            PDDocument document = PDDocument.load(pdfFile);
//            int pageCount = document.getNumberOfPages();
//            System.out.println("Total number of pages: " + pageCount);
//
//            double desiredWidthInches = 8.5;
//            double desiredHeightInches = 11.00;
//            int resolution = calculateResolution(document, desiredWidthInches, desiredHeightInches);
//
//            for (int i = 0; i < pageCount; i++) {
//                PDFRenderer renderer = new PDFRenderer(document);
//                BufferedImage image = renderer.renderImageWithDPI(i, resolution);
//
//                int widthPixels = image.getWidth();
//                int heightPixels = image.getHeight();
//
//                double widthInches = widthPixels / (double) resolution;
//                double heightInches = heightPixels / (double) resolution;
//                System.out.println("Page " + (i + 1) + " size: " + widthInches + "x" + heightInches + " inches");
//            }
//
//            document.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Helper method to calculate resolution
//    private static int calculateResolution(PDDocument document, double desiredWidthInches, double desiredHeightInches) {
//        int pageWidthPoints = (int) document.getPage(0).getMediaBox().getWidth();
//        int pageHeightPoints = (int) document.getPage(0).getMediaBox().getHeight();
//        int resolutionWidth = (int) (pageWidthPoints / desiredWidthInches);
//        int resolutionHeight = (int) (pageHeightPoints / desiredHeightInches);
//        return Math.min(resolutionWidth, resolutionHeight);
//    }



