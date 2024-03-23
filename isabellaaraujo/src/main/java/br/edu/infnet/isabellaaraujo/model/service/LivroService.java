package br.edu.infnet.isabellaaraujo.model.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.edu.infnet.isabellaaraujo.model.domain.Biblioteca;
import br.edu.infnet.isabellaaraujo.model.domain.Livro;

@Service
public class LivroService {
    BibliotecaService bibliotecaService = new BibliotecaService();
    Biblioteca biblioteca;
	
	public void Incluir(Livro livro, String cep) {
        biblioteca = bibliotecaService.Obter(cep);
        Biblioteca.livros.put(livro.getIsbn(), livro);
    }

    public void Excluir(String isbn, String cep) {
        biblioteca = bibliotecaService.Obter(cep);
        Biblioteca.livros.remove(isbn);
    }

    public Collection<Livro> ObterLista(String cep){
        biblioteca = bibliotecaService.Obter(cep);
        return Biblioteca.livros.values();
    }

    public Livro Obter(String isbn, String cep) {
        biblioteca = bibliotecaService.Obter(cep);
        return Biblioteca.livros.get(isbn);
    }
}