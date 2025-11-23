package reinadondt;

public class Alumno {
    private String nombre;
    private int energia, conocimiento, monedas, nivel, defensa;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.energia = 20;
        this.conocimiento = 0;
        this.monedas = 20;
        this.nivel = 1;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public int getEnergia() { return energia; }
    public int getConocimiento() { return conocimiento; }
    public int getMonedas() { return monedas; }
    public int getNivel() { return nivel; }
    public int getDefensa() { return defensa; }

    public void setEnergia(int energia) {
    if (energia > 20) {
        this.energia = 20; 
    } else {
        this.energia = energia;
    }
}
    public void setConocimiento(int conocimiento) { this.conocimiento = conocimiento; }
    public void setMonedas(int monedas) { this.monedas = monedas; }
    public void setDefensa(int defensa) { this.defensa = defensa; }

    @Override
    public String toString() {
        return "Alumno: " + nombre +
               " | Energia: " + energia +
               " | Conocimiento: " + conocimiento +
               " | Monedas: " + monedas +
               " | Nivel: " + nivel +
               " | Defensa: " + defensa;
    }

    public void calcularConocimientoInicial() {
        int fuerza = (int)(Math.random() * 10) + 1;
        this.conocimiento = fuerza;
    }

    public String mostrarBarraEnergia() {
        int maxEnergia = 20;
        int longitudBarra = 20;
        int relleno = (int)((double) energia * longitudBarra);

        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < longitudBarra; i++) {
            if (i < relleno) barra.append("#");
            else barra.append("-");
        }
        barra.append("] ").append(energia).append("/").append(maxEnergia);
        return barra.toString();
    }
    
    public void subirNivel() { this.nivel++; }
}


