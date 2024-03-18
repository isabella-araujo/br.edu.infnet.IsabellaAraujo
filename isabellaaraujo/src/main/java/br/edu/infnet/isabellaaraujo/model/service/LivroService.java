package br.edu.infnet.isabellaaraujo.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.isabellaaraujo.model.domain.Biblioteca;
import br.edu.infnet.isabellaaraujo.model.domain.Livro;

@Service
public class LivroService {
	private static Map<String, Livro> livros = new HashMap<String, Livro>();
	
	BibliotecaService bibliotecaService = new BibliotecaService();
	
	public void Incluir(Livro livro) {
        livros.put(livro.getIsbn(), livro);
    }

    public void Excluir(String isbn) {
        livros.remove(isbn);
    }

    public List<Livro> ObterLista(String cep){
    	Biblioteca biblioteca = bibliotecaService.Obter(cep);
        return biblioteca.livros;
    }

    public Livro Obter(String isbn) {
    	Livro livro = livros.get(isbn);
        return livro;
    }
}