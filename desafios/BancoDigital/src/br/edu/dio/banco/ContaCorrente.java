package br.edu.dio.banco;

class ContaCorrente extends ContaAbstract {
    private static final double LIMITE_PADRAO = 10000;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public double getLimite() {
        return getSaldo() > 0 ? LIMITE_PADRAO : LIMITE_PADRAO + getSaldo();
    }

    @Override
    public String toString() {
        return "Conta Corrente " + Util.idContaFormatador(getIdConta()) +
                " :: saldo: " + Util.doubleToBRL(getSaldo())+
                " :: limite: "+Util.doubleToBRL(getLimite());
    }

}
