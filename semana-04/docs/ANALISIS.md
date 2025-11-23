# Semana 04 - Herencia en Gestión de Campañas Publicitarias

## Descripción

Esta semana se implementó un sistema avanzado de gestión de campañas publicitarias utilizando herencia y polimorfismo. Se creó una clase padre `Campaign` y dos subclases especializadas `DigitalCampaign` y `TraditionalCampaign`, junto con un programa `Main` que utiliza `ArrayList` para demostrar el funcionamiento del sistema.

El sistema implementa un modelo orientado a objetos que permite gestionar diferentes tipos de campañas publicitarias de forma polimórfica, reutilizando el código común y especializando el comportamiento según el tipo de campaña.

---

## Objetivos Cumplidos

- Implementar clase padre con atributos `protected`
- Implementar mínimo 2 subclases con `extends`
- Usar `super()` en constructores de subclases
- Implementar métodos con `@Override`
- Crear array polimórfico usando `ArrayList`
- Documentar la jerarquía de clases con diagrama UML
- Aplicar conceptos de encapsulación, herencia y polimorfismo

---

## Estructura del Proyecto

```
semana-04/
├── README.md
├── Campaign.java
├── DigitalCampaign.java
├── TraditionalCampaign.java
├── Main.java
└── JERARQUIA.md
```

---

## Clases Implementadas

### 1. Campaign.java (Clase Padre)

Clase base que define la estructura común de todas las campañas publicitarias.

**Atributos Protegidos:**
- `protected String campaignCode` - Código identificador único de la campaña
- `protected String clientName` - Nombre del cliente
- `protected double budget` - Presupuesto base de la campaña
- `protected String status` - Estado de la campaña (Activa, Inactiva)

**Métodos Principales:**
- `Campaign(String, String, double)` - Constructor
- `protected double calculateCost()` - Calcula el costo (puede ser sobrescrito)
- `protected void showBaseInfo()` - Muestra información base
- `public void showInfo()` - Muestra información completa
- Getters y Setters para acceso controlado a atributos

**Características:**
- Atributos `protected` para acceso desde subclases
- Métodos `protected` para operaciones internas
- Método `showInfo()` para ser sobrescrito en subclases

---

### 2. DigitalCampaign.java (Subclase 1)

Subclase que representa campañas publicitarias en medios digitales.

**Herencia:**
```java
public class DigitalCampaign extends Campaign
```

**Atributos Adicionales:**
- `private String platform` - Plataforma (Instagram, Facebook, TikTok, etc.)
- `private int targetAudience` - Cantidad de personas en la audiencia objetivo
- `private double engagementRate` - Tasa de engagement del público

**Constructor:**
```java
public DigitalCampaign(String campaignCode, String clientName, double budget, 
                      String platform, int targetAudience) {
    super(campaignCode, clientName, budget);
    this.platform = platform;
    this.targetAudience = targetAudience;
    this.engagementRate = 0.0;
}
```

**Métodos Sobrescritos:**

```java
@Override
protected double calculateCost() {
    return super.getBudget() + (targetAudience * 0.50);
}

@Override
public void showInfo() {
    super.showBaseInfo();
    System.out.println("Tipo: Campana Digital");
    System.out.println("Plataforma: " + platform);
    System.out.println("Audiencia Objetivo: " + targetAudience + " personas");
    System.out.println("Tasa de Engagement: " + engagementRate + "%");
    System.out.println("Costo Total: $" + calculateCost());
    System.out.println("-----------------------------------");
}
```

**Métodos Adicionales:**
- `simulateEngagement(double rate)` - Simula el engagement obtenido

---

### 3. TraditionalCampaign.java (Subclase 2)

Subclase que representa campañas publicitarias en medios tradicionales.

**Herencia:**
```java
public class TraditionalCampaign extends Campaign
```

**Atributos Adicionales:**
- `private String medium` - Medio de publicidad (TV, Radio, Prensa, etc.)
- `private int durationDays` - Duración de la campaña en días
- `private double reachPercentage` - Porcentaje de alcance en la población

**Constructor:**
```java
public TraditionalCampaign(String campaignCode, String clientName, double budget, 
                          String medium, int durationDays) {
    super(campaignCode, clientName, budget);
    this.medium = medium;
    this.durationDays = durationDays;
    this.reachPercentage = 0.0;
}
```

**Métodos Sobrescritos:**

