package br.edu.infnet.isabellaaraujo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.isabellaaraujo.clients.IEnderecoClient;
import br.edu.infnet.isabellaaraujo.model.domain.Endereco;

@Service
public class EnderecoService {
	@Autowired
	private IEnderecoClient enderecoClient;
	
	public Map<String, Endereco> enderecos = new HashMap<String, Endereco>();
	
	public Endereco obterPorCep(String cep) {
		return enderecoClient.obterPorCep(cep);
	}
	
	public void Incluir(Endereco endereco) {
        enderecos.put(endereco.getCep(), endereco);
    }

    public void Excluir(String cep) {
        enderecos.remove(cep);
    }

    public Collection<Endereco> ObterLista(){
        return enderecos.values();
    }

    public Endereco Obter(String cep) {
        return enderecos.get(cep);
    }
}
