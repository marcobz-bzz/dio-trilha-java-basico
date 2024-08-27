package br.edu.dio.livros;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livrosList;

    public CatalogoLivros() {
        livrosList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livrosList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosAutorList = new ArrayList<>();
        for(Livro ll : livrosList){
            if(ll.getAutor().equalsIgnoreCase(autor)){
                livrosAutorList.add(ll);
            }
        }
        return livrosAutorList;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosAnos = new ArrayList<>();
        for(Livro ll : livrosList){
            if((ll.getAnoPublicacao() >= anoInicial) && (ll.getAnoPublicacao() <= anoFinal)){
                livrosAnos.add(ll);
            }
        }
        return livrosAnos;
    }

    public Livro pesquisarPorTitulo(String titulo){
        for(Livro ll : livrosList){
            if(ll.getTitulo().equalsIgnoreCase(titulo)){
                return ll;
            }
        }
        return null;
    }
}
