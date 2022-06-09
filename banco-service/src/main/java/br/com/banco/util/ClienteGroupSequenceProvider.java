package br.com.banco.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.banco.model.PessoaModel;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<PessoaModel> {
	
	@Override
	public List<Class<?>> getValidationGroups(PessoaModel pess) {
		
		List<Class<?>> groups = new ArrayList<>();
		groups.add(PessoaModel.class);
	
		if(isPessoaSelecionada(pess)) {
			groups.add(pess.getTipoPessoa().getGroup());
		}
		
		return groups;
	}

	private boolean isPessoaSelecionada(PessoaModel pess) {
		
		return pess != null && pess.getTipoPessoa() != null;
	}
}