package br.com.banco.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.banco.dto.PessoaDTO;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<PessoaDTO> {
	
	@Override
	public List<Class<?>> getValidationGroups(PessoaDTO pess) {
		
		List<Class<?>> groups = new ArrayList<>();
		groups.add(PessoaDTO.class);
	
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