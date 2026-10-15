# Unidad 02 ________________________________________

## Documento Word - Ejercicio 1: ¿Puede entrar?
Un local tiene una edad mínima de 18 años para poder entrar.
El programa debe pedir la edad de una persona y mostrar:
- "Puedes entrar" si tiene 18 años o más. 
- "No puedes entrar" si tiene menos de 18. 
- Si tiene exactamente 18, mostrar "Justo de edad".

***************************************

## Documento Word - Ejercicio 2: Nota del examen.
Pide al usuario una nota entre 0 y 10.
El programa debe mostrar:
- "Suspenso" si la nota es menor que 5. 
- "Aprobado" si está entre 5 y 6,9. 
- "Notable" si está entre 7 y 8,9. 
- "Sobresaliente" si es 9 o más. 

***************************************

## Documento Word - Ejercicio 3: Descuento en una tienda.
Una tienda hace un 10% de descuento si la compra es superior a 50 €.
El programa debe pedir el importe de la compra y mostrar:
- Si supera los 50 €, el precio original, el descuento aplicado y el precio final. 
- Si no supera los 50 €, mostrar que no tiene descuento y el precio final.

***************************************

## Documento Word Bucles - Ejercicio 1:
Transforma el siguiente bucle for a un bucle while:
```java
for (i = 5; i<15; i++)
{
System.out.println(i);
}

```

***************************************

## Documento Word Bucles - Ejercicio 2:

Escribe un programa utilizando FOR que mostrará por pantalla los numeros comprendidos entre 200 y 300, ambos incluidos.

***************************************

## Documento Word Bucles - Ejercicio 3:

Escribe un programa utilizando FOR que mostrará por pantalla los 5 primeros numero pares.


***************************************

## Documento Word Bucles - Ejercicio 4:

Escribe un programa que mostrará por pantalla el numero factorial del número introducido por el usuario por consola. El número introducido debe ser mayor que 0.
[Enlace a Wikipedia](https://es.wikipedia.org/wiki/Factorial)

>El factorial de un número entero positivo (se representa con un signo de exclamación !) es el resultado de multiplicar todos los números enteros desde el 1 hasta ese número. Por ejemplo, el factorial de 5 (se escribe 5!) se calcula así: 5!=5×4×3×2×1=120


***************************************

## Documento Word Bucles - Ejercicio 5:

Escribe un programa que mostrará por pantalla cuántos dígitos tiene el número introducido por el usuario.

***************************************

## Ejercicio 44

Realiza la clase Java `Menucase` que muestra un menú y lee por teclado el valor de una opción. En función de la opción, muestra un mensaje indicando la opción seleccionada usando una estructura selectiva.

1. Opción 1
2. Opción 2
3. Opción 3
4. Opción 4
5. Opción 5
6. Salir

***************************************

## Ejercicio 45

Realiza la clase Java `Menudias` que lee por teclado un carácter y muestra el día de la semana que le corresponde según la siguiente tabla:

* **L**: Lunes
* **M**: Martes
* **X**: Miércoles
* **J**: Jueves
* **V**: Viernes
* **S**: Sábado
* **D**: Domingo
* **Otro Carácter**: ERROR

***************************************

## Ejercicio 46

Realiza la clase Java `Menumeses` que lee por teclado un `String` con el nombre del mes por pantalla y muestra el número de mes que le corresponde.

***************************************

## Ejercicio 107

Realiza la clase Java `Num100` que muestra por pantalla los 100 primeros números enteros.

***************************************

## Ejercicio 108

Realiza la clase Java `Sacanumw` que lee un número entero por teclado y muestra los números desde 1 hasta él inclusive. Con `While`.

***************************************

## Ejercicio 109

Realiza la clase Java `Sacaparw` que lee un número entero por teclado y muestra los números pares desde 0 hasta él inclusive. Con `While`.

***************************************

## Ejercicio 110

Realiza la clase Java `Sacanudw` que lee un número entero por teclado y muestra los números desde él inclusive hasta 1. Con `While`.

***************************************

## Ejercicio 115

Realiza la clase Java `Sumaparw` lee un número entero por teclado y muestra la suma de todos los números pares desde 0 hasta n. Con `While`.

***************************************

## Ejercicio 117

Realiza la clase Java `Sumapadw` lee un número entero por teclado y muestra la suma de todos los números pares desde n hasta 0 (en orden descendente). Con `While`.

***************************************

## Ejercicio Gestionar Notas:

PROGRAMA PARA GESTIONAR NOTAS

Crea el programa “Gestionarnotas”. El programa pedirá usuario y contraseña. Si en la contraseña está la letra “e” mostrará un mensaje de ERROR y pedirá de nuevo el usuario y la contraseña hasta que no exista la letra “e” en la contraseña. (Utiliza indexOf y ten en cuenta las mayúsculas y minúsculas).

>Introduce tu usuario: AntonioR
>
>Introduce tu contraseña: 136ae
>
>ERROR, en la contraseña no puede aparecer la letra e. Introduce de nuevo, por favor:
>
>Introduce tu usuario: AntonioR
>
>Introduce tu contraseña: 136aa
>

Después, aparecerá el siguiente menú:

1.- Introducir notas. Pedirá los datos del alumno (nombre y apellido). Después, calculará la nota final, utilizando la siguiente fórmula:

- La media de los 3 exámenes parciales es el 55%.
- La nota obtenida en el último examen es el 30%.
- La nota obtenida en el último trabajo es el 15%.
  
¡Atención! Las notas introducidas no pueden ser negativas, ni mayores de 10.
Después de introducir todas las notas, deberá aparecer un mensaje como este:

>La nota final del alumno Jon Perez es 5, suficiente.

Hay que tener en cuenta la siguiente tabla:
- 0-4,9 SUSPENSO
- 5-5,9 SUFICIENTE
- 6-6,9 BIEN
- 7-8,9 NOTABLE
- 9-10 SOBRESALIENTE

>Introducir la nota del examen 1: 5
>
>Introducir la nota del examen 2: 7
>
>Introducir la nota del examen 3: -2
>
>ERROR! La nota no puede ser negativa.
>
>Introducir la nota del examen 3: 2
>
>Introducir la nota del último examen: 4
>
>Introducir la nota del trabajo: 9
>
>La nota final del alumno Jon Perez es 5, suficiente.
>

2 .- Salir del programa.

Dar las gracias al usuario y finaliza el programa.

>Muchas gracias y hasta pronto.
>
>
***************************************

## Ejercicio Menustring:
La clase String

Crear la clase MenuString. El programa le pedirá el nombre al usuario y le dará la bienvenida:

>Bienvenido Antonio. ¿Qué quieres hacer?

Después le mostrará este menú:

1.- Dar la vuelta a una palabra.

Se le pedirá una palabra al usuario y se mostrará por pantalla dada la vuelta. Por ejemplo: Si escribo Hola, se mostrará aloH.

2.- Comparar dos palabras.

Se le pedirán dos palabras al usuario y el programa dirá si son iguales o no. Ejemplo:

>Inserta la primera palabra: Hola
>
>Inserta la segunda palabra: Hola
>
>Son iguales
>
Ejemplo:
>Inserta la primera palabra: Hola
>
>Inserta la segunda palabra: Adios
>
>No son iguales
>

3.-Número de letras.

Se le pedirá una palabra al usuario y se visualizará por pantalla cuántas letras tiene. Si el número de letras es 7 o más, mostrara un mensaje indicando que el tamaño de la palabra es grande. Y si es menor de 7, indicará que el tamaño es pequeño. Ejemplo:

>Inserta una palabra: Hola
>
>Numero de letras: 4
>
>El tamaño de la palabra es pequeño.

4.- Repetir palabra.

Se le pedirá al usuario una palabra y un número. Se mostrará por pantalla dicha palabra en mayúsculas y el número de veces que haya indicado el usuario. Ejemplo:

>Inserta la palabra que quieras repetir: Hola
>
>¿Cuantas veces la quieres repetir?: 3
>
>HOLA HOLA HOLA

5.- Repetir palabra (Mayúscula / Minúscula).

Se le pedirá una palabra al usuario. Después, se le preguntará si quiere visualizarla en mayúsculas o minúsculas. Para terminar, se le preguntará cuantas veces quiere repetir dicha palabra. No se puede repetir una palabra 6 veces o más. Si el usuario inserta el número 6 o un número mayor, le pediremos de nuevo el número de repeticiones.
Ejemplo:

>Inserta la palabra que quieres repetir: Hola
>
>¿Mayúscula o Minúscula?: Minuscula
>
>¿Cuantas veces la quieres repetir? 7
>
>No se puede repetir más de 6 veces.
>
>¿Cuantas veces la quieres repetir? 8
>
>No se puede repetir más de 6 veces.
>
>¿Cuantas veces la quieres repetir? 2
>
>hola hola

6.- Salir del programa.

Le dará las gracias al usuario y se terminará el programa.

>Muchas gracias y hasta pronto.


***************************************
