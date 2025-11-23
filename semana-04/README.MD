# 🧩 Semana 04 – Herencia y Polimorfismo
## 📘 Sistema de Gestión de Campañas Publicitarias

Este proyecto implementa una **jerarquía de herencia** para modelar diferentes tipos de campañas publicitarias en una agencia de marketing digital. Se aplican conceptos de **POO**, como herencia, especialización, métodos sobrescritos, `super()`, polimorfismo y uso de `ArrayList` polimórfico.

---

## 🎯 Objetivos

- [x] Implementar superclase `Campaign`
- [x] Crear subclases especializadas (`DigitalCampaign`, `TraditionalCampaign`)
- [x] Aplicar herencia, protected, @Override y super()
- [x] Usar polimorfismo para gestionar campañas en un solo ArrayList
- [x] Documentar la jerarquía y su funcionamiento

---

## 📂 Archivos Entregados

- `src/Campaign.java` – Superclase con atributos y métodos base
- `src/DigitalCampaign.java` – Subclase para campañas digitales
- `src/TraditionalCampaign.java` – Subclase para campañas tradicionales
- `src/Main.java` – Ejecución y demostración de polimorfismo
- `docs/README.md` – Documentación de la jerarquía

---

## 📐 Diagrama de Clases UML

``` mermaid
classDiagram
    class Campaign {
        #String campaignCode
        #String clientName
        #double budget
        #String status
        +Campaign(String, String, double)
        #double calculateCost()
        #void showBaseInfo()
        +void showInfo()
    }

    class DigitalCampaign {
        -String platform
        -int targetAudience
        -double engagementRate
        +DigitalCampaign(String, String, double, String, int)
        +double calculateCost()*
        +void showInfo()*
        +void simulateEngagement(double)
    }

    class TraditionalCampaign {
        -String medium
        -int durationDays
        -double reachPercentage
        +TraditionalCampaign(String, String, double, String, int)
        +double calculateCost()*
        +void showInfo()*
        +void updateReach(double)
    }

    Campaign <|-- DigitalCampaign
    Campaign <|-- TraditionalCampaign
```
🏛️ Estructura de la Jerarquía

🟦 Superclase: Campaign
Define la estructura común:
- Código de campaña
- Cliente
- Presupuesto
- Estado

Contiene métodos básicos reutilizables como showBaseInfo() y calculateCost().

🟩 Subclase: DigitalCampaign
Especializa campañas digitales agregando:
- Plataforma
- Audiencia objetivo
- Engagement

Sobrescribe:

@Override
protected double calculateCost()

@Override
public void showInfo()

🟨 Subclase: TraditionalCampaign
Especializa campañas tradicionales con:
- Medio (TV, radio, prensa)
- Duración
- Porcentaje de alcance

Sobrescribe:

@Override
protected double calculateCost()

@Override
public void showInfo()

🔄 Polimorfismo Implementado

ArrayList<Campaign> campaigns = new ArrayList<>();

campaigns.add(new DigitalCampaign(...));
campaigns.add(new TraditionalCampaign(...));

for (Campaign c : campaigns) {
c.showInfo();
c.calculateCost();
}

Acceso a métodos específicos mediante instanceof.

🚀 Ejecución

cd src
javac *.java
java Main

📌 Conceptos Aplicados
- Herencia simple
- Atributos y métodos protected
- Uso de super() en constructores
- Sobreescritura con @Override
- Polimorfismo en colecciones
- Uso de instanceof
- Código reutilizable y extensible

🧩 Conclusión
La jerarquía implementada permite extender fácilmente el sistema agregando nuevas campañas sin modificar código existente. El diseño aplica principios como OCP, LSP y DRY, logrando un código limpio, organizado y mantenible.
