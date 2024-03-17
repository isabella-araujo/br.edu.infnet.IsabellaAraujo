package br.edu.infnet.isabellaaraujo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.isabellaaraujo.clients.IEnderecoClient;
import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.domain.Livraria;
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
		Endereco enderecoDaTravessa = enderecoClient.obterPorCep("20050-009");
		
		
		livrariaService.Incluir(new Livraria("Livraria Carello", enderecoCarello));
		livrariaService.Incluir(new Livraria("Livraria Leitura", enderecoLeitura));
		livrariaService.Incluir(new Livraria("Livraria da Travessa", enderecoDaTravessa));
		
//        System.out.println("----------------------------------------------------------");
//        System.out.println("Lista de Livrarias: ");
//		System.out.println(livrariaService.ObterLista());
//		
//		livrariaService.Obter("Livraria Carello");
//
//        livrariaService.Excluir("Livraria da Travessa");
//        System.out.println(" - " + livrariaService.ObterLista());	
	}
}
	
