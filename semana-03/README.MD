# Semana 02 - Gestión de Campañas Publicitarias

## Descripción

Esta semana se implementó un sistema mejorado de gestión de campañas publicitarias con enfoque en diseño orientado a objetos y reutilización de código. Se crearon las clases AdCampaign, Client, Designer y SocialMediaPost, junto con un programa Main para demostrar su funcionamiento.

El sistema implementa un modelo básico pero escalable que permite gestionar campañas publicitarias, información de clientes, diseñadores especializados y contenido de redes sociales de forma integrada.

---

## Objetivos Cumplidos

- Implementar clase principal del dominio (AdCampaign)
- Implementar clases secundarias relacionadas (Client, Designer, SocialMediaPost)
- Crear programa de demostración (Main.java)
- Documentar análisis del dominio (ANALISIS.md)
- Estructurar relaciones entre objetos (1:N)
- Implementar métodos de acceso controlado (Getters y Setters)

---

## Archivos Entregados

### Código Fuente

- src/AdCampaign.java - Clase principal que representa una campaña publicitaria con código, cliente y presupuesto
- src/Client.java - Clase que representa a los clientes con información de contacto e industria
- src/Designer.java - Clase que representa diseñadores especializados con experiencia
- src/SocialMediaPost.java - Clase que representa posts de redes sociales como entregables de campañas
- src/Main.java - Programa de demostración que crea instancias y muestra información

### Documentación

- docs/ANALISIS.md - Análisis completo del dominio con diagrama de clases, decisiones de diseño y comparativas
- README.md - Este archivo con instrucciones e información general

---

## Estructura del Proyecto

```
Semana02_GestionCampanias/
│
├── src/
│   ├── AdCampaign.java
│   ├── Client.java
│   ├── Designer.java
│   ├── SocialMediaPost.java
│   └── Main.java
│
├── docs/
│   └── ANALISIS.md
│
└── README.md
```

---

## Clases Implementadas

### 1. AdCampaign

Clase principal que gestiona las campañas publicitarias.

Atributos:
- campaignCode (String) - Identificador único de la campaña
- clientName (String) - Nombre del cliente asociado
- budget (double) - Presupuesto total en pesos colombianos

Métodos:
- AdCampaign(String, String, double) - Constructor
- showInfo() - Muestra información de la campaña
- Getters: getCampaignCode(), getClientName(), getBudget()
- Setters: setCampaignCode(), setClientName(), setBudget()

Ejemplo:
```
AdCampaign camp = new AdCampaign("CAMP-001", "TechCorp", 15000000);
camp.showInfo();
```

Salida:
```
Campaña No.: CAMP-001
Cliente: TechCorp
Presupuesto: $15000000.0
```

---

### 2. Client

Clase que representa a los clientes de la agencia.

Atributos:
- clientName (String) - Nombre del cliente
- industry (String) - Sector o industria
- contactEmail (String) - Correo electrónico de contacto

Métodos:
- Client(String, String, String) - Constructor
- showInfo() - Muestra información del cliente
- Getters: getClientName(), getIndustry(), getContactEmail()
- Setters: setClientName(), setIndustry(), setContactEmail()

Ejemplo:
```
Client client = new Client("TechCorp", "Tecnología", "contacto@techcorp.co");
client.showInfo();
```

Salida:
```
Cliente: TechCorp
Industria: Tecnología
Correo: contacto@techcorp.co
```

---

### 3. Designer

Clase que representa a los diseñadores de la agencia.

Atributos:
- name (String) - Nombre del diseñador
- specialization (String) - Área de especialidad (Branding, Gráficos, UX, etc.)
- yearsExperience (int) - Años de experiencia

Métodos:
- Designer(String, String, int) - Constructor
- showInfo() - Muestra información del diseñador
- Getters: getName(), getSpecialization(), getYearsExperience()
- Setters: setName(), setSpecialization(), setYearsExperience()

Ejemplo:
```
Designer designer = new Designer("Laura Gómez", "Branding", 5);
designer.showInfo();
```

Salida:
```
Diseñador: Laura Gómez
Especialidad: Branding
Experiencia: 5 años
```

---

### 4. SocialMediaPost

Clase que representa los posts de redes sociales.

Atributos:
- postId (String) - Identificador único del post
- platform (String) - Plataforma (Instagram, Facebook, TikTok, etc.)
- content (String) - Contenido del post

Métodos:
- SocialMediaPost(String, String, String) - Constructor
- showInfo() - Muestra información del post
- Getters: getPostId(), getPlatform(), getContent()
- Setters: setPostId(), setPlatform(), setContent()

Ejemplo:
```
SocialMediaPost post = new SocialMediaPost("POST-1001", "Instagram", "Lanzamiento de nuevo producto");
post.showInfo();
```

Salida:
```
Post ID: POST-1001
Plataforma: Instagram
Contenido: Lanzamiento de nuevo producto
```

---

## Relaciones entre Clases

- Un Client puede tener múltiples AdCampaign (relación 1:N)
- Una AdCampaign puede asignar múltiples Designer (relación 0:N)
- Una AdCampaign puede contener múltiples SocialMediaPost (relación 1:N)

---

## Instrucciones de Ejecución

### Compilación

Abrir terminal en el directorio del proyecto y ejecutar:

```
cd src
javac *.java
```

### Ejecución

```
java Main
```

### Salida Esperada

```
Campaña No.: CAMP-001
Cliente: TechCorp
Presupuesto: $15000000.0
-----------------------------------
Cliente: TechCorp
Industria: Tecnología
Correo: contacto@techcorp.co
-----------------------------------
Diseñador: Laura Gómez
Especialidad: Branding
Experiencia: 5 años
-----------------------------------
Post ID: POST-1001
Plataforma: Instagram
Contenido: Lanzamiento de nuevo producto
-----------------------------------
```

---

## Decisiones de Diseño

### 1. Modelo Simplificado

Se optó por un modelo simple y enfocado, sin complejidades innecesarias. Cada clase tiene una responsabilidad única y clara.

### 2. Uso de Getters y Setters

Se implementaron métodos de acceso controlado para proteger los atributos privados y facilitar futuras validaciones.

### 3. Método showInfo()

Cada clase implementa showInfo() para proporcionar una representación legible de sus datos.

### 4. Constructor Simple

Los constructores reciben los parámetros esenciales, inicializando todos los atributos de forma inmediata.

---

## Conceptos de POO Aplicados

Encapsulación: Atributos privados con acceso mediante getters y setters
Cohesión: Cada clase tiene una responsabilidad específica
Abstracción: Cada clase abstrae un concepto del dominio
Reutilización: Las clases pueden ser usadas en múltiples contextos
Independencia: Las clases son independientes pero relacionables

---

## Mejoras Futuras

1. Colecciones: Agregar ArrayList para gestionar múltiples campañas, diseñadores y posts
2. Métodos de Cálculo: Implementar calculateDailyCost() para análisis financiero
3. Validaciones: Agregar excepciones personalizadas para entradas inválidas
4. Persistencia: Conectar con base de datos para almacenar datos
5. Interfaz Gráfica: Crear interfaz de usuario
6. Reportes: Generar reportes de campañas y presupuestos

---

## Autor

Estudiante de Programación Orientada a Objetos
Semana 02 - Gestión de Campañas Publicitarias

---

## Estado del Proyecto

Estado: Completado
Versión: 2.0
Última Actualización: Semana 02