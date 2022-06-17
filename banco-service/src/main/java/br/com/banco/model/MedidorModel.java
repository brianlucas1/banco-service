package br.com.banco.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class MedidorModel {

	private String qtdLtGasolina;
	private String qtdLtAlcool;	
	private double preco;
	
}
