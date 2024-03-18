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
	private Endereco endereco;

	private LivroService livroService = new LivroService();

    private Livro livro;
    
    private Biblioteca biblioteca;

    private final String isbn = "8579622875";

    @BeforeEach
    void setUp() {
    	endereco = enderecoService.obterPorCep("22410-001");
    	biblioteca = new Biblioteca("Biblioteca UM", endereco);
        livro = new Livro("O senhor das moscas", "William Golding", 1954, isbn);
        biblioteca.livros.add(livro);
    }

    @Test
    void Inclusao() {

        livroService.Incluir(livro);

        assertEquals(livro, livroService.Obter(isbn));
    }

    @Test
    void Exclusao() {
        Inclusao();

        livroService.Excluir(isbn);

        assertNull(livroService.Obter(isbn));
    }

    @Test
    void RecuperacaoTotal() {
    	
        Inclusao();
        
        System.out.println(livroService.Obter(isbn));

        assertTrue(livroService.ObterLista("22410-001").contains(livro));
    }

}
