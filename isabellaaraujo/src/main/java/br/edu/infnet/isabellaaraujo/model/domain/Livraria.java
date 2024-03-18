package br.edu.infnet.isabellaaraujo.model.domain;

import java.util.ArrayList;

public class Livraria {
	private String nome;
    private Endereco endereco;
    private String cep;
    public ArrayList<Estoque> estoque = new ArrayList<>();

    public Livraria(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
        cep = endereco.getCep();
    }
    
    @Override
    public String toString() {
    	return "Livraria: " + nome + "\n" + "Endereço: " + endereco;
    }
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void exibirEstoque() {
		for(Estoque estoque : estoque) {
			System.out.println(estoque);
		}
	}

	public String getCep() {
		return cep;
	}
}
