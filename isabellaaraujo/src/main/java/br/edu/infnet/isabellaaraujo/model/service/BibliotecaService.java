package br.edu.infnet.isabellaaraujo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.isabellaaraujo.model.domain.Biblioteca;

@Service
public class BibliotecaService {
	private static Map<String, Biblioteca> bibliotecas = new HashMap<String, Biblioteca>();
	
	public void Incluir(Biblioteca biblioteca) {
        bibliotecas.put(biblioteca.getCep(), biblioteca);
    }

    public void Excluir(String cep) {
        bibliotecas.remove(cep);
    }

    public Collection<Biblioteca> ObterLista(){
        return bibliotecas.values();
    }

    public Biblioteca Obter(String cep) {
    	Biblioteca biblioteca = bibliotecas.get(cep);
        return biblioteca;
    }
}
