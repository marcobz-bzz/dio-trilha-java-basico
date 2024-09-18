package dio.spring_data_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.spring_data_jpa.model.UserJpa;
import dio.spring_data_jpa.repository.UserRepository;

@Component
public class StartApp implements CommandLineRunner{

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        UserJpa ubzz = new UserJpa();
        ubzz.setName("Marco Bezerra");
        ubzz.setUsername("bzz");
        ubzz.setPassword("bzz123");

        System.out.println(">> salvando usuário <<<");
        repository.save(ubzz);

        System.out.println("-------------------------");
        System.out.println(">> pegando usuários do banco H2 <<");
        repository.findAll().stream().forEach(System.out::println);
        
    }

}
