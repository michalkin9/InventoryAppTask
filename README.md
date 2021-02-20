# InventoryAppTask
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

## API's
[Link to swagger](http://localhost:8080/swagger-ui.html) - **You can perform the actions below from the link when the application is running**

- Get a list of all inventories in the DB and their details by a `GET Request.` 

```
GET: /inventories/{number}
```
- Get a specific item details  by a  `GET Request` with a spesific number of the inventory.
```
GET: /inventories/{number}
```
* Withdrawal/Deposit  quantity of an item by `PUT Request` with a spesific number of the inventory you wish to change 


with a body of the relevant changes of the item.
```
PUT: /inventories/{number}
```
* Add item to stock  by a  `POST Request`
```
POST: /inventories/add
```
* Delete an item from stock by `DELETE Request`  with a spesific number of the inventory you wish to delete from DB.
```
DELETE: /inventories/{number}
```
