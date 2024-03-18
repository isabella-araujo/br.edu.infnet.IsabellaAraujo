package br.edu.infnet.isabellaaraujo.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.isabellaaraujo.model.domain.Endereco;

@SpringBootTest
class EnderecoServiceTest {
	@Autowired
	private EnderecoService enderecoService = new EnderecoService();
	
	private Endereco endereco;
	
	private Endereco enderecoViaCep;
	
	private String logradouro = "Rua Visconde de Pirajá";
	private String bairro = "Ipanema";
    private String localidade = "Rio de Janeiro";
    private String uf = "RJ";
    private final String cep = "22410001";
	
	@BeforeEach
	void setUp() {
		endereco = new Endereco(logradouro, bairro, localidade, uf, cep);
		enderecoViaCep = enderecoService.obterPorCep(cep);
	}
	
//	@Test
//	void ObterPorCep() {
//		Endereco enderecoViaCep = enderecoService.obterPorCep(cep);
//	}

	@Test
	void Inclusao() {
		enderecoService.Incluir(endereco);
		enderecoService.Incluir(enderecoViaCep);
		
		assertEquals(endereco, enderecoService.Obter(cep));
	}
	
	@Test
    void Exclusao() {
        Inclusao();

        enderecoService.Excluir(cep);

        assertNull(enderecoService.Obter(cep));
    }

    @Test
    void RecuperacaoTotal() {
        Inclusao();

        assertTrue(enderecoService.ObterLista().contains(endereco));
    }

}
