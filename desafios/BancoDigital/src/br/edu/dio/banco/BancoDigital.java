package br.edu.dio.banco;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BancoDigital {

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

    public void cadastrarCliente(String cpf, String nome, String novaSenha) {
        if (!Util.verificarCpfNomeReceitaFederal(cpf, nome)) {
            System.out.println("CPF ou NOME inválidos!!");
            return;
        }
        clientesMap.put(cpf, new Cliente(nome, cpf, novaSenha));
        System.out.println(">> Cliente cadastrado com sucesso!!");
        System.out.println(clientesMap.get(cpf));
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

    // Operação de contas
    public boolean depositar(String cpf, int idNumeroDaConta, double valor) {
        if (contasSet.isEmpty()) {
            System.out.println(">> Conta nº " + idNumeroDaConta + " inválida!!");
            return false;
        }

        if (!Util.verificarCpfValidoReceitaFederal(cpf)) {
            System.out.println(">> CPF " + cpf + " inválido!!");
            return false;
        }

        try {
            contasSet.stream()
                    .filter(cc -> cc.getIdConta() == idNumeroDaConta)
                    .findFirst().get().depositar(valor);
            // System.out.println(">> Depósito realizado com sucesso!!");
            return true;
        } catch (Exception e) {
            System.out.println(">> Erro ao processar o depósito, verifique os dados!!");
            return false;
        }
    }

    public boolean sacar(String cpf, String senha, int idNumeroDaConta, double valor) {
        if (!autenticarCliente(cpf, senha)) {
            System.out.println(">> Usuãrio não autenticado!!");
            return false;
        }
        if (contasSet.isEmpty()) {
            System.out.println(">> Conta " + idNumeroDaConta + " inexistente!!");
            return false;
        }

        try {
            ContaAbstract conta = contasSet.stream()
                    .filter(cc -> cc.getIdConta() == idNumeroDaConta)
                    .findFirst().get();

            if (conta == null) {
                System.out.println(">> Conta " + idNumeroDaConta + " não encontrada!!");
                return false;
            }
            if (!conta.getClienteCpf().equalsIgnoreCase(cpf)) {
                System.out.println("Conta " + Util.idContaFormatador(idNumeroDaConta) +
                        " inválida para o cpf " + cpf + " informado!!");
                return false;
            }
            if (conta.sacar(valor)) {
                // System.out.println(">> Saque realizado com sucesso!!");
                return true;
            } else {
                System.out.println(">> saque não realizado, consulte o saldo!!");
                return false;
            }
        } catch (Exception e) {
            System.out.println(">> Erro ao processar o depósito, verifique os dados!!");
            return false;
        }
    }

    public void transferir(String cpf, String senha, int idContaOrigem,
            int idContaDestino, double valor) {
        if (sacar(cpf, senha, idContaOrigem, valor)) {
            if (depositar(cpf, idContaDestino, valor)) {
                System.out.println(">> Transferência realizada com sucesso!!");
            } else {
                depositar(cpf, idContaOrigem, valor);
                System.out.println(">> Falha na operação de transferência!!");
                System.out.println(">>> OPERAÇÃO CANCELADA <<<");
            }
        }
    }

    // Relatórios
    public void printSaldoConta(String cpf, String senha, int idNumeroDaConta) {
        if (!autenticarCliente(cpf, senha)) {
            System.out.println(">> Usuãrio não autenticado!!");
            return;
        }
        if (contasSet.isEmpty()) {
            System.out.println(">> Conta " + idNumeroDaConta + " inexistente!!");
            return;
        }
        try {
            ContaAbstract conta = contasSet.stream()
                    .filter(cc -> cc.getIdConta() == idNumeroDaConta)
                    .findFirst().get();
            if (conta == null) {
                System.out.println(">> Conta " + idNumeroDaConta + " não encontrada!!");
                return;
            }
            if (conta.getClienteCpf().equalsIgnoreCase(cpf)) {
                System.out.println(conta);
            } else {
                System.out.println(">> Cliente cpf " + cpf + " não possui conta " +
                        Util.idContaFormatador(idNumeroDaConta) + "!!");
            }
        } catch (Exception e) {
            System.out.println(">> Conta " + Util.idContaFormatador(idNumeroDaConta) +
                    " não localizada!!");
        }
    }

    public void gerarExtratoCliente(String cpf, String senha) {
        if (!autenticarCliente(cpf, senha)) {
            System.out.println(">> Usuãrio não autenticado!!");
            return;
        }

        System.out.println("=================================================================================");
        System.out.println("                    " + this);
        System.out.println("                               E X T R A T O");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Cliente: " + clientesMap.get(cpf));
        System.out.println("---------------------------------------------------------------------------------");
        contasSet.stream().filter(cc -> ContaCorrente.class.isInstance(cc))
                .filter(cc -> cc.getClienteCpf() == cpf)
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------");
        contasSet.stream().filter(cc -> ContaPoupanca.class.isInstance(cc))
                .filter(cc -> cc.getClienteCpf() == cpf)
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------");
        double saldo = contasSet.stream().filter(cc -> cc.getClienteCpf() == cpf)
                .mapToDouble(cc -> cc.getSaldo()).sum();
        System.out.println("Saldo: " + Util.doubleToBRL(saldo));
        System.out.println("=================================================================================");
    }

    @Override
    public String toString() {
        return "=== " + nomeBanco.toUpperCase() +
                " (" + String.format("%03d", numeroBanco) + ") ag.: " +
                String.format("%04d", agenciaBanco) + " ===";
    }

    private boolean autenticarCliente(String cpf, String senha) {
        if (clientesMap.isEmpty())
            return false;
        if (!clientesMap.containsKey(cpf))
            return false;

        return clientesMap.get(cpf).verificaSenha(senha);
    }

}
