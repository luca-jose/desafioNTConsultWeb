# Automação Web

Esse é um repositório que contém alguns testes automatizados de um sistema web. Os subtópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

- Java
  https://www.oracle.com/java/technologies/downloads/
-  JUnit
   https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.0
-  Selenium
   https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.4.0
-  Webdriver
   https://chromedriver.chromium.org/downloads
-  Maven

## Testes automatizados

- Teste para validar mensagem de Sucesso na criação de usuário.
- Teste para validar mensagem de delete.

## Notas Gerais

Nas classes Page, estou usando um Design Pattern chamado "PageObject" que mapeia cada elemento web de acordo com a pagina, e as chamando conforme a necessidade dos testes, dessa forma evitando duplicação de código.
