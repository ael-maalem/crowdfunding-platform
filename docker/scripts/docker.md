## Docker commands 

### Create a container for mongo db 
```shell script
docker run --name mongodb -d --network crowdfunding-network -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root -v db-mongo:/data/db -p 27017:27017 mongo
```
docker run --name mongodb -d -v db-mongo:C:\ProgramData\docker -p 27017:27017 mongo


### Create a container for mongo express (UI for mongodb)
```shell script
docker run --name mongodb-express -d --network crowdfunding-network -e ME_CONFIG_MONGODB_ADMINUSERNAME=root -e ME_CONFIG_MONGODB_ADMINPASSWORD=root -e ME_CONFIG_MONGODB_SERVER=mongodb -p 8088:8088 mongo-express
```

### Create a volume for mongodb to store data when container 
```shell script
docker volume create db-mongo
```
##### to inspect the volume used for mongodb 
```shell script
docker volume inspect db-mongo
```

### Create a network for our two containers mongodb and UI of mongodb 
```shell script
docker network create crowdfunding-network 
```


##### To verify the signature of the token for an admin or user 
###### we copied the secret key in application.yaml including simple quotes ***' '***

--> Example of token for Admin:
eyJ0eXAiOiJ....

--> This is our secret:
'Yq3t6w9y$....'

--> To verify the signature of our token: [jwt.io](https://jwt.io/#debugger-io?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJDcm93ZC1mdW5kaW5nIEFkbWluaXN0cmF0aW9uIiwic3ViIjoiYWRtaW4iLCJpc3MiOiJDcm93ZC1mdW5kaW5nIExpbWl0ZWQiLCJleHAiOjE2MjQ2Njc0OTAsImlhdCI6MTYyNDA2MjY5MCwiYXV0aG9yaXRpZXMiOlsidXNlcjpyZWFkIiwidXNlcjpjcmVhdGUiLCJ1c2VyOnVwZGF0ZSJdfQ.O9jEAnoXldNMv7N-ap9ye1b1cE8gtRR0WPmQQNnAACoSjtTylLhM5Tpep3dC7eT8ZIuwH9x95Kfo9YBwimiz5A)

### Create a container for users-service with env_var  
docker run --name users-service --env-file ./.env users-development:v1.0
