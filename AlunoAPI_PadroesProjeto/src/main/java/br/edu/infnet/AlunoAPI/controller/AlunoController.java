package br.edu.infnet.AlunoAPI.controller;

import br.edu.infnet.AlunoAPI.cliente.IClienteAPI;
import br.edu.infnet.AlunoAPI.model.negocio.Aluno;
import br.edu.infnet.AlunoAPI.model.negocio.Endereco;
import br.edu.infnet.AlunoAPI.model.service.AlunoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {
    
    @Autowired
    private IClienteAPI clienteAPI;
    
    @Autowired
    private AlunoService alunoService;
    
    @GetMapping("/alunos")
    public List<Aluno> consultarAlunos(){
        return alunoService.consultarAlunos(); 
    }
    
    @GetMapping("/alunos/{id}")
    public Aluno consultarAluno(@PathVariable int id){
        return alunoService.consultarAluno(id);
    }
    
    @PostMapping("/incluir")
    private String incluir(@RequestBody Aluno aluno){
        Endereco endereco = clienteAPI.buscaEnderecoPor(aluno.getEndereco().getCep());
        aluno.setEndereco(endereco);
        alunoService.incluirAluno(aluno);
        return "Aluno incluído";
    }
    
    @PutMapping("/alterar/{id}")
    private String alterar(@RequestBody Aluno novoAluno, @PathVariable int id){ 
        Endereco endereco = clienteAPI.buscaEnderecoPor(novoAluno.getEndereco().getCep());
        novoAluno.setEndereco(endereco);
        return alunoService.alterarAluno(novoAluno, id);
    }
    
   
    
    @DeleteMapping("/excluir/{id}")
    private String excluir(@PathVariable int id){
        return alunoService.excluirAluno(id);
    } 
    
    @GetMapping("/procurar/{keyword}")
    public List<Aluno> procurar(@PathVariable String keyword){
        return alunoService.procurarAlunos(keyword);
    }
    
}
