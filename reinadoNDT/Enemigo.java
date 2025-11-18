package reinadondt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array de enemigos
        String[] nombresEnemigos = {"Casandra", "Miguel", "Javier", "Guillermo"};

        // Introducción
        System.out.println("Bienvenido al REINADO DE NDT!");
        System.out.print("Introduce tu nombre: ");
        String nombreJugador = sc.nextLine();

        Jugador jugador = new Jugador(nombreJugador);
        jugador.calcularFuerzaInicial();

        // Opción de cambiar fuerza inicial
        System.out.println("Quieres cambiar tu fuerza inicial a cambio de 1 oro? (s/n)");
        String opcion = sc.nextLine();
        if(opcion.equalsIgnoreCase("s") && jugador.getDinero() > 0) {
            jugador.setDinero(jugador.getDinero() - 1);
            jugador.calcularFuerzaInicial();
        }

        boolean jugando = true;
        while(jugando) {
            mostrarMenu();
            
            int eleccion = sc.nextInt();
            sc.nextLine();

            switch(eleccion) {
                case 1: // Luchar contra enemigo
                    int random = (int)(Math.random() * nombresEnemigos.length);
                    Enemigo enemigo = new Enemigo(nombresEnemigos[random]);
                    enemigo.calcularFuerzaEnemigo();

                    if(jugador.getPuntosAtaque() >= enemigo.getPuntosAtaque()) {
                        int oroGanado = enemigo.soltarDinero();
                        jugador.setDinero(jugador.getDinero() + oroGanado);
                        System.out.println("Has vencido a " + enemigo.getNombre() + " Ganaste " + oroGanado + " de oro.");
                    } else {
                        int daño = enemigo.getPuntosAtaque() - jugador.getPuntosAtaque();
                        jugador.setPuntosSalud(jugador.getPuntosSalud() - daño);
                        System.out.println("Has perdido contra " + enemigo.getNombre() + ". Pierdes " + daño + " puntos de salud.");
                        if(jugador.getPuntosSalud() <= 0) {
                            System.out.println("Tu salud llego a 0. Has perdido el juego!");
                            jugando = false;
                        }
                    }
                    break;

                case 2: // Comprar ítems
                    mostrarTienda();
                    int compra = sc.nextInt();
                    sc.nextLine();

                    if(compra == 1 && jugador.getDinero() >= 2) {
                        jugador.setDinero(jugador.getDinero() - 2);
                        jugador.setPuntosAtaque(jugador.getPuntosAtaque() + 3);
                        System.out.println("Has comprado una espada (+3 ataque).");
                    } else if(compra == 2 && jugador.getDinero() >= 1) {
                        jugador.setDinero(jugador.getDinero() - 1);
                        jugador.setPuntosSalud(jugador.getPuntosSalud() + 5);
                        System.out.println("Has comprado una pocion (+5 salud).");
                    } else {
                        System.out.println("No tienes suficiente oro o la opcion no es valida.");
                    }
                    break;

                case 3: // Consultar estadísticas
                    System.out.println(jugador);
                    break;

                case 4: // Salir
                    System.out.println("Gracias por jugar. Hasta la proxima!");
                    jugando = false;
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
        sc.close();
    }

    // Función menú principal
    public static void mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Luchar contra enemigo");
        System.out.println("2. Comprar items");
        System.out.println("3. Consultar estadisticas");
        System.out.println("4. Salir del juego");
        System.out.print("Elige una opcion: ");
    }

    // Función tienda
    public static void mostrarTienda() {
        System.out.println("\n--- TIENDA ---");
        System.out.println("1. Espada (+3 ataque) - 2 oro");
        System.out.println("2. Pocion (+5 salud) - 1 oro");
        System.out.print("Elige que comprar: ");
    }
}

