package br.edu.infnet.isabellaaraujo.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.isabellaaraujo.model.domain.Livro;

@SpringBootTest
class LivroServiceTest {

	private LivroService livroService = new LivroService();

    private Livro livro;

    private final String isbn = "8579622875";

    @BeforeEach
    void setUp() {
        livro = new Livro("O senhor das moscas", "William Golding", 1954, isbn);
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

        assertTrue(livroService.ObterLista().contains(livro));
    }

}
