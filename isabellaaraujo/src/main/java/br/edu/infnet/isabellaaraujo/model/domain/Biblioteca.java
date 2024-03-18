package br.edu.infnet.isabellaaraujo.model.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Biblioteca {
	private String nome;
    private Endereco endereco;
    private String cep;
    
    @OneToMany
    public ArrayList<Livro> livros = new ArrayList<>();
    
    public Biblioteca() {
    	
    }

    public Biblioteca(String nome, Endereco endereco) {
    	this();
        this.nome = nome;
        this.endereco = endereco;
        cep = endereco.getCep();
    }
    
    @Override
    public String toString() {
    	return "Biblioteca: " + nome + "\n" + "Endereço: " + endereco;
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
	

	public String getCep() {
		return cep;
	}
}
