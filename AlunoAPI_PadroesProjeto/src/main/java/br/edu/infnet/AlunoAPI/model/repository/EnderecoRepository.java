package br.edu.infnet.AlunoAPI.model.repository;

import br.edu.infnet.AlunoAPI.model.negocio.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository <Endereco, Integer> {
    
}
