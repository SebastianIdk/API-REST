# Empleado API

[![Java 17](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)]
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.2-green?logo=spring&logoColor=white)]
[![VS Code](https://img.shields.io/badge/IDE-VS%20Code-blue?logo=visual-studio-code&logoColor=white)]
[![Spring Tools](https://img.shields.io/badge/IDE-Spring_Tools-brightgreen?logo=spring&logoColor=white)]
[![Maven Wrapper](https://img.shields.io/badge/Build-Maven_Wrapper-red?logo=maven&logoColor=white)]

- Pequeña API REST para gestionar **empleados** con atributos:  
- ID, nombre, apellido, edad, sueldo, email, años de experiencia y teléfono.

---

## 📁 Estructura del proyecto

```
empleado/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── puce
                    └── empleado
                        ├── EmpleadoApplication.java
                        ├── model
                        │   └── EmpleadoModel.java
                        ├── repository
                        │   └── EmpleadoRepository.java
                        ├── service
                        │   └── EmpleadoService.java
                        └── controller
                            └── EmpleadoController.java
```

---

## 🛠 Recursos

- **Lenguaje**: Java 17  
- **Framework**: Spring Boot 3.5.2  
- **Build**: Maven Wrapper (`mvnw`, `mvnw.cmd`)  
- **IDE**: VS Code + Java Extension Pack o Spring Tools Suite  

---

## 🚀 Cómo ejecutar

### En VS Code

1. Abre la carpeta del proyecto (`File → Open Folder...`).  
2. Refresca el panel **Maven Projects**.  
3. Ejecuta en terminal integrada:
   ```powershell
   .\mvnw.cmd clean package
   .\mvnw.cmd spring-boot:run
   ```
4. O haz clic en ▶️ junto a `EmpleadoApplication.java` o en `Lifecycle → spring-boot:run`.

### En Spring Tools Suite (STS)

1. Abre STS y elige **File → Import → Maven → Existing Maven Projects**.  
2. Selecciona la carpeta raíz (`empleado/`) y finaliza.  
3. En el panel **Package Explorer**, haz clic derecho en `EmpleadoApplication.java` → **Run As → Spring Boot App**.  
4. Espera a que la consola indique `Started EmpleadoApplication` en `8080`.

La API quedará disponible en:  
```
http://localhost:8080/api/v1/empleados
```

---

## ⚙️ Endpoints

| Verbo    | Ruta                            | Descripción                                    |
|:---------|:--------------------------------|:-----------------------------------------------|
| **POST**   | `/api/v1/empleados`             | Guardar nuevo empleado (envía JSON)            |
| **GET**    | `/api/v1/empleados`             | Listar todos los empleados                     |
| **GET**    | `/api/v1/empleados/{id}`        | Obtener empleado por ID                        |
| **GET**    | `/api/v1/empleados/email/{email}` | Obtener empleado por email                     |
| **GET**    | `/api/v1/empleados/sueldo-mayor?min=1000` | Listar empleados con sueldo > 1000         |
| **GET**    | `/api/v1/empleados/experiencia-mayor?min=5` | Listar con experiencia > 5 años          |
| **PUT**    | `/api/v1/empleados/{id}`        | Actualizar empleado (envía JSON sin el campo id) |
| **DELETE** | `/api/v1/empleados/{id}`        | Eliminar empleado por ID                       |

---

> Proyecto desarrollado para la asignatura de Arquitectura Empresarial.  


