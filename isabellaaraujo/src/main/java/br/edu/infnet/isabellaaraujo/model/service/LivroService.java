package br.edu.infnet.isabellaaraujo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.isabellaaraujo.model.domain.Livro;

@Service
public class LivroService {
	public Map<String, Livro> livros = new HashMap<String, Livro>();
	
	public void Incluir(Livro livro) {
        livros.put(livro.getTitulo(), livro);
    }

    public void Excluir(String isbn) {
        livros.remove(isbn);
    }

    public Collection<Livro> ObterLista(){
        return livros.values();
    }

    public Livro Obter(String isbn) {
        return livros.get(isbn);
    }
}
