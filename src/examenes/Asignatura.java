package examenes;

/*Crea una clase llamada Asignatura que tendrá los siguientes atributos:
	Nombre (PGR, FOL, ...)
	Curso (1DAM, 2DAM, 1RPA...)
	Número de alumnos y alumnas matriculados
	Número de suspensos
El nombre y el curso serán obligatorios y los demás campos opcionales.
Crea dos constructores que cumplan lo anterior.
Crea sus métodos get, set y toString.
Tendrá dos métodos especiales:
	porcentajeAprobados(): este método devuelve un porcentaje que puede tener decimales
	indicando el porcentaje de alumn@s que han aprobado la asignatura.
	obtenerNumeroAprobados(): este método nos devuelve un entero que nos indica el número total
	de aprobados que hay en la asignatura.
*/

public class Asignatura {
    // Atributos de la clase
    private String nombre;
    private String curso;
    private int numeroAlumnos;
    private int numeroSuspensos;

    // Constructor con los campos obligatorios (nombre y curso)
    public Asignatura(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
        this.numeroAlumnos = 0;
        this.numeroSuspensos = 0;
    }

    // Constructor con todos los campos (obligatorios y opcionales)
    public Asignatura(String nombre, String curso, int numeroAlumnos, int numeroSuspensos) {
        this.nombre = nombre;
        this.curso = curso;
        this.numeroAlumnos = numeroAlumnos;
        this.numeroSuspensos = numeroSuspensos;
    }

    // Métodos GET
    public String getNombre() {
        return this.nombre;
    }

    public String getCurso() {
        return this.curso;
    }

    public int getNumeroAlumnos() {
        return this.numeroAlumnos;
    }

    public int getNumeroSuspensos() {
        return this.numeroSuspensos;
    }

    // Métodos SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public void setNumeroSuspensos(int numeroSuspensos) {
        this.numeroSuspensos = numeroSuspensos;
    }

    // MÉTODOS

    // Devuelve el número total de aprobados (total alumnos - suspensos)
    public int obtenerNumeroAprobados() {
        int aprobados;
        
        aprobados = this.numeroAlumnos - this.numeroSuspensos;
        if (aprobados < 0) {
            aprobados = 0;
        }
        
        return aprobados;
    }

    // Devuelve el porcentaje de alumnado aprobado (con decimales)
    /*recordatorio: En Java, si uno de los números de una operación tiene decimales, el resultado de esa operación se convierte automáticamente a double.
     * Al multiplicar primero aprobados * 100.0, obtienes un número con decimales antes de dividir entre this.numeroAlumnos,
     * evitando así que Java trunque los decimales
     Como aprobados y numero de alumnos son int, su división(porcentaje) no tendría decimales,
     pero multiplicando * 100.0 primero si*/
    
    public double porcentajeAprobados() {
        double porcentaje;
        int aprobados;

        aprobados = this.obtenerNumeroAprobados();
        if (this.numeroAlumnos <= 0) {
            porcentaje = 0.0;
        } else {
            porcentaje = (aprobados * 100.0) / this.numeroAlumnos;
        }

        return porcentaje;
    }

    // Método toString
    @Override
    public String toString() {
        return "Asignatura [Nombre=" + this.nombre + 
               ", Curso=" + this.curso + 
               ", Alumnos matriculados=" + this.numeroAlumnos + 
               ", Suspensos=" + this.numeroSuspensos + 
               ", Aprobados=" + this.obtenerNumeroAprobados() + 
               ", % Aprobados=" + this.porcentajeAprobados() + "%]";
    }
}