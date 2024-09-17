package dio.springbzz;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {
    public int somar(int x, int y) {
        return x + y;
    }
}
