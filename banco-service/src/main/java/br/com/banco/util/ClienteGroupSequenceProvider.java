package br.com.banco.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.banco.dto.PessoaDto;
import br.com.banco.model.PessoaModel;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<PessoaDto> {
	
	@Override
	public List<Class<?>> getValidationGroups(PessoaDto pess) {
		
		List<Class<?>> groups = new ArrayList<>();
		groups.add(PessoaDto.class);
	
		if(pess != null) {
			
			if("fisica".equalsIgnoreCase(pess.getTipoPessoa())) {
				groups.add(PessoaFisica.class);
			}else if("juridica".equalsIgnoreCase(pess.getTipoPessoa())){
				groups.add(PessoaJuridica.class);
			}
			
		}
		
		
		return groups;
	}

}