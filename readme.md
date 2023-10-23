
## Instalación

Use maven

```bash
mvn clean install
```

## Uso

Se puede probar el servicio mediante swagger
``` 
http://localhost:8080/swagger-ui/index.html
```

## Estructura del proyecto

- common
    - common-application
    ```
    Se define los manejadores globales para la gestión de las excepciones
    ```
    - common-domain
     ```
    Se define lo siguiente
    - Clases Base para la creación de las clases en el proyecto
    - La clase para la captura para las excepciones del dominio
    - La creacion de los ValueObjects
    
    ```
- price-service
    - price-application
         ```
        Se define los manejadores globales para la gestión de las excepciones dentro del servicio y la creacion de los servicios rest del servicio para interactuar con el exterior
        ```
    - price-container
         ```
        - Se crea el main del servcio, este modulo concentra los modulos necesarios para el funcionamiento del servicio
        - Se realiza la configuracion de la aplicacion para la conexion al motor de datos y la creacion de los esquemas y datos de prueba
        - Se tienen creados los test para probar los servicios rest
        ```
    - price-dataaccess
         ```
        - En este módulo se crea la entidad que interactua con la BD
        - La definición de la interfaz JPA para interactuar con la BD
        - La implementacion de la interfaz del puerto de salida "port.output" definida en el dominio
        - El mapeo de la Entidad de base de datos a la entidad del dominio
        ```
    - price-domain
        - price-application-service
            ```
            Se define las interfaces de comunicacion del dominio con el exterior, definiendo
            - Las clases DTO que utilizaran para presentar la informacion
            - El mapeo de domino a los DTO
            - La definicion de los puertos de entrada y salida (Input, Output)
            ```
        - price-domain-core
            ```
            Se define la entidades del domino  la gestion de excepciones del dominio
            ```

Los tests se encuentran en:
```
   src/test/java/com/price/system/service/domain/PriceSystemUnitTest.java
```