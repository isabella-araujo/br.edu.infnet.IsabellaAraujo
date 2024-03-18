package br.edu.infnet.isabellaaraujo.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.domain.Biblioteca;

@SpringBootTest
class BibliotecaServiceTest {
	
	private String logradouro = "Rua Visconde de Pirajá";
	private String bairro = "Ipanema";
    private String localidade = "Rio de Janeiro";
    private String uf = "RJ";
    private final String cep = "22410001";
    
    private Endereco endereco = new Endereco(logradouro, bairro, localidade, uf, cep);

	private BibliotecaService bibliotecaService = new BibliotecaService();

    private Biblioteca biblioteca;
    
    private final String nome = "Biblioteca UM";

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca(nome, endereco);
    }

    @Test
    void Inclusao() {
        bibliotecaService.Incluir(biblioteca);

        assertEquals(biblioteca, bibliotecaService.Obter(cep));
    }

    @Test
    void Exclusao() {
        Inclusao();

        bibliotecaService.Excluir(cep);

        assertNull(bibliotecaService.Obter(cep));
    }

    @Test
    void RecuperacaoTotal() {
        Inclusao();

        assertTrue(bibliotecaService.ObterLista().contains(biblioteca));
    }

}
