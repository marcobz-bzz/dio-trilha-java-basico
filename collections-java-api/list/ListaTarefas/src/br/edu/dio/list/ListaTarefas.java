package br.edu.dio.list;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> tarefaList;

    public ListaTarefas() {
        tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasRemocaoList = new ArrayList<>();

        for (Tarefa tt : tarefaList) {
            if (tt.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasRemocaoList.add(tt);
            }
        }
        tarefaList.removeAll(tarefasRemocaoList);
    }

    public int obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    public void obterDescricoesTarefas() {
        System.out.println(tarefaList);
    }
}
