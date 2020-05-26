# Instruções
Desafio zetta

Criação de uma API Rest utilizando Java no backend.

Desafio proposto pela Zetta (Agência UFLA de Inovação, Geotecnologia e Sistemas Inteligentes).

Tecnologias utilizadas no projeto:
O frontend foi feito utilizando VueJS e Materialize.
O backend foi feito utilizando Spring Boot e Postgres como SGBD.

Ferramentas utilizadas no projeto:
Projeto desenvolvido tendo comoo SO Ubuntu versão 18.04
As IDE's IntelliJ e VS Code foram utilizadas para o backend e frontend, respectivamente.
Para teste no backend foi utilizado o Postman.
Como gerenciador do banco de dados o DBeaver foi o software escolhido.
Todos os testes do frontend foram feitos no navegador Firefox versão 76.0.1

Para rodar a aplicação siga os passos a seguir:
1º passo: Criar um banco de dados "projeto-zetta" username=postgres e password=postgres
2º passo: Conferir o arquivo application.properties caso necessidade de trocar ou ler informações sobre o banco
3º passo: Executar o arquivo ProjetoZettaApplication para rodar a API (backend) no localhost na porta 8090 (http://localhost:8090), caso necessário ir em application.properties e trocar a porta onde estiver "server.port=8090" (primeira linha do arquivo)
4º passo: Executar o frontend no localhost na porta 8080 (http://localhost:8080), caso tenha trocado a porta da API ir em config.js e trocar a porta da rota.
5º passo: Abrir seu navegador de preferência e digitar na parte da URL http://localhost:8080
