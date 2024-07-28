import br.edu.dio.set.AgendaContatos;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Contatos!");

        AgendaContatos agc = new AgendaContatos();
        agc.exibirContatos();

        agc.adicionarContato("marco", 33589473);
        agc.exibirContatos();

        agc.adicionarContato("Marco", 33589473);
        agc.adicionarContato("Caca", 33589474);
        agc.adicionarContato("Patinho", 33589475);
        agc.adicionarContato("Onça", 33589476);

        agc.exibirContatos();

        System.out.println(agc.atualizarNumeroContato("MARCO", 144));
        agc.exibirContatos();
    }
}
