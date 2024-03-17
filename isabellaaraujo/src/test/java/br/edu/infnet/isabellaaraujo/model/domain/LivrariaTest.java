package br.edu.infnet.isabellaaraujo.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LivrariaTest {
	// endereco
	private String logradouro = "Rua Visconde de Pirajá";
	private String bairro = "Ipanema";
    private String localidade = "Rio de Janeiro";
    private String uf = "RJ";
    private String cep = "22410001";
  
    public Endereco enderecoLivraria = new Endereco(logradouro, bairro, localidade, uf, cep);
    
    //livraria
    public final String nomeLivraria = "Livraria Carello";
	public Livraria livraria = new Livraria(nomeLivraria, enderecoLivraria);
	
	// livros e estoque
	public Livro livro1 = new Livro("Você", "Caroline Kepnes", 2014, "853253094X");
	Estoque estoque1 = new Estoque(livro1, 50, livraria);
	
	public Livro livro2 = new Livro("Conectadas", "Clara Alves", 2019, "8555340896");
	Estoque estoque2 = new Estoque(livro2, 10, livraria);

	@BeforeEach
	void setUp(){
		livraria.setNome(nomeLivraria);
		livraria.setEndereco(enderecoLivraria);
		livraria.estoque.add(estoque1);
		livraria.estoque.add(estoque2);
	}

	@Test
	void recuperarDados() {
		assertEquals(nomeLivraria, livraria.getNome());
		assertEquals(enderecoLivraria, livraria.getEndereco());
	}
	
	@Test
	void exibirEstoque() {
		livraria.exibirEstoque();
	}

}
