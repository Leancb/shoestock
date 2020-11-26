# new feature
# language: pt

Funcionalidade:
  Eu, enquanto concorrente a uma vaga de autommação
  Preciso validar mercadorias na tela de compras
  Para garantir minha vaga

Esquema do Cenário: Realizar busca, por no carrinho e validar
  Dado              configurei ambiente para acessar URL Chrome
  E                 abri tela Shoestock
  E                 realizei busca por<busca1>
  E                 adicionei sapato a cesta
  E                 escolher mais produtos
  Quando            realizei busca por<busca2>
  E                 adicionei tennis a cesta
  Entao             valido itens
  Exemplos:
  | busca1  | busca2 |
  | sapatos | tennis |
