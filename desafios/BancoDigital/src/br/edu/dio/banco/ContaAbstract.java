package br.edu.dio.banco;

abstract class ContaAbstract {
    private static int controleId = 1;

    private Cliente cliente;
    private int idConta;
    private double saldo;

    public ContaAbstract(Cliente cliente) {
        this.cliente = cliente;
        this.idConta = getIdNovaConta();
    }

    public String getClienteCpf() {
        return cliente.getCpf();
    }

    public int getIdConta() {
        return idConta;
    }

    public double getSaldo(){
        return saldo;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public abstract String toString();

    // ----estáticos, da classe------
    private static int getIdNovaConta() {
        return controleId++;
    }
}
