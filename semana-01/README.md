# Semana 2 - Programación Orientada a Objetos: Agencia de Marketing Digital

## 📝 Descripción

Sistema de gestión para una agencia de marketing digital que permite administrar clientes y sus campañas publicitarias. Implementa conceptos de POO como encapsulamiento, asociación entre clases y métodos de cálculo de costos.

## 🎯 Objetivos Cumplidos

- [x] Implementar clase principal del dominio (Client)
- [x] Implementar clase secundaria relacionada (AdCampaign)
- [x] Crear programa de demostración con 5 clientes y 5 campañas
- [x] Documentar análisis del dominio

## 📂 Archivos Entregados

- `src/Client.java` - Clase que representa clientes de la agencia con atributos como ID, nombre, industria y tipo premium
- `src/AdCampaign.java` - Clase que gestiona campañas publicitarias con presupuesto, duración y cálculo de costos diarios
- `src/Main.java` - Programa de demostración que crea clientes, campañas y muestra información del sistema
- `docs/ANALISIS.md` - Análisis del dominio con identificación de objetos, relaciones y decisiones de diseño

## 🚀 Instrucciones de Ejecución
```bash
cd src
javac *.java
java Main
```

## 💡 Conceptos Aplicados

- Encapsulamiento (atributos private con getters)
- Asociación entre clases (Client - AdCampaign)
- Métodos de instancia y cálculos
- Constructores parametrizados
- Tipos de datos primitivos y referenciados

## 📊 Salida Esperada

El programa muestra:
- Listado de 5 clientes registrados con sus datos
- 5 campañas publicitarias con presupuestos y duración
- Cálculo automático del costo diario de cada campaña
- Ejemplo de desactivación de campaña