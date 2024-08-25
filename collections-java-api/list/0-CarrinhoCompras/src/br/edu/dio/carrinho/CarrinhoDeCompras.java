package br.edu.dio.carrinho;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itensList;

    public CarrinhoDeCompras() {
        this.itensList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itensList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensRemocao = new ArrayList<>();
        for (Item it : itensList) {
            if (it.getNome().equalsIgnoreCase(nome)) {
                itensRemocao.add(it);
            }
        }
        itensList.removeAll(itensRemocao);
    }

    public double calcularValorTotal(){
        double total = 0;
        for(Item it : itensList){
            total += it.getPreco()*it.getQuantidade();
        }
        return total;
    }

    public void exibirItens(){
        System.out.println(itensList);
    }

}
