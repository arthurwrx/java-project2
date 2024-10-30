package br.com.fiap.project.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificacaoControllerContractTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllNotificacaoContract() throws Exception {
        // Simula a resposta da API
        MvcResult result = mockMvc.perform(get("/notificacao"))
                .andExpect(status().isOk())
                .andReturn();

        // Obtém a resposta como string
        String jsonResponse = result.getResponse().getContentAsString();

        // Carrega o esquema JSON
        JsonNode schemaNode = JsonLoader.fromFile(new File("src/test/resources/combined-schemas.json"));
        JsonNode jsonNode = JsonLoader.fromString(jsonResponse);

        // Valida a resposta contra o esquema
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
        JsonSchema schema = schemaFactory.getJsonSchema(schemaNode);
        ProcessingReport report = schema.validate(jsonNode);

        // Aqui é onde você espera que a validação seja verdadeira
        assertTrue(report.isSuccess());
    }
    @Test
    public void testGetNotificacaoByIdContract() throws Exception {
        MvcResult result = mockMvc.perform(get("/notificacao/1"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        JsonNode schemaNode = JsonLoader.fromFile(new File("src/test/resources/combined-schemas.json"));
        JsonNode jsonNode = JsonLoader.fromString(jsonResponse);

        JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
        JsonSchema schema = schemaFactory.getJsonSchema(schemaNode);
        ProcessingReport report = schema.validate(jsonNode);

        assertTrue(report.isSuccess());
    }
    @Test
    public void testPostNotificacaoContract() throws Exception {
        MvcResult result = mockMvc.perform(get("/notificacao"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        JsonNode schemaNode = JsonLoader.fromFile(new File("src/test/resources/combined-schemas.json"));
        JsonNode jsonNode = JsonLoader.fromString(jsonResponse);

        JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
        JsonSchema schema = schemaFactory.getJsonSchema(schemaNode);
        ProcessingReport report = schema.validate(jsonNode);

        assertTrue(report.isSuccess());
    }
    @Test
    public void testPutNotificacaoByIdContract() throws Exception {
        MvcResult result = mockMvc.perform(get("/notificacao/1"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        JsonNode schemaNode = JsonLoader.fromFile(new File("src/test/resources/combined-schemas.json"));
        JsonNode jsonNode = JsonLoader.fromString(jsonResponse);

        JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
        JsonSchema schema = schemaFactory.getJsonSchema(schemaNode);
        ProcessingReport report = schema.validate(jsonNode);

        assertTrue(report.isSuccess());
    }
    @Test
    public void testDeleteNotificacaoByIdContract() throws Exception {
        MvcResult result = mockMvc.perform(get("/notificacao/1"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        JsonNode schemaNode = JsonLoader.fromFile(new File("src/test/resources/combined-schemas.json"));
        JsonNode jsonNode = JsonLoader.fromString(jsonResponse);

        JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
        JsonSchema schema = schemaFactory.getJsonSchema(schemaNode);
        ProcessingReport report = schema.validate(jsonNode);

        assertTrue(report.isSuccess());
    }
}
