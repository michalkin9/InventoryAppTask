# InventoryAppTask

simple application created with **Spring-boot**, Rest controller and swagger.

## Technologies
Project is created with:
* Spring boot: 2.4.2
* Spring fox swagger: 2.9.2
* Java: 1.8
* Docker: 20.10.2

## Docker Image
["inventory_task" repository](https://hub.docker.com/repository/docker/michaly/inventory_task)

*Pull docker request :* 

```
pull michaly/inventory_task:latest
```
*run docker image :*
```
docker run -p 8080:8080 michaly/inventory_task:latest
```


## API's
[Link to swagger](http://localhost:8080/swagger-ui.html) - **You can perform the actions below from the link when the application is running**

- Get a list of all inventories in the DB and their details by a `GET Request.` 

```
GET: api/inventories/{number}
```
Get a specific item details  by a  `GET Request` with a specific number of the inventory.
```
GET: api/inventories/{number}
```
* Withdrawal/Deposit quantity of an item by `PUT Request` with a specific number of the inventory and specific amount.
```
PUT: api/inventories/{number}/{amount}
```
* Change Inventory details by a `PUT request` with a spesific number of the inventory. (you can see request body in swagger)
```
PUT: api/inventories/{number}
```
* Add item to stock  by a  `POST Request`. (you can see request body in swagger)
```
POST: api/inventories/add
```
* Delete an item from stock by a `DELETE Request`  with a spesific number of the inventory you wish to delete from DB.
```
DELETE: api/inventories/{number}
```
