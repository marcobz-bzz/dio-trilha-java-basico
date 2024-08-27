package br.edu.dio.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

public class EstoqueProdutos {
    private Map<Long, Produto> produtosMap;

    public EstoqueProdutos() {
        produtosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome,
            int quantidade, double preco) {
        produtosMap.put(cod, new Produto(cod, nome, quantidade, preco));
    }

    public void exibirProdutos() {
        System.out.println(produtosMap);
    }

    public double calcularValorTotalEstoque() {
        //TODO falta trabalhar
        if (produtosMap.isEmpty())
            return 0;

        return 0;
    }
}
