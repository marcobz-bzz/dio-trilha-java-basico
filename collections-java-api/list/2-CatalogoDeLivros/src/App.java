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

        System.out.println("pesquisando por autor [marco]: " + catL.pesquisarPorAutor("marco") +
                "\n=============================");
        System.out.println("pesquisando por autor [a2]: " + catL.pesquisarPorAutor("a2") +
                "\n=============================");
        System.out.println("pesquisando por intervalo anos [2020 - 2022]: " +
                catL.pesquisarPorIntervaloAnos(2020, 2022) +
                "\n=============================");
        System.out.println("pesquisando por título [t1]: " + catL.pesquisarPorTitulo("t1") +
                "\n=============================");

    }
}
