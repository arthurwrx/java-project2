# language: pt


Funcionalidade: Consultar tipo de residuo

  Como um usuário do sistema
  Eu quero consultar um tipo de residuo.
  Para que eu possa gerenciar as informações sobre resíduos

  Cenário: Consulta de um tipo de resíduo existente pelo ID
    Dado que existe um tipo de resíduo com id 3 e descrição "Perigosos"
    Quando o usuário consulta o tipo de resíduo pelo id 3
    Então o sistema retorna o tipo de resíduo com id 3 e descrição "Perigosos"
