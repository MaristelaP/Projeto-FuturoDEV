# DEVin-Adotation
##Projeto avaliativo do curso FuturoDEV - Módulo 3

## Introdução

Uma empresa especializada em desenvolvimento de aplicações
deseja desenvolver uma aplicação para controle de estoque 
de materiais para ONGs. Com isso a **LAB CAT&DOG** está 
contratando novos desenvolvedores para o seu quadro de 
colaboradores, com o intuito de expandir os negócios, os 
gestores entendem que antes de finalizar as contratações,
é necessário executar um desafio prático onde o futuro 
colaborador deverá criar um sistema de controle de estoque. 
É hora de ficar feliz, pois você foi escolhido para criar o **DEVin-Adotation**.

## Como rodar o projeto?

```bash
# Clone este repositório
$ git clone link-do-projeto

# Acesse a pasta do projeto no seu terminal
$ cd adotation

# Abra a aplicação na IDE Intellij
```
Configure o Banco de Dados através do arquivo _aplication.properties_
Após abra um arquivo e clique em run para rodar o projeto. 
A aplicação será iniciada na porta 8080, por exemplo.

## Como utilizar o projeto?

Será necessário o uso de _EndPoints_

* Para Login de Usuário

**POST** '/login'

_Body_ requisição
```json
{
  "email": "fulano@gmail.com",
  "senha": 12345678
}
```
Resposta esperada: O usuário estando cadastrado e sua 
senha e email estiverem corretos, ele entra no sistema.
Caso contrário, será necessário fazer o cadastro.

* Para Cadastrar Usuário

**POST** '/usuario'

_Body_ requisição
```json
{
  "nome": "Fulano de Tal",
  "email": "fulano@gmail.com",
  "senha": 12345678
}
```
_Body_ resposta esperada
```json
{
  "id": 1,
  "nome": "Fulano de Tal",
  "email": "fulano@gmail.com",
  "senha": 12345678
}
```

---

* Para Cadastrar Produto

**POST** '/produto'

_Body_ requisição

```json
{
  "produto": "ração",
  "quantidade": "10",
  "animal": "gato",
  "categoria": "adulto"
}
```
_Body_ resposta esperada

```json
{
  "id": "11",
  "produto": "ração",
  "quantidade": "10",
  "animal": "gato",
  "categoria": "adulto"
}
```

* Para listar todos Produtos

O sistema apresenta uma lista com todos produtos cadastrados.


**GET** '/produto'

Requisição _/produto_

_Body_ resposta esperada

```json
[
    {
      "id": "11",
      "produto": "ração",
      "quantidade": "10",
      "animal": "gato",
      "categoria": "adulto"
    },
    
    {
       "id": "12",
       "produto": "antipulgas",
       "quantidade": "30",
       "animal": "gato",
       "categoria": "adulto"
    }  
]
```

* Para buscar determinado produto

**GET** '/produto/id'

Requisição:  _/produto/11_

_Body_ resposta esperada

```json
{
  "id": "11",
  "produto": "ração",
  "quantidade": "10",
  "animal": "gato",
  "categoria": "adulto"
}
```

* Para Editar produto

Apenas o tipo de produto e a sua quantidade poderão 
ser editados.

**PUT** '/produto/id'

Requisição:  _/produto/11_

_Body_ 
```json
{
  "produto": "ração",
  "quantidade": "10"
}
```
Após serem definidas as mudanças necessárias, neste caso 
o tipo de ração armazenada e sua quantidade. 

_Body_ resposta esperada

```json
{
  "id": "11",
  "produto": "ração trato gastrointestinal",
  "quantidade": "2",
  "animal": "gato",
  "categoria": "adulto"
}
```

* Para Excluir um produto

**DELETE** 'produto/id'

Requisição: _/produto/11_

Resposta esperada: O produto será excluído 
e não constará mais na listagem.

---

* Para Cadastrar Estoque

**POST** '/estoque'

_Body_ Requisição

```json
{
  "nome": "Estoque 3",
  "animal": "cachorro"
}
```

_Body_ resposta esperada

```json
{
  "id": "3",
  "nome": "Estoque 3",
  "animal": "cachorro"
}
```

* Para listar todos os Estoques existentes

**GET** '/estoque'

_Body_ resposta esperada

```json
[
    {
      "id": "1",
      "nome": "Estoque 1",
      "animal": "cachorro"
    },
    
    {
       "id": "2",
       "nome": "Estoque 2",
       "animal": "gato"
    }  
]
```

* Para listar determinado Estoque

**GET** '/estoque/id'

Requisição: /estoque/3

_Body_ resposta esperada

```json
{
  "id": "3",
  "nome": "Estoque 3",
  "animal": "cachorro"
}
```

* Para Editar o Estoque

**PUT** '/estoque/id'

Requisição:  _/estoque/4_

_Body_
```json
{
  "nome": "Estoque 4",
  "animal": "cachorro"
}
```

Após as alterações necessárias serem feitas, neste caso
houve a mudança de estoque e animal.

_Body_ resposta esperada

```json
{
  "id": "4",
  "nome": "Estoque 5",
  "animal": "gato"
}
```

* Para Excluir um Estoque

**DELETE** 'estoque/id'

Requisição: _/estoque/2_

Resposta esperada: O Estoque será excluído
e não constará mais na listagem.

---

## 👏Pessoas envolvidas no projeto

<a href= "https://www.linkedin.com/in/maristelapeglow/" target= "_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target= "_blank"/> Maristela
#
<a href= "https://www.linkedin.com/in/renato-aires-5128b7189/" target= "_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target= "_blank"/> Renato
#
<a href= "https://www.linkedin.com/in/vini-andrade-35ab6421/" target= "_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target= "_blank"/> Vinícius


## Considerações Finais Sobre o Projeto

Algumas funcionalidades começaram a ser desenvolvidas, como o "findByEstoque" para produtos,
mas como não era exigência, sua implementação não foi concluída, devido a outras prioridades da fatoração.

Ainda não sabemos como enviar determinados erros do back-end para o front-end, como, por exemplo, quando
alguém tenta deletar um estoque com um produto dentro e não consegue. Preferimos manter o cumprimento da exigência
do curso, mas temos o ônus de não obter essa informação no front-end.

