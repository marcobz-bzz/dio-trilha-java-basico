package br.edu.dio;

import java.util.List;

public class BancoDigital {
    private String nomeBanco;
    private int numeroBanco;
    private int agenciaBanco;
    private List<ContaAbstract> contaList;

    public BancoDigital(String nomeBanco, int numeroBanco, int agenciaBanco) {
        this.nomeBanco = nomeBanco;
        this.numeroBanco = numeroBanco;
        this.agenciaBanco = agenciaBanco;
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

    @Override
    public String toString() {
        return "=== " + getNomeBanco() +
                " (" + getNumeroBanco() + ") ag.: " +
                getAgenciaBanco() + " ===";
    }

}
