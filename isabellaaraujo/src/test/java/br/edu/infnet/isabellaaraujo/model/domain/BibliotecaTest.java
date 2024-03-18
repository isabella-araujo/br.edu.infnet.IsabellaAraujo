package br.edu.infnet.isabellaaraujo.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.isabellaaraujo.model.service.LivroService;

@SpringBootTest
class BibliotecaTest {
	LivroService livroService = new LivroService();
	// endereco
	private String logradouro = "Rua Visconde de Pirajá";
	private String bairro = "Ipanema";
    private String localidade = "Rio de Janeiro";
    private String uf = "RJ";
    private String cep = "22410001";
  
    public Endereco enderecoBiblioteca = new Endereco(logradouro, bairro, localidade, uf, cep);
    
    //biblioteca
    public final String nomeBiblioteca = "Biblioteca UM";
	public Biblioteca biblioteca = new Biblioteca(nomeBiblioteca, enderecoBiblioteca);
	
	// livros 
	public Livro livro1 = new Livro("Você", "Caroline Kepnes", 2014, "853253094X");
	
	public Livro livro2 = new Livro("Conectadas", "Clara Alves", 2019, "8555340896");

	@BeforeEach
	void setUp(){
		biblioteca.setNome(nomeBiblioteca);
		biblioteca.setEndereco(enderecoBiblioteca);
		biblioteca.livros.add(livro1);
		biblioteca.livros.add(livro2);
	}

	@Test
	void recuperarDados() {
		System.out.print(biblioteca);
		assertEquals(nomeBiblioteca, biblioteca.getNome());
		assertEquals(enderecoBiblioteca, biblioteca.getEndereco());
	}
}
