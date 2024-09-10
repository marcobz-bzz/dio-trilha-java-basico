import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Desafios!");

        desafio5();

    }

    public static void desafio1() {
        Scanner scanner = new Scanner(System.in);

        // Lê a Entrada que informa o saldo inicial da conta
        double saldo = scanner.nextDouble();

        // Lê a Entrada com a quantidade total de transações
        int quantidadeTransacoes = scanner.nextInt();

        // Lista para armazenar as transações
        List<String> transacoes = new ArrayList<>();
        // Loop para iterar sobre as transações
        for (int i = 1; i <= quantidadeTransacoes; i++) {
            // Lê a Entrada com o tipo de transação (D para depósito ou S para saque)
            // O método "toUpperCase" padroniza o tipo de transação com a letra maiúscula
            char tipoTransacao = scanner.next().toUpperCase().charAt(0);
            // Lê a Entrada com o valor da transação
            double valorTransacao = scanner.nextDouble();

            // Atualiza o saldo da conta e adicionar a transação à lista
            if (tipoTransacao == 'D') {
                saldo += valorTransacao;
                transacoes.add("Deposito de " + valorTransacao);
            } else if (tipoTransacao == 'S') {
                saldo -= valorTransacao;
                transacoes.add("Saque de " + valorTransacao);
            } else {
                System.out.println("Opção inválida. Utilize D para depósito ou S para saque.");
                i--; // Decrementa o índice para repetir a iteração
            }
        }

        // TODO: Exibir o saldo final e a lista de transações conforme a tabela de
        // Exemplos.
        System.out.println("Saldo: " + String.format("%.1f", saldo));
        System.out.println("Transacoes:");
        IntStream.range(1, transacoes.size() + 1)
                .mapToObj(nn -> nn + ". " + transacoes.get(nn - 1))
                .forEach(System.out::println);
        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }

    public static void desafio2() {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        int quantidadeTransacoes = scanner.nextInt();

        List<Transacao> transacoes = new ArrayList<>();

        for (int i = 1; i <= quantidadeTransacoes; i++) {

            char tipoTransacao = scanner.next().charAt(0);
            double valorTransacao = scanner.nextDouble();

            // TODO: Criar uma nova transação e adicioná-la à lista de transações
            Transacao transacao;
            transacao = new Transacao(tipoTransacao, valorTransacao);
            transacoes.add(transacao);
            // Verifica e atualiza o saldo da conta com base no tipo de transação
            if (Character.toUpperCase(transacao.getTipo()) == 'D') {
                saldo += valorTransacao;
            } else if (Character.toUpperCase(transacao.getTipo()) == 'S') {
                saldo -= valorTransacao;
            }
        }

        System.out.println("\nSaldo : " + saldo);
        System.out.println("\nTransacoes:");
        transacoes.stream()
                .map(transacao -> transacao.getTipo() + " de " + transacao.getValor())
                .forEach(System.out::println);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }

    public static void desafio3() {
        Scanner scanner = new Scanner(System.in);

        // TODO: Criar uma nova conta bancária com o saldo inicial
        double saldoInicial = scanner.nextDouble();
        ContaBancaria3 conta = new ContaBancaria3(saldoInicial);

        // Lê a Entrada com o valor do deposito e aciona o método "depositar"
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);

        // Lê a Entrada com o valor do saque e aciona o método "sacar"
        double valorSaque = scanner.nextDouble();
        conta.sacar(valorSaque);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }

    public static void desafio4() {
        // Lendo os dados de Entrada:
        Scanner scanner = new Scanner(System.in);
        String titular = scanner.next();
        int numeroConta = scanner.nextInt();
        double saldo = scanner.nextDouble();
        double taxaJuros = scanner.nextDouble();

        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, titular, saldo, taxaJuros);

        System.out.println("Conta Poupanca:");
        contaPoupanca.exibirInformacoes();
        scanner.close();
    }

    public static void desafio5() {
        // Lê o tipo de cofre (primeira linha da entrada)
        Scanner scanner = new Scanner(System.in);
        String tipoCofre = scanner.nextLine();

        // TODO: Implemente a condição necessário para a verificação dos cofres seguros:
        //Cofre cofre = null;
        if (tipoCofre.equalsIgnoreCase("digital")) {
            int senha = Integer.parseInt(scanner.nextLine());
            CofreDigital cofre = new CofreDigital(senha);
            cofre.imprimirInformacoes();
            int confirmacaoSenha = Integer.parseInt(scanner.nextLine());
            if(!cofre.validarSenha(confirmacaoSenha)){
                System.out.println("Senha incorreta!");
            }else{
                System.out.println("Cofre aberto!");
            }

        }else{
            CofreFisico cofre = new CofreFisico();
            cofre.imprimirInformacoes();
        }
        scanner.close();
    }
}

// classes e métodos auxiliares
// desfio 2
class Transacao {
    private char tipo;
    private double valor;

    public Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}

// desafio 3
class ContaBancaria3 {
    private double saldo;

    public ContaBancaria3(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        // TODO: Incrementar o saldo com o valor e imprimir "Deposito feito."
        saldo += valor;
        System.out.println("Deposito feito.");
        imprimirSaldo();
    }

    public void sacar(double valor) {
        // TODO: Verificar se o saldo é suficiente considerando o valor:
        // Se sim, atualizar o saldo e imprimir "Saque feito."
        // Se não, imprimir "Saldo insuficiente. Saque não realizado."
        if (valor > saldo) {
            System.out.println("Saldo insuficiente. Saque não realizado.");
            return;
        }
        saldo -= valor;
        System.out.println("Saque feito.");
        imprimirSaldo();
    }

    private void imprimirSaldo() {
        System.out.printf("Saldo atual: %.1f\n", this.saldo);
    }
}

// desafio 4
class ContaBancaria {
    protected int numero;
    protected String titular;
    protected double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void exibirInformacoes() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        System.out.println(titular);
        System.out.println(numero);
        System.out.println("Saldo: R$ " + decimalFormat.format(saldo));
    }
}

class ContaPoupanca extends ContaBancaria {
    private double taxaJuros;

    public ContaPoupanca(int numero, String titular, double saldo, double taxaJuros) {
        // TODO: Implementar adequadamente esta sobrecarga de construtores.
        super(numero, titular, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        // TODO: Complementar as informações com a taxa de juros.
        System.out.println("Taxa de juros: " + String.format("%.1f%%", taxaJuros));
    }
}

// desafio 5
abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;
  
    public Cofre(String tipo, String metodoAbertura) {
      this.tipo = tipo;
      this.metodoAbertura = metodoAbertura;
    }
  
    public void imprimirInformacoes() {
      System.out.println("Tipo: " + this.tipo);
      System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
  }
  
  class CofreDigital extends Cofre {
  
    private int senha;
  
    public CofreDigital(int senha) {
      super("Cofre Digital", "Senha");
      this.senha = senha;
    }
  
    public boolean validarSenha(int confirmacaoSenha) {
      return confirmacaoSenha == this.senha;
    }
  }
  
  class CofreFisico extends Cofre {
  
    public CofreFisico() {
      super("Cofre Fisico", "Chave");
    }
  
  }