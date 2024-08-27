package br.edu.dio.set;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatosSet;

    public AgendaContatos() {
        contatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatosSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        System.out.println(contatosSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatoPesq = new HashSet<>();
        for(Contato cc : contatosSet){
            if(cc.getNome().toLowerCase().startsWith(nome.toLowerCase())){
                contatoPesq.add(cc);
            }
        }
        return contatoPesq;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        for(Contato cc : contatosSet){
            if(cc.getNome().equalsIgnoreCase(nome)){
                cc.setNumero(novoNumero);
                return cc;
            }
        }
        return null;
    }
}
