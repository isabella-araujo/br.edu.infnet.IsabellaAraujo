package br.edu.infnet.isabellaaraujo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.isabellaaraujo.model.domain.Livro;
import br.edu.infnet.isabellaaraujo.model.service.LivroService;

@Component
public class LivroLoader implements ApplicationRunner{

	LivroService livroService = new LivroService();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Livro livro = new Livro("Entrevista com o Vampiro", "Anne Rice", 1976, "8532531830");
		livroService.Incluir(livro);
        livroService.Incluir(new Livro("Não me abandone jamais", "Kazuo Ishiguro", 2005, "8535926550"));
        livroService.Incluir(new Livro("Belas Maldições", "Neil Gaiman & Terry Pratchett", 1990, "6558380765"));

//        System.out.println("----------------------------------------------------------");
//        System.out.println("Lista de Livros: ");
//        System.out.println(" - " + livroService.ObterLista());
//
//        livroService.Obter("6558380765");

//        livroService.Excluir("6558380765");
        System.out.println(" - " + livroService.ObterLista());	
	}

}
