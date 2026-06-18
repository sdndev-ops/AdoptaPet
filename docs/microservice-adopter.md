# Microservicio de Adoptantes

Este microservicio representa la administración de personas interesadas en adoptar una mascota.

La entidad principal será `Adopter`, la cual almacena la información básica del adoptante para que pueda participar en un proceso de adopción.

---

## Entidad: Adopter

La entidad `Adopter` representa a una persona que desea adoptar una mascota dentro del sistema.

## elementos que se deben de respetar
- Nombre de proyecto: MicroserviceAdopter
- Nombre del microservicio (application.properties): microserviceadopter
- Nombre de base de datos microserviceadopter
- Puerto: 9092

---

## Atributos sugeridos

- id
- firstName
- lastName
- email
- phone
- address

---

## Funcionalidades requeridas

1. Registrar un adoptante.
2. Consultar todos los adoptantes.
3. Buscar adoptante por id.
4. Buscar adoptante por email.
5. Buscar adoptantes por apellido.
6. Actualizar información de un adoptante.
7. Eliminar un adoptante por id.

---

## Reglas básicas

- El email del adoptante debe ser único.
- El nombre y apellido son obligatorios.
- El teléfono es obligatorio.
- La dirección es obligatoria.
- No se debe eliminar un adoptante si tiene una solicitud de adopción activa.

---

## Endpoints sugeridos

| Método HTTP | Endpoint | Descripción |
|---|---|---|
| POST | `/adopter` | Registrar un nuevo adoptante |
| GET | `/adopter` | Consultar todos los adoptantes |
| GET | `/adopter/{id}` | Buscar adoptante por id |
| GET | `/adopter/email/{email}` | Buscar adoptante por email |
| GET | `/ap/adopter/lastname/{lastName}` | Buscar adoptantes por apellido |
| PUT | `/adopter` | Actualizar información de un adoptante |
| DELETE | `/adopter/{id}` | Eliminar un adoptante por id |


---
## Variables de ambiente usadas por el microservicio.
- **PORT default(9092)**:Representa el puerto en el que se ejecuta el microservicio
- **DB_IP default (localhost)**: Representa la IP del servidor MySQL.
- **DB_PORT default (3306)**: Representa el puerto de acceso del servidor MySQL.
- **DB_NAME default (microserviceadopter)**: Nombre de la base de datos a la que se conectará el microservicio.
- **DB_USERNAME default (root)**: Usuario de la base de datos
- **DB_PASSWORD default (abc123)**: Password del usuario de la base de datos
- **EUREKA_IP default (localhost)**: Representa la IP de Eureka.
- **EUREKA_PORT default (9999)**: Representa el puerto de acceso del servidor Eureka.
- **CONFIG_IP default(localhost)**: IP del servidor de configuración.
- **CONFIG_PORT default(7777)**: Puerto del servidor de configuración.
