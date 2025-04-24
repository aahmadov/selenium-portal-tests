package UtilsTesNG;

import org.apache.commons.lang3.time.DateUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.*;
import java.util.Properties;

    public class ReceiveMailOutlook {

        private static String host = "imap.gmail.com"; // IMAP host for gmail
        private static String mailStoreType = "imap";
        private static String username = "amansurov485@gmail.com"; // Replace with your Outlook email
        private static String password = "hgwf xvsu uywh uqpo"; // Replace with your Outlook password
        private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < mimeMultipart.getCount(); i++) {
                BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/plain")) {
                    result.append(bodyPart.getContent());
                } else if (bodyPart.isMimeType("text/html")) {
                    // You can parse HTML if needed
                    result.append(org.jsoup.Jsoup.parse(bodyPart.getContent().toString()).text());
                } else if (bodyPart.getContent() instanceof MimeMultipart) {
                    result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()));
                }
            }
            return result.toString();
        }

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

                // 3) Create the folder object and open it with read and write permissions;
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
                if (messages.length == 0) {
                    // Negative scenario: No email found after retries
                    System.out.println("No email found from: " + mailFrom + " with subject: " + subjectFilter);
                    System.out.println("Retries attempted: " + noOfTimes);
                    return result; // Return false indicating the negative scenario
                }

                for (int i = 0; i < messages.length; i++) {
                    Message message = messages[i];
                    System.out.println("---------------------------------");
                    System.out.println("Email Number " + (i + 1));
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("Text: " + message.getContent().toString());
                    Object content = message.getContent();
                    if (content instanceof String) {
                        System.out.println("Text: " + content);
                    } else if (content instanceof MimeMultipart) {
                        MimeMultipart mimeMultipart = (MimeMultipart) content;
                        String resultText = getTextFromMimeMultipart(mimeMultipart);
                        System.out.println("Text: " + resultText);
                    }



                    message.setFlag(Flags.Flag.SEEN, true); // Mark email as read
                }
                result = true;
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
