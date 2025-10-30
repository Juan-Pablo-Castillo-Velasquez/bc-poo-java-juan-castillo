# Semana 01 - Introducción al Paradigma Orientado a Objetos

**Estudiante:** Juan Pablo Castillo Velasquez  
**Ficha:** 3228970A  
**Dominio Asignado:** Agencia de Publicidad "Creativa Digital"

---

## 📋 Contexto del Dominio

**Tipo de Negocio:** Agencia de Publicidad y Marketing  
**Nombre Comercial:** Creativa Digital  
**Ubicación:** Bogotá, Chicó  
**Especialidad:** Diseño gráfico, marketing digital, redes sociales, campañas publicitarias

### Descripción Breve
Creativa Digital es una agencia de publicidad que ofrece servicios de diseño gráfico, marketing digital, manejo de redes sociales, desarrollo de campañas publicitarias y producción audiovisual. Cuenta con 20 profesionales (diseñadores, publicistas, community managers) y gestiona 40 clientes activos.

---

## 🎯 Objetivos de la Semana 01

Al finalizar esta semana, deberás ser capaz de:

1. Identificar objetos del mundo real en el contexto de una agencia de publicidad
2. Comprender las diferencias entre programación estructurada y POO
3. Reconocer los conceptos fundamentales: clase, objeto, atributo, método
4. Crear tu primera clase simple en Java aplicada al dominio

---

## 📝 Actividades Obligatorias

### Actividad 1: Identificación de Objetos (Ejercicio 01)

**Instrucciones:**
- Lee el material teórico de la semana sobre conceptos fundamentales de POO
- Identifica **5 objetos principales** que existen en una agencia de publicidad
- Para cada objeto, describe:
  - ¿Qué es? (definición)
  - ¿Qué características tiene? (atributos)
  - ¿Qué puede hacer? (comportamientos/métodos)

**Ejemplo:**
```
Objeto: Campaña Publicitaria
- ¿Qué es?: Un proyecto de publicidad para un cliente
- Características: código de campaña, cliente, objetivo, presupuesto, fecha inicio, fecha fin
- Comportamientos: crear campaña, asignar equipo, actualizar presupuesto, generar reporte
```

**Entregable:** Documento con la identificación de 5 objetos del dominio de la agencia de publicidad.

---

### Actividad 2: Comparación de Paradigmas (Ejercicio 02)

**Instrucciones:**
- Investiga las diferencias entre programación estructurada y POO
- Escribe un ejemplo conceptual de cómo se manejaría la información de una campaña en:
  1. **Programación estructurada** (usando variables sueltas y funciones)
  2. **Programación orientada a objetos** (usando una clase)

**Entregable:** Documento comparativo con ejemplos explicados.

---

### Actividad 3: Primera Clase Simple (Ejercicio 03)

**Instrucciones:**
Crea tu primera clase en Java llamada `AdCampaign` (Campaña Publicitaria) con:
- **3 atributos** (ej: `campaignCode`, `clientName`, `budget`)
- **1 constructor** que inicialice los atributos
- **1 método** que muestre la información de la campaña

**Código de ejemplo:**

```java
public class AdCampaign {
    // Atributos
    String campaignCode;
    String clientName;
    double budget;
    
    // Constructor
    public AdCampaign(String campaignCode, String clientName, double budget) {
        this.campaignCode = campaignCode;
        this.clientName = clientName;
        this.budget = budget;
    }
    
    // Método para mostrar información
    public void showInfo() {
        System.out.println("Campaña No.: " + campaignCode);
        System.out.println("Cliente: " + clientName);
        System.out.println("Presupuesto: $" + budget);
    }
}
```

**Instrucciones adicionales:**
1. Crea una clase `Main` con el método `main`
2. Instancia **3 objetos diferentes** de tipo `AdCampaign`
3. Llama al método `showInfo()` para cada objeto

**Entregable:** Archivo `AdCampaign.java` y `Main.java` funcionando correctamente.

---

### Actividad 4: Múltiples Objetos (Ejercicio 04)

**Instrucciones:**
Amplía el ejercicio anterior:
- Crea al menos **5 objetos** de tipo `AdCampaign` con datos diferentes
- Cada campaña debe tener información coherente con una agencia real
- Muestra la información de todas las campañas

**Ejemplo de datos:**
- CAMP-001, TechCorp, $15000000
- CAMP-002, Fashion Boutique, $8000000
- CAMP-003, Restaurante Gourmet, $5000000
- CAMP-004, Gimnasio FitLife, $10000000
- CAMP-005, Universidad Digital, $20000000

**Entregable:** Código Java con 5 instancias de `AdCampaign` y su salida en consola.

---

## 🎓 Criterios de Evaluación

| Criterio | Peso | Descripción |
|----------|------|-------------|
| **Identificación de objetos** | 25% | Objetos identificados son relevantes al dominio de la agencia de publicidad |
| **Comprensión conceptual** | 25% | Demuestra entender diferencias entre paradigmas |
| **Implementación de clase** | 30% | Clase `AdCampaign` implementada correctamente con atributos, constructor y método |
| **Instanciación de objetos** | 20% | Crea múltiples objetos con datos coherentes |

---

## 📚 Recursos de Apoyo

### Material Teórico (Carpeta `1-teoria/`)
- `01-historia-evolucion-poo.md`
- `02-paradigmas-programacion.md`
- `03-conceptos-fundamentales-poo.md`
- `04-primer-programa-poo.md`

### Ejercicios Guiados (Carpeta `2-practica/`)
- `ejercicio-01-comparacion-paradigmas/`
- `ejercicio-02-primera-clase/`
- `ejercicio-03-multiples-objetos/`
- `ejercicio-04-modelado-mundo-real/`

### Glosario
Revisa el archivo `3-recursos/glosario.md` para términos clave de esta semana.

---

## 💡 Consejos

1. **No te compliques:** Esta semana es sobre conceptos básicos, no sobre código complejo
2. **Piensa en objetos reales:** Visualiza cómo funciona una agencia de publicidad real
3. **Pregunta:** Si tienes dudas sobre el dominio o los conceptos, consulta con el instructor
4. **Compila y prueba:** Asegúrate de que tu código compile antes de entregar

---

## 📅 Fecha de Entrega

**Entrega:** Según calendario definido por el instructor  
**Formato:** Código fuente (.java) y documentos en formato Markdown o PDF

---

**Nota Importante:** Este es tu dominio personal para todo el bootcamp. Todas las actividades futuras seguirán en el contexto de la agencia de publicidad Creativa Digital. No compartas tu código directamente con otros estudiantes, ya que cada uno tiene un dominio diferente.
