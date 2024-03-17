package br.edu.infnet.isabellaaraujo.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LivroTest {

	public Livro livro;
	
	public final String titulo = "Você";
	public final String autor = "Caroline Kepnes";
	public final int anoPublicacao = 2014;
	public final String isbn = "853253094X";
	
	@BeforeEach
	void setUp(){
		livro = new Livro(titulo, autor, anoPublicacao, isbn);
		
		livro = new Livro();
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setAnoPublicacao(anoPublicacao);
		livro.setIsbn(isbn);
	}  
	
	@Test
	void recuperarDados() {
		System.out.println(livro);
		assertEquals(titulo, livro.getTitulo());
		assertEquals(autor, livro.getAutor());
		assertEquals(anoPublicacao, livro.getAnoPublicacao());
		assertEquals(isbn, livro.getIsbn());
	}

}