# Sistema de Adopciones de Mascotas

## 1. Nombre del proyecto

**AdoptaPet – Sistema de adopciones de mascotas basado en microservicios**

---

## 2. Descripción general

El proyecto consiste en desarrollar una plataforma para administrar el proceso de adopción de mascotas de una organización protectora de animales.

La solución permitirá registrar mascotas disponibles, consultar adoptantes interesados y gestionar solicitudes de adopción. El sistema será construido utilizando una arquitectura basada en microservicios, aplicando tecnologías como **Spring Boot**, **Spring Cloud**, **OpenFeign**, **Eureka**, **Spring Cloud Gateway**, **Spring Cloud Config**, **Resilience4j** y **Docker**.

El propósito del proyecto es que el participante aplique los conocimientos adquiridos durante el curso, desarrollando una arquitectura distribuida donde cada microservicio tenga una responsabilidad específica y pueda comunicarse con otros servicios de manera controlada.

---

## 3. Escenario de negocio

La organización **AdoptaPet** se dedica al rescate, cuidado y adopción de mascotas. Actualmente, la información de mascotas, adoptantes y solicitudes se administra de forma manual mediante hojas de cálculo, formularios físicos y mensajes entre colaboradores.

Este proceso genera diversos problemas:

- Dificultad para consultar qué mascotas están disponibles.
- Información duplicada o desactualizada.
- Falta de seguimiento formal de las solicitudes de adopción.
- No existe una validación automática entre mascotas y adoptantes.
- No hay una API centralizada para futuras aplicaciones web o móviles.
- El proceso de aprobación o rechazo de solicitudes depende completamente de revisiones manuales.

Por esta razón, la organización necesita una primera versión de una plataforma digital que permita administrar el proceso de adopción de forma más ordenada, escalable y segura.

---

## 4. Objetivo general

Desarrollar una aplicación basada en microservicios que permita administrar mascotas, adoptantes y solicitudes de adopción, integrando comunicación entre servicios, descubrimiento de servicios, API Gateway, configuración centralizada, tolerancia a fallas, seguridad básica y despliegue mediante contenedores.

---

## 5. Objetivos específicos

Al finalizar el proyecto, el participante será capaz de:

- Diseñar una arquitectura básica de microservicios.
- Crear microservicios independientes con Spring Boot.
- Separar responsabilidades por dominio de negocio.
- Implementar operaciones CRUD en microservicios.
- Comunicar microservicios mediante OpenFeign.
- Registrar servicios en Eureka Server.
- Exponer los servicios mediante Spring Cloud Gateway.
- Centralizar configuraciones usando Spring Cloud Config.
- Implementar tolerancia a fallas con Resilience4j.
- Aplicar seguridad básica con Spring Security.
- Crear imágenes Docker de los microservicios.
- Levantar la arquitectura completa usando Docker Compose.
- Probar los servicios mediante Postman, Insomnia o curl.

---

## 6. Alcance de la primera versión

La primera versión del sistema incluirá los siguientes módulos principales:

1. Administración de mascotas.
2. Administración de adoptantes.
3. Administración de solicitudes de adopción.
4. Comunicación entre microservicios.
5. Descubrimiento de servicios.
6. API Gateway.
7. Configuración centralizada.
8. Seguridad básica.
9. Despliegue con Docker.

Esta versión no contempla una interfaz gráfica completa. El consumo de los servicios se realizará mediante herramientas como Postman, Insomnia o curl.


## 7. Diagrama de Arquitectura
![Diagrama de Arquitectura](diagrama_arquitectura.png)

## 8. Diagrama de Arquitectura Desacoplada
![Diagrama de Arquitectura Desacoplada](diagrama_arquitectura_EurekaServer.png)
