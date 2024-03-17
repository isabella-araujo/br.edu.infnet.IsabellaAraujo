package br.edu.infnet.isabellaaraujo.model.domain;

public class Estoque {
    private Livro livro;
    private String nomeLivro;
    private int qtdeLivros;
    private Livraria livraria;
    private String isbn;

    public Estoque(Livro livro, int qtdeLivros, Livraria livraria) {
        this.livro = livro;
        nomeLivro = livro.getTitulo();
        setQtdeLivros(qtdeLivros);
        this.livraria = livraria;
        isbn = livro.getIsbn();
    }

    @Override
    public String toString() {
        return "Estoque da " + livraria.getNome() + ": " + "\n" +
                "Livro: " + nomeLivro + "\n" +
                "ISBN: " + isbn  + "\n" +
                "Quantidade de Livros: " + qtdeLivros;
    }

    public boolean estoqueCheio() {
        return qtdeLivros == 50;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public int getQtdeLivros() {
        return qtdeLivros;
    }

    public void setQtdeLivros(int qtdeLivros) {
        if (qtdeLivros >= 0 && qtdeLivros <= 50) {
            this.qtdeLivros = qtdeLivros;
        }
    }

    public Livraria getLivraria() {
        return livraria;
    }

    public void setLivraria(Livraria livraria) {
        this.livraria = livraria;
    }

    public String getIsbn() {
        return isbn;
    }
}