```java
@Override
protected double calculateCost() {
    return (super.getBudget() / durationDays) * durationDays;
}

@Override
public void showInfo() {
    super.showBaseInfo();
    System.out.println("Tipo: Campana Tradicional");
    System.out.println("Medio: " + medium);
    System.out.println("Duracion: " + durationDays + " dias");
    System.out.println("Alcance: " + reachPercentage + "%");
    System.out.println("Costo Diario: $" + (calculateCost() / durationDays));
    System.out.println("Costo Total: $" + calculateCost());
    System.out.println("-----------------------------------");
}
```

**Métodos Adicionales:**
- `updateReach(double reach)` - Actualiza el alcance de la campaña

---

### 4. Main.java (Programa Principal)

Programa de demostración que implementa polimorfismo y ArrayList.

**ArrayList Polimórfico:**
```java
ArrayList<Campaign> campaigns = new ArrayList<Campaign>();

campaigns.add(new DigitalCampaign("DCAMP-001", "TechCorp", 5000000, "Instagram", 50000));
campaigns.add(new TraditionalCampaign("TCAMP-001", "GlobalBrand", 3000000, "Television", 30));
campaigns.add(new DigitalCampaign("DCAMP-002", "FashionCo", 2500000, "Facebook", 75000));
campaigns.add(new TraditionalCampaign("TCAMP-002", "AutomotiveCorp", 4000000, "Radio", 45));
campaigns.add(new DigitalCampaign("DCAMP-003", "EcommercePro", 1800000, "TikTok", 100000));
```

**Operaciones con ArrayList:**
- `add()` - Agregar nuevas campañas
- `get()` - Acceder a elementos específicos
- `size()` - Obtener cantidad de campañas
- `remove()` - Eliminar campañas

**Métodos Polimórficos:**

```java
public static double calculateTotalBudget(ArrayList<Campaign> campaigns) {
    double total = 0;
    for (Campaign campaign : campaigns) {
        total += campaign.calculateCost();
    }
    return total;
}

public static void listarCampanasPorTipo(ArrayList<Campaign> campaigns) {
    int digitalCount = 0;
    int traditionalCount = 0;
    
    for (Campaign campaign : campaigns) {
        if (campaign instanceof DigitalCampaign) {
            digitalCount++;
        } else if (campaign instanceof TraditionalCampaign) {
            traditionalCount++;
        }
    }
    
    System.out.println("Campanas Digitales: " + digitalCount);
    System.out.println("Campanas Tradicionales: " + traditionalCount);
}
```

---

## Conceptos de POO Implementados

### 1. Encapsulación

- Atributos privados en subclases
- Atributos protegidos en clase padre para acceso controlado desde subclases
- Métodos públicos como interfaz de control

### 2. Herencia

- `DigitalCampaign extends Campaign`
- `TraditionalCampaign extends Campaign`
- Reutilización de código común de la clase padre
- Acceso a atributos y métodos protegidos

### 3. Polimorfismo

- Método `calculateCost()` sobrescrito con lógica diferente en cada subclase
- Método `showInfo()` adaptado según el tipo de campaña
- ArrayList que contiene referencias de tipo `Campaign`
- Llamadas a métodos resueltas en tiempo de ejecución

### 4. super()

Llamada al constructor de la clase padre desde las subclases:

```java
super(campaignCode, clientName, budget);
```

### 5. @Override

Anotación que indica métodos sobrescritos:

```java
@Override
protected double calculateCost() { ... }

@Override
public void showInfo() { ... }
```

### 6. instanceof

Verificación de tipos en tiempo de ejecución:

```java
if (campaign instanceof DigitalCampaign) {
    // Código específico para campañas digitales
}
```

---

## Instrucciones de Ejecución

### Compilación

Abrir terminal en el directorio del proyecto y ejecutar:

```bash
javac Campaign.java
javac DigitalCampaign.java
javac TraditionalCampaign.java
javac Main.java
```

O compilar todos a la vez:

```bash
javac *.java
```

### Ejecución

```bash
java Main
```

---

## Salida Esperada

