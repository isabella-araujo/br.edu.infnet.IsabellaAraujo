package br.edu.infnet.isabellaaraujo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.isabellaaraujo.clients.IEnderecoClient;
import br.edu.infnet.isabellaaraujo.model.domain.Biblioteca;
import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.domain.Livro;
import br.edu.infnet.isabellaaraujo.model.service.BibliotecaService;
import br.edu.infnet.isabellaaraujo.model.service.LivroService;

@Component
public class BibliotecaLoader implements ApplicationRunner {
		
	@Autowired
	private IEnderecoClient enderecoClient;
	
	private static BibliotecaService bibliotecaService = new BibliotecaService();
	private static LivroService livroService = new LivroService();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Endereco endereco1 = enderecoClient.obterPorCep("22410001");
		Endereco endereco2 = enderecoClient.obterPorCep("20010150");
		Endereco endereco3 = enderecoClient.obterPorCep("20050009");
		
		Biblioteca biblioteca = new Biblioteca("Biblioteca UM", endereco1);
		bibliotecaService.Incluir(new Biblioteca("Biblioteca DOIS", endereco2));
		bibliotecaService.Incluir(new Biblioteca("Biblioteca TRÊS", endereco3));
		bibliotecaService.Incluir(biblioteca);
        //System.out.println(bibliotecaService.Obter("20050-009"));
		
		
		Livro livro1 = new Livro("Você", "Caroline Kepnes", 2014, "853253094X", biblioteca);
		Livro livro2 = new Livro("O castelo animado", "Diana Wynne Jones", 2022, "655587208X", biblioteca);
		Livro livro3 = new Livro("Não me abandone jamais", "Kazuo Ishiguro", 2005, "8535926550", biblioteca);
		
		livroService.Incluir(livro1, "22410-001");
		livroService.Incluir(livro2, "22410-001");
		livroService.Incluir(livro3, "22410-001");
	}
}
	
