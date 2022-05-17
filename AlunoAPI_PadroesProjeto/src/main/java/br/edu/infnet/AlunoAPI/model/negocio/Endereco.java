package br.edu.infnet.AlunoAPI.model.negocio;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TEnderecos")
public class Endereco implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private int id;
    @JsonProperty
    private String cep;
    @JsonProperty
    private String logradouro;
    @JsonProperty
    private String complemento;
    @JsonProperty
    private String bairro;
    @JsonProperty
    private String localidade;
    @JsonProperty
    private String uf;
    @JsonProperty
    private String ibge;
    @JsonProperty
    private String gia;
    @JsonProperty
    private String ddd;
    @JsonProperty
    private String siafi;
    
    @OneToOne(mappedBy = "endereco")
    private Aluno aluno;
            
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getCep() {
        return cep;
    }
    
    @Override
    public String toString() {
        String msg;
        
        if (cep != null) {
            msg = cep + "\n" + logradouro + "\n" +  complemento + "\n" + bairro + "\n" +
            localidade + "\n" +  uf + "\n" + ibge + "\n" + gia + "\n" + ddd + "\n" + siafi;
        }
        else {
            msg = "Erro: cep inválido";
        }
        return msg;
    }
}
