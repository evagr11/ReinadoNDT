package reinadondt;

/**
 * Representa a un alumno dentro del RPG escolar.
 * El alumno tiene atributos como energía, conocimiento, monedas, nivel y defensa,
 * que determinan su capacidad para superar exámenes y progresar en el juego.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class Alumno {
    private String nombre;
    private int energia, conocimiento, monedas, nivel, defensa;

    /**
     * Crea un nuevo alumno con valores iniciales predefinidos:
     * energía = 20, conocimiento = 0, monedas = 2, nivel = 1, defensa = 0.
     *
     * @param nombre Nombre del alumno.
     */
    public Alumno(String nombre) {
        this.nombre = nombre;
        this.energia = 20;
        this.conocimiento = 0;
        this.monedas = 2;
        this.nivel = 1;
    }

    // Getters y Setters

    /**
     * Obtiene el nombre del alumno.
     *
     * @return Nombre del alumno.
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene la energía actual del alumno.
     *
     * @return Energía actual (máximo 20).
     */
    public int getEnergia() { return energia; }

    /**
     * Obtiene el nivel de conocimiento del alumno.
     *
     * @return Conocimiento actual.
     */
    public int getConocimiento() { return conocimiento; }

    /**
     * Obtiene la cantidad de monedas que posee el alumno.
     *
     * @return Número de monedas.
     */
    public int getMonedas() { return monedas; }

    /**
     * Obtiene el nivel actual del alumno.
     *
     * @return Nivel actual.
     */
    public int getNivel() { return nivel; }

    /**
     * Obtiene el valor de defensa del alumno.
     *
     * @return Defensa actual.
     */
    public int getDefensa() { return defensa; }

    /**
     * Establece la energía del alumno. 
     * Si el valor supera 20, se iguala automáticamente a 20.
     *
     * @param energia Nueva energía a asignar.
     */
    public void setEnergia(int energia) {
        if (energia > 20) {
            this.energia = 20; 
        } else {
            this.energia = energia;
        }
    }

    /**
     * Establece el conocimiento del alumno.
     *
     * @param conocimiento Nuevo valor de conocimiento.
     */
    public void setConocimiento(int conocimiento) { this.conocimiento = conocimiento; }

    /**
     * Establece la cantidad de monedas del alumno.
     *
     * @param monedas Nuevo número de monedas.
     */
    public void setMonedas(int monedas) { this.monedas = monedas; }

    /**
     * Establece la defensa del alumno.
     *
     * @param defensa Nuevo valor de defensa.
     */
    public void setDefensa(int defensa) { this.defensa = defensa; }

    /**
     * Devuelve una representación en texto del alumno con todos sus atributos.
     *
     * @return Cadena con nombre, energía, conocimiento, monedas, nivel y defensa.
     */
    @Override
    public String toString() {
        return "Alumno: " + nombre +
               " | Energia: " + energia +
               " | Conocimiento: " + conocimiento +
               " | Monedas: " + monedas +
               " | Nivel: " + nivel +
               " | Defensa: " + defensa;
    }

    /**
     * Calcula un conocimiento inicial aleatorio entre 1 y 10
     * y lo asigna al alumno.
     */
    public void calcularConocimientoInicial() {
        int fuerza = (int)(Math.random() * 10) + 1;
        this.conocimiento = fuerza;
    }

    /**
     * Genera una barra visual de energía proporcional al valor actual.
     * La energía máxima es 20, y la barra se representa con 20 caracteres.
     *
     * @return Cadena con la barra de energía y el valor actual.
     */
    public String mostrarBarraEnergia() {
        int maxEnergia = 20;
        int longitudBarra = 20;

        int relleno = (int) Math.round((double) energia / maxEnergia * longitudBarra);
        
        if (relleno > longitudBarra) relleno = longitudBarra;
        if (relleno < 0) relleno = 0;

        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < longitudBarra; i++) {
            if (i < relleno) barra.append("#");
            else barra.append("-");
        }
        barra.append("] ").append(energia).append("/").append(maxEnergia);
        return barra.toString();
    }
    
    /**
     * Incrementa en 1 el nivel del alumno.
     */
    public void subirNivel() { this.nivel++; }
}


