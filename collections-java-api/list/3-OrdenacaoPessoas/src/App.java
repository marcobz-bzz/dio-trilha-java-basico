import br.edu.dio.pessoas.OrdenacaoPessoas;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Pessoa Ordenada!");

        OrdenacaoPessoas op = new OrdenacaoPessoas();

        op.adicionarPessoa("nome1", 20, 1.56);
        op.adicionarPessoa("nome2", 30, 1.80);
        op.adicionarPessoa("nome3", 25, 1.70);
        op.adicionarPessoa("nome4", 17, 1.56);

        System.out.println(op);
        System.out.println("------------------------------");
        System.out.println(op.ordenarPorIdade());
        System.out.println("------------------------------");
        System.out.println(op.ordenarPorAltura());
    }
}
