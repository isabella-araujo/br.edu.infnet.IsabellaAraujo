package br.edu.infnet.isabellaaraujo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.isabellaaraujo.model.domain.Livro;
import br.edu.infnet.isabellaaraujo.model.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Livro livro) {
		livroService.Incluir(livro);
	}

	@DeleteMapping(value = "/{isbn}/excluir")
    public void Excluir(@PathVariable String isbn) {
    	livroService.Excluir(isbn);
    }

    @GetMapping(value = "{cep}/listar-livros")
    public List<Livro> ObterLista(@PathVariable String cep){
        return livroService.ObterLista(cep);
    }

    @GetMapping(value = "/{isbn}/listar")
    public Livro Obter(@PathVariable String isbn) {
        return livroService.Obter(isbn);
    }
}
