import br.edu.dio.carrinho.CarrinhoDeCompras;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Carrinho de Compras!");

        CarrinhoDeCompras cdc = new CarrinhoDeCompras();

        System.out.println("total = " + cdc.calcularValorTotal());
        cdc.adicionarItem("sabão", 2, 3);
        cdc.adicionarItem("sabão", 3, 10);
        cdc.adicionarItem("limão", 10, 4);
        cdc.exibirItens();
        System.out.println("total = " + cdc.calcularValorTotal());

        cdc.removerItem("SABÃO");
        cdc.exibirItens();
        System.out.println("total = " + cdc.calcularValorTotal());
    }
}
