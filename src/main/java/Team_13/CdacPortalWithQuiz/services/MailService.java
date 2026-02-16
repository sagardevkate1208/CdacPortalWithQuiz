package Team_13.CdacPortalWithQuiz.services;


import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String email, String password){
    	
    	    MimeMessagePreparator preparator = new MimeMessagePreparator() 
    	    {
    	        public void prepare(MimeMessage mimeMessage) throws Exception 
    	        {
    	            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
    	            
    	            mimeMessage.setSubject("Registration Successfull");
    	             
    	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
    	            String mailtext = MailGenerator.welcomeMail(email, password);
    	             
    	            helper.setText(mailtext, true);
    	             
    	           
    	        }
    	    };
    	     
    	    try {
    	        emailSender.send(preparator);
    	    }
    	    catch (MailException ex) {
    	       
    	        System.out.println(ex.getMessage());
    	    }
    	
//        SimpleMailMessage message = new SimpleMailMessage();
//        
//        message.setTo(email);
//        message.setSubject("Something");
//       
//        message.setText(mailtext);
//        emailSender.send(message);

    }

    public void sendSimpleMessage1(String email, String otp) {

      
        MimeMessagePreparator preparator = new MimeMessagePreparator() 
	    {
	        public void prepare(MimeMessage mimeMessage) throws Exception 
	        {
	            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
	            mimeMessage.setSubject("Password reset OTP");
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	            String mailtext = MailGenerator.otpMail(email, otp);
	            helper.setText(mailtext, true);
	             
	           
	        }
	    };
	     
	    try {
	        emailSender.send(preparator);
	    }
	    catch (MailException ex) {
	       
	        System.out.println(ex.getMessage());
	    }
	
    }
    public void sendNotice(String email, String subject,String notice) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() 
	    {
	        public void prepare(MimeMessage mimeMessage) throws Exception 
	        {
	            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
	            mimeMessage.setSubject(subject);
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	            String mailtext = MailGenerator.noticeMail(subject, notice);
	            helper.setText(mailtext, true);
	        }
	    };
	     
	    try {
	        emailSender.send(preparator);
	    }
	    catch (MailException ex) {
	       
	        System.out.println(ex.getMessage());
	    }
	
    }
}
