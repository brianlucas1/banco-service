package br.com.banco.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class CarroModel {

	private String carro;
	private String kmRodados;
	private String qtdLitros;
	private double preco;
	
}
