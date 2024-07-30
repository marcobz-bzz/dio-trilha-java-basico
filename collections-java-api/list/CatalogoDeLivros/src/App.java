import br.edu.dio.livros.CatalogoLivros;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Livros!");

        CatalogoLivros catL = new CatalogoLivros();

        catL.adicionarLivro("t1", "a1", 2020);
        catL.adicionarLivro("t1", "a2", 2021);
        catL.adicionarLivro("t2", "a2", 2022);
        catL.adicionarLivro("t3", "a3", 2023);
        catL.adicionarLivro("t4", "a4", 1994);

        System.out.println(catL.pesquisarPorAutor("marco"));
        System.out.println(catL.pesquisarPorAutor("a2"));
        System.out.println(catL.pesquisarPorIntervaloAnos(2020,2022));
        System.out.println(catL.pesquisarPorTitulo("t1"));
    }
}
