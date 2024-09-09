package br.edu.dio.banco;

class ContaCorrente extends ContaAbstract {
    private static final double LIMITE_PADRAO = 10000;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public double getLimite() {
        if (getSaldo() < 0)
            return LIMITE_PADRAO + getSaldo();
        return LIMITE_PADRAO;
    }

    @Override
    public String toString() {
        return "Conta Corrente " + Util.idContaFormatador(getIdConta()) +
                " :: saldo: " + Util.doubleToBRL(getSaldo()) +
                " :: limite: " + Util.doubleToBRL(getLimite()) +
                " :: disponível: " + Util.doubleToBRL(getLimite());
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > getSaldo() + LIMITE_PADRAO)
            return false;
        super.ajSaldo(valor);
        return true;
    }

}
