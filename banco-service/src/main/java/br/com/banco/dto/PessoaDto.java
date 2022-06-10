package br.com.banco.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.banco.util.ClienteGroupSequenceProvider;
import br.com.banco.util.PessoaFisica;
import br.com.banco.util.PessoaJuridica;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@GroupSequenceProvider(ClienteGroupSequenceProvider.class)
public class PessoaDto  implements Serializable{
	

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	
	@NotEmpty(message = "{campo.email.obrigatorio}")
	@Email(message= "{preencher.email.correto}")
	private String email;
	
	private String tipoPessoa;
	
	@NotEmpty(message = "{campo.cpf.obrigatorio}")
	@CPF(groups = PessoaFisica.class, message = "{preencher.cpf.correto}")
	@CNPJ(groups = PessoaJuridica.class, message = "{preencher.cnpj.correto}")
	private String cpf_cnpj;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist(){
		setDataCadastro(LocalDate.now());
	}
	

}
