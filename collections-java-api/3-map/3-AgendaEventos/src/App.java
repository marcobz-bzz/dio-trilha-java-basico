import java.time.LocalDate;

import br.edu.dio.map.AgendaEventos;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Agenda de Eventos!\n");

        System.out.println("... criando agenda ...");
        AgendaEventos ae = new AgendaEventos();
        ae.exibirAgenda();
        System.out.println("========================\n");
        System.out.println(">>> adicionando eventos <<<");
        ae.adicionarEvento(LocalDate.parse("2024-01-26"),
                "anivarsário bzz", "festa");
        ae.adicionarEvento(LocalDate.parse("2024-01-26"),
                "anivarsário bzz", "festa total");
        ae.adicionarEvento(LocalDate.parse("2024-02-26"),
                "carnaval", null);
        ae.adicionarEvento(LocalDate.parse("2025-02-26"),
                "carnaval 2025", "timbalada");
        ae.adicionarEvento(LocalDate.parse("2024-12-24"),
                "Natal 2024", "noite do peru");

        ae.exibirAgenda();

        System.out.println("========================\n");
        System.out.println("Próximo evento: " + ae.obterProximoEvento());

    }
}
