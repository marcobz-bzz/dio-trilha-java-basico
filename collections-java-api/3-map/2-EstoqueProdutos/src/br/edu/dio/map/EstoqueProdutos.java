package br.edu.dio.map;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> produtosMap;

    public EstoqueProdutos() {
        produtosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome,
            int quantidade, double preco) {
        produtosMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        System.out.println(produtosMap);
    }

    public double calcularValorTotalEstoque() {
        if (produtosMap.isEmpty())
            return 0;

        double valorTotalEstoque = 0;
        for (Produto pp : produtosMap.values()) {
            valorTotalEstoque += pp.getQuantidade() * pp.getPreco();
        }

        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        if (produtosMap.isEmpty())
            return null;

        Produto pp = null;
        for (Produto pp2 : produtosMap.values()) {
            if (pp2 == null)
                continue;
            if (pp == null) {
                pp = pp2;
                continue;
            }
            if (pp2.getPreco() > pp.getPreco())
                pp = pp2;
        }
        return pp;
    }

    public Produto obterProdutoMaisBarato() {
        if (produtosMap.isEmpty())
            return null;

        Produto pp = null;
        for (Produto pp2 : produtosMap.values()) {
            if (pp2 == null)
                continue;
            if (pp == null) {
                pp = pp2;
                continue;
            }
            if (pp2.getPreco() < pp.getPreco())
                pp = pp2;
        }
        return pp;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        if (produtosMap.isEmpty())
            return null;

        Produto pp = null;
        for (Produto pp2 : produtosMap.values()) {
            if (pp2 == null)
                continue;
            if (pp == null) {
                pp = pp2;
                continue;
            }
            if (pp2.getPreco()*pp2.getQuantidade() > pp.getPreco()*pp.getQuantidade())
                pp = pp2;
        }
        return pp;
    }
}
