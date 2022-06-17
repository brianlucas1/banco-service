package br.com.banco.servicce;

import java.awt.print.Pageable;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.banco.enums.StatusEmail;
import br.com.banco.model.EmailModel;
import br.com.banco.model.UsuarioModel;
import br.com.banco.repository.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	EmailRepository emailRepository;

	@Autowired
	private JavaMailSender emailSender;

	 
	 public EmailModel sendEmail(UsuarioModel userModel) {
		 
		 EmailModel dadoseMail = setDadosMail(userModel);
		 
	        try{
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setFrom(dadoseMail.getEmailFrom());
	            message.setTo(dadoseMail.getEmailTo());
	            message.setSubject(dadoseMail.getSubject());
	            message.setText(dadoseMail.getText());
	            emailSender.send(message);

	            dadoseMail.setStatusEmail(StatusEmail.SENT);
	        } catch (MailException e){
	        	dadoseMail.setStatusEmail(StatusEmail.ERROR);
	        } finally {
	            return emailRepository.save(dadoseMail);
	        }
	    }


	private EmailModel setDadosMail(UsuarioModel userModel) {
		
		 EmailModel dadoseMail = new EmailModel();
		 dadoseMail.setSendDateEmail(LocalDateTime.now());
		 dadoseMail.setEmailTo(userModel.getEmail());
		 dadoseMail.setEmailFrom("brianlucas@gmail.com");
		 dadoseMail.setText("CODIGO CONFIRMAÇÃO");
		 
		return dadoseMail;
	}

	 
}
