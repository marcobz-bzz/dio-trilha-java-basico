import br.edu.dio.list.ListaTarefas;

/**
 * Projeto -- Lista de Tarefas
Crie uma classe chamada "ListaTarefas" que possui uma lista de tarefas como atributo.
Cada tarefa é representada por uma classe chamada "Tarefa" que possui um atributo de descrição.
Implemente os seguintes métodos:

adicionarTarefa(String descricao): Adiciona uma nova tarefa à lista com a descrição fornecida.
removerTarefa(String descricao): Remove uma tarefa da lista com base em sua descrição.
obterNumeroTotalTarefas(): Retorna o número total de tarefas na lista.
obterDescricoesTarefas(): Retorna uma lista contendo a descrição de todas as tarefas na lista.
 */

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ListaTarefas lt = new ListaTarefas();
        System.out.println("> num. inicial de tarefas = "+lt.obterNumeroTotalTarefas());
        lt.adicionarTarefa("tarefa 1");
        lt.adicionarTarefa("tarefa 1");
        lt.adicionarTarefa("tarefa 2");
        lt.adicionarTarefa("tarefa 3");
        lt.adicionarTarefa("a e i o u");
        System.out.println("> num. de tarefas = "+lt.obterNumeroTotalTarefas());
        //lt.removerTarefa("Tarefa 1");
        System.out.println("> num. de tarefas = "+lt.obterNumeroTotalTarefas());
        lt.obterDescricoesTarefas();
    }
}