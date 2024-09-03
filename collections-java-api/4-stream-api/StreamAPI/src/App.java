import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Stream!");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        List<Integer> nn = new ArrayList<>(numeros);

        System.out.println(nn);

        // Desafio 1 - Mostre a lista na ordem numérica crescente.
        System.out.println(">> 1. Ordem numérica crescente:");
        nn.stream().sorted().forEach(System.out::println);

        // Desafio 2 - Imprima a soma dos números pares da lista
        System.out.println(">> 2. Soma da lista:");
        System.out.println(nn.stream().reduce(0, (a, b) -> a + b));

        // Desafio 3 - Verifique se todos os números da lista são positivos
        System.out.println(">> 3. Verifique se todos os números da lista são positivos");
        System.out.println(nn);
        int negativos = nn.stream().filter(n -> n < 0).toArray().length;
        System.out.println(negativos > 0 ? "existem " + negativos +
                " números negativos" : "todos os números são positivos");
        List<Integer> n1 = Arrays.asList(0, 9, -2, -4, 10);
        System.out.println(n1);
        negativos = n1.stream().filter(n -> n < 0).toArray().length;
        System.out.println(negativos > 0 ? "existem " + negativos +
                " números negativos" : "todos os números são positivos");

        // Desafio 4 - Remova todos os valores ímpares
        System.out.println(">> 4. Remova todos os valores ímpares");
        System.out.println(nn);
        nn.removeIf(n -> (n % 2) != 0);
        System.out.println(nn);
        nn = new ArrayList<>(numeros);

        // Desafio 5 - Calcule a média dos números maiores que 5
        System.out.println(">> 5. Calcule a média dos números maiores que 5");
        System.out.println(nn);
        long totNum = nn.stream().filter(n -> n > 5).count();
        if (totNum > 0) {
            long totSum = nn.stream().filter(n -> n > 5).reduce(0, (a, b) -> a + b);
            System.out.println("média (>5) = " + totSum / totNum);
        } else {
            System.out.println("não existem números maiores que 5");
        }

        // Desafio 6 - Verificar se a lista contém algum número maior que 10
        System.out.println(">> 6. Verificar se a lista contém algum número maior que 10");
        n1 = Arrays.asList(0, 9, 12, 14, 10);
        n1.stream().filter(n -> n > 10).forEach(System.out::println);

        // Desafio 7 - Encontrar o segundo número maior da lista
        System.out.println(">> 7. Encontrar o segundo número maior da lista");
        n1 = Arrays.asList(0, 9, 12, 12, 14, 10, 14);
        System.out.println(n1);
        Object[] n11 = n1.stream().sorted().distinct().toArray();
        System.out.println(n11.length >= 2 ? n11[n11.length - 2] : n11[0]);

        // Desafio 8 - Somar os dígitos de todos os números da lista
        System.out.println(">> 8. Somar os dígitos de todos os números da lista");
        n1 = Arrays.asList(0, 9, -12, 12, -14, 10, 14, 222);
        System.out.println(n1);
        int total = n1.stream().map(n -> Integer.toString(Math.abs(n)))
                .collect(Collectors.toList()).stream()
                .map(n -> n.codePoints().map(c -> c - 48)
                        .reduce(0, (a, b) -> a + b))
                .collect(Collectors.toList())
                .stream().reduce(0, (x, y) -> x + y);
        System.out.println(total);

        int total2 = n1.stream().map(n -> Math.abs(n))
                .map(n -> Integer.toString(n))
                .map(n -> n.chars()
                        .map(x -> x - '0')
                        .reduce(0, (x, y) -> x + y))
                .reduce(0, (x, y) -> x + y);
        System.out.println(total2);

        // Desafio 9 - Verificar se todos os números da lista são distintos
        System.out.println(">> 9. Verificar se todos os números da lista são distintos");
        System.out.println(n1);
        if (n1.size() == n1.stream().sorted()
                .distinct().count()) {
            System.out.println(">> são distintos <<");
        } else {
            System.out.println(">> NÃO são distintos <<");
        }

        n1 = Arrays.asList(0, 9, -12, -12, 14, 10, 14, 222);
        System.out.println(n1);
        if (n1.size() == n1.stream().sorted()
                .distinct().count()) {
            System.out.println(">> são distintos <<");
        } else {
            System.out.println(">> NÃO são distintos <<");
        }

        // Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5
        System.out.println(">> 10. Agrupe os valores ímpares múltiplos de 3 ou de 5");
        System.out.println(nn);
        List<Integer> dd = nn.stream().filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .collect(Collectors.toList());
        // .forEach(System.out::println);
        System.out.println(dd);

        // Desafio 11 - Encontre a soma dos quadrados de todos os números da lista
        System.out.println(">> 11. Encontre a soma dos quadrados de todos os números da lista");
        n1 = Arrays.asList(0, 1, 2, 3);
        System.out.println(n1);
        System.out.println(n1.stream().reduce(0, (a, b) -> a + b * b).intValue());

        // Desafio 12 - Encontre o produto de todos os números da lista
        System.out.println(">> 12. Encontre o produto de todos os números da lista");
        n1 = Arrays.asList(-1, 10, 2, 3);
        System.out.println(n1);
        System.out.println(n1.stream().reduce(1, (x, y) -> x * y));

        // Desafio 13 - Filtrar os números que estão dentro de um intervalo
        // Utilize a Stream API para filtrar os números que estão dentro
        // de um intervalo específico (por exemplo, entre 5 e 10)
        // e exiba o resultado no console.
        System.out.println(">> 13. Números que estão dentro de um intervalo [5,10]");
        System.out.println(nn);
        System.out.println(nn.stream().filter(n -> (n >= 5) && (n <= 10))
                .collect(Collectors.toList()));

        // Desafio 14 - Encontre o maior número primo da lista
        System.out.println(">> 14. Encontre o maior número primo da lista");
        System.out.println(nn);
        System.out.println(nn.stream().filter(new Predicate<Integer>() {

            @Override
            public boolean test(Integer num) {
                if (num <= 1)
                    return false;
                if (num == 2 || num == 3)
                    return true;
                if (num % 2 == 0 || num % 3 == 0)
                    return false;

                // Verifica a divisibilidade até a raiz quadrada do número
                for (int i = 5; i * i <= num; i += 6) {
                    if (num % i == 0 || num % (i + 2) == 0)
                        return false;
                }
                return true;
            }

        }).max(Comparator.naturalOrder()).get());
        // metodo 2
        Predicate<Integer> findPrimo = new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                if (num <= 1)
                    return false;
                if (num == 2 || num == 3)
                    return true;
                if (num % 2 == 0 || num % 3 == 0)
                    return false;

                // Verifica a divisibilidade até a raiz quadrada do número
                for (int i = 5; i * i <= num; i += 6) {
                    if (num % i == 0 || num % (i + 2) == 0)
                        return false;
                }
                return true;
            }
        };

        System.out.println("## metodo2 - primos");
        System.out.println(nn.stream()
                .filter(findPrimo::test)
                .max(Comparator.naturalOrder()).get());

        // Desafio 15 - Verifique se a lista contém pelo menos um número negativo
        System.out.println(">> 15. Verifique se a lista contém pelo menos um número negativo");
        System.out.println(n1);
        System.out.println(
                n1.stream()
                        .filter(n -> n < 0)
                        .count() > 0 ? ">> tem número negativo <<" : ">> NÃO tem negativo <<");

        // Desafio 16 - Agrupe os números em pares e ímpares
        System.out.println(">> 16. Agrupe os números em pares e ímpares");
        System.out.println(nn);
        List<Integer> pares = nn.stream()
                .filter(n -> (n % 2) == 0)
                .collect(Collectors.toList());
        List<Integer> impares = nn.stream()
                .filter(n -> (n % 2) != 0)
                .collect(Collectors.toList());
        System.out.println("pares: " + pares + "\nimpares: " + impares);

        // segundo método 2
        System.out.println("## método 2");
        Map<Boolean, List<Integer>> paresEimpares = nn.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        pares = paresEimpares.get(true);
        impares = paresEimpares.get(false);
        System.out.println("pares: " + pares + "\nimpares: " + impares);

        // Desafio 17 - Filtrar os números primos da lista
        System.out.println(">> 17. Filtrar os números primos da lista");
        System.out.println(nn);
        nn.stream().filter(new Predicate<Integer>() {

            @Override
            public boolean test(Integer num) {
                if (num <= 1)
                    return false;
                if (num == 2 || num == 3)
                    return true;
                if (num % 2 == 0 || num % 3 == 0)
                    return false;

                // Verifica a divisibilidade até a raiz quadrada do número
                for (int i = 5; i * i <= num; i += 6) {
                    if (num % i == 0 || num % (i + 2) == 0)
                        return false;
                }
                return true;
            }

        }).forEach(System.out::println);

        // Desafio 18 - Verifique se todos os números da lista são iguais
        System.out.println(">> 18. Verifique se todos os números da lista são iguais");
        System.out.println(nn);
        System.out.println(nn.stream()
                .sorted()
                .distinct()
                .count() == 1 ? "iguais" : "diferentes");
        n1 = Arrays.asList(12, 12, 12, 12, 12);
        System.out.println(n1);
        System.out.println(n1.stream()
                .sorted()
                .distinct()
                .count() == 1 ? "iguais" : "diferentes");

        // Desafio 19 - Encontre a soma dos números divisíveis por 3 ou 5
        System.out.println(">> 19.  Encontre a soma dos números divisíveis por 3 ou 5");
        System.out.println(nn);
        System.out.println(nn.stream()
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .reduce(0, (x, y) -> x + y));
        // outro método
        System.out.println("## método 2");
        System.out.println(nn.stream()
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .mapToInt(Integer::intValue).sum());
    }

}
