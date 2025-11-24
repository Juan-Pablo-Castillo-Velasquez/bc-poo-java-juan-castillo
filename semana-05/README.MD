# 🧩 Semana 05 – Sobrecarga, Sobrescritura y Polimorfismo
## 📘 Sistema de Gestión de Campañas Publicitarias (Marketing Digital)

Este proyecto amplía la jerarquía creada en la Semana 04, implementando **sobrecarga**, **sobrescritura** y **polimorfismo dinámico**, junto con una clase gestora capaz de manejar diferentes campañas bajo un mismo tipo base.

---

## 📂 Archivos Incluidos

- `Campaign.java` — Clase padre (métodos sobrescribibles)
- `DigitalCampaign.java` — Subclase con @Override
- `TraditionalCampaign.java` — Subclase con @Override
- `CampaignManager.java` — Sobrecarga + polimorfismo + ArrayList
- `Main.java` — Demostración completa
- `POLIMORFISMO.md` — Análisis de semana 05

---

## 🚀 ¿Qué se aplicó?

### ✔ Sobrescritura (@Override)
- `calculateCost()`
- `showInfo()`

### ✔ Sobrecarga (Overloading)
Métodos en `CampaignManager`:
- `buscarCampaña(String codigo)`
- `buscarCampaña(String cliente, double minimo)`
- `buscarCampaña(double presupuestoMin, double presupuestoMax)`

### ✔ Polimorfismo Dinámico
- `ArrayList<Campaign>`
- Llamadas dinámicas a métodos sobrescritos

---

## 🔧 Ejecución

```bash
cd semana-05
javac *.java
java Main
