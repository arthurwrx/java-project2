Feature: Consulta de Tipo de Resíduo por ID
  Scenario: Consulta de um tipo de resíduo existente pelo ID
    Given que existe um tipo de resíduo com id "1" e descrição "Resíduo Orgânico"
    When o usuário consulta o tipo de resíduo pelo id "1"
    Then o sistema retorna o tipo de resíduo com id "1" e descrição "Resíduo Orgânico"

  Scenario: Consulta de um tipo de resíduo inexistente pelo ID
    Given que não existe um tipo de resíduo com id "99"
    When o usuário consulta o tipo de resíduo pelo id "99"
    Then o sistema retorna uma mensagem de erro "Nenhum tipo de residuo foi encontrado com o id: 99"
