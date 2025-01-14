# Desafio Back-End AnotaAi

To usando o desafio como estudo.

Segue o texto do desafio.

### Backend Analyst Candidate Test
Dear developer,

Welcome to the Backend Analyst Candidate Test. This test aims to assess your general knowledge and development speed. Below, you will find the details and requirements for this test.


<strong>The Challenge</strong>

Your task is to develop an API using Node.js for a product catalog management system in a marketplace application. You should analyze and convert the following user stories into routes for the application:

<strong>User Stories:</strong>

- As a user, I want to register a product with its owner, so that I can access its data in the future (title, description, price, category, owner ID).
- As a user, I want to register a category with its owner, so that I can access its data in the future (title, description, owner ID).
- As a user, I want to associate a product with a category.
- As a user, I want to update the data of a product or category.
- As a user, I want to delete a product or category from my catalog.
- A product can only be associated with one category at a time.
- Assume that products and categories belong only to one owner.

- Keep in mind that this is an online product catalog, which means there will be multiple requests for editing items/categories per second, as well as accessing the catalog search endpoint.
- Consider the product catalog as a JSON compilation of all available categories and items owned by a user. This way, the catalog search endpoint does not need to fetch information from the database.
- Whenever there is a change in the product catalog, publish this change to the "catalog-emit" topic in the AWS SQS service.
- Implement a consumer that listens to catalog changes for a specific owner.
- When the consumer receives a message, search the database for that owner's catalog, generate the catalog JSON, and publish it to an AWS S3 service bucket.

<strong>You need to develop this test using the following technologies:</strong>

- MongoDB for the database.
- AWS SQS for the catalog change notifications.
- AWS S3 for storing the catalog JSON.
- Node.js for the backend.
- Express.js as the web framework.

<hr>
<strong>Diagram representing the final structure of the project:</strong> <br><br>
![image](https://github.com/githubanotaai/new-test-backend-nodejs/assets/52219768/504ba448-f128-41db-ae86-18dc19c0dc9d)


<hr>

<strong>Instructions</strong>

<strong>To begin the test, fork this repository, create a branch with your full name, and send us the link to your completed test (link to your repository). If you only clone the repository, you won't be able to push changes, making the pull request more complicated.</strong>
- Use your own AWS account to set up the required services.
- Update the README file with instructions on how to run your application.
- Paste the branch name into the GUPY system and indicate the completion of the test.
- Feel free to provide us with feedback regarding the test.

<strong>Our Evaluation Criteria</strong>
We will assess the following aspects of your solution:

- Knowledge of JavaScript, Node.js, and Express.js.
- Proper structure of the application layers.
- Handling of outgoing calls.
- Effective use of environment variables.
- Implementation of unit tests.
- Logging mechanisms.
- Error handling strategies.
- Documentation quality.
- Code organization, module separation, readability, and comments.
- Commit history.

## Notes

- I didn't use dtos to make impl simpler. My focus is not the impl, its to study terraform, containers and noSql. 
And I used kotlin as a challenge, to study another lang.

- Pra conectar no MongoDb utilizei dbeaver conectado ao container local.

- No desafio ta errado a nomeclatura, pede sqs e chama de topico, vou publicar direto no sqs pra provisionar menos infra na aws
e chamar a fila de catalog-emit-queue.

## Run APP

Comandos

```
docker compose up -d                 
docker exec -it test-backend-anotaai-kotlin-mongo-1 bash
mongosh mongodb://localhost:27017 -u vini -p vini22k0
show dbs;
use catalog-api;
db.product.find()
```

## Cadastros

owner
```
{
    "id":"caafbf41-0a8e-48b3-b064-35d764c9699e" 
    "name":"Tia Nena"
}
```

category
```
{
    "id":"abd3e329-1903-4cf6-83d0-364f241a209e"
    "title":"Quitanda",
    "description":"Quitandinhas da Tia Nena",
    "ownerId":"caafbf41-0a8e-48b3-b064-35d764c9699e"
}
```

produtos:
```
{
    "id":"1a3b385b-3038-4664-9bde-1b658117440b",
    "ownerId":"caafbf41-0a8e-48b3-b064-35d764c9699e",
    "title":"Broa da Tia Nena",
    "price":"40R$/kg",
    "description":"Broa de fubá. Melhor da cidade!",
    "categoryId":"abd3e329-1903-4cf6-83d0-364f241a209e"
}

{
    "id":"8503c08c-157a-43b0-ac53-2942d3069a24",
    "ownerId":"caafbf41-0a8e-48b3-b064-35d764c9699e",
    "title":"Pão de Queijo Mineiro da Tia Nena",
    "price":"35R$/kg",
    "description":"Pão de queijo. Melhor da cidade!",
    "categoryId":"abd3e329-1903-4cf6-83d0-364f241a209e"
}
```

## Duvidas sobre a regra

Nao vou inventar e impl a regra mas fica o questionamento.

- O que acontece caso delete uma categoria? Desativa os produtos? Deixa sem? Atualiza pra vazio na coluna de catalogoId?
Somente produtos com categoria entram no catalogo?
Nota: Se deletar categoria vai acabar ficando fora do catalogo pois busco todas categorias pra um owner.