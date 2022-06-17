package br.com.banco.util;

public class ConverterUtil {

	public double stringToDouble(String qtdLitros) {
	
		try {
			
			Double formatado = Double.parseDouble(qtdLitros);
			return formatado;
		}catch (NumberFormatException e) {
			System.out.println("Inserir somente numéros para ser feito o calculo");
			return 0;
		}
			
	}

}
