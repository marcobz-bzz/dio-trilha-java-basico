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
        System.out.println("---criando uma nova Lista de Tarefas---");
        ListaTarefas lt = new ListaTarefas();
        System.out.println("> num. inicial de tarefas = "+lt.obterNumeroTotalTarefas());
        System.out.println("===============================");

        lt.adicionarTarefa("tarefa 1");
        System.out.println("aidicionada 'tarefa1'");
        lt.adicionarTarefa("tarefa 1");
        System.out.println("aidicionada 'tarefa1' ... novamente");
        lt.adicionarTarefa("tarefa 2");
        System.out.println("aidicionada 'tarefa2'");
        lt.adicionarTarefa("tarefa 3");
        System.out.println("aidicionada 'tarefa3'");
        lt.adicionarTarefa("a e i o u");
        System.out.println("aidicionada 'a e i o u'");
        System.out.println("> num. de tarefas = "+lt.obterNumeroTotalTarefas());
        System.out.println("===============================");
        
        lt.removerTarefa("Tarefa 1");
        System.out.println("removida 'Tarefa 1'");
        System.out.println("> num. de tarefas = "+lt.obterNumeroTotalTarefas());
        
        System.out.println("===============================");
        System.out.println("listando as tarefas...");
        lt.obterDescricoesTarefas();
    }
}
