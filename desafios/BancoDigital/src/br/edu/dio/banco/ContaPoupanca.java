package br.edu.dio.banco;

class ContaPoupanca extends ContaAbstract{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String toString() {
        return "Conta Poupança " + Util.idContaFormatador(getIdConta()) +
                " :: saldo: " + Util.doubleToBRL(getSaldo());
    }
    
}
