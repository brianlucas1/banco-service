package br.com.banco.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.UsuarioDTO;
import br.com.banco.exception.EmailAlreadyExistsExcpetion;
import br.com.banco.exception.UserAlreadyExistsExcpetion;
import br.com.banco.model.UsuarioModel;
import br.com.banco.servicce.UsuarioService;

@RestController
@RequestMapping("/api/user")
public class LoginController {
	
	
	@Autowired
	private UsuarioService loginService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioModel criaUsuario(@RequestBody @Valid UsuarioDTO userDTO) throws EmailAlreadyExistsExcpetion, UserAlreadyExistsExcpetion {
		
		UsuarioModel userModel = new UsuarioModel();
		BeanUtils.copyProperties(userDTO,userModel);		
		return loginService.newUser(userModel);
		
	}

}
