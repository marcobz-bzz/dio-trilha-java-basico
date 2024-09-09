package br.edu.dio.banco;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public abstract class Util {

    private static final Map<String, String> CPF_RECEITA_FEDERAL_MAP = Map.ofEntries(
            Map.entry("182.198.228-21", "Marcelo"),
            Map.entry("310.818.628-07", "Regina"),
            Map.entry("052.215.559-64", "Eliana"),
            Map.entry("111.427.608-12", "Adilaudo"),
            Map.entry("156.810.758-77", "Fernanda"),
            Map.entry("330.659.798-88", "Michele"),
            Map.entry("334.418.778-37", "Silvia"),
            Map.entry("354.459.008-51", "Paula"),
            Map.entry("252.218.168-81", "Sandra"),
            Map.entry("321.754.178-24", "Edilene"),
            Map.entry("044.502.329-50", "Marcia"),
            Map.entry("260.504.318-50", "Viviviane"),
            Map.entry("335.545.078-22", "Joice"),
            Map.entry("357.376.918-70", "Wilson"),
            Map.entry("229.752.858-25", "Celso"),
            Map.entry("291.303.858-14", "Luciana"),
            Map.entry("132.545.738-89", "Andre"),
            Map.entry("087.606.338-59", "Carlos"),
            Map.entry("292.711.238-08", "Alessandra"),
            Map.entry("458.403.748-57", "Naiara"),
            Map.entry("122.565.638-98", "Sandra"),
            Map.entry("088.709.048-65", "Catia"),
            Map.entry("161.800.968-05", "Glaucia"),
            Map.entry("414.762.258-50", "Cassia"),
            Map.entry("160.983.068-77", "Regina"),
            Map.entry("365.187.758-23", "Tatiane"),
            Map.entry("272.729.458-18", "Glaucia"),
            Map.entry("097.517.866-06", "Leandro"),
            Map.entry("329.665.448-80", "Matheus"));

    public static boolean verificarCpfNomeReceitaFederal(String cpf, String nome) {
        if (CPF_RECEITA_FEDERAL_MAP.get(cpf) == null)
            return false;
        return CPF_RECEITA_FEDERAL_MAP.get(cpf).equalsIgnoreCase(nome);
    }

    public static boolean verificarCpfValidoReceitaFederal(String cpf){
        return CPF_RECEITA_FEDERAL_MAP.containsKey(cpf);
    }

    public static String doubleToBRL(double valor) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
    }

    public static String idContaFormatador(int idConta) {
        return String.format("%04d", idConta);
    }
}
