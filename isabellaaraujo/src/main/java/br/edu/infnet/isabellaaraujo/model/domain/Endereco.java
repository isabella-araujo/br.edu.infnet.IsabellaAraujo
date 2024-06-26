package br.edu.infnet.isabellaaraujo.model.domain;

public class Endereco {
	private String logradouro;
	private String bairro;
    private String localidade;
    private String uf;
    private String cep;

    public Endereco() {
    	
    }
    
    public Endereco(String logradouro, String bairro, String localidade, String uf, String cep) {
    	this();
    	this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.cep = cep;
    }

	@Override
	public String toString() {
		return logradouro + ", " + bairro + ", " + localidade + ", " + uf + ", " + cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
