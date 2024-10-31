Feature: Gerenciamento de Tipo de Resíduo

  Como um usuário do sistema
  Eu quero consultar e criar tipos de resíduos
  Para que eu possa gerenciar as informações sobre resíduos

  Scenario: Consulta de um tipo de resíduo existente pelo ID
    Given que existe um tipo de resíduo com id 2 e descrição "Resíduo Reciclável"
    When o usuário consulta o tipo de resíduo pelo id 2
    Then o sistema retorna o tipo de resíduo com id 2 e descrição "Resíduo Reciclável"

  Scenario: Consulta de um tipo de resíduo inexistente pelo ID
    Given que não existe um tipo de resíduo com id 99
    When o usuário consulta o tipo de resíduo pelo id 99
    Then o sistema retorna uma mensagem de erro "Nenhum tipo de resíduo foi encontrado com o id: 99"

  Scenario: Criação de um novo tipo de resíduo
    When o usuário envia os dados do tipo de resíduo com id 10 e descrição "Resíduo Reciclável"
    Then o sistema cria o tipo de resíduo e retorna o status 201
