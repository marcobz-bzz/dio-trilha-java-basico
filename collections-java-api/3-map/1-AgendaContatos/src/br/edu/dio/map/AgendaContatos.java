package br.edu.dio.map;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String,Integer> contatoMap;

    public AgendaContatos() {
        contatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        contatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(contatoMap.isEmpty()) return;
        contatoMap.remove(nome);
    }

    public void exibirContatos(){
        System.out.println(contatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        if(contatoMap.isEmpty())return null;
        return contatoMap.get(nome);
    }
}
