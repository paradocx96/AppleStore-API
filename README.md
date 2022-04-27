# MADD Assignment 3 Backend

## Endpoints

### GET All
```
"method": "GET",
"url": "http://localhost:8080/api/v1/item/"
```

### POST
```
"method": "POST",
"body": {
    "name": "iPhone 12", 
    "code": "120100", 
    "availableUnit": 10, 
    "price": 699.99, 
    "taxPrice": 799.99, 
    "productDescription": "This is the sample desccription for item.", 
    "imagePath": "iphone12.jpg",
    "type": "New"
},
"url": "http://localhost:8080/api/v1/item/"
```

### GET By ID
```
"method": "GET",
"url": "http://localhost:8080/api/v1/item/6269928bcff1cd692e83faef"
```

### GET By Type
```
"method": "GET",
"url": "http://localhost:8080/api/v1/item/byType/New"
```

### PUT
```
"method": "PUT",
"body": {
    "id":"6269928bcff1cd692e83faef",
    "name": "iPhone 12", 
    "code": "120100", 
    "availableUnit": 10, 
    "price": 699.99, 
    "taxPrice": 799.99, 
    "productDescription": "This is the sample desccription for item.", 
    "imagePath": "iphone12.jpg",
    "type": "New"
},
"url": "http://localhost:8080/api/v1/item/"
```

### DELETE
```
"method": "DELETE",
"url": "http://localhost:8080/api/v1/item/6269928bcff1cd692e83faef"
```
