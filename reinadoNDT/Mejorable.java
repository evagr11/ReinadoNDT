package reinadondt;

/**
 * Interfaz que representa cualquier elemento capaz de aplicar una mejora
 * sobre un alumno dentro del RPG escolar.
 * 
 * @author Eva Gallardo
 * @version 1.1
 */public interface Mejorable {
     
    /**
     * Aplica la mejora correspondiente al alumno indicado
     *
     * @param alumno Alumno al que se le aplicará la mejora
     */
    void aplicarMejora(Alumno alumno);

    /**
     * Obtiene el tipo de mejora que proporciona el objeto
     *
     * @return Tipo de mejora (conocimiento, energía o defensa)
     */
    TipoMejora getTipo();
}

