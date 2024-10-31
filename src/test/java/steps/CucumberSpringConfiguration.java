package steps;

import org.springframework.boot.test.context.SpringBootTest;

import br.com.fiap.project.Main;
import io.cucumber.spring.CucumberContextConfiguration; // Substitua pelo nome da sua classe principal de aplicação

@CucumberContextConfiguration
@SpringBootTest(classes = {Main.class, TestConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberSpringConfiguration {
}

