package br.edu.infnet.isabellaaraujo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.isabellaaraujo.model.domain.Livraria;

@Service
public class LivrariaService {
	public Map<String, Livraria> livrarias = new HashMap<String, Livraria>();
	
	public void Incluir(Livraria livraria) {
        livrarias.put(livraria.getCep(), livraria);
    }

    public void Excluir(String cep) {
        livrarias.remove(cep);
    }

    public Collection<Livraria> ObterLista(){
        return livrarias.values();
    }

    public Livraria Obter(String cep) {
        return livrarias.get(cep);
    }
}
