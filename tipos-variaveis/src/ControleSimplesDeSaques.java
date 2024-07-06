
/**
 * Descrição
Você está desenvolvendo um programa simples em Java para auxiliar um cliente a realizar saques 
de uma conta bancária. O cliente pode fazer saques até atingir um limite diário predefinido.

Entrada
O programa solicitará ao usuário que informe o limite diário de saque.
Em seguida, o programa solicitará ao usuário que informe o valor do primeiro saque.

Saída
Utilizando um laço for, o programa iterará sobre os saques.
Para cada saque, o programa verificará se o valor ultrapassa o limite diário.
Se ultrapassar, o programa informará que o limite foi atingido e encerrará o loop.
Se não ultrapassar, o programa informará que o saque foi realizado com sucesso.

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	Saída
---------------------------------------------------------------
1500
430
0	    Saque realizado. Limite restante: 1070.0
        Transacoes encerradas.
---------------------------------------------------------------
500
1500	Limite diario de saque atingido. Transacoes encerradas.
---------------------------------------------------------------
80
40
0	    Saque realizado. Limite restante: 40.0
        Transacoes encerradas.
---------------------------------------------------------------
 */
import java.util.Scanner;

public class ControleSimplesDeSaques {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double limiteDiario = scanner.nextDouble();

        // Loop for para iterar sobre os saques
        for (int i = 1;; i++) {

            double valorSaque = scanner.nextDouble();

            if (valorSaque == 0) {
                System.out.println("Transacoes encerradas.");
                break; // Encerra o loop
            } else if (valorSaque > limiteDiario) {
                System.out.println("Limite diario de saque atingido. Transacoes encerradas.");
                break; // Encerra o loop
            } else {
                // TODO: Atualizar o limite diário e imprimir a saída no formato dos exemplos.
                limiteDiario -= valorSaque;
                System.out.println("Saque realizado. Limite restante: " + limiteDiario);
                System.out.println("Transacoes encerradas.");
                break;
            }
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}