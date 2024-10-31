# language: pt


Funcionalidade: Criar novo residuo

  Como um usuário do sistema
  Eu quero criar tipos de resíduos
  Para que eu possa gerenciar as informações sobre resíduos


  Cenário: Criação de um novo tipo de resíduo
    Quando o usuário envia os dados do tipo de resíduo com id 2 e descrição "Resíduo Reciclável"
    Então o sistema cria o tipo de resíduo e retorna o status 201

