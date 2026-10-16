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


#### 1. Mostrar el título de todos los libros.


Se mostrarán todos los títulos de los libros de la tienda de libros.


#### 2. Mostrar el título y el precio de todos los libros.


Se mostrarán todos los títulos y precios de los libros de la tienda de libros. Por ejemplo:

>El precio del libro Tímidamente de la oscuridad a la luz son 12 euros.


#### 3. Mostrar el precio de un libro.

Se le pedirá al usuario el título de un libro y se mostrará por pantalla el precio de dicho libro. (Cuidado con las mayúsculas y minúsculas)

*Por ejemplo:*

> ¿Cuál es el título del libro? Tímidamente de la oscuridad a la luz
> 
> El precio del libro "Tímidamente de la oscuridad a la luz” son 12 euros.
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


Si existe espacio libre, se le pedirá al usuario el título y el precio del libro y se guardará dentro de los arrays (en la última posición).

> ¿Cuál es el título del libro? Aladin
> 
> ¿Cuál es el precio? 19
> 
> El libro ha sido guardado.


#### 5. Eliminar un libro.

Se le pedirá al usuario el título del libro, se eliminará y se compactará el array.

> ¿Cuál es el título del libro? Aladin
> 
> El libro ha sido eliminado.
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


#### 8. Salir del programa.


Se terminará el programa.


***************************************


## Documento Word: Librería con Métodos Estáticos.


Crea métodos estáticos para cada opción del menú del ejercicio anterior.


***************************************

## PDF (Arrays y Métodos estáticos) - Ejercicio 1:

Define un array y rellénalo con números aleatorios de 0 a 100 (mirar aquí).
Muestra el siguiente menú:

1.Salir
2. Mostrar la suma
3. Mostrar el máximo
4. Mostrar el mínimo
5. Mostrar la media
6. Rellenarlo de nuevo con números (formatear)

(Buscar como se usa `Math.random()`)

## PDF (Arrays y Métodos estáticos) - Ejercicio 2: Array y String.

Rellena un array de tamaño 5 con nombres de manera estática (sin introducirlos por teclado). Muestra el siguiente menú:

1. Salir
2. Mostrar lista
3. Pedir un nombre y contar las veces que aparece
4. Pedir un nombre y decir si existe
5. Eliminar. Pedir un nombre y en el lugar de ese nombre introducir “null”.

## PDF (Arrays y Métodos estáticos) - Ejercicio 3:

Crear dos arrays, arrMeses y arrLitros. En el primero guarda los meses desde
enero a mayo, y en el segundo 123, 333, 180, 211, 90.

Por ejemplo:
> arrMeses[0] – enero
> arrLitros[0] -- 123

- Mostrar en cada mes cuántos litros han llovido.
- Mostrar en pantalla el mes y los litros del mes más lluvioso.
 

## PDF (Arrays y Métodos estáticos) - Ejercicio 4:

Teniendo un array de nombre y otro de edades de una clase. Saca por pantalla los siguientes datos:

>Alumnos: Jon, Sara, Ander, Marta, Jone, Mikel
>Edad: 18,20,26,21,17,24

- El nombre y edad del más joven.
- El nombre y edad del mayor.

## PDF (Arrays y Métodos estáticos) - Ejercicio 5: La temperatura de los días de la semana.

La temperatura de los días de la semana, leerla en ºC.
Habrá que calcular y mostrar lo siguiente:

- La media de la semana en ºF.
- El día más caluroso y más frio
- Los días por encima de la media.
- Los días por debajo de la media.

***************************************

## PDF Tienda 2.

Vamos a crear un programa para gestionar nuestra tienda utilizando los métodos de
java. Al iniciar el programa se crearán 2 arrays de 50 posiciones. El primer array contendrá
los nombres de los artículos y el segundo el precio de los mismos.

