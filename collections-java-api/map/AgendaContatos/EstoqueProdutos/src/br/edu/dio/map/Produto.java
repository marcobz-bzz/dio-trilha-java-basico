package br.edu.dio.map;

public class Produto {
    private long cod;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(long cod, String nome, int quantidade, double preco) {
        this.cod = cod;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public long getCod() {
        return cod;
    }
    public String getNome() {
        return nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto [cod=" + cod + ", nome=" + nome + 
        ", quantidade=" + quantidade + ", preco=" + preco + "]\n";
    } 

}
