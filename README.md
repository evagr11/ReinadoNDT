<div align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0%3A1E1B4B%2C50%3A6366F1%2C100%3AC7D2FE&height=200&section=header&text=Reinado+NDT&fontSize=60&fontColor=fff&fontAlignY=38&desc=Un+RPG+escolar+por+consola+en+Java&descAlignY=62&descSize=18" width="100%"/>
</div>

<div align="center">
  <a href="https://github.com/evagr11/ReinadoNDT" target="_blank"><img src="https://img.shields.io/badge/Ver_Código-1E1B4B?style=for-the-badge&logo=github&logoColor=white" alt="Ver Código"></a>
  <a href="#-cómo-utilizar-el-proyecto"><img src="https://img.shields.io/badge/Cómo_Jugar-6366F1?style=for-the-badge&logo=openjdk&logoColor=white" alt="Cómo Jugar"></a>
</div>

<div align="center">
  <a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.demolab.com/?font=JetBrains+Mono&size=18&duration=3500&pause=800&color=6366F1&center=true&vCenter=true&width=600&lines=RPG+por+consola+en+Java%3BExamenes+en+lugar+de+dragones%3BTienda+de+mejoras+con+monedas%3BJefe+final%3A+el+Director%3BSin+dependencias+externas" alt="Typing SVG" /></a>
</div>

# 🚀 Sobre el Proyecto

**Reinado NDT** es un juego de rol de texto hecho en Java en el que eres un alumno que tiene que sobrevivir al curso. En lugar de dragones, tus enemigos son los **exámenes de los profesores**: apruébalos para ganar monedas y subir de nivel, gasta las monedas en la tienda para prepararte y, al llegar al nivel 5, enfréntate al **examen final del Director**.

✨ **Características principales:**

*   📝 **Exámenes aleatorios:** Cada vez te examina un profesor al azar con una dificultad del 1 al 15. Si tu **conocimiento** es mayor o igual, apruebas; si no, pierdes **energía**.
*   🛡️ **Defensa:** Reduce la energía que pierdes en cada suspenso.
*   🛒 **Tienda de mejoras:** Seis objetos para subir conocimiento, energía o defensa a cambio de monedas.
*   🎲 **Comienzo aleatorio:** Empiezas con un conocimiento entre 1 y 10 y puedes pagar 1 moneda para volver a tirar.
*   🏆 **Jefe final:** Al llegar al nivel 5 puedes enfrentarte al Director (dificultad 20) o seguir preparándote.
*   🔋 **Barra de energía:** Se dibuja con caracteres en la consola; si llega a 0, pierdes el curso.
*   ✍️ **Animación de examen:** Los puntos suspensivos de "Escribiendo respuestas…" se generan con un método **recursivo**.

### 🖥️ Así se ve una partida

```text
Introduce tu nombre: Eva
Tu conocimiento inicial es: 10

--- MENU PRINCIPAL ---
1. Presentarse a examen
2. Prepararse (tienda)
3. Consultar tus estadisticas
4. Salir
Elige una opcion: 1
---------- INICIO DEL EXAMEN ----------
El profesor Guillermo te ha puesto un examen.

Alumno: Eva | Energia: 20 | Conocimiento: 10 | Monedas: 2 | Nivel: 1 | Defensa: 0

Dificultad del examen: 5

Escribiendo respuestas...
Entrega del examen!

Has aprobado gracias a tu conocimiento.
Ganas 2 monedas.
Subes a nivel 2
```

### 🛒 Tienda

<div align="center">

| Objeto | Efecto | Precio |
| :----- | :----- | :----: |
| Chuleta | +3 conocimiento | 2 🪙 |
| Estudiar | +5 conocimiento | 3 🪙 |
| Pedir ayuda a un compañero | +2 conocimiento | 1 🪙 |
| Bebida energética | +5 energía | 2 🪙 |
| Café | +3 energía | 1 🪙 |
| Apuntes organizados | +2 defensa | 2 🪙 |

</div>

Empiezas con **20 de energía** (es también el máximo), **2 monedas** y **0 de defensa**. Cada examen aprobado da entre 1 y 3 monedas y un nivel.

# 🧠 Contexto del Proyecto

Fue una práctica del módulo de **Programación** del ciclo de **Desarrollo de Aplicaciones Multiplataforma (DAM)** en **New Digital Talent**, de ahí el *NDT* del nombre y de los profesores del juego. El objetivo era aplicar la **programación orientada a objetos** en una aplicación de consola completa:

<div align="center">

| Concepto | Dónde se usa |
| :------- | :----------- |
| **Clases y encapsulación** | `Alumno` y `Profesor`, con atributos privados, getters y setters |
| **Interfaces** | `Mejorable`, implementada por `MejoraSimple`, que aplica las compras de la tienda |
| **Enumerados** | `TipoMejora` (conocimiento, energía, defensa) con `switch` |
| **Recursividad** | `animacionExamenRecursiva()` para la animación del examen |
| **Aleatoriedad** | `Math.random()` en el conocimiento inicial, los profesores, la dificultad y las monedas |
| **Documentación** | Comentarios **Javadoc** en todas las clases y métodos |

</div>

# 🛠️ Stack Tecnológico

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Consola-1E1B4B?style=for-the-badge&logo=windowsterminal&logoColor=white" alt="Consola">
  <img src="https://img.shields.io/badge/Status-MVP-6366F1?style=for-the-badge" alt="Status MVP">
</div>

<br>

<div align="center">

| Área | Tecnología |
| :--- | :--------- |
| **Lenguaje** | `Java` (usa `switch` con flechas, así que necesita **Java 14 o superior**) |
| **Entrada** | `Scanner` |
| **Interfaz** | Consola, con arte ASCII |
| **Dependencias** | Ninguna |

</div>

# 📂 Estructura del Proyecto

```bash
ReinadoNDT/
├── reinadoNDT/
│   ├── Main.java          # Bucle de juego, menús, exámenes, tienda y jefe final
│   ├── Alumno.java        # El jugador: energía, conocimiento, monedas, nivel y defensa
│   ├── Profesor.java      # Genera la dificultad del examen y las monedas
│   ├── Mejorable.java     # Interfaz de las mejoras de la tienda
│   ├── MejoraSimple.java  # Mejora de un tipo y una cantidad
│   └── TipoMejora.java    # CONOCIMIENTO, ENERGIA, DEFENSA
├── .gitignore
└── README.md
```

# 🚀 Cómo Utilizar el Proyecto

Solo necesitas el **JDK 14 o superior**.

1.  **Clona el repositorio:**
    ```bash
    git clone https://github.com/evagr11/ReinadoNDT.git
    ```
2.  **Navega al directorio del proyecto:**
    ```bash
    cd ReinadoNDT
    ```
3.  **Compila** los archivos en una carpeta `out`:
    ```bash
    javac -d out reinadoNDT/*.java
    ```
4.  **Ejecuta el juego:**
    ```bash
    java -cp out reinadondt.Main
    ```

> 💡 El paquete se llama `reinadondt` (en minúsculas) aunque la carpeta sea `reinadoNDT`. Compilar con `-d out` crea la carpeta con el nombre correcto, así que funciona igual en Windows, macOS y Linux.

<div align="center">
  <p><em>¡Y listo! Ya puedes empezar tu aventura para conquistar el Reinado de NDT.</em></p>
</div>

<br>

<div align="center">
  <p>Creado por <strong>Eva Gallardo</strong></p>
  <a href="https://github.com/evagr11" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" alt="GitHub">
  </a>
  <a href="https://www.linkedin.com/in/eva-gallardo-romero-830362349/" target="_blank">
    <img src="https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn">
  </a>
</div>

<div align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0%3A1E1B4B%2C50%3A6366F1%2C100%3AC7D2FE&height=120&section=footer" width="100%"/>
</div>
