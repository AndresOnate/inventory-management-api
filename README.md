# API de Control de Inventario

Este proyecto es un sistema de gestión de inventario con autenticación y funcionalidad CRUD para gestionar productos. Está construido con Spring Boot y utiliza OAuth2 para la autenticación de usuarios.

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener lo siguiente instalado:

- **Java 11 o superior** (JDK 11+)
- **Maven** (para gestión de dependencias y construcción del proyecto)
- **Visual Studio Code** 

Además, asegúrate de que tu entorno esté configurado para la autenticación OAuth2 con Google (según lo configurado en el proyecto).

## Iniciando el proyecto

Sigue estos pasos para configurar y ejecutar el proyecto localmente:

### 1. Clonar el repositorio

Primero, clona el repositorio en tu máquina local:

```bash
git https://github.com/AndresOnate/
inventory-management-api.git
```

```
cd inventory-management-api
```

### 2. Configurar el entorno
En el archivo src/main/resources/application.yml, actualiza las propiedades para configurar la aplicación:
```
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: TU_GOOGLE_CLIENT_ID
            client-secret: TU_GOOGLE_CLIENT_SECRET
      resourceserver:
        jwt:
          issuer-uri: accounts.google.com
          jwk-set-uri: https://www.googleapis.com/oauth2/v3/certs
```
- Reemplaza TU_GOOGLE_CLIENT_ID y TU_GOOGLE_CLIENT_SECRET con tus credenciales desde la Consola de Desarrolladores de Google. 

### 3. Instalar dependencias

Instala las dependencias con el siguiente comando:

```
mvn clean install
```
###  4. Ejecutar la aplicación
Una vez todo esté configurado, puedes ejecutar la aplicación utilizando Maven:
```
mvn spring-boot:run
```

### 5. Acceder a la aplicación

## Puntos finales de la API

Después de ejecutar la aplicación, deberías poder acceder a los siguientes puntos finales:

### 1. Página de Login (OAuth2)
- **URL**: `http://localhost:8080/login`
- **Descripción**: Página de login para autenticación a través de OAuth2 (Google).

### 2. Página de Inicio (Después de iniciar sesión correctamente)
- **URL**: `http://localhost:8080/home`
- **Descripción**: Página de inicio después de iniciar sesión correctamente.

### 3. Puntos finales de la API

- **GET /api/products**
  - **Descripción**: Obtener todos los productos.
  - **Respuesta**: Lista de productos.
  
- **GET /api/products/{id}**
  - **Descripción**: Obtener un producto específico por su ID.
  - **Parámetros**:
    - `id` (Long): El ID del producto a consultar.
  - **Respuesta**: Detalles del producto.
  
- **POST /api/products**
  - **Descripción**: Crear un nuevo producto.
  - **Cuerpo de la solicitud**: Un objeto JSON con los detalles del producto.
    ```json
    {
      "name": "Nombre del producto",
      "description": "Descripción del producto",
      "price": 100.0,
      "quantity": 50
    }
    ```
  - **Respuesta**: El producto creado con los detalles proporcionados.

- **PUT /api/products/{id}**
  - **Descripción**: Actualizar un producto existente.
  - **Parámetros**:
    - `id` (Long): El ID del producto a actualizar.
  - **Cuerpo de la solicitud**: Un objeto JSON con los nuevos detalles del producto.
  - **Respuesta**: El producto actualizado.

- **DELETE /api/products/{id}**
  - **Descripción**: Eliminar un producto específico.
  - **Parámetros**:
    - `id` (Long): El ID del producto a eliminar.
  - **Respuesta**: Sin contenido, solo indica que el producto ha sido eliminado.

### 4. Swagger UI

- **URL**: `http://localhost:8080/swagger-ui/index.html`
- **Descripción**: La interfaz de Swagger proporciona una forma visual para probar las APIs de la aplicación. Desde aquí, podrás ver todos los puntos finales disponibles, probar las solicitudes y ver las respuestas directamente en el navegador.

---

### 7. Solución de problemas
Si encuentras algún problema, verifica lo siguiente:

- Asegúrate de que todas las variables de entorno (como las credenciales OAuth2 de Google) estén correctamente configuradas.
- Verifica que la base de datos esté en ejecución y accesible.
- Revisa la salida de la consola para cualquier mensaje de error durante el inicio y sigue las instrucciones proporcionadas.

### 8. Dependencias
- Spring Boot: Web, Seguridad, OAuth2, JPA y Thymeleaf
- Swagger/OpenAPI: Para documentación de las APIs
- Lombok: Para reducir código repetitivo (getters, setters, etc.)