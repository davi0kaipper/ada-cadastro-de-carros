# Cadastro de Carros

## Resumo da Aplicação

A aplicação "Cadastro de Carros" permite ao usuário criar seu cadastro próprio de carros.

Foi disponibilizado um conjunto extenso de opções de marcas e modelos de carros através da tabela FIPE para auxiliar as operações.

Disponibilizamos o acesso à aplicação através de API REST e um frontend integrado ao projeto. Na página inicial do frontend, é possível listar os carros cadastrados e cadastrar novos.

O sistema conta com uma plataforma externa (Frontend) que permite ao usuário cadastrar, consultar, alterar e excluir seus carros.

## Parâmetros

O sistema conta com seis parâmetros para cadastro de carros:

- Marca;
- Modelo;
- Cor;
- Tipo de transmissão;
- Ano de Fabricação;
- Preço.

A aplicação expõe suas funcionalidades através de endpoints REST.

## Tecnologias utilizadas

- Java;
- Quarkus;
- Maven;
- HTML;
- CSS;
- Angular;
- JavaScript;
- Swagger;
- H2.

## Instalação e execução

Para rodar o projeto é necessário ter o Node.js e o Maven instalados na máquina.

Backend - vá na raiz do projeto e rode os comandos:
- mvn install (para instalar as dependências do backend)
- mvn quarkus:dev (para rodar o backend)

Frontend - vá na pasta front e rode o comando:
- npm install (para instalar as dependências do frontend)
- ⁠npm run start (para rodar o frontend)

## Como utilizar a aplicação

Recomendamos utilizar o Frontend integrado ao projeto. Em sua página inicial, é possível acessar os carros cadastrados e a funcionalidade de novos cadastramentos.

- Selecionado "Confira nossos Carros", será exibida a lista de carros próprios cadastrados, com as opções de alteração e exclusão.
- Clicando em "Acesso ao Cadastro", o usuário será direcionado para a funcionalidade de cadastramento de novos carros. Os campos "Marca", "Modelo" e "Tipo de transmissão" já possuem as opções predefinidas.

Obs: O acesso à API REST pode ser feito com o cliente da sua preferência, como cURL, Postman, Insomnia, Apidog etc. Nenhuma autenticação é necessária. Os parâmetros estão listados em ordem em **Parâmetros**.

## Considerações Finais

Agradecemos ao professor Rodolfo da Ada Tech pelos conhecimentos transmitidos no curso de Quarkus, do qual esse é o nosso projeto final.

Davi Gonçalves Kaipper
André Tavares De Oliveira
Ivan De Bastos Sousa
Matheus Benedito Mendes