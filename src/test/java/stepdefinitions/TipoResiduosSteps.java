package stepdefinitions;

import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

public class TipoResiduosSteps {

    @Autowired
    private RestTemplate restTemplate;

    private ResponseEntity<?> response;

    @Given("que existe um tipo de resíduo com id {int} e descrição {string}")
    public void que_existe_um_tipo_de_resíduo_com_id_e_descrição(Integer id, String descricao) {
        // Código para garantir que o tipo de resíduo existe antes de cada teste
    }

    @When("o usuário consulta o tipo de resíduo pelo id {int}")
    public void o_usuário_consulta_o_tipo_de_resíduo_pelo_id(Integer id) {
        String url = "http://localhost:8080/tipo-residuos/" + id;
        response = restTemplate.getForEntity(url, TipoResiduos.class);
    }

    @Then("o sistema retorna o tipo de resíduo com id {int} e descrição {string}")
    public void o_sistema_retorna_o_tipo_de_resíduo_com_id_e_descrição(Integer id, String descricao) {
        assertEquals(200, response.getStatusCodeValue());
        TipoResiduos tipoResiduos = (TipoResiduos) response.getBody();
        assertNotNull(tipoResiduos);
        assertEquals(id, tipoResiduos.getId_tipo_residuos());
        assertEquals(descricao, tipoResiduos.getDescricao());
    }

    @When("o usuário envia os dados do tipo de resíduo com id {int} e descrição {string}")
    public void o_usuário_envia_os_dados_do_tipo_de_resíduo_com_id_e_descrição(Integer id, String descricao) {
        TipoResiduos tipoResiduos = new TipoResiduos();
        tipoResiduos.setId_tipo_residuos(id);
        tipoResiduos.setDescricao(descricao);
        String url = "http://localhost:8080/tipo-residuos";
        response = restTemplate.postForEntity(url, tipoResiduos, TipoResiduos.class);
    }

    @Then("o sistema cria o tipo de resíduo e retorna o status {int}")
    public void o_sistema_cria_o_tipo_de_resíduo_e_retorna_o_status(Integer statusCode) {
        assertEquals(statusCode.intValue(), response.getStatusCodeValue());
    }
}

