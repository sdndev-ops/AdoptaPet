# Microservicio de Mascotas

Este microservicio representa la administración de mascotas disponibles para adopción.

## Atributos sugeridos

- `id`
- `nombre`
- `especie`
- `raza`
- `edad`
- `tamaño`
- `sexo`
- `estadoSalud`
- `estadoAdopcion`
- `descripcion`

## Funcionalidades requeridas

1. Registrar una mascota.
2. Consultar todas las mascotas.
3. Buscar mascota por ID.
4. Buscar mascotas por especie.
5. Buscar mascotas por estado de adopción.
6. Actualizar información de una mascota.
7. Cambiar estado de adopción de una mascota.
8. Eliminar una mascota por ID.

---
## Variables de ambiente usadas por el microservicio.
- **PORT default(9091)**:Representa el puerto en el que se ejecuta el microservicio
- **DB_IP default (localhost)**: Representa la IP del servidor MySQL.
- **DB_PORT default (3306)**: Representa el puerto de acceso del servidor MySQL.
- **DB_NAME default (microservicepet)**: Nombre de la base de datos a la que se conectará el microservicio.
- **DB_USERNAME default (root)**: Usuario de la base de datos
- **DB_PASSWORD default (abc123)**: Password del usuario de la base de datos
- **EUREKA_IP default (localhost)**: Representa la IP de Eureka.
- **EUREKA_PORT default (9999)**: Representa el puerto de acceso del servidor Eureka.
- **CONFIG_IP default(localhost)**: IP del servidor de configuración.
- **CONFIG_PORT default(7777)**: Puerto del servidor de configuración.
