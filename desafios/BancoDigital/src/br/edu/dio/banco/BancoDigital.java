package br.edu.dio.banco;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BancoDigital {
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

    private String nomeBanco;
    private int numeroBanco;
    private int agenciaBanco;
    private Map<String, Cliente> clientesMap;
    private Set<ContaAbstract> contasSet;

    public BancoDigital(String nomeBanco, int numeroBanco, int agenciaBanco) {
        this.nomeBanco = nomeBanco;
        this.numeroBanco = numeroBanco;
        this.agenciaBanco = agenciaBanco;
        clientesMap = new HashMap<>();
        contasSet = new HashSet<>();
    }

    public String getNomeBanco() {
        return nomeBanco.toUpperCase();
    }

    public String getNumeroBanco() {
        return String.format("%03d", numeroBanco);
    }

    public String getAgenciaBanco() {
        return String.format("%04d", agenciaBanco);
    }

    public boolean cadastrarCliente(String cpf, String nome, String novaSenha) {
        if (!verificarCpfNomeReceitaFederal(cpf, nome)) {
            System.out.println("CPF ou NOME inválidos!!");
            return false;
        }
        clientesMap.put(cpf, new Cliente(nome, cpf, novaSenha));
        System.out.println(">> Cliente cadastrado com sucesso!!");
        System.out.println(clientesMap.get(cpf));
        return true;
    }

    public int criarContaCorrente(String cpf, String senha, Operacao tipoDeOperacao) {
        if (!autenticarCliente(cpf, senha))
            return 0;
        ContaAbstract conta = null;
        switch (tipoDeOperacao) {
            case CONTA_CORRENTE:
                conta = new ContaCorrente(clientesMap.get(cpf));
                break;

            case POUPANCA:
                conta = new ContaPoupanca(clientesMap.get(cpf));
                break;

            default:
                break;
        }
        contasSet.add(conta);
        return conta.getIdConta();
    }

    // TODO
    public boolean depositar(String cpf, int idNumeroDaConta, double valor) {
        if (contasSet.isEmpty())
            return false;
        if (!CPF_RECEITA_FEDERAL_MAP.containsKey(cpf))
            return false;

        contasSet.stream().filter(cc -> cc.getIdConta() == idNumeroDaConta)
                .findFirst().get().depositar(valor);
        return true;
    }

    public void printSaldoConta(String cpf, String senha, int idNumeroDaConta) {
        if (!autenticarCliente(cpf, senha)) {
            System.out.println(">> Usuãrio não autenticado!!");
            return;
        }
        if (contasSet.isEmpty()) {
            System.out.println(">> Conta inexistente!!");
            return;
        }
        try {
            ContaAbstract conta = contasSet.stream().filter(cc -> cc.getIdConta() == idNumeroDaConta)
                    .findFirst().get();
            if (conta == null)
                System.out.println(">> Conta não encontrada!!");
            if (conta.getClienteCpf().equalsIgnoreCase(cpf)) {
                System.out.println(conta);
            } else {
                System.out.println(">> Clinete não possui conta " +
                        Util.idContaFormatador(idNumeroDaConta) + "!!");
            }
        } catch (Exception e) {
            System.out.println(">> Conta " + Util.idContaFormatador(idNumeroDaConta) +
                    " não localizada!!");
        }
    }

    @Override
    public String toString() {
        return "=== " + getNomeBanco() +
                " (" + getNumeroBanco() + ") ag.: " +
                getAgenciaBanco() + " ===";
    }

    private boolean autenticarCliente(String cpf, String senha) {
        if (clientesMap.isEmpty())
            return false;
        if (!clientesMap.containsKey(cpf))
            return false;

        return clientesMap.get(cpf).verificaSenha(senha);
    }

    private static boolean verificarCpfNomeReceitaFederal(String cpf, String nome) {
        if (CPF_RECEITA_FEDERAL_MAP.get(cpf) == null)
            return false;
        return CPF_RECEITA_FEDERAL_MAP.get(cpf).equalsIgnoreCase(nome);
    }
}
