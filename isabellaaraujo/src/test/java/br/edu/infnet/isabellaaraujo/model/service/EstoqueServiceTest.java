package br.edu.infnet.isabellaaraujo.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.domain.Estoque;
import br.edu.infnet.isabellaaraujo.model.domain.Livraria;
import br.edu.infnet.isabellaaraujo.model.domain.Livro;

@SpringBootTest
class EstoqueServiceTest {
	
	private String logradouro = "Rua Visconde de Pirajá";
	private String bairro = "Ipanema";
    private String localidade = "Rio de Janeiro";
    private String uf = "RJ";
    private final String cep = "22410001";
    
    private Endereco endereco = new Endereco(logradouro, bairro, localidade, uf, cep);

    private Livraria livraria = new Livraria("Livraria Leitura", endereco);
    
    private Livro livro = new Livro("Você", "Caroline Kepnes", 2014, "853253094X");

	private EstoqueService estoqueService = new EstoqueService();

    private Estoque estoque;

    @BeforeEach
    void setUp() {
        estoque = new Estoque(livro, 30, livraria);
    }

    @Test
    void Inclusao() {

        estoqueService.Incluir(estoque);

        assertEquals(estoque, estoqueService.Obter(estoque.getIsbn()));
    }

    @Test
    void Exclusao() {
        Inclusao();

        estoqueService.Excluir(estoque.getIsbn());

        assertNull(estoqueService.Obter(estoque.getIsbn()));
    }

    @Test
    void RecuperacaoTotal() {
        Inclusao();

        assertTrue(estoqueService.ObterLista().contains(estoque));
    }


}
