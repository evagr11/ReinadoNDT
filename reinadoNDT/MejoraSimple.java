package reinadondt;

/** 
 * Representa una mejora simple que puede aplicarse al alumno,
 * aumentando uno de sus atributos: conocimiento, energía o defensa
 *
 * @author Eva Gallardo
 * @version 1.1
 */
public class MejoraSimple implements Mejorable {
    private TipoMejora tipo;
    private int cantidad;

    /**
     * Crea una mejora simple con un tipo y una cantidad determinada
     *
     * @param tipo Tipo de mejora que se aplicará
     * @param cantidad Cantidad que se sumará al atributo correspondiente
     */
    public MejoraSimple(TipoMejora tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    /**
     * Aplica la mejora al alumno, aumentando el atributo correspondiente
     * según el tipo de mejora
     *
     * @param alumno Alumno al que se le aplicará la mejora
     */
    @Override
    public void aplicarMejora(Alumno alumno) {
        switch (tipo) {
            case CONOCIMIENTO -> alumno.setConocimiento(alumno.getConocimiento() + cantidad);
            case ENERGIA -> alumno.setEnergia(alumno.getEnergia() + cantidad);
            case DEFENSA -> alumno.setDefensa(alumno.getDefensa() + cantidad);
        }
    }

    /**
     * Devuelve el tipo de mejora aplicada
     *
     * @return Tipo de mejora
     */
    @Override
    public TipoMejora getTipo() {
        return tipo;
    }
}

