package fr.projetRadar;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.jdi.connect.Transport;



public class EnvoyerMail {
	 Session mailSession;
	 	private int points;
	 	
	    public void setPoints(int points) {
			this.points = points;
		}

		void setMailServerProperties() {
	        Properties emailProperties = System.getProperties();
	        emailProperties.put("mail.smtp.port", "587");
	        emailProperties.put("mail.smtp.auth", "true");
	        emailProperties.put("mail.smtp.starttls.enable", "true");
	        mailSession = Session.getDefaultInstance(emailProperties, null);
	    }
	 
	    public MimeMessage draftEmailMessage(Vehicule v, int amende) throws AddressException, MessagingException {

	        String[] toEmails = { v.getEmailConducteur() };
	        String emailSubject = "Amende forfaitaire - suite infraction au code de la route";
	        String emailBody = "Vous conduisiez la voiture " + v.getMarque() + " immatriculee"+ v.getPlaqueImmat() + ",<br><br>Vous avez ete flashe par <b>Vincent et Martin</b>, à une vitesse de "
	        + v.getVitesse() + "kmh, votre amende est donc de " + amende  + " et vous perdez " + points +  " points sur votre permis ! <br>;) ";
	        MimeMessage emailMessage = new MimeMessage(mailSession);
	        /**
	         * Listing des destinataires
	         * */
	        for (int i = 0; i < toEmails.length; i++)
	        {
	            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
	        }
	        emailMessage.setSubject(emailSubject);
	        /**
	         * Si envoyer en HTML
	         * */
	        emailMessage.setContent(emailBody, "text/html");
	        /**
	         * Si envoyer en texte uniquement
	         * */
	        //emailMessage.setText(emailBody);// for a text email
	        return emailMessage;
	    }
	 
	    public void sendEmail(Vehicule v, int amende) throws AddressException, MessagingException {
	        /**
	         * Identifiants mail
	         * */
	        String fromUser = "testvincentetmartin@gmail.com";
	        String fromUserEmailPassword = "xsmfyplknlskifnt";
	 
	        String emailHost = "smtp.gmail.com";
	        javax.mail.Transport transport = mailSession.getTransport("smtp");/// modif!!!
	        transport.connect(emailHost, fromUser, fromUserEmailPassword);
	        /**
	         * Redaction du mail
	         * */
	        MimeMessage emailMessage = draftEmailMessage(v,amende);
	        /**
	         * Envoi du mail
	         * */
	        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
	        transport.close();
	        System.out.println("Notification envoyee par mail a " + v.getEmailConducteur());
	    }
	
}
