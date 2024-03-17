package br.edu.infnet.isabellaaraujo.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.domain.Livraria;

@SpringBootTest
class LivrariaServiceTest {
	
	private String logradouro = "Rua Visconde de Pirajá";
	private String bairro = "Ipanema";
    private String localidade = "Rio de Janeiro";
    private String uf = "RJ";
    private final String cep = "22410001";
    
    private Endereco endereco = new Endereco(logradouro, bairro, localidade, uf, cep);

	private LivrariaService livrariaService = new LivrariaService();

    private Livraria livraria;
    
    private final String nome = "Livraria Saraiva";

    @BeforeEach
    void setUp() {
        livraria = new Livraria(nome, endereco);
    }

    @Test
    void Inclusao() {
        livrariaService.Incluir(livraria);

        assertEquals(livraria, livrariaService.Obter(cep));
    }

    @Test
    void Exclusao() {
        Inclusao();

        livrariaService.Excluir(cep);

        assertNull(livrariaService.Obter(cep));
    }

    @Test
    void RecuperacaoTotal() {
        Inclusao();

        assertTrue(livrariaService.ObterLista().contains(livraria));
    }

}
