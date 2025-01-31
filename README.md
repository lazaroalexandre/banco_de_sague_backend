# Banco de Sangue - Backend

O sistema é uma ferramenta móvel de manipulação de dados de sangue de uma agência, com o fito de:

- Fazer upload de arquivos jsons com dados dos candidatos para doação de sangue;
- Listar os possíveis doadores de sangue;
- Informar quantos candidatos existem em cada estado do Brasil;
- Informar o IMC médio em cada faixa de idade de dez em dez anos;
- Informar o percentual de obesos entre os homens e entre as mulheres;
- Informar a média de idade para cada tipo sanguíneo;
- Informar a quantidade de possíveis doadores para cada tipo sanguíneo receptor.

Por fim, nesse repositório foi desenvolvido o backend do projeto.

## Tecnologias usadas

- Spring - Java
- MySql - SQL

## Configurações em localhost

    1 - Instale o Maven na sua máquina;
    2 - Instale o Postgres SQL na sua máquina;
    3 - Crie um usuário chamado postgres no Postgres SQL;
    4 - Altere a senha de usuário para postgres também;
    5 - Crie um banco de dados chamado "entregas";
    6 - No arquivo "aplication.properties", altere o valor de "JWT_SECRET" 
    na chave secreta para qualquer palavra que você ache secreta;
    7 - No arquivo "application.properties", altere o seu username (e-mail) e password nas confirgurações de smtp. Veja como adicionar a senha correta do seu e-mail 
    de envio escolhido: https://support.google.com/accounts/answer/185833.    

## Dependências implantadas

- Spring Web
- Spring Data JPA
- Lombok
- Spring Boot DevTools
- MySQL Driver

## Inicialização

- ### Instalação

        Antes de tudo, instale o JDK21 e o Maven na sua máquina. Veja algum tutorial atualizado na internet.

- ### No Linux
        
        Execute o comando para limpar e reconstruir o projeto spring no linux:

        - mvn clean package
    
        Execute o comando para rodar o projeto no linux:

        - mvn spring-boot:run


- ### No Windows

        Execute o comando para limpar e reconstruir o projeto spring no windows:
        
        - ./mvnw clean package
        
        Execute o comando para rodar o projeto no windows:

        - ./mvnw spring-boot:run

## Endpoints

    [endpoints.json](/endpoints.json)
    
## Autor

Olá, sou o Lázaro Alexandre, um desenvolvedor full stack e futuro analista de sistemas apaixonado por transformar vidas através da inovação tecnológica.

Para mais informações, acesse o meu portifólio: https://homolazarus.netlify.app/

Estarei te aguardando ^-^