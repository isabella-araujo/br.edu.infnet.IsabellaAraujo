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

import br.edu.infnet.isabellaaraujo.model.domain.Livro;
import br.edu.infnet.isabellaaraujo.model.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping(value = "/{cep}/incluir")
	public void incluir(@RequestBody Livro livro, @PathVariable String cep) {
		livroService.Incluir(livro, cep);
	}

	@DeleteMapping(value = "/{cep}/{isbn}/excluir")
    public void Excluir(@PathVariable String isbn, String cep) {
    	livroService.Excluir(isbn, cep);
    }

    @GetMapping(value = "{cep}/listar-livros")
    public Collection<Livro> ObterLista(@PathVariable String cep){
        return livroService.ObterLista(cep);
    }

    @GetMapping(value = "/{cep}/{isbn}/listar")
    public Livro Obter(@PathVariable String isbn, @PathVariable String cep) {
        return livroService.Obter(isbn, cep);
    }
}
