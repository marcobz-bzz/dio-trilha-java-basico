package br.edu.dio.list;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> tarefaList;

    ListaTarefas() {
        tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        for (Tarefa tt : tarefaList) {
            List<Tarefa> tarefasRemocaoList = new ArrayList<>();
            if (tt.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasRemocaoList.add(tt);
            }
            tarefaList.removeAll(tarefasRemocaoList);
        }
    }

    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }

    public List<String> obterDescricoesTarefas(){
        List<String> descricaoList = new ArrayList<>();
        //TODO codificar
        return descricaoList;
    }
}
