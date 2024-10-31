# language: pt


Funcionalidade: Consultar tipo de residuo

  Como um usuário do sistema
  Eu quero consultar um tipo de residuo.
  Para que eu possa gerenciar as informações sobre resíduos

  Cenário: Consulta de um tipo de resíduo existente pelo ID
    Dado que existe um tipo de resíduo com id 4 e descrição "Organicos"
    Quando o usuário consulta o tipo de resíduo pelo id 4
    Então o sistema retorna o tipo de resíduo com id 4 e descrição "Organicos"
