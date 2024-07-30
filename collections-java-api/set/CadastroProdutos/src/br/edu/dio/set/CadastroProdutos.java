package br.edu.dio.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtosSet;

    public CadastroProdutos() {
        produtosSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtosSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNomeSet = new TreeSet<>(produtosSet);
        return produtosPorNomeSet;
    }

    public Set<Produto> exibirProdutosPorNome22() {
        Set<Produto> produtosPorNomeSet = new TreeSet<>(new ComparatorPorNome());
        produtosPorNomeSet.addAll(produtosSet);
        return produtosPorNomeSet;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPrecoSet = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPrecoSet.addAll(produtosSet);
        return produtosPorPrecoSet;
    }

    public Set<Produto> exibirProdutos(){
        return produtosSet;
    }
}
