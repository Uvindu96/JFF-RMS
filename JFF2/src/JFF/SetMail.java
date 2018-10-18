package JFF;
import javafx.scene.text.Text;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.text.html.HTML;

public class SetMail {
    public SetMail() {
    }

    public void mailConfig(String getDate, String getName, String getAddress, String getEmail, String getItem, String getCode, String getAmount, String getTotal){
    String fromMail = "codejunctioncrew@gmail.com";
    String setPassword = "codejunciit12";

    String sendToUser = "torin.w.@iit.ac.lk";
    String host = "smtp.gmail.com";

    Properties propertiesSet = System.getProperties();

        propertiesSet.put("mail.smtp.starttls.enable","true");
        propertiesSet.put("mail.smtp.host",host);
        propertiesSet.put("mail.smtp.user",fromMail);
        propertiesSet.put("mail.smtp.password", setPassword);
        propertiesSet.put("mail.smtp.port","587");
        propertiesSet.put("mail.smtp.auth","true");

        Session newSession = Session.getDefaultInstance(propertiesSet);

        try{
            MimeMessage newMessage = new MimeMessage(newSession);

            newMessage.setFrom(new InternetAddress(fromMail));

            newMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendToUser));

            newMessage.setSubject("This is the Subject Line");

            newMessage.setSubject("TAX INVOICE!");
newMessage.setContent("<center> JFF Fishing Shack<br><br>Tax Invoice</center><br><left>JFF's Fishing Shack<br>Trading as Octopus pvt Ltd<br>Shop 04,Hillaries Boat Harbour<br>"+
                    "Hillaries, WA 6025<br>TP :0894022222<br>E : sales@JFF.com.au<br></left>" +
                  "Recipt #56234<br>"+"<right>"+getDate+"</right><br>"+"Customer"+getName+"<br>"+getAddress+"<br>Customer No: #45896" +
                  "<br>"+getEmail+"<br>Purchaces"+"<br><left>"+getItem+"<center>"+getCode+"<right>"+getAmount+"<br>" +
                  "<left>Total Paid:"+getTotal+"<br>" +
                   "Thank You For Your Buisness<br>JFF's Where the real fishermen shop<left>", "text/html");
            Transport setTransport = newSession.getTransport("smtp");
            setTransport.connect(host,fromMail,setPassword);
            setTransport.sendMessage(newMessage,newMessage.getAllRecipients());
            setTransport.close();
            System.out.println("Mail Sent Success");

        } catch (MessagingException mass) {
            mass.printStackTrace();
            System.out.println("Mail Sent Fail");

        }

    }

     public void mailConfig(String detail){

         String fromMail = "codeJunctioncrew@gmail.com";
         String setPassword = "codejunciit12";
         String sendToUser = "uvindu.2017279@iit.ac.lk";
         String host = "smtp.gmail.com";
         Properties propertiesSet = System.getProperties();
         propertiesSet.put("mail.smtp.starttls.enable","true");
         propertiesSet.put("mail.smtp.host",host);
         propertiesSet.put("mail.smtp.user",fromMail);
         propertiesSet.put("mail.smtp.password", setPassword);
         propertiesSet.put("mail.smtp.port","587");
         propertiesSet.put("mail.smtp.auth","true");
         Session newSession = Session.getDefaultInstance(propertiesSet);

         try{
             MimeMessage newMessage = new MimeMessage(newSession);

             newMessage.setFrom(new InternetAddress(fromMail));

             newMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendToUser));

             newMessage.setSubject("TAX INVOICE");
             newMessage.setText(detail);

             Transport setTransport = newSession.getTransport("smtp");
             setTransport.connect(host,fromMail,setPassword);
             setTransport.sendMessage(newMessage,newMessage.getAllRecipients());
             setTransport.close();
             System.out.println("Mail Sent Success");

         } catch (MessagingException mass) {
             mass.printStackTrace();
             System.out.println("Mail Sent Fail");

         }
     }
}
