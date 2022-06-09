package br.com.banco.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.banco.util.ClienteGroupSequenceProvider;
import br.com.banco.util.CnpjGoup;
import br.com.banco.util.CpfGroup;
import br.com.banco.util.TipoPessoa;
import lombok.Data;

@Data
@Entity
@GroupSequenceProvider(ClienteGroupSequenceProvider.class)
public class PessoaModel implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPessoa;
	private String nome;
	
	@Email
	private String email;
	
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	
	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGoup.class)
	private String cpf_cnjp;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist(){
		setDataCadastro(LocalDate.now());
	}
	
}
