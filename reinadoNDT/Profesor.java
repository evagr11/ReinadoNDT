package reinadondt;

public class Profesor {
    private String nombre;
    private int dificultadExamen; 

    public Profesor(String nombre) {
        this.nombre = nombre;
        this.dificultadExamen = 0;
    }

    public String getNombre() { return nombre; }
    public int getDificultadExamen() { return dificultadExamen; }
    public void setDificultadExamen(int dificultadExamen) { this.dificultadExamen = dificultadExamen; }

    public void generarExamen() {
        this.dificultadExamen = (int)(Math.random() * 15) + 1;
    }

    public int darMonedas() {
        return (int)(Math.random() * 3) + 1;
    }
}


