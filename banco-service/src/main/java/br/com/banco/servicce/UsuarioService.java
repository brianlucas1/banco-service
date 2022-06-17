package br.com.banco.servicce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.banco.exception.EmailAlreadyExistsExcpetion;
import br.com.banco.exception.UserAlreadyExistsExcpetion;
import br.com.banco.model.EmailModel;
import br.com.banco.model.UsuarioModel;
import br.com.banco.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository loginRepo;
	
	@Autowired
	private EmailService emailService; 

	public UsuarioModel newUser(UsuarioModel userModel) throws EmailAlreadyExistsExcpetion, UserAlreadyExistsExcpetion {

		//SE RETORNAR TRUE QUER DIZER QUE JÁ EXISTE UM E-MAIL
		//OU UM USUARIO COM O MESMO NOME.
		boolean userAlreadyExists = validationUser(userModel);
		
		if(!userAlreadyExists) {
			throw new ResponseStatusException(HttpStatus.OK,"ESSE USUARIO JÁ ESTÁ CADASTRADO NA BASE");
		}else {
			
			UsuarioModel userSave = loginRepo.save(userModel);
			
			if(userSave != null) {
				
				emailService.sendEmail(userModel);
			}
			
			return userSave;
		}
		
	}

	private boolean validationUser(UsuarioModel userModel) throws EmailAlreadyExistsExcpetion, UserAlreadyExistsExcpetion {
		
		boolean emailAlreadyExists = sereachUserEmail(userModel.getEmail());
		
		boolean usernameAlreadyExists = sereachUsername(userModel.getNomeUsuario());
		
		//SE OS DOIS RETORNAREM FALSE QUER DIZER QUE NÃO EXISTEM PODEM GRAVAR
		if(emailAlreadyExists && usernameAlreadyExists) {
			return false;
		}else {
			return true;
		}
		
	}

	private boolean sereachUsername(String nomeUsuario) throws UserAlreadyExistsExcpetion {
		
		UsuarioModel user = loginRepo.findByEmail(nomeUsuario);
		
		if(user != null) {
			throw new UserAlreadyExistsExcpetion("USERNAME JÁ CADASTRO NA BASE");
		}else {
			return false;			
		}
	}

	private boolean sereachUserEmail(String email) throws EmailAlreadyExistsExcpetion {
		
		UsuarioModel user = loginRepo.findByEmail(email);
		
		if(user != null) {
			throw new EmailAlreadyExistsExcpetion("E-MAIL JÁ CADASTRO NA BASE");
		}else {
			return false;			
		}
		
	}
	
	
}
