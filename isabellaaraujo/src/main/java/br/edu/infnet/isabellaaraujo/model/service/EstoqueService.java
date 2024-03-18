package br.edu.infnet.isabellaaraujo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.isabellaaraujo.model.domain.Estoque;

@Service
public class EstoqueService {
	private static Map<String, Estoque> estoques = new HashMap<String, Estoque>();
	
	public void Incluir(Estoque estoque) {
        estoques.put(estoque.getIsbn(), estoque);
    }

    public void Excluir(String isbn) {
        estoques.remove(isbn);
    }

    public Collection<Estoque> ObterLista(){
        return estoques.values();
    }

    public Estoque Obter(String isbn) {
    	Estoque estoque = estoques.get(isbn);
        return estoque;
    }
}
