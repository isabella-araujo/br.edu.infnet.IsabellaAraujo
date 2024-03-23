package br.edu.infnet.isabellaaraujo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.isabellaaraujo.clients.IEnderecoClient;
import br.edu.infnet.isabellaaraujo.model.domain.Biblioteca;
import br.edu.infnet.isabellaaraujo.model.domain.Endereco;
import br.edu.infnet.isabellaaraujo.model.domain.Livro;
import br.edu.infnet.isabellaaraujo.model.service.LivroService;

@Component
public class LivroLoader implements ApplicationRunner{

	@Autowired
	private IEnderecoClient enderecoClient;
	
	public LivroService livroService = new LivroService();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Endereco endereco1 = enderecoClient.obterPorCep("22410001");
		
		Biblioteca biblioteca = new Biblioteca("Biblioteca UM", endereco1);
		
		livroService.Incluir(new Livro("Entrevista com o Vampiro", "Anne Rice", 2020, "8532531830", biblioteca), biblioteca.getCep());
        livroService.Incluir(new Livro("Belas Maldições", "Neil Gaiman & Terry Pratchett", 2022, "6558380765", biblioteca), biblioteca.getCep());

        //livroService.Excluir("6558380765", biblioteca.getCep());
	}

}
