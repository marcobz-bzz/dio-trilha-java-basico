package dio.springbzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApp implements CommandLineRunner {

    @Autowired
    Calculadora calc;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>> inicializada minha App");
        System.out.println("calculando 2+3 = "+calc.somar(2,3));
    }

}
