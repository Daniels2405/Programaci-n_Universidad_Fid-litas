# Playlist – Lista Doblemente Circular

**Curso:** SC-304 Estructuras de Datos
**Unidad:** 05 – Listas Mejoradas (Semana 08)
**Ejercicio:** Práctico #3 (Extra Clase)

---

## ¿Qué hace este proyecto?

Este proyecto implementa un gestor de playlist de música usando una **lista doblemente circular**. El usuario puede:

- Agregar canciones (nombre y artista) a la playlist.
- Ver todas las canciones en orden, marcando cuál es la "actual".
- Avanzar a la siguiente canción.
- Retroceder a la canción anterior.
- Cargar canciones de prueba al inicio (5 canciones de The Weeknd).

La interfaz es por ventanas usando `JOptionPane` (librería SWING de Java).

---

## Clases del proyecto

### `NodoCancion.java`
Representa un nodo de la lista. Cada canción es un nodo con:

```java
String nombre;      // nombre de la canción
String artista;     // nombre del artista
NodoCancion siguiente;  // apunta al siguiente nodo
NodoCancion anterior;   // apunta al nodo anterior
```

Al crearse, el nodo se apunta a sí mismo en ambas direcciones (`siguiente = this`, `anterior = this`). Esto es el punto de partida de la circularidad: un solo nodo ya forma un "círculo" de tamaño 1.

---

### `ListaDobleCircular.java`
Contiene la lógica de la estructura. Maneja dos punteros:

- `cabeza`: apunta siempre al primer nodo de la lista (punto de entrada).
- `actual`: apunta al nodo que está "sonando" actualmente.

**Métodos:**

| Método | Qué hace |
|--------|----------|
| `agregarCancion(nombre, artista)` | Crea un nuevo nodo y lo inserta al final (antes de `cabeza`), manteniendo los enlaces circulares en ambas direcciones. |
| `mostrarPlaylist()` | Recorre la lista desde `cabeza` con un `do-while` hasta volver a `cabeza`, mostrando cada canción. Marca con `<- ACTUAL` el nodo que coincide con `actual`. |
| `siguiente()` | Mueve `actual` al nodo siguiente: `actual = actual.siguiente`. Por ser circular, después de la última canción vuelve a la primera automáticamente. |
| `anterior()` | Mueve `actual` al nodo anterior: `actual = actual.anterior`. Por ser circular, antes de la primera canción va a la última automáticamente. |

**Lógica de inserción al agregar una canción:**
```
Antes de agregar:  [A] <-> [B] <-> [C] <-> (vuelve a A)

Agregar [D]:
  - D.siguiente = cabeza (A)
  - D.anterior  = ultimo (C)
  - C.siguiente = D
  - A.anterior  = D

Resultado: [A] <-> [B] <-> [C] <-> [D] <-> (vuelve a A)
```

---

### `Playlist.java` (Main)
Clase principal. Crea una instancia de `ListaDobleCircular` y muestra el menú de opciones en un ciclo `do-while`. Maneja errores de entrada con bloques `try-catch`.

---

## Las tres listas mejoradas de la Unidad 05

La presentación de la semana 08 cubre tres variantes de listas enlazadas que mejoran la lista simple. Aquí se explican en orden de menor a mayor complejidad, terminando en la que se usó en el proyecto.

---

### 1. Lista Circular

Una lista enlazada simple donde el **último nodo apunta de vuelta al primero** en lugar de apuntar a `null`.

```
[A] -> [B] -> [C] -> [D] -> (vuelve a A)
                              ^___________
```

**Características:**
- No existe un nodo `NULL` al final.
- Se puede recorrer indefinidamente sin reiniciar el puntero.
- Solo tiene un puntero por nodo: `siguiente`.

**Ventaja clave:** recorrido continuo sin necesidad de controlar si se llegó al final.

**Casos de uso reales:** buffers circulares, juegos (turno de jugadores en ronda), sistemas en tiempo real.

**En código (del ejemplo de clase):**
```java
// Recorrido con do-while para no perderse en el ciclo infinito
Nodo actual = cabeza;
do {
    System.out.print(actual.dato + " -> ");
    actual = actual.siguiente;
} while (actual != cabeza);
```
El `do-while` con la condición `actual != cabeza` es el patrón clave para recorrer una lista circular sin entrar en un bucle infinito.

---

### 2. Lista Doblemente Enlazada

Cada nodo tiene **dos referencias**: `anterior` y `siguiente`. La lista se puede recorrer en ambas direcciones, pero el primer nodo tiene `anterior = null` y el último tiene `siguiente = null`.

```
null <- [A] <-> [B] <-> [C] <-> [D] -> null
```

**Características:**
- Navegación bidireccional.
- El primer nodo sabe quién está antes de él (nadie, `null`).
- El último nodo sabe que no hay nada después (`null`).

**Ventaja clave:** poder retroceder en la lista sin tener que recorrerla desde el inicio.

**Casos de uso reales:** historial de navegación de un browser (botón "atrás" y "adelante"), editores de texto (deshacer/rehacer), pilas con acceso bidireccional.

**Nodo en código (del ejemplo de clase):**
```java
public class NodoDoble {
    int dato;
    NodoDoble siguiente, anterior;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;  // los extremos son null
    }
}
```

---

### 3. Lista Doblemente Circular ← la usada en el proyecto

Es la **combinación de las dos anteriores**: cada nodo tiene `anterior` y `siguiente`, Y además el último nodo apunta al primero y el primer nodo apunta al último. No hay `null` en ningún extremo.

```
[A] <-> [B] <-> [C] <-> [D] <-> (vuelve a A)
 ^___________________________________|
```

**Características:**
- Navegación en ambas direcciones (como la doble).
- Sin extremos: nunca se llega a `null` (como la circular).
- El primer nodo tiene `anterior` apuntando al último nodo.
- El último nodo tiene `siguiente` apuntando al primer nodo.

**Ventaja clave:** recorrer la lista en cualquier dirección de forma indefinida y sin verificar nulos.

**Casos de uso reales:** reproductores de música (avanzar/retroceder canciones en modo repetición), carruseles de imágenes, sistemas de turno rotativo.

---

## Por qué el proyecto usa la Lista Doblemente Circular

Una playlist de música necesita exactamente las dos capacidades que solo tiene esta estructura combinada:

| Necesidad de la playlist | Por qué necesita lista doblemente circular |
|--------------------------|------------------------------------------|
| Botón "siguiente canción" | Avanza con `actual.siguiente` |
| Botón "canción anterior" | Retrocede con `actual.anterior` (requiere lista doble) |
| Al final de la lista, volver a la primera | `siguiente` del último apunta al primero (requiere circular) |
| Al inicio, retroceder a la última | `anterior` del primero apunta al último (requiere circular doble) |

Con una lista simple, no se puede retroceder. Con una lista doble sin circularidad, llegar al extremo daría `null` y habría que manejar ese caso especialmente. La lista doblemente circular resuelve ambos problemas de forma elegante.

---

## Diagrama de la estructura en el proyecto

```
cabeza
  |
  v
[Blinding Lights / The Weeknd]
  ^  siguiente                  anterior  ^
  |      |                          |     |
  |      v                          |     |
[Save Your Tears / The Weeknd]      |     |
       siguiente                    |     |
           |                        |     |
           v                        |     |
      [Starboy / The Weeknd]        |     |
              siguiente             |     |
                  |                 |     |
                  v                 |     |
         [The Hills / The Weeknd]   |     |
                 siguiente          |     |
                     |              |     |
                     v              |     |
            [Die For You / The Weeknd]    |
                      siguiente -------> (vuelve a Blinding Lights)
                      anterior  <------- (apunta desde Blinding Lights)
```

`actual` puede estar apuntando a cualquiera de estos nodos. `siguiente()` y `anterior()` simplemente mueven ese puntero en la dirección correspondiente.

---

## Tabla comparativa de las tres listas

| Tipo de Lista | Punteros por nodo | ¿Circular? | Retroceder | Extremos |
|---|---|---|---|---|
| Lista Circular | 1 (`siguiente`) | Sí | No | No hay `null` |
| Lista Doble | 2 (`anterior`, `siguiente`) | No | Sí | `null` en extremos |
| Lista Doble Circular | 2 (`anterior`, `siguiente`) | Sí | Sí | No hay `null` |
