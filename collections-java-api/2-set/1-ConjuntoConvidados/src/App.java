import br.edu.dio.set.ConjuntoConvidados;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Convidados!");

        ConjuntoConvidados cConj = new ConjuntoConvidados();
        System.out.println("quantidade = " + cConj.contarConvidados());
        System.out.println("=======================");

        cConj.adicionarConvidado("marco", 22);
        System.out.println("quantidade = " + cConj.contarConvidados());

        cConj.adicionarConvidado("marco", 22);
        System.out.println("quantidade = " + cConj.contarConvidados());

        cConj.adicionarConvidado("cacá", 19);
        System.out.println("quantidade = " + cConj.contarConvidados());

        cConj.adicionarConvidado("renato", 27);
        System.out.println("quantidade = " + cConj.contarConvidados());

        cConj.exibirConvidados();
        System.out.println("=======================");

        cConj.removerConvidadoPorCodigoConvite(22);

        cConj.exibirConvidados();
    }
}
