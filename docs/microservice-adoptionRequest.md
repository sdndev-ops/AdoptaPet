# Microservicio de Solicitudes de Adopción
Este microservicio representa la administración de solicitudes de adopción dentro del sistema.

La entidad principal será AdoptionRequest, la cual almacena la información necesaria para registrar qué adoptante desea adoptar una mascota.

---
## Entidad: AdoptionRequest
La entidad AdoptionRequest representa una solicitud realizada por un adoptante para iniciar el proceso de adopción de una mascota.

Este microservicio se comunica con:

Microservicio de mascotas.
Microservicio de adoptantes.

---
## Atributos sugeridos
- id
- adopterId
- petId
- emailAdopter
- namePet
- status

---
### Enum sugerido: AdoptionRequestStatus
El estado de la solicitud puede manejarse mediante un enum.

`public enum AdoptionRequestStatus {
PENDING,
APPROVED,
REJECTED
}`

### Implementación de Resilience4j
Al comunicarse con los microservicios **microservicepet y microserviceadopter**, se implmenta el patrón de diseño de **Circuit Breaker** en la implmentación del servicio (**ServiceImpl**)

### Se agrega el siguiente starter
- Resilience4j de Spring Cloud


---
## Variables de ambiente usadas por el microservicio.
- **PORT default(9093)**:Representa el puerto en el que se ejecuta el microservicio
- **DB_IP default (localhost)**: Representa la IP del servidor MySQL.
- **DB_PORT default (3306)**: Representa el puerto de acceso del servidor MySQL.
- **DB_NAME default (microserviceadoptionrequest)**: Nombre de la base de datos a la que se conectará el microservicio.
- **DB_USERNAME default (root)**: Usuario de la base de datos
- **DB_PASSWORD default (abc123)**: Password del usuario de la base de datos
- **EUREKA_IP default (localhost)**: Representa la IP de Eureka.
- **EUREKA_PORT default (9999)**: Representa el puerto de acceso del servidor Eureka.
- **CONFIG_IP default(localhost)**: IP del servidor de configuración.
- **CONFIG_PORT default(7777)**: Puerto del servidor de configuración.