package br.edu.dio.banco;

class Cliente {
    private static int controleId = 1;

    private String nomeCliente;
    private String cpf;
    private String senha;
    private int idCliente;

    public Cliente(String nome, String cpf, String senha) {
        this.nomeCliente = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.idCliente = getIdNovoCliente();
    }

    public boolean verificaSenha(String senha) {
        return this.senha.equals(senha);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdCliente() {
        return idCliente;
    }

    private static int getIdNovoCliente() {
        return controleId++;
    }

    @Override
    public String toString() {
        return "[" + idCliente + "-" + nomeCliente + ", cpf " + cpf + "]";
    }

}
