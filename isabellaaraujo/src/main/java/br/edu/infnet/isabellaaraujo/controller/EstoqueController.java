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

import br.edu.infnet.isabellaaraujo.model.domain.Estoque;
import br.edu.infnet.isabellaaraujo.model.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;

	@PostMapping(value = "/incluir")
	public void Incluir(@RequestBody Estoque estoque) {
		estoqueService.Incluir(estoque);
	}

	@DeleteMapping(value = "/{isbn}/excluir")
	public void Excluir(@PathVariable String isbn) {
		estoqueService.Excluir(isbn);
	}

	@GetMapping(value = "/listar")
	public Collection<Estoque> ObterLista() {
		return estoqueService.ObterLista();
	}

	@GetMapping(value = "/{isbn}/listar")
	public Estoque Obter(@PathVariable String isbn) {
		return estoqueService.Obter(isbn);
	}

}