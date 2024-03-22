package br.edu.infnet.isabellaaraujo.model.domain;

import java.time.Year;

public class Livro {

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String isbn;
    private boolean disponivel = true;
    private final int prazoDevolucao = 7;
    private Biblioteca biblioteca;
    
    public Livro() {
        
    }
    
    public Livro(String titulo, String autor, int anoPublicacao, String isbn) {
        this();
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
    }
    
    public Livro(String titulo, String autor, int anoPublicacao, String isbn, Biblioteca biblioteca) {
        this(titulo, autor, anoPublicacao, isbn);
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.biblioteca = biblioteca;
    }
    
    @Override
    public String toString() {
        return "Título: " + titulo + "\n" + "Autor: " + autor + "\n" + "ISBN: " + isbn;
    }
    
    public String verificarDisponibilidade() {
      if(disponivel){
        return "Disponível";
      } else {
        return "Indisponível";
      }
    }
    
    public void devolver() {
      if (!disponivel) {
        disponivel = true;
      }
    }

    public void emprestar() {
      if (disponivel){
        disponivel = false;
      }
    }
    
    public int obterPrazoDeDevolucao() {
      return prazoDevolucao;
    }
    
    // getters e setters
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
    	if (titulo.length() >= 2 && titulo.length() <= 30) {
            this.titulo = titulo;
        }
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
    	if (autor.length() >= 2 && autor.length() <= 30) {
            this.autor = autor;
        }
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int anoPublicacao) {
    	int anoAtual = Year.now().getValue();
    	if (anoPublicacao >= 1455 && anoPublicacao <= anoAtual) {
            this.anoPublicacao = anoPublicacao;
        }
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
    	if (isbn.length() == 10 || isbn.length() == 13) {
            this.isbn = isbn;
        }
    }
    
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
