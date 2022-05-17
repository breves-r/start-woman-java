package br.edu.infnet.AlunoAPI.cliente;

import br.edu.infnet.AlunoAPI.model.negocio.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://viacep.com.br/ws/", name="ViaCepService")
public interface IClienteAPI {

    @GetMapping("{cep}/json")
    Endereco buscaEnderecoPor(@PathVariable("cep") String cep);
}
