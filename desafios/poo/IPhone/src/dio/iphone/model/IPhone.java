package dio.iphone.model;

public class IPhone implements ReprodutorMusical {

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
        System.out.println(">>> Reprodutor Musical :: selecionada música -- [" + musica + "]");
    }

}
