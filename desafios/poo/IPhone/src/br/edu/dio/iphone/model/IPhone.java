package br.edu.dio.iphone.model;

public class IPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

    @Override
    public void tocar() {
        System.out.println(">>> Reprodutor Musical TOCANDO");
    }

    @Override
    public void pausar() {
        System.out.println(">>> Reprodutor Musical PAUSADO");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println(">>> Reprodutor Musical :: SELECIONADA MÚSICA -- [" + musica + "]");
    }

    @Override
    public void ligar(String numero) {
        System.out.println(">>> Aparelho Telefônico :: LIGANDO para -- [" + numero + "]");
    }

    @Override
    public void atender() {
        System.out.println(">>> Aparelho Telefônico :: ATENDENDO");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println(">>> Aparelho Telefônico :: iniciando CORREIO DE VOZ");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println(">>> Navegador Internet :: EXIBINDO PÁGINA -- [" + url + "]");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println(">>> Navegador Internet :: ADICIONANDO ABA");
    }

    @Override
    public void atualizarPagina() {
        System.out.println(">>> Navegador Internet :: ATUALIZANDO PÁGINA");
    }
}
