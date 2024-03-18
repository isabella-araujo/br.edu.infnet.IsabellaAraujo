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

import br.edu.infnet.isabellaaraujo.model.domain.Livraria;
import br.edu.infnet.isabellaaraujo.model.service.LivrariaService;

@RestController
@RequestMapping("/livraria")
public class LivrariaController {
	
	@Autowired
	private LivrariaService livrariaService;
	
	@PostMapping(value = "/incluir")
	public void Incluir(@RequestBody Livraria livraria) {
		livrariaService.Incluir(livraria);
	}
	
	@DeleteMapping(value = "/{cep}/excluir")
	public void Excluir(@PathVariable String cep) {
		livrariaService.Excluir(cep);
	}

	@GetMapping(value = "/listar")
    public Collection<Livraria> ObterLista(){
        return livrariaService.ObterLista();
    }

	@GetMapping(value = "/{cep}/listar")
    public Livraria Obter(@PathVariable String cep) {
        return livrariaService.Obter(cep);
    }
	
}
