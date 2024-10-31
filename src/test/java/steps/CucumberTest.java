package steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",          // Caminho das features
    glue = "steps",                                     // Pacote dos steps
    plugin = {
        "pretty",                                      // Exibe o resultado detalhado no terminal
        "html:target/cucumber-reports.html",           // Gera relatório HTML
        "json:target/cucumber-reports/cucumber.json"   // Gera relatório JSON
    },
    monochrome = true                                  // Saída do console mais legível
)
public class CucumberTest {
}
