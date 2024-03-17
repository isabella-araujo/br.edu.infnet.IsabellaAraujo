package br.edu.infnet.isabellaaraujo.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EstoqueTest {
	
	public Estoque estoque;

	public Endereco endereco = new Endereco();
	
	public final Livro livro = new Livro("Não me abandone jamais", "Kazuo Ishiguro", 2005, "8535926550");

	public final Livraria livraria = new Livraria("Livraria Carello", endereco);

	public final int qtdeLivros = 35;

	@BeforeEach
	void setUp(){
		estoque = new Estoque(livro, qtdeLivros, livraria);
		estoque.setLivro(livro);
		estoque.setQtdeLivros(qtdeLivros);
		estoque.setLivraria(livraria);
	}

	@Test
	void qdteLivrosInvalida() {
		estoque.setQtdeLivros(999);
		
	}
	
	@Test
	void qdteLivrosValida() {
		estoque.setQtdeLivros(qtdeLivros);
	}	
	
	@Test
	void estoqueCheio() {
		estoque.setQtdeLivros(50);
		assertTrue(estoque.estoqueCheio());
	}
	
	@Test
	void estoqueNaoCheio() {
		assertFalse(estoque.estoqueCheio());
	}

	@Test
	void recuperarDados() {
		System.out.println(estoque);
		assertEquals(livro, estoque.getLivro());
		assertEquals(qtdeLivros, estoque.getQtdeLivros());
		assertEquals(livro.getTitulo(), estoque.getNomeLivro());
		assertEquals(livro.getIsbn(), estoque.getIsbn());
		assertEquals(livraria, estoque.getLivraria());
	}
}
