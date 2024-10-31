# language: pt
Funcionalidade: Gerenciamento de Tipo de Resíduo

  Como um usuário do sistema
  Eu quero consultar e criar tipos de resíduos
  Para que eu possa gerenciar as informações sobre resíduos

  Cenário: Consulta de um tipo de resíduo existente pelo ID
    Dado que existe um tipo de resíduo com id 2 e descrição "Resíduo Reciclável"
    Quando o usuário consulta o tipo de resíduo pelo id 2
    Então o sistema retorna o tipo de resíduo com id 2 e descrição "Resíduo Reciclável"

  Cenário: Consulta de um tipo de resíduo inexistente pelo ID
    Dado que não existe um tipo de resíduo com id 77
    Quando o usuário consulta o tipo de resíduo pelo id 77
    Então o sistema retorna uma mensagem de erro "Nenhum tipo de resíduo foi encontrado com o id: 1"

  Cenário: Criação de um novo tipo de resíduo
    Quando o usuário envia os dados do tipo de resíduo com id 2 e descrição "Resíduo Reciclável"
    Então o sistema cria o tipo de resíduo e retorna o status 201
