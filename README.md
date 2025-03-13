# ✅ Organizador de Tareas Personal

**Organizador de Tareas Personal** es una aplicación de gestión de tareas desarrollada en **Spring Boot y React.js**, diseñada para permitir a los usuarios crear, administrar y priorizar sus tareas diarias de manera eficiente.

---

## 🚀 Tecnologías Utilizadas

- **Backend:** Spring Boot (Java) + MySQL
- **Frontend:** React.js + Vite
- **Base de Datos:** MySQL con JPA/Hibernate
- **Estilos:** CSS + Material UI
- **Autenticación:** JWT para sesiones seguras

---

## 📂 Estructura del Proyecto

```
organizador-tareas/
│── backend/
│   ├── src/main/java/com/example/tareas/
│   │   ├── controller/   # Controladores REST
│   │   ├── model/        # Modelos de datos (Tarea, Usuario)
│   │   ├── repository/   # Repositorios JPA
│   │   ├── service/      # Lógica de negocio
│   ├── application.properties  # Configuración de la BD
│── frontend/
│   ├── src/
│   │   ├── components/   # Componentes reutilizables (Botones, Modal)
│   │   ├── pages/        # Páginas principales (Home, Login, Tareas)
│   │   ├── services/     # Llamadas a la API
│   │   ├── App.jsx       # Punto de entrada React
│── README.md
```

---

## 🎨 Funcionalidades

### 1️⃣ **Gestión de Tareas**
- Agregar, editar y eliminar tareas.
- Organizar tareas por prioridad y fecha.

### 2️⃣ **Autenticación de Usuarios**
- Registro e inicio de sesión con **JWT**.
- Protección de rutas en React con **PrivateRoute**.

### 3️⃣ **Notificaciones y Recordatorios**
- Alertas visuales de tareas próximas.
- Envío de recordatorios por correo electrónico.

### 4️⃣ **Interfaz Responsiva**
- Adaptación automática a dispositivos móviles.

---

## 📊 Base de Datos (MySQL)

**Ejemplo de tabla `tareas`**:
```sql
CREATE TABLE tareas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    prioridad ENUM('Baja', 'Media', 'Alta') NOT NULL,
    fecha_vencimiento DATE,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
```

**Ejemplo de modelo en Java:**
```java
@Entity
public class Tarea {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private LocalDate fechaVencimiento;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
```

---

## 🔧 Instalación y Ejecución

### **Backend (Spring Boot)**
1️⃣ Clona el repositorio:
```sh
git clone https://github.com/Pabloob/organizador-tareas.git
```

2️⃣ Configura MySQL en `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/organizador_tareas
spring.datasource.username=root
spring.datasource.password=tu_password
```

3️⃣ Ejecuta el backend:
```sh
mvn spring-boot:run
```

### **Frontend (React.js)**
1️⃣ Accede al directorio `frontend`:
```sh
cd frontend
```

2️⃣ Instala dependencias:
```sh
npm install
```

3️⃣ Ejecuta la aplicación:
```sh
npm run dev
```

---

## 📢 Despliegue

Para desplegar el backend en un servidor:
```sh
mvn package
java -jar target/organizador-tareas.jar
```

Para el frontend, usa **Vercel o Netlify**:
```sh
npm run build
```

---

## 📌 Autor

**Pablo Orbea Benitez** – [GitHub](https://github.com/Pabloob) | [LinkedIn](https://www.linkedin.com/in/pabloob5)

✅ ¡Organiza tus tareas y mejora tu productividad con esta app! 🚀
