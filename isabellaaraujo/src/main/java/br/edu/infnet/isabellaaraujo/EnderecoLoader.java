package br.edu.infnet.isabellaaraujo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.isabellaaraujo.clients.IEnderecoClient;
import br.edu.infnet.isabellaaraujo.model.service.EnderecoService;

@Component
public class EnderecoLoader implements ApplicationRunner {

	@Autowired
	private IEnderecoClient enderecoClient;
	
	private static EnderecoService enderecoService = new EnderecoService();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		enderecoService.Incluir(enderecoClient.obterPorCep("22410001"));
		enderecoService.Incluir(enderecoClient.obterPorCep("20010150"));
		enderecoService.Incluir(enderecoClient.obterPorCep("20050009"));
		
        System.out.println("----------------------------------------------------------");
        System.out.println("Lista de Enderecos: ");
		System.out.println(enderecoService.ObterLista());
		
		enderecoService.Obter("22410001");

        enderecoService.Excluir("20050009");
        System.out.println(" - " + enderecoService.ObterLista());	
	}
}
