import br.edu.dio.banco.BancoDigital;
import br.edu.dio.banco.Operacao;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("---------------------------------");
        System.out.println("Hello, Banco Digital!\n");

        System.out.println("\n---------------------------------");
        System.out.println(">> criando banco Santander -- número 033 e agência 222");
        System.out.println(">> print do Banco:");
        BancoDigital bDigital = new BancoDigital("Santander", 33, 222);
        System.out.println(bDigital);

        System.out.println("\n---------------------------------");
        System.out.println(">> cadastrando um cliente inválido na RECEITA FEDERAL");
        bDigital.cadastrarCliente("111.222.333.444-88", "Marcelo", "senha1");

        System.out.println("\n---------------------------------");
        System.out.println(">> cadastrando cliente VÁLIDO");
        bDigital.cadastrarCliente("182.198.228-21", "Marcelo", "senha1");
        bDigital.cadastrarCliente("329.665.448-80", "Matheus", "senha2");

        System.out.println("\n---------------------------------");
        System.out.println(">> criar uma CONTA CORRENTE para Marcelo");
        int idCCMarcelo1 = bDigital.criarContaCorrente("182.198.228-21",
                "senha1",
                Operacao.CONTA_CORRENTE);
        System.out.println(">> id CC Marcelo = " + idCCMarcelo1);

        System.out.println("\n---------------------------------");
        System.out.println(">> criar outa CONTA CORRENTE para Marcelo");
        int idCCMarcelo2 = bDigital.criarContaCorrente("182.198.228-21",
                "senha1",
                Operacao.CONTA_CORRENTE);
        System.out.println(">> id CC Marcelo = " + idCCMarcelo2);

        System.out.println("\n---------------------------------");
        System.out.println(">> criar uma CONTA POUPANCA para Marcelo");
        int idPoupMarcelo1 = bDigital.criarContaCorrente("182.198.228-21",
                "senha1",
                Operacao.POUPANCA);
        System.out.println(">> id CC Marcelo = " + idPoupMarcelo1);

        System.out.println("\n---------------------------------");
        System.out.println(">> criar uma CONTA CORRENTE para Matheus");
        int idCCMatheus1 = bDigital.criarContaCorrente("329.665.448-80",
                "senha2",
                Operacao.CONTA_CORRENTE);
        System.out.println(">> id CC Matheus = " + idCCMatheus1);

        System.out.println("\n---------------------------------");
        System.out.println(">> criar uma CONTA POUPANÇA para Matheus");
        int idPoupMatheus1 = bDigital.criarContaCorrente("329.665.448-80",
                "senha2",
                Operacao.POUPANCA);
        System.out.println(">> id CC Matheus = " + idPoupMatheus1);

        System.out.println("\n---------------------------------");
        System.out.println(">> depositar R$ 100,00 na CONTA CORRENTE 1 de Marcelo");
        boolean ok = bDigital.depositar("182.198.228-21", idCCMarcelo1, 100);
        System.out.println(ok? ">> Operação bem sucedida!!" : ">> Falha na operação!!");

        System.out.println("\n---------------------------------");
        System.out.println(">> Obtém o saldo CONTA CORRENTE 1 de Marcelo");
        bDigital.printSaldoConta("182.198.228-21", "senha1", idCCMarcelo1);
        
        System.out.println("\n---------------------------------");
        System.out.println(">> depositar R$ 200,00 nas outras contas de Marcelo");
        ok = bDigital.depositar("182.198.228-21", idCCMarcelo2, 200);
        System.out.println(ok? ">> Operação bem sucedida!!" : ">> Falha na operação!!");
        bDigital.printSaldoConta("182.198.228-21", "senha1", idCCMarcelo2);
        ok = bDigital.depositar("182.198.228-21", idPoupMarcelo1, 200);
        System.out.println(ok? ">> Operação bem sucedida!!" : ">> Falha na operação!!");
        bDigital.printSaldoConta("182.198.228-21", "senha1", idPoupMarcelo1);

        System.out.println("\n---------------------------------");
        System.out.println(">> testando print do saldo com conta inexistente (id = 99)");
        bDigital.printSaldoConta("182.198.228-21", "senha1", 99);
        
    }
}
