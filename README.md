# Automação Web / API

Projeto de automação web utilizando Selenium Webdriver, Java e Cucumber. Automação de Api com Junit.


Para baixar o projeto: 

Em seu terminal execute o comando  git clone https://github.com/Leancb/shoestock.git 

Ainda no terminal, execute a seguinte operação:

mvn eclipse:eclipse No Eclipse/STS, importe o projeto com o Maven.

Para o teste de Automação Web rodar o Run em src/test/java/Teste_Web/Validar mercadorias.feature

Para o teste de Automação  de Api rodar o Run da classe java em src/test/java/Teste_ApiRest/testeApi.java




Validação Web, ao efetuar a compra de um sapato, seu o nome é guardado em uma variável, o mesmo ocorre para o tennis, 
 logo na tela de compras os nomes exibidos dos produtos são validados pelo comando java assertTrue.
 
Validação API:
- Ao rodar a classe exibirNome exibe na tela o nome contido no subnível list do retorno JSON.
- Ao rodar a classe VerificaStatusCode, esta validando com RestAssured se status code é 200. 