# 📇 Agenda de Contactos (Java)

---

## 🎯 Objetivo del proyecto

Practicar y aplicar conceptos clave de programación en Java:
- Clases, objetos y encapsulamiento.
- Arreglos dinámicos mediante `ArrayList`.
- Estructuras de control (`while`, `switch`, `if-else`).
- Métodos organizados por responsabilidad única.
- Entrada y salida de datos por consola de forma robusta.
- Arquitectura básica dividida en capas (Modelo, Servicio, Vista, Utilidades).

---

## 🛠️ Estructura del Proyecto

El código está organizado bajo el directorio `src/` con la siguiente estructura de paquetes:
- `model`: Contiene la definición del modelo de datos de la aplicación ([Contacto.java](src/model/Contacto.java)).
- `servicio`: Lógica de negocio para administrar y gestionar los contactos ([GestorContactos.java](src/servicio/GestorContactos.java)).
- `vista`: Interface gráfica de consola interactiva ([Menu.java](src/vista/Menu.java)).
- `utils`: Clases de soporte para la validación y captura segura de datos por consola ([UtilInputs.java](src/utils/UtilInputs.java)).

---

## ✨ Funcionalidades y Mejoras de Estabilidad

### Funciones Principales:
- **Agregar contacto:** Permite registrar nombre, teléfono y correo electrónico.
- **Listar contactos:** Despliega todos los contactos registrados de manera formateada en la interfaz de consola.
- **Buscar contacto:** Localiza un contacto mediante coincidencia exacta e insensible a mayúsculas.
- **Modificar datos:** Edita el teléfono y correo electrónico del contacto por ID, mostrando los valores previos.
- **Eliminar contacto:** Remueve un contacto de la lista por ID con una advertencia y paso de confirmación previo.

### Mejoras de Estabilidad e Integridad:
- **Prevención de Caídas:** Gestión robusta de excepciones al ingresar caracteres inválidos donde se esperan enteros (evita caídas por `InputMismatchException`).
- **Unificación de Entrada:** Uso centralizado del flujo de lectura (`System.in`) a través de `UtilInputs` para prevenir colisiones e hilos de lectura bloqueados.
- **Modificación Inteligente:** Permite dejar en blanco (presionar Enter) los campos a modificar para conservar los valores existentes.
- **Validaciones en Tiempo Real:** Validación estricta usando expresiones regulares para formato de correos y números telefónicos.

---

## 🚀 Cómo Ejecutar el Proyecto

1. **Compilar los archivos Java:**
   ```bash
   javac -d out src/model/Contacto.java src/utils/UtilInputs.java src/servicio/GestorContactos.java src/vista/Menu.java src/Main.java
   ```

2. **Iniciar la aplicación:**
   ```bash
   java -cp out Main
   ```
