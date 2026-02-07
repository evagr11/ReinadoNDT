package reinadondt;

/**
 * Representa a un profesor dentro del RPG escolar.
 * Cada profesor puede generar un examen con cierta dificultad
 * y otorgar monedas al alumno en caso de superar la prueba.
 *
 * @author Eva Gallardo Romero
 * @version 1.1
 */
public class Profesor {
    private String nombre;
    private int dificultadExamen; 

    /**
     * Crea un nuevo profesor con el nombre indicado.
     * La dificultad del examen se inicializa en 0.
     *
     * @param nombre Nombre del profesor.
     */
    public Profesor(String nombre) {
        this.nombre = nombre;
        this.dificultadExamen = 0;
    }

    /**
     * Obtiene el nombre del profesor.
     *
     * @return Nombre del profesor.
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene la dificultad actual del examen asignado por el profesor.
     *
     * @return Dificultad del examen (valor entero).
     */
    public int getDificultadExamen() { return dificultadExamen; }

    /**
     * Establece la dificultad del examen del profesor.
     *
     * @param dificultadExamen Nuevo valor de dificultad.
     */
    public void setDificultadExamen(int dificultadExamen) { this.dificultadExamen = dificultadExamen; }

    /**
     * Genera un examen con dificultad aleatoria entre 1 y 15.
     * El valor se asigna directamente al atributo dificultadExamen.
     */
    public void generarExamen() {
        this.dificultadExamen = (int)(Math.random() * 15) + 1;
    }

    /**
     * Devuelve una cantidad aleatoria de monedas que el alumno recibe
     * al superar el examen. El valor está entre 1 y 3.
     *
     * @return Número de monedas otorgadas.
     */
    public int darMonedas() {
        return (int)(Math.random() * 3) + 1;
    }
}

