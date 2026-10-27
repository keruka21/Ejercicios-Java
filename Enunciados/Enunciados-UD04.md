# Unidad 04

## Documento Word - Ejercicio 1

Crea una clase llamada “Cuenta” que tendrá los siguientes atributos: titular y cantidad (puede tener decimales). 

El titular será obligatorio y la cantidad es opcional. 

- Crea dos constructores que cumplan lo anterior. 
- Crea sus métodos get, set y toString.
  
Tendrá dos métodos especiales:

- *ingresar* (double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada. 
- *retirar* (double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0. 

## Documento Word - Ejercicio 2 

Vamos a crear una clase llamada “Persona”. Sus atributos son: nombre, edad y DNI. 
Construye los siguientes métodos para la clase:

- Un constructor, donde los datos pueden estar vacíos. 
- Los setters y getters para cada uno de los atributos. 
- *mostrar()*: Muestra los datos de la persona. 
- *esMayorDeEdad()*: Devuelve un valor lógico indicando si es mayor de edad. 

 
## Documento Word - Ejercicio 3 

Crea una clase llamada "Libro" que tendrá los siguientes atributos: titulo, autor y numeroPaginas.
El título y el autor serán obligatorios, mientras que el número de páginas será opcional.

- Crea dos constructores que cumplan lo anterior.
- Crea sus métodos get, set y toString.
  
Tendrá dos métodos especiales:
- **esLargo()**: devuelve un valor lógico indicando si el libro tiene más de 300 páginas.
- **mostrarInformacion()**: muestra por pantalla toda la información del libro.

  
## Documento Word - Ejercicio 4

Vamos a crear un programa que me gestione personas. Nuestro programa podrá manipular hasta 10 personas distintas. 

Basándote en el **ejercicio 2**, crea una aplicación que gestione el siguiente menú repetitivo.

1. Introducir las personas (pedimos los datos de TODAS las personas y los almacenamos para usos posteriores).
2. Muestra la persona de mayor edad. 
3. Muestra la información de una persona tras introducir su DNI. 
4. Muestra la información de todas las personas. 
5. Salir.

## Documento Word - Ejercicio 5

Vamos a crear un programa que me gestione las cuentas de un banco. Nuestro programa podrá manipular hasta 50 cuentas distintas. 

Basándote en el **ejercicio 1**, crea una aplicación que gestione el siguiente menú repetitivo: 
1. Introducir cuenta/s.
>
>OJO: Como máximo hay 50 cuentas, lo que no significa que al elegir esta opción introduzca las 50. Controlar, eso sí, que no pueda introducir más de 50.
>
2. Muestra las cuentas introducidas.
3. Ingresar una cantidad a un titular concreto introducido por teclado (Llama al método ingresar y controla la posibilidad de que no exista el titular). 
4. Retirar de todas las cuentas introducidas, la comisión de 12€ (Llama al método retirar). 
5. Muestra la cuenta de mayor saldo. 
6. Muestras las cuentas que tengan saldo superior a uno introducido por teclado. Si no hay, mensaje indicándolo. 
7. Muestra la cuenta de un titular concreto. Controlar si no encuentra. 
8. Muestra las cuentas de los titulares que contengan un grupo de letras, introducido por teclado, en su atributo titular. 
9. Ordena y muestra las cuentas según su saldo (de mayor a menor saldo).
10. Salir
    
En todas las opciones a partir de la 1, controlar previamente si hay o no cuentas introducidas. 
Vamos a suponer que las cuentas son únicas (no hay titulares que se repiten).


***************************************
