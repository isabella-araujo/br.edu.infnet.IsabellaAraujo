package br.edu.infnet.isabellaaraujo.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnderecoTest {
	
	private Endereco endereco;
	
	private String logradouro = "Rua Visconde de Pirajá";
	private String bairro = "Ipanema";
    private String localidade = "Rio de Janeiro";
    private String uf = "RJ";
    private String cep = "22410001";
   
	@BeforeEach
	void setUp() {
		endereco = new Endereco(logradouro, bairro, localidade, uf, cep);
		
		endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setBairro(bairro);
		endereco.setLocalidade(localidade);
		endereco.setUf(uf);
		endereco.setCep(cep);
	}
	
	@Test
	void recuperarDados() {
		assertEquals(logradouro, endereco.getLogradouro());
		assertEquals(bairro, endereco.getBairro());
		assertEquals(localidade, endereco.getLocalidade());
		assertEquals(uf, endereco.getUf());
		assertEquals(cep, endereco.getCep());
	}

}
