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
        String cpfMarcelo = "182.198.228-21";
        String cpfMatheus = "329.665.448-80";
        bDigital.cadastrarCliente(cpfMarcelo, "Marcelo", "senha1");
        bDigital.cadastrarCliente(cpfMatheus, "Matheus", "senha2");

        System.out.println("\n---------------------------------");
        System.out.println(">> criar uma CONTA CORRENTE para Marcelo");
        int idCCMarcelo1 = bDigital.criarContaCorrente(cpfMarcelo,
                "senha1",
                Operacao.CONTA_CORRENTE);
        System.out.println(">> id CC Marcelo = " + idCCMarcelo1);

        System.out.println("\n---------------------------------");
        System.out.println(">> criar outa CONTA CORRENTE para Marcelo");
        int idCCMarcelo2 = bDigital.criarContaCorrente(cpfMarcelo,
                "senha1",
                Operacao.CONTA_CORRENTE);
        System.out.println(">> id CC Marcelo = " + idCCMarcelo2);

        System.out.println("\n---------------------------------");
        System.out.println(">> criar uma CONTA POUPANCA para Marcelo");
        int idPoupMarcelo1 = bDigital.criarContaCorrente(cpfMarcelo,
                "senha1",
                Operacao.POUPANCA);
        System.out.println(">> id CC Marcelo = " + idPoupMarcelo1);

        System.out.println("\n---------------------------------");
        System.out.println(">> criar uma CONTA CORRENTE para Matheus");
        int idCCMatheus1 = bDigital.criarContaCorrente(cpfMatheus,
                "senha2",
                Operacao.CONTA_CORRENTE);
        System.out.println(">> id CC Matheus = " + idCCMatheus1);

        System.out.println("\n---------------------------------");
        System.out.println(">> criar uma CONTA POUPANÇA para Matheus");
        int idPoupMatheus1 = bDigital.criarContaCorrente(cpfMatheus,
                "senha2",
                Operacao.POUPANCA);
        System.out.println(">> id CC Matheus = " + idPoupMatheus1);

        System.out.println("\n---------------------------------");
        System.out.println(">> depositar R$ 1000,00 na CONTA CORRENTE 1 de Marcelo");
        bDigital.depositar(cpfMarcelo, idCCMarcelo1, 1000);

        System.out.println("\n---------------------------------");
        System.out.println(">> Obtém o saldo CONTA CORRENTE 1 de Marcelo");
        bDigital.printSaldoConta(cpfMarcelo, "senha1", idCCMarcelo1);
        
        System.out.println("\n---------------------------------");
        System.out.println(">> depositar R$ 2000,00 nas outras contas de Marcelo");
        bDigital.depositar(cpfMarcelo, idCCMarcelo2, 2000);
        bDigital.printSaldoConta(cpfMarcelo, "senha1", idCCMarcelo2);
        bDigital.depositar(cpfMarcelo, idPoupMarcelo1, 2000);
        bDigital.printSaldoConta(cpfMarcelo, "senha1", idPoupMarcelo1);

        System.out.println("\n---------------------------------");
        System.out.println(">> testando depósito conta (88) inexistente");
        bDigital.depositar(cpfMatheus, 88, 999);

        System.out.println("\n---------------------------------");
        System.out.println(">> testando print do saldo com conta inexistente (id = 99)");
        bDigital.printSaldoConta(cpfMarcelo, "senha1", 99);

        System.out.println("\n---------------------------------");
        System.out.println(">> testando saque CC 0001 de Marcelo");
        bDigital.printSaldoConta(cpfMarcelo, "senha1", idCCMarcelo1);
        bDigital.sacar(cpfMarcelo, "senha1", idCCMarcelo1, 9500);
        bDigital.printSaldoConta(cpfMarcelo, "senha1", idCCMarcelo1);

        System.out.println("\n---------------------------------");
        System.out.println(">> testando transferência");
        bDigital.transferir(cpfMarcelo, "senha1", idCCMarcelo1, idCCMatheus1, 500);
        bDigital.transferir(cpfMarcelo, "senha1", idCCMarcelo2, idPoupMatheus1, 1500);

        System.out.println("\n---------------------------------");
        System.out.println(">> gerando extrato Marcelo");
        bDigital.gerarExtratoCliente(cpfMarcelo, "senha1");
        System.out.println(">> gerando extrato Matheus");
        bDigital.gerarExtratoCliente(cpfMatheus, "senha2");
    }
}
