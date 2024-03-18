package br.edu.infnet.isabellaaraujo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService = new EnderecoService();
	
	@GetMapping(value = "/{cep}")
	public Endereco obterPorCep(@PathVariable String cep) {
		return enderecoService.obterPorCep(cep);
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Endereco endereco) {
		enderecoService.Incluir(endereco);
	}

	@DeleteMapping(value = "/{cep}/excluir")
    public void Excluir(@PathVariable String cep) {
    	enderecoService.Excluir(cep);
    }

    @GetMapping("/listar")
    public Collection<Endereco> ObterLista(){
        return enderecoService.ObterLista();
    }

    @GetMapping(value = "/{cep}/listar")
    public Endereco Obter(@PathVariable String cep) {
        return enderecoService.Obter(cep);
    }
}
