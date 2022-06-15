package br.com.banco.dto;

import java.time.LocalDate;

import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class UsuarioDTO {
	
	private String nomeUsuario;
	
	private String userName;
	
	private String passWord;
	
	@NotEmpty(message = "{campo.email.obrigatorio}")
	@Email(message= "{preencher.email.correto}")
	private String email;
		
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist(){
		setDataCadastro(LocalDate.now());
	}

}
