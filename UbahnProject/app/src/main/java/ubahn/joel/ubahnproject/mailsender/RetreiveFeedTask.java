package ubahn.joel.ubahnproject.mailsender;

import android.os.AsyncTask;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Usuario on 10/01/2017.
 */
public class RetreiveFeedTask extends AsyncTask<Session, Void, String> {

    @Override
    protected String doInBackground(Session... params) {

        try{
            Message message = new MimeMessage(params[0]);
            message.setFrom(new InternetAddress("testfrom354@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("joelfernandezreviejo@gmail.com"));
            message.setSubject("Atencion al Cliente Ubahn");
            message.setContent("prueba", "text/html; charset=utf-8");
            Transport.send(message);
        } catch(MessagingException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    protected void onPostExecute(String result) {   }
}