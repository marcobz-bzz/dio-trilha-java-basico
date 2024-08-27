import br.edu.dio.set.CadastroProdutos;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Produtos!");

        CadastroProdutos cp = new CadastroProdutos();
        System.out.println("----------------------");
        System.out.println(cp.exibirProdutosPorNome());

        System.out.println(">>> insere produtos <<<");

        cp.adicionarProduto(1, "pipoca", 1.15, 18);
        cp.adicionarProduto(2, "batata", 5.15, 120);
        cp.adicionarProduto(2, "batata 22", 10.15, 18);
        cp.adicionarProduto(3, "bateria", 85.15, 10);
        cp.adicionarProduto(4, "pipoca", 8.15, 24);

        System.out.println("----------------------");
        System.out.println(">>> produtos por nome (forma 11) <<<");
        System.out.println(cp.exibirProdutosPorNome());
        System.out.println("----------------------");
        System.out.println(">>> produtos por nome (forma 22 - Comparator) <<<");
        System.out.println(cp.exibirProdutosPorNome22());

        System.out.println("----------------------");
        System.out.println(">>> produtos por preço <<<");
        System.out.println(cp.exibirProdutosPorPreco());

        System.out.println("----------------------");
        System.out.println(">>> EXIBE PRODUTOS <<<");
        System.out.println(cp.exibirProdutos());

    }
}
