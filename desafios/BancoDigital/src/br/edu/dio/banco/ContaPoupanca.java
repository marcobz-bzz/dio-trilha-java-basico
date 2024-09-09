package br.edu.dio.banco;

class ContaPoupanca extends ContaAbstract {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String toString() {
        return "Conta Poupança " + Util.idContaFormatador(getIdConta()) +
                " :: saldo: " + Util.doubleToBRL(getSaldo());
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > getSaldo())
            return false;
        super.ajSaldo(valor);
        return true;
    }

}
