# Proyecto APIExamenBack - Registro de Cambios

## Descripción del Proyecto
Este es un proyecto **Java** desarrollado con **Spring Boot** que permite conectarse a una base de datos **MySQL** para gestionar y almacenar información de cursos, docentes y usuarios.  

En la versión más reciente, el proyecto fue migrado de **Gradle** a **Maven**, lo que facilita la gestión de dependencias y la integración con entornos de desarrollo estándar. Además, se realizaron ajustes en la estructura de paquetes, configuración de conexión a la base de datos y código para mejorar su mantenimiento.

---

## Cambios Realizados

### Migración de Gradle a Maven
- **Archivo anterior:** `build.gradle`
- **Archivo nuevo:** `pom.xml`
- **Error:** Uso de Gradle como administrador de dependencias, lo que dificultaba la configuración estándar de Spring Boot.
- **Solución:** Migración a Maven con dependencias declaradas en `pom.xml` y configuración compatible con Spring Boot 3.x.

---

### application.properties
- **Ubicación anterior:** `src/main/resources/application.properties` (Gradle)
- **Ubicación nueva:** `src/main/resources/application.properties` (Maven)
- **Cambios:**
  - Líneas afectadas: **2 -> 5**
  - Actualización de la URL de conexión a la base de datos.
  - Inclusión de parámetros `spring.datasource.username` y `spring.datasource.password`.
  - Configuración de `spring.jpa.hibernate.ddl-auto=update` para mantener la estructura de tablas automáticamente.
- **Motivo:** Estandarización para conexión local con MySQL vía XAMPP.

---

### Curso.java
- **Paquete anterior:** `com.example.Examen1Back2.modelos`
- **Paquete nuevo:** `com.example.APIExamenBack.modelos`
- **Cambios:**
  - Líneas afectadas: **8, 9, 13 -> 16, 26 en adelante**
  - Renombrado de paquete para unificar la nomenclatura del proyecto.
  - Ajuste de imports y anotaciones de JPA.
  - **Creación de Getters y Setters** para todos los atributos.
  - **Eliminación de líneas de relacionamiento** con otras entidades (ej. `@OneToMany`, `@ManyToOne`), dejando la clase independiente.
- **Error corregido:** Uso inconsistente de nombres de paquete que provocaba conflictos en el arranque de la aplicación.
- **Solución:** Estandarizar los paquetes bajo `com.example.APIExamenBack`.

---

### Docente.java
- **Paquete anterior:** `com.example.Examen1Back2.modelos`
- **Paquete nuevo:** `com.example.APIExamenBack.modelos`
- **Cambios:**
  - Líneas afectadas: **7, 17 -> 24, 26**
  - Ajuste de anotaciones `@Entity` y `@Table`.
  - Renombrado de variables para mayor claridad.
  - **Creación de constructores** (por defecto y con parámetros).
  - **Eliminación de líneas de relacionamiento** con otras entidades.
- **Error corregido:** Campos con nombres poco descriptivos y problemas en el mapeo de columnas.
- **Solución:** Usar nombres más claros y coherentes con la base de datos.

---

### Usuario.java
- **Paquete anterior:** `com.example.Examen1Back2.modelos`
- **Paquete nuevo:** `com.example.APIExamenBack.modelos`
- **Cambios:**
  - Líneas afectadas: **5, 11, 17, 41 en adelante**
  - Adición de `TipoUsuario` como enumeración externa (`ayudas/TipoUsuario.java`).
  - Ajuste de tipo de datos para compatibilidad con MySQL.
  - **Creación de Getters y Setters** para todos los atributos.
  - **Eliminación de líneas de relacionamiento** con otras entidades.
- **Error corregido:** Uso de valores "mágicos" para roles en lugar de un enum.
- **Solución:** Implementar un `enum` para centralizar y controlar los tipos de usuario.

---

### Estructura de Proyecto
- Se eliminaron directorios y archivos de Gradle (`gradlew`, `.gradle`, `settings.gradle`).
- Se añadieron scripts y configuración de Maven (`mvnw`, `.mvn/wrapper/maven-wrapper.properties`).
- Se reorganizaron paquetes para seguir la convención `com.example.APIExamenBack`.

---

## Guía de Conexión a la Base de Datos (XAMPP + phpMyAdmin)

1. **Instalar XAMPP** y asegurarse de iniciar los módulos **Apache** y **MySQL**.  
2. Abrir **phpMyAdmin** desde [http://localhost/phpmyadmin](http://localhost/phpmyadmin).  
3. Crear una nueva base de datos llamada: **develop_db**
4. Crear las tablas necesarias según el modelo de datos (`Curso`, `Docente`, `Usuario`).  
5. Editar el archivo `src/main/resources/application.properties` con:  
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/develop_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
6. Guardar cambios y ejecutar la aplicación: `mvn spring-boot:run`

---

## Recomendaciones para Evitar Errores Similares

- Usar siempre un administrador de dependencias estándar (Maven o Gradle) y mantenerlo actualizado.
- Documentar credenciales y configuración de conexión en un archivo seguro.
- Mantener consistencia en nombres de paquetes y clases para evitar conflictos.
- Probar la conexión a la base de datos antes de desplegar.
- Realizar commits frecuentes y descriptivos en Git.
- Separar la lógica de negocio de la capa de acceso a datos para facilitar mantenibilidad.
