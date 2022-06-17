package br.com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.CarroModel;
import br.com.banco.model.MedidorModel;
import br.com.banco.servicce.CalculoService;

@RestController
@RequestMapping("/api/combustivel")
public class CombustivelController {
	
	@Autowired
	private CalculoService calcService;

	@PostMapping("/medidor")
	public double contadoPorKm(@RequestBody CarroModel carro) {		
		
		return calcService.mediaPorKmPorLitro(carro);
	}
	
}
