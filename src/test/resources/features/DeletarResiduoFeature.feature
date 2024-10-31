# language: pt

# DeletarResiduo.feature

Funcionalidade: Exclusão de Resíduo

  Cenário: Exclusão de um tipo de resíduo existente pelo ID
    Dado que existe um tipo de resíduo com id 55 e descrição "Resíduo"
    Quando o usuário solicita a exclusão do tipo de resíduo com id 55
    Então o sistema retorna o status de exclusão 204

