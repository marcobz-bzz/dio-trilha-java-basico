import br.edu.dio.map.AgendaContatos;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Contatos!");

        AgendaContatos aCont = new AgendaContatos();

        System.out.println("----------------------");
        aCont.exibirContatos();

        aCont.adicionarContato("bzz", 33589473);
        aCont.adicionarContato("fbz", 9988);
        aCont.adicionarContato("panda", 6666);
        aCont.adicionarContato("fbz", 77777);
        aCont.adicionarContato("Panda", 9999);
        System.out.println("----------------------");
        aCont.exibirContatos();

        aCont.removerContato("Panda");
        System.out.println("----------------------");
        aCont.exibirContatos();

        System.out.println("----------------------");
        System.out.println("bzz = " + aCont.pesquisarPorNome("bzz"));

    }
}
