package UtilsTesNG;

import org.apache.commons.lang3.time.DateUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.search.*;
import java.util.Properties;

    public class ReceiveMailOutlook {

        private static String host = "imap.gmail.com"; // IMAP host for gmail
        private static String mailStoreType = "imap";
        private static String username = "amansurov485@gmail.com"; // Replace with your Outlook email
        private static String password = "abbas1234!"; // Replace with your Outlook password

        public static Boolean receiveEmail2(String mailFrom, String subjectFilter) throws InterruptedException {

            Boolean result = false;
            try {
                // 1) Create the session
                Properties props = new Properties();
                props.setProperty("mail.imap.port", "993");
                props.setProperty("mail.imap.timeout", "10000"); // 30 seconds
                props.setProperty("mail.imap.ssl.enable", "true");
                Session session = Session.getDefaultInstance(props, null);

                // Connect to the email
                Store emailStore = session.getStore(mailStoreType);
                emailStore.connect(host, username, password);

                // 3) Create the folder object and open it with read and write permissions
                Folder emailFolder = emailStore.getFolder("INBOX");
                emailFolder.open(Folder.READ_WRITE);

                // 4) Search conditions
                SearchTerm from = new FromTerm(new InternetAddress(mailFrom)); // Filter by sender
                SearchTerm unreadEmails = new FlagTerm(new Flags(Flags.Flag.SEEN), false); // Filter unread emails
                SearchTerm subject = new SubjectTerm(subjectFilter); // Filter by subject string
                SearchTerm todayDate = new ReceivedDateTerm(ComparisonTerm.EQ,
                        DateUtils.truncate(new java.util.Date(), java.util.Calendar.DATE)); // Filter emails received today
                SearchTerm condition = new AndTerm(new SearchTerm[]{from, todayDate, unreadEmails});

                Message[] messages = emailFolder.search(condition);
                int noOfTimes = 0;
                while (messages.length == 0 && noOfTimes < 10) {
                    Thread.sleep(1000 * 20);
                    noOfTimes++;
                    emailFolder.close(false);
                    emailFolder.open(Folder.READ_WRITE);
                    messages = emailFolder.search(condition);
                }

                for (int i = 0; i < messages.length; i++) {
                    Message message = messages[i];
                    System.out.println("---------------------------------");
                    System.out.println("Email Number " + (i + 1));
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("Text: " + message.getContent().toString());
                    message.setFlag(Flags.Flag.SEEN, true); // Mark email as read
                }

                // 5) Close the store and folder objects
                emailFolder.close(false);
                emailStore.close();

            } catch (Exception e) {
                e.printStackTrace();
                return result;
            }

            return result;
        }
    }


