package br.edu.infnet.isabellaaraujo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.isabellaaraujo.clients.IEnderecoClient;
import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.domain.Estoque;
import br.edu.infnet.isabellaaraujo.model.domain.Livraria;
import br.edu.infnet.isabellaaraujo.model.domain.Livro;
import br.edu.infnet.isabellaaraujo.model.service.EstoqueService;

@Component
public class EstoqueLoader implements ApplicationRunner {
	
	@Autowired
	private IEnderecoClient enderecoClient;

	EstoqueService estoqueService = new EstoqueService();

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Endereco endereco = enderecoClient.obterPorCep("22410001");
		Livraria livraria = new Livraria("Livraria Carello", endereco);
		
		Livro livro1 = new Livro("Deuses Americanos", "Neil Gaiman", 2001, "8551000721");
		Livro livro2 = new Livro("Não me abandone jamais", "Kazuo Ishiguro", 2005, "8535926550");
		Livro livro3 = new Livro("Você", "Caroline Kepnes", 2014, "853253094X");
		
		estoqueService.Incluir(new Estoque(livro1, 50, livraria));
		estoqueService.Incluir(new Estoque(livro2, 30, livraria));
		estoqueService.Incluir(new Estoque(livro3, 15, livraria));

		System.out.println("----------------------------------------------------------");
	    System.out.println("Lista de Estoque: ");
	    System.out.println(" - " + estoqueService.ObterLista());

	    estoqueService.Obter("8535926550");

	    estoqueService.Excluir("8535926550");
	    System.out.println(" - " + estoqueService.ObterLista());	
	}

}