El programa principal tendrá el siguiente menú:
1. Añadir artículos y precios
2. Mostrar productos de la tienda
3. Obtener el precio de un producto
4. Obtener el IVA de un producto
5. Modificar el precio de un producto
6. Eliminar un producto
7. Salir
¿Qué quieres hacer?

#### 1.- Añadir artículos y precios.

Se le pedirá al usuario que introduzca el nombre y el precio de un nuevo artículo.
En caso de que el array esté lleno, se mostrará un mensaje de error. Daremos opción al
usuario de introducir más de un artículo con su correspondiente precio.
Ejemplo:

>Introduce el nombre del artículo:
>Goma
>Introduce el precio del producto:
>0,2
>El artículo ha sido introducido.
>__
>
>¿Qué quieres hacer?
>1
>No hay espacio libre.

#### 2.- Mostrar productos de la tienda.

Se le mostrarán los nombres y precios de los artículos. En caso de que el array no
tenga datos, se mostrará un mensaje informativo.
Ejemplo:

>El precio del artículo goma es de 1.0 €
>
>El precio del artículo lápiz es de 1.0 €
>__
>
>¿Qué quieres hacer?
>
>2
>
>No hay productos en la tienda.
>

#### 3.- Obtener el precio de un producto.

Se le pedirá al usuario el nombre de un producto y se mostrará su precio. En caso de
que el array no tenga datos, se mostrará un mensaje informativo. Si el producto no se
encuentra en el array, se le mostrará un mensaje de error.

>¿Qué quieres hacer?
>
>3
>
>¿Cuál es el nombre del artículo?
>
>Cuento
>
>El artículo no existe.
>
>__
>
>¿Qué quieres hacer?
>
>3
>
>¿Cuál es el nombre del artículo?
>
>Lápiz
>
>El precio del artículo lápiz es de 1.0 €
>
>__
>
>No hay artículos en la tienda.

#### 4.- Obtener el iva de un producto.

Se le pedirá al usuario el nombre de un producto y se mostrará su iva (21%). En caso
de que el array no tenga datos, se mostrará un mensaje informativo. Si el producto no
se encuentra en el array, se le mostrará un mensaje de error.

>¿Qué quieres hacer?
>
>4
>
>¿Cuál es el nombre del artículo?
>
>Cuento
>
>El artículo no existe.
>
>__
>
>¿Qué quieres hacer?
>
>4
>¿Cual es el nombre del artículo?
>
>Lápiz
>
>El IVA del artículo Lápiz es 0.21€
>
>__
>
>No hay artículos en la tienda.

#### 5.- Modificar el precio de un producto.

Se le pedirá al usuario el nombre de un producto y el nuevo precio. En caso de que el
array no tenga datos, se mostrará un mensaje informativo. Si el producto no se
encuentra en el array, se le mostrará un mensaje de error.

>¿Qué quieres hacer?
>
>5
>
>¿Cuál es el nombre del artículo?
>
>Lápiz
>
>Introduce el nuevo precio del producto:
>
>2
>
>El precio del Lápiz ha sido modificado.
>
>__
>
>¿Cuál es el nombre del artículo?
>
>Cuento
>
>El artículo no existe.
>
>__
>
>No hay artículos en la tienda.


#### 6.- Eliminar un producto.

Se le pedirá al usuario el nombre de un producto y se le pedirá confirmación antes de
borrarlo. En caso de que el array no tenga datos, se mostrará un mensaje informativo.
Si el producto no se encuentra en el array, se le mostrará un mensaje de error.

>¿Qué quieres hacer?
>
>6
>
>¿Cuál es el nombre del artículo que quieres eliminar?
>
>Lapiz
>
>¿Estás segur@ de que quieres eliminarlo?
>
>Si
>
>Producto eliminado correctamente
>__
>
>¿Cuál es el nombre del artículo?
>
>Cuento
>
>El artículo no existe.
>
>__
>
>No hay artículos en la tienda.


**7.- Salir del programa.**

---


