### Probrar endpoints

Con el siguiente json puedes probar con POSTMAN o CURL
```=json
{
  "id": "1",
  "nombre": "Juan Pérez",
  "email": "juan@example.com",
  "edad": 30,
  "tipoCliente": "VIP"
}

```

Ejecutando en CURL
```=json
curl -X POST http://localhost:8080/clientes -H "Content-Type: application/json" -d '{
  "id": "1",
  "nombre": "Juan Pérez",
  "email": "juan@example.com",
  "edad": 30,
  "tipoCliente": "VIP"
}'


```
Obtener clientes

```=json
curl -X GET http://localhost:8080/clientes
```
Actualizar cliente

```=json
curl -X PUT http://localhost:8080/clientes/1 -H "Content-Type: application/json" -d '{
  "id": "1",
  "nombre": "Juan Pérez",
  "email": "juan_perez@nuevo.com",
  "edad": 30,
  "tipoCliente": "REGULAR"
}'
```

Aplicar beneficio:

```=json
curl -X POST http://localhost:8080/clientes/1/beneficio
```


Eliminar cliente: 
```=json
curl -X DELETE http://localhost:8080/clientes/1
```
![Screenshot from 2025-02-28 11-30-34](https://github.com/user-attachments/assets/670461e4-dba1-46d4-9408-d7d4e7bf56c3)

OpenAPI

🔹 Swagger UI (documentación visual):
👉 http://localhost:8080/swagger-ui.html

![Screenshot from 2025-02-28 11-28-09](https://github.com/user-attachments/assets/47875dc9-3c08-4dd1-921d-afbecaa3ae58)

🔹 Esquema OpenAPI en formato JSON:
👉 http://localhost:8080/v3/api-docs

