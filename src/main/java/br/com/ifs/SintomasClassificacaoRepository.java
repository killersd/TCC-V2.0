package br.com.ifs;

import org.springframework.data.repository.CrudRepository;

public interface SintomasClassificacaoRepository extends CrudRepository<SintomasClassificacaoModel, Long> {

	SintomasClassificacaoModel findById(long id);
	
}
