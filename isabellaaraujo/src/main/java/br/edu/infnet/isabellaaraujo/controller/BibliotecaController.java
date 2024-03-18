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

import br.edu.infnet.isabellaaraujo.model.domain.Biblioteca;
import br.edu.infnet.isabellaaraujo.model.service.BibliotecaService;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
	
	@Autowired
	private BibliotecaService bibliotecaService;
	
	@PostMapping(value = "/incluir")
	public void Incluir(@RequestBody Biblioteca biblioteca) {
		bibliotecaService.Incluir(biblioteca);
	}
	
	@DeleteMapping(value = "/{cep}/excluir")
	public void Excluir(@PathVariable String cep) {
		bibliotecaService.Excluir(cep);
	}

	@GetMapping(value = "/listar")
    public Collection<Biblioteca> ObterLista(){
        return bibliotecaService.ObterLista();
    }

	@GetMapping(value = "/{cep}/listar")
    public Biblioteca Obter(@PathVariable String cep) {
        return bibliotecaService.Obter(cep);
    }
	
}
