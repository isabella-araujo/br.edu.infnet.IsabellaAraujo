package br.edu.infnet.isabellaaraujo.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.isabellaaraujo.model.domain.Biblioteca;
import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.domain.Livro;

@SpringBootTest
class LivroServiceTest {
	
	@Autowired
	private EnderecoService enderecoService = new EnderecoService();
    private LivroService livroService = new LivroService();
    
	private Endereco endereco;
    private Biblioteca biblioteca;
    private Livro livro;
    
    private final String isbn = "8579622875";

    @BeforeEach
    void setUp() {
    	endereco = enderecoService.obterPorCep("22410-001");
    	biblioteca = new Biblioteca("Biblioteca UM", endereco);
        livro = new Livro("O senhor das moscas", "William Golding", 1954, isbn, biblioteca);
    }

    @Test
    void Inclusao() {
    	
        livroService.Incluir(livro, biblioteca.getCep());

        assertEquals(livro, livroService.Obter(isbn, biblioteca.getCep()));
    }

    @Test
    void Exclusao() {
        Inclusao();

        livroService.Excluir(isbn, biblioteca.getCep());

        assertNull(livroService.Obter(isbn, biblioteca.getCep()));
    }

    @Test
    void RecuperacaoTotal() {
    	
        Inclusao();

        assertTrue(livroService.ObterLista("22410-001").contains(livro));
    }

}
