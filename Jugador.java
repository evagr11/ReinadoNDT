package reinadondt;

public class Jugador {
    
    private String nombre;
    private int puntosSalud, puntosAtaque, dinero;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntosSalud = 20;
        this.puntosAtaque = 0;
        this.dinero = 2;
        
        System.out.println("Bienvenido " + nombre + " al juego!");
        System.out.println("Comienzas con 20 puntos de salud y 2 monedas.");
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public int getDinero() {
        return dinero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "\n--- ESTADÍSTICAS DEL JUGADOR ---\n" +
               "Nombre: " + nombre + "\n" +
               "Salud: " + puntosSalud + "\n" +
               "Ataque: " + puntosAtaque + "\n" +
               "Dinero: " + dinero + "\n";
    }

    
    // Método personalizado: asigna ataque inicial aleatorio
    public void calcularFuerzaInicial() {
        int fuerza = (int)(Math.random() * 10); // entre 1 y 10
        this.puntosAtaque = fuerza;
        System.out.println(nombre + " tiene una fuerza inicial de " + fuerza + " puntos de ataque.");
    }
    
}
