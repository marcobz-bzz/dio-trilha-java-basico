import br.edu.dio.BancoDigital;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("---------------------------------");
        System.out.println("Hello, Banco Digital!\n");

        System.out.println("---------------------------------");
        System.out.println(">> criando banco Santander -- número 033 e agência 222");
        BancoDigital bDigital = new BancoDigital("Santander", 33, 222);
        System.out.println(bDigital);

        System.out.println("---------------------------------");
    }
}
