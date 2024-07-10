import br.edu.dio.iphone.model.IPhone;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Testando o iPhone!!");
        IPhone iphoneMarco = new IPhone();

        System.out.println("----------------------------");
        System.out.println("=== Reprodutor Musical ===");
        iphoneMarco.tocar();
        iphoneMarco.pausar();
        iphoneMarco.selecionarMusica("As quatro estações (Vivaldi)");

        System.out.println("----------------------------");
        System.out.println("=== Aparelho Telefonico ===");
        iphoneMarco.ligar("+55 71 99151-0929");
        iphoneMarco.atender();
        iphoneMarco.iniciarCorreioVoz();

        System.out.println("----------------------------");
        System.out.println("=== Navegador Internet ===");
        iphoneMarco.exibirPagina("https://www.dio.me");
        iphoneMarco.adicionarNovaAba();
        iphoneMarco.atualizarPagina();
    }
}
