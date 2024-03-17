package br.edu.infnet.isabellaaraujo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.isabellaaraujo.model.domain.Livro;
import br.edu.infnet.isabellaaraujo.model.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	public LivroService livroService;
	
	@PostMapping(value = "/incluir")
	public void Incluir(Livro livro) {
		System.out.println("inclusao realizada");
    }

	@DeleteMapping(value = "/{isbn}/excluir")
    public void Excluir(@PathVariable String isbn) {
    	System.out.println("exclusao realizada");
    }

    @GetMapping(value = "/listar")
    public Collection<Livro> ObterLista(){
        return livroService.ObterLista();
    }

    @GetMapping(value = "/{isbn}/listar")
    public Livro Obter(@PathVariable String isbn) {
        return livroService.Obter(isbn);
    }
}
