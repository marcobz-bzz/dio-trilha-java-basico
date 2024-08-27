package br.edu.dio.pessoas;

public class Pessoa implements Comparable<Pessoa>{
    private String nome;
    private int idade;
    private double altura;
    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public double getAltura() {
        return altura;
    }
    @Override
    public String toString() {
        return "[nome=" + nome + ", idade=" + idade + ", altura=" + altura + "]\n";
    }
    @Override
    public int compareTo(Pessoa pp) {
        return Integer.compare(idade, pp.getIdade());
    }
}