```
====== CAMPANAS PUBLICITARIAS ======

--- Listado de Campanas ---

Codigo: DCAMP-001
Cliente: TechCorp
Presupuesto: $5000000.0
Estado: Activa
Tipo: Campana Digital
Plataforma: Instagram
Audiencia Objetivo: 50000 personas
Tasa de Engagement: 0.0%
Costo Total: $5025000.0
-----------------------------------

Codigo: TCAMP-001
Cliente: GlobalBrand
Presupuesto: $3000000.0
Estado: Activa
Tipo: Campana Tradicional
Medio: Television
Duracion: 30 dias
Alcance: 0.0%
Costo Diario: $100000.0
Costo Total: $3000000.0
-----------------------------------

Codigo: DCAMP-002
Cliente: FashionCo
Presupuesto: $2500000.0
Estado: Activa
Tipo: Campana Digital
Plataforma: Facebook
Audiencia Objetivo: 75000 personas
Tasa de Engagement: 0.0%
Costo Total: $2537500.0
-----------------------------------

Codigo: TCAMP-002
Cliente: AutomotiveCorp
Presupuesto: $4000000.0
Estado: Activa
Tipo: Campana Tradicional
Medio: Radio
Duracion: 45 dias
Alcance: 0.0%
Costo Diario: $88888.89
Costo Total: $4000000.0
-----------------------------------

Codigo: DCAMP-003
Cliente: EcommercePro
Presupuesto: $1800000.0
Estado: Activa
Tipo: Campana Digital
Plataforma: TikTok
Audiencia Objetivo: 100000 personas
Tasa de Engagement: 0.0%
Costo Total: $1850000.0
-----------------------------------

Presupuesto Total de Campanas: $16412500.0
Total de Campanas: 5

====== ACTUALIZACIONES ======

Engagement actualizado a: 8.5%
Alcance actualizado a: 65.0%

====== DEMOSTRACION DE HERENCIA ======

Acceso a atributos protegidos de Campaign desde subclases:
Campana 0 - Codigo: DCAMP-001
Campana 0 - Cliente: TechCorp
Campana 0 - Presupuesto: 5000000.0
Campana 0 - Estado: Activa

====== LISTAR CAMPANAS POR TIPO ======

Campanas Digitales: 3
Campanas Tradicionales: 2

====== REMOVER CAMPANA ======

Campana removida: DCAMP-002
Total de campanas ahora: 4

====== AGREGAR NUEVA CAMPANA ======

Nueva campana agregada
Total de campanas ahora: 5
```

---

## Comparativa de Características

| Característica | DigitalCampaign | TraditionalCampaign |
|---|---|---|
| **Plataforma** | Instagram, Facebook, TikTok, etc. | Television, Radio, Prensa, etc. |
| **Audiencia** | Cantidad de personas | Porcentaje de alcance |
| **Cálculo de Costo** | Presupuesto + (audiencia * 0.50) | Presupuesto / duración * duración |
| **Métodos Específicos** | simulateEngagement() | updateReach() |
| **Duración** | No especificada | En días |

---

## Checklist de Entrega

- [x] Clase padre `Campaign` con atributos `protected`
- [x] Subclase `DigitalCampaign` con `extends Campaign`
- [x] Subclase `TraditionalCampaign` con `extends Campaign`
- [x] `super()` en constructores de subclases
- [x] Métodos `@Override` implementados
- [x] Array polimórfico con `ArrayList<Campaign>`
- [x] Operaciones de ArrayList (add, get, size, remove)
- [x] Método `instanceof` para verificar tipos
- [x] Polimorfismo completo funcionando
- [x] README.md documentado
- [x] JERARQUIA.md con diagrama UML

---

## Mejoras Futuras

1. Agregar más tipos de campañas (Campañas Híbridas, Email Marketing, etc.)
2. Implementar interfaz `Comparable` para ordenar campañas
3. Agregar validaciones y manejo de excepciones
4. Crear clase `CampaignManager` para gestionar las campañas
5. Implementar persistencia con archivos o base de datos
6. Agregar métodos de búsqueda y filtrado de campañas
7. Crear reportes detallados por tipo de campaña

---

## Commit Recomendado

```bash
git add .
git commit -m "feat(semana-04): Implementar herencia en gestion de campanas publicitarias"
git push origin main
```

---

## Autor

**Estudiante de Programación Orientada a Objetos**

Semana 04 - Herencia, Polimorfismo y ArrayList

---

## Estado del Proyecto

**Estado:** Completado

**Versión:** 4.0

**Última Actualización:** Semana 04

---

## Referencias Teóricas

### Herencia en Java

La herencia permite que una clase (subclase) herede los atributos y métodos de otra clase (clase padre). En este proyecto, `DigitalCampaign` y `TraditionalCampaign` heredan de `Campaign`.

### Polimorfismo

El polimorfismo permite que objetos de diferentes tipos se traten de manera uniforme. En este caso, ambas subclases pueden ser almacenadas en un `ArrayList<Campaign>` y sus métodos se ejecutan según el tipo real del objeto.

### ArrayList vs Array

Un `ArrayList` es una estructura de datos dinámica que puede cambiar de tamaño, mientras que un array tiene tamaño fijo. En este proyecto se utiliza `ArrayList` para mayor flexibilidad en la gestión de campañas.

### super y @Override

`super()` se utiliza para llamar al constructor de la clase padre, y `@Override` es una anotación que indica que un método está siendo sobrescrito de la clase padre.