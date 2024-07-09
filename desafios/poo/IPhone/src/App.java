import dio.iphone.model.IPhone;
import dio.iphone.model.ReprodutorMusical;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Testando o iPhone!!");

        System.out.println("----------------------------");
        ReprodutorMusical iphone = new IPhone();
        System.out.println("=== Reprodutor Musical ===");
        iphone.tocar();
        iphone.pausar();
        iphone.selecionarMusica("As quatro estações (Vivaldi)");
    }
}
