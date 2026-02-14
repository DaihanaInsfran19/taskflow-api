# TaskFlow API

API REST desarrollada con Spring Boot para la gestión de tareas. Permite
crear, listar, actualizar, eliminar y marcar tareas como completadas.


## Tecnologías utilizadas

-   Java 17
-   Spring Boot
-   Spring Data JPA
-   PostgreSQL
-   Docker
-   Maven
-   Thunder Client (para pruebas)


## Cómo ejecutar el proyecto

### 1. Levantar la base de datos con Docker

docker compose up -d

Esto levantará PostgreSQL en: localhost:5432 DB: taskflow USER: postgres
PASS: postgres


### 2. Ejecutar la API

./mvnw spring-boot:run

La API se levantará en: http://localhost:8080


## Endpoints disponibles

GET /api/tasks GET /api/tasks?completed=true GET /api/tasks/{id} POST
/api/tasks PUT /api/tasks/{id} PATCH /api/tasks/{id}/complete DELETE
/api/tasks/{id}


### Ejemplo de creación

{ "title": "Comprar leche", "description": "Ir al supermercado",
"priority": "HIGH" }


## Validaciones

-   El campo title es obligatorio
-   El título debe tener mínimo 3 caracteres


## Manejo de errores

400 - Bad Request 404 - Not Found 500 - Internal Server Error


## Pruebas

Los endpoints fueron probados utilizando Thunder Client en VS Code.

Flujo de pruebas: 1. Crear tarea 2. Listar tareas 3. Marcar como
completada 4. Actualizar tarea 5. Obtener por ID 6. Eliminar tarea


## Autor

Desarrollado por Daihana Insfran
