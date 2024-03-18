package br.edu.infnet.isabellaaraujo.model.domain;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String isbn;
    
    public Livro() {
        
    }
    
    public Livro(String titulo, String autor, int anoPublicacao, String isbn) {
        this();
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
    }
    
    @Override
    public String toString() {
        return "Título: " + titulo + "\n" + "Autor: " + autor + "\n" + "ISBN: " + isbn;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
