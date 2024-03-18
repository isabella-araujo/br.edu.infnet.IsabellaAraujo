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
import br.edu.infnet.isabellaaraujo.model.service.LivrariaService;

@Component
public class LivrariaLoader implements ApplicationRunner {
		
	@Autowired
	private IEnderecoClient enderecoClient;
	
	private static LivrariaService livrariaService = new LivrariaService();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Endereco enderecoCarello = enderecoClient.obterPorCep("22410001");
		Endereco enderecoLeitura = enderecoClient.obterPorCep("20010150");
		Endereco enderecoDaTravessa = enderecoClient.obterPorCep("20050009");
		
		Livro livro = new Livro("Você", "Caroline Kepnes", 2014, "853253094X");
		
		Livraria livraria = new Livraria("Livraria Carello", enderecoCarello);
		
	    Estoque estoque = new Estoque(livro, 30, livraria);
		
		livraria.estoque.add(estoque);

		livrariaService.Incluir(livraria);
		livrariaService.Incluir(new Livraria("Livraria Leitura", enderecoLeitura));
		livrariaService.Incluir(new Livraria("Livraria da Travessa", enderecoDaTravessa));
        
        System.out.println(livrariaService.Obter("20050009"));
	}
}
	
