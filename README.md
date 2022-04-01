2022 Q1 Chapter Backend - Practical assessment  
=

## Indicaciones Generales

- Crear una rama con el nombre del participante: Ejemplo: Q12022-lincango-baquero-fernando-daniel.
- Subir cambios a sus ramas una vez terminado el tiempo establecido.
  - Al finalizar el tiempo el repositorio no permitirá nuevos cambios.
- Elaborar pruebas unitarias que cumplan el 75% de cobertura, se excluirán:
  - Clases de entidades persistentes.
  - Clases de entidades no persistentes
  - Clases de configuración.
- Elaborar al menos una prueba de integración.
- Implementar buenas prácticas de programación.
- Implementar control de errores.
- Implementar el modelo de Base de datos con cualquier motor
  - De preferencia H2.
- Adjuntar evidencia de las respuestas de los endpoints requeridos.
- Adjuntar evidencia de cobertura de pruebas unitarias.

## Importante

- En caso de tener problemas al subir el repositorio, enviar un comprimido del ejercicio al correo: flincang@pichincha.com
- Incluir el directorio .git

# Requerimiento

Crear una API Rest que permita 
- Administrar la información de los productos de una tienda de un usuario específico.
- Realizar pedidos por usuarios no registrados en la aplicación a una tienda.


## Usuario
- Datos usuario de la tienda
  - identificador único
  - usuario
  - fecha creación

## Tienda
- Datos tienda
  - identificador único
  - nombre
  - categoría
  - usuario propietario
  
- Crear servicios para administración de una tienda:
  - Crear una tienda nueva.
  - Obtener tienda por nombre.
  - Actualizar tienda por identificador.
  - Eliminar tienda sin productos.
  
- Crear al menos tres tiendas

## Producto:
- Cargar productos a base de datos.
  - Crear endpoint que permita crear base de productos a partir de un servicio mock
    - Input identificador único de la tienda. 
    - Url mock tipo de petición GET: [Productos](https://253b6042-ec17-4ee8-8d7d-ea9d62805337.mock.pstmn.io/dummy-products)
  - Reglas de negocio:
    - Los productos se asignarán a la tienda especificada.
    - Solo deben registrar los productos con stock superior a 5.

## Pedidos
- Realizar pedido
  - Crear endpoint que permita realizar un pedido por usuario a una tienda.
- Reglas de negocio:
  - La tienda debe existir.
  - El producto debe tener stock en tienda.
  - Registro de la transacción.

## Reporte
- Generar reporte de los pedidos realizados por tienda.
- Reglas de negocio:
  - El reporte permite buscar por fecha y por identificador de la tienda.
  - La información a desplegar en el reporte:
    - Nombre del producto
    - Nombre de la tienda
    - Categoría de la tienda
    - Cantidad de productos solicitados.
    - Monto total vendido por producto.
  - No requiere formato de archivo, únicamente respuesta estructurada en formato JSON.
