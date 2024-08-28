import br.edu.dio.map.EstoqueProdutos;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Produtos!");

        System.out.println(">>> cria estoque de produtos <<<");
        EstoqueProdutos ep = new EstoqueProdutos();
        ep.exibirProdutos();
        System.out.println("================================");

        System.out.println(">>> adiciona produtos <<<");
        ep.adicionarProduto(1, "arroz", 10, 5.5);
        ep.adicionarProduto(1, "feijão", 20, 15.5);
        ep.adicionarProduto(3, "mandioca", 2, 30.2);
        ep.adicionarProduto(11, "pão", 20, 7.5);
        ep.adicionarProduto(21, "cerveja", 18, 11.5);
        ep.exibirProdutos();
        System.out.println("================================");

        System.out.println(">>> calcula valor total estoque <<<");
        System.out.println(ep.calcularValorTotalEstoque());
        System.out.println("================================");

        System.out.println(">>> produto mais caro <<<");
        System.out.println(ep.obterProdutoMaisCaro());
        System.out.println("================================");

        System.out.println(">>> produto mais barato <<<");
        System.out.println(ep.obterProdutoMaisBarato());
        System.out.println("================================");

        System.out.println(">>> produto maior quantidade valor <<<");
        System.out.println(ep.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
        System.out.println("================================");
    }
}
