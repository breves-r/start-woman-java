package br.edu.infnet.AlunoAPI.model.repository;

import br.edu.infnet.AlunoAPI.model.negocio.Aluno;
import feign.Param;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
    
    @Query("SELECT c FROM Aluno c WHERE c.nome LIKE '%' || :keyword || '%' OR c.telefone LIKE '%' || :keyword || '%'")
    public List<Aluno> busca(@Param("keyword") String keyword);
}
