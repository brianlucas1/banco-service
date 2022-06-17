package br.com.banco.servicce;

import org.springframework.stereotype.Service;

import br.com.banco.exception.CalculoException;
import br.com.banco.model.CarroModel;
import br.com.banco.util.ConverterUtil;

@Service
public class CalculoService {

	public double mediaPorKmPorLitro(CarroModel carro) {
		
		ConverterUtil util = new ConverterUtil();
	
		double litros = util.stringToDouble(carro.getQtdLitros());
		
		if(litros == 0) {
			throw new CalculoException("Não foi possivel realizar a media de combustivel, verifique se campso foram preenchidos corretamente");
		}
		return 0;
		
	}

}
