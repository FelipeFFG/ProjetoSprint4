# ProjetoSprint4
ProjetoSprint4 -CompassoUol

##  DOCUMENTAÇÃO
-Para acessar a documentação, utilizar a url: 
```
http://localhost:8080/swagger-ui.html
```
## AUTENTICACAO CONTROLLER
-Para se autenticar, eu recomendo incluir no banco de dados o seguinte cadastro na tabela usuário.

```
email: aluno@email.com 
senha: $2a$10$85Sqzu.FA4GGRIUCim0/bOG8MJpkqjl7kxCut3IxsWzCL/grj3bku
nome: aluno
```

-Desta forma quando for realizar a autentição,passar no RequestBody do método POST o seguinte json:

```
{
  "email": "aluno@email.com",
  "senha": "123456"
}
```
este método retornará um TOKEN e um TIPO, que deveram ser passados no HEADER Authorization para os endpoints do pedido-controller e do produto-controller na seguinte ordem
```
TIPO TOKEN
```

## PESSOA CONTROLLER
-No pessoa controller, podemos realizar uma série de funcionalidades, entre elas:

* Listar todas as pessoas que estão presentes no banco de dados
* Incluir uma pessoa no sistema
* Buscar uma pessoa por ID
* Realizar alterações no cadastro 
* Deletar uma pessoa do bando de dados.

## PRODUTO CONTROLLER
-No produto controller, podemos realizar uma série de  funcionalidades, entre elas:

* Listar todos os produtos que estão presentes no banco de dados desde que ele esteja ativo 
* Incluir um produto no banco de dados
* Buscar produtos por id(aqui podemos realizar a busca por produtos inativos e ativos)
* Atualizar um produto
* Deletar um produto(soft delete, em que atribui falso no atributo status.) 

## PEDIDO CONTROLLER
-No pedido controller, podemos realizar uma série de funcionalidades, entre elas

* Adicionar um pedido no banco de dados
* Listar todos os produtos no banco de dados desde que ele esteja ativo
* Incluir um pedido no banco de dados,buscar pedido por id(aqui podemos realizar a busca por produtos inativos e ativos)
* Atualizar uma lista de pedidos
* Deletar um pedido(soft delete, em que atribui falso no atributo status)
