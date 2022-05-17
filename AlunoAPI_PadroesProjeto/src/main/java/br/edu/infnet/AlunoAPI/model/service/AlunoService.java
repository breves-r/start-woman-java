package br.edu.infnet.AlunoAPI.model.service;

import br.edu.infnet.AlunoAPI.model.negocio.Aluno;
import br.edu.infnet.AlunoAPI.model.repository.AlunoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    private List<Aluno> alunos = new ArrayList();
    
    public List<Aluno> consultarAlunos(){
        return (List<Aluno>) alunoRepository.findAll();
    }
    
    public Aluno consultarAluno(int id){
        return alunoRepository.findById(id).get();
    }
    
    public void incluirAluno(Aluno aluno){
        alunoRepository.save(aluno);
    }
    
    public String alterarAluno(Aluno novoAluno, int id){
        String msg = "Aluno alterado";
        
        
        alunoRepository.findById(id).map(aluno -> {
        aluno.setNome(novoAluno.getNome());
        aluno.setTelefone(novoAluno.getTelefone());
        aluno.setEndereco(novoAluno.getEndereco());
        return alunoRepository.save(aluno);
        }).orElseGet(() -> {
        novoAluno.setId(id);
        return alunoRepository.save(novoAluno);
        });
        
        return msg;
        
    }
    
    public String excluirAluno(int id ){
        String msg = "Erro ao excluir  aluno";
        
        Aluno aluno = alunoRepository.findById(id).get();
        
            if(aluno!=null){
                alunoRepository.delete(aluno);
                msg = "Aluno excluído";
            }
        return msg;
    }
    
    public List<Aluno> procurarAlunos(String keyword){
        List<Aluno> lista = alunoRepository.busca(keyword);
        
        return lista;
    }
    
}
