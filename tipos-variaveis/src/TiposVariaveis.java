import java.util.Locale;
import java.util.Scanner;

public class TiposVariaveis {
    public static void main(String[] args) throws Exception {

        System.out.println("argum = " + args.length);

        for (int ii = 0; ii < args.length; ii++) {
            System.out.println("argumento [" + ii + "] = " + args[ii]);
        }

        // Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        // System.out.println(">>> Digite seu nome:");
        // String nome = scanner.next();
        // System.out.println("nome = " + nome);

        // switch (nome) {
        // case "joão":
        // System.out.println("nok");
        // break;
        // case "marco":
        // System.out.println("okkkk");
        // break;
        // default:
        // break;
        // }

        // System.out.println(">>> Peso (kg):");
        // double peso = scanner.nextDouble();
        // System.out.println("Peso = " + peso + "Kg");

        // System.out.println(">>> Altura (m):");
        // double altura = scanner.nextDouble();
        // System.out.println("Altura = " + altura + "m");

        // System.out.println("IMC = " + (peso / Math.pow(altura, 2)));
        // scanner.close();

        // for (int ii = 0; ii < 100; ii++) {
        // System.out.println("Carolina " + ii);
        // }
        for (BzzNum bb : BzzNum.values()) {
            System.out.println("Bezerra = " + bb.getNome() + "--" + bb.getAbreviatura());
        }

    }

    public enum BzzNum {
        MARCO("Marco", 'M'),
        ANTONIO("Antonio", 'A'),
        DIAS("Dias", 'D'),
        BEZERRA("Bezerra", 'B');

        private String nome;
        private char abreviatura;

        private BzzNum(String nome, char abreviatura) {
            this.nome = nome;
            this.abreviatura = abreviatura;
        }

        public String getNome() {
            return nome;
        }

        public char getAbreviatura() {
            return abreviatura;
        }
    }
}