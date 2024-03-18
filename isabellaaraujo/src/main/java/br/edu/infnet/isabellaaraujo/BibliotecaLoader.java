package br.edu.infnet.isabellaaraujo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.isabellaaraujo.clients.IEnderecoClient;
import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.domain.Biblioteca;
import br.edu.infnet.isabellaaraujo.model.domain.Livro;
import br.edu.infnet.isabellaaraujo.model.service.BibliotecaService;

@Component
public class BibliotecaLoader implements ApplicationRunner {
		
	@Autowired
	private IEnderecoClient enderecoClient;
	
	private static BibliotecaService bibliotecaService = new BibliotecaService();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Endereco endereco1 = enderecoClient.obterPorCep("22410001");
		Endereco endereco2 = enderecoClient.obterPorCep("20010150");
		Endereco endereco3 = enderecoClient.obterPorCep("20050009");
		
		Biblioteca biblioteca = new Biblioteca("Biblioteca UM", endereco1);
		
		bibliotecaService.Incluir(biblioteca);
		
		Livro livro1 = new Livro("Você", "Caroline Kepnes", 2014, "853253094X");
		Livro livro2 = new Livro("O castelo animado", "Diana Wynne Jones", 1986, "655587208X");
		Livro livro3 = new Livro("Não me abandone jamais", "Kazuo Ishiguro", 2005, "8535926550", biblioteca);
		
		biblioteca.livros.add(livro1);
		biblioteca.livros.add(livro2);
		biblioteca.livros.add(livro3);

		bibliotecaService.Incluir(new Biblioteca("Biblioteca DOIS", endereco2));
		bibliotecaService.Incluir(new Biblioteca("Biblioteca TRÊS", endereco3));
        
        System.out.println(bibliotecaService.Obter("20050009"));
	}
}
	
