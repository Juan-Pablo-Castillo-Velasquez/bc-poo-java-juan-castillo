# 🧩 Semana 06 – Abstracción e Interfaces
## 📘 Sistema Avanzado de Gestión de Campañas Publicitarias

Este proyecto implementa **clases abstractas**, **interfaces** y **principios SOLID** para crear una arquitectura más flexible y extensible en el sistema de campañas publicitarias.

---

## 📂 Archivos Incluidos

- `abstractas/Campaign.java` — Clase abstracta base
- `interfaces/Measurable.java` — Interface para métricas
- `interfaces/Budgetable.java` — Interface para presupuestos
- `interfaces/Reportable.java` — Interface para reportes
- `implementaciones/DigitalCampaign.java` — Implementación concreta
- `implementaciones/TraditionalCampaign.java` — Implementación concreta
- `Main.java` — Demostración completa
- `README.md` — Documentación del sistema
- `ANALISIS.md` — Análisis de diseño

---

## 🚀 ¿Qué se aplicó?

### ✔ Clases Abstractas
- `Campaign` con métodos abstractos y concretos
- Atributos protegidos para herencia
- Constructores base

### ✔ Interfaces Múltiples
- `Measurable` - capacidad de medición
- `Budgetable` - gestión de presupuesto
- `Reportable` - generación de reportes

### ✔ Principios SOLID
- **SRP** - Responsabilidades separadas
- **OCP** - Extensible sin modificar
- **LSP** - Sustituibilidad de subtipos
- **ISP** - Interfaces segregadas
- **DIP** - Dependencia de abstracciones

### ✔ Polimorfismo Avanzado
- Múltiple implementación de interfaces
- Referencias por tipo abstracto e interface
- Comportamiento específico por clase concreta

---

## 🔧 Ejecución

```bash
cd semana-06
javac abstractas/*.java interfaces/*.java implementaciones/*.java Main.java
java Main