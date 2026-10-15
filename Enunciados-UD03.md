# Unidad 03

## Ejercicios sencillos de Arrays - Ejercicio 1:

Declara un array llamado `aNombres` de 5 posiciones, inicialízalo con 5 nombres y muéstralos por pantalla.

***************************************

## Ejercicios sencillos de Arrays - Ejercicio 2:

Declara un array llamado `aNotas` de 8 posiciones (real). Pídele al usuario que introduzca 8 notas, guárdalas en el array y muestra todas al final.

***************************************

## Ejercicios sencillos de Arrays - Ejercicio 3:

Declara un array llamado `aNotasPGR` de 5 posiciones (int). Pídele al usuario que introduzca 5 notas, guárdalas en el array y muestra la media de todas las notas.

***************************************

## Ejercicio 5:

Realiza la clase Java `Numveces` que pide números de 0 a 9 por pantalla y calcula el número de veces que han sido introducidos utilizando un array. Finaliza la introducción de datos cuando se introduce un valor negativo o el array está lleno. Al finalizar la introducción de datos muestra por pantalla el número de veces que se ha introducido cada número.

***************************************

## Ejercicio 6:

Realiza la clase Java `Medianum` que pide números por pantalla y los almacena en un array hasta que se introduzca un número negativo que no será tenido en cuenta o el array esté lleno. Después calcula la Media y la muestra.

***************************************

## Ejercicio 7:

Realiza la clase Java `Mediatem` que pide temperaturas por pantalla y las almacena en un array hasta que se introduzca la temperatura -999 que no será tenida en cuenta o el array esté lleno. Después calcula la temperatura media y muestra el número de temperaturas que son mayores que la media, iguales que la media, e inferiores a la media.

***************************************

## Ejercicio 9:

Realiza la clase Java `Contrase` que pide un nombre por pantalla y una contraseña. Compara los valores con unos valores predefinidos y si coinciden muestra un mensaje de bienvenida. Si no coinciden muestra un mensaje de error por pantalla. El proceso se repite hasta que los datos son correctos o hasta que se produzcan más de 3 intentos.

***************************************

## Ejercicios Métodos Estáticos - Ejercicio 1: Saludo sencillo.

Crea un programa con un método llamado `saludar` que muestre por pantalla el mensaje `¡Hola, bienvenidos a Java!`. Llama al método desde el `main`.

***************************************

## Ejercicios Métodos Estáticos - Ejercicio 2: Saludo personalizado.

Crea un método llamado `mostrarNombre` que reciba como parámetro un nombre (tipo `String`) y muestre el mensaje `Hola [nombre]!`. El nombre se debe pedir por teclado con `Scanner` desde el `main`.

***************************************

## Ejercicios Métodos Estáticos - Ejercicio 3: Comprobador de número par.

Crea tres métodos:

1. `pedirNumero()`: pide un número entero por teclado y lo devuelve.
2. `esPar(int n)`: devuelve `true` si el número es par, `false` en caso contrario.
3. En el `main`, usa los otros métodos para indicar si el número introducido es par o impar.

***************************************

## Ejercicios Métodos Estáticos - Ejercicio 4: Calculadora de operaciones básicas.

Crea los siguientes métodos estáticos:

* `sumar(int a, int b)`
* `restar(int a, int b)`
* `multiplicar(int a, int b)`
* `dividir(int a, int b)`

Desde el `main`, pide dos números por teclado y muestra un menú con las distintas opciones.

***************************************

## Documento Word: Tienda de Libros.

Vamos a crear un programa para gestionar una tienda de libros de nuestro pueblo.
Al iniciar el programa se crearán 2 arrays.

**Título**: Aquí guardaremos los títulos de los libros de la tienda.

- Tendrá 20 posiciones.
- Guardará variables de tipo `String`.
- Valores iniciales: (las posiciones 12-19 no tendrán valores iniciales).

0. Nada
1. Tímidamente de la oscuridad a la luz
2. Pájaros a golpes
3. Caperucita Roja
4. 12 cuentos clásicos
5. Pepe y Mila
6. Enojaos
7. En casa vacía
8. 123
9. Día Negro
10. El Hobbit
11. Calle Judía


**Precios** :Aquí guardaremos los precios de los libros.

