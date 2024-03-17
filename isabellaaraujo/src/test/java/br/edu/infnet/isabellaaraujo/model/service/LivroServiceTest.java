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

    private final String titulo = "O senhor das moscas";

    @BeforeEach
    void setUp() {
        livro = new Livro(titulo, "William Golding", 1954, "8579622875");
    }

    @Test
    void Inclusao() {

        livroService.Incluir(livro);

        assertEquals(livro, livroService.Obter(titulo));
    }

    @Test
    void Exclusao() {
        Inclusao();

        livroService.Excluir(titulo);

        assertNull(livroService.Obter(titulo));
    }

    @Test
    void RecuperacaoTotal() {
        Inclusao();

        assertTrue(livroService.ObterLista().contains(livro));
    }

}