- Tendrá 20 posiciones.
- Guardará variables de tipo `int`.
- Valores iniciales: (las posiciones 12-19 no tendrán valores iniciales).
  
0. 15
1. 12
2. 15
3. 25
4. 19
5. 17
6. 25
7. 13
8. 11
9. 18
10. 25
11. 35

Por lo tanto, el precio del libro “Tímidamente de la oscuridad a la luz” son 12 euros.

Después se le dará la bienvenida al usuario y se le mostrará el siguiente menú:

1. Mostrar el título de todos los libros.
2. Mostrar el título y el precio de todos los libros.
3. Mostrar el precio de un libro.
4. Introducir un nuevo libro.
5. Eliminar un libro.
6. Modificar el precio de un libro.
7. Modificar el título de un libro.
8. Salir del programa.

Después de cada opción (excepto la última opción), se le mostrará esta pregunta al usuario:


>¿Quieres continuar en el programa? SI / NO

#### 1. Mostrar el título de todos los libros.


Se mostrarán todos los títulos de los libros de la tienda de libros.


#### 2. Mostrar el título y el precio de todos los libros.


Se mostrarán todos los títulos y precios de los libros de la tienda de libros.

*Por ejemplo:* El precio del libro Tímidamente de la oscuridad a la luz son 12 euros.

¿Quieres continuar en el programa? SI / NO


#### 3. Mostrar el precio de un libro.

Se le pedirá al usuario el título de un libro y se mostrará por pantalla el precio de dicho libro. (Cuidado con las mayúsculas y minúsculas)

*Por ejemplo:*

> ¿Cuál es el título del libro? Tímidamente de la oscuridad a la luz
> 
> El precio del libro "Tímidamente de la oscuridad a la luz” son 12 euros.
> 
> ¿Quieres continuar en el programa? SI / NO
> 

#### 4. Introducir un nuevo libro.

Se le pedirá al usuario el título y el precio del libro y se guardará dentro de los arrays (En la primera posición libre).

> ¿Cuál es el título del libro? Aladin
> 
> ¿Cuál es el precio? 19
> 
> El libro ha sido guardado.


Primero tendremos que comprobar si existe espacio libre en nuestro array para introducir un nuevo libro. Si no hay espacio libre, se mostrará el siguiente mensaje:

> Tienes muchos libros en la tienda, elimina un libro.
> 
> ¿Quieres continuar en el programa? SI / NO


Si existe espacio libre, se le pedirá al usuario el título y el precio del libro y se guardará dentro de los arrays (en la última posición).

> ¿Cuál es el título del libro? Aladin
> 
> ¿Cuál es el precio? 19
> 
> El libro ha sido guardado.
> 
> ¿Quieres continuar en el programa? SI / NO


#### 5. Eliminar un libro.

Se le pedirá al usuario el título del libro, se eliminará y se compactará el array.

> ¿Cuál es el título del libro? Aladin
> 
> El libro ha sido eliminado.
> 
> ¿Quieres continuar en el programa? SI / NO
> 

*Recuerda que se deben eliminar el título y el precio del libro.*


#### 6. Modificar el precio de un libro.

Se le pedirá al usuario el título y el nuevo precio del libro a modificar. Después de comprobar que existe el libro, se cambiará el precio.


> ¿Cuál es el título del libro? Aladin
> 
> El precio del libro Aladin son 19 euros.
> 
> ¿Cuál es el nuevo precio? 20
> 
> El precio ha sido cambiado.
> 
> El nuevo precio del libro Aladin son 20 euros.
> 
> ¿Quieres continuar en el programa? SI / NO
> 


#### 7. Modificar el título de un libro.


Se le pedirá al usuario el título del libro. Después de comprobar que existe el libro, se modificara el título.


> ¿Cuál es el título del libro? Aladin
> 
> ¿Cuál es el nuevo título del libro? Aladin y la lámpara maravillosa
> 
> El título ha sido modificado.
> 
> El nuevo título del libro Aladin es Aladin y la lámpara maravillosa.
> 
> ¿Quieres continuar en el programa? SI / NO
> 


#### 8. Salir del programa.


Se terminará el programa.


***************************************


## Documento Word: Librería con Métodos Estáticos.


Crea métodos estáticos para cada opción del menú dl ejercicio anterior.


***************************************

---


