package reinadondt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombresProfesores = {"Casandra", "Miguel", "Guillermo", "Javier"};

        Alumno alumno = iniciarJuego(sc);

        boolean jugando = true;
        while(jugando) {
            mostrarMenu();
            int eleccion = sc.nextInt();

            switch(eleccion) {
                case 1: // Examen
                    int random = (int)(Math.random() * nombresProfesores.length);
                    Profesor profesor = new Profesor(nombresProfesores[random]);
                    profesor.generarExamen();
                    
                    System.out.println("---------- INICIO DEL EXAMEN ----------");
                    System.out.println("El profesor " + profesor.getNombre() + " te ha puesto un examen.");
                    System.out.println("\n" + alumno);
                    System.out.println("Barra de energia: " + alumno.mostrarBarraEnergia());
                    System.out.println("\nDificultad del examen: " + profesor.getDificultadExamen() + "\n");

                    animacionExamen();

                    int ataqueEnemigo = profesor.getDificultadExamen();

                    if (ataqueEnemigo <= alumno.getDefensa()) {
                        // Defensa bloquea el examen
                        System.out.println("Tu defensa bloquea el examen. No pierdes energia!");
                        int monedasGanadas = profesor.darMonedas();
                        alumno.setMonedas(alumno.getMonedas() + monedasGanadas);
                        System.out.println("Ganas " + monedasGanadas + " monedas.");
                        alumno.subirNivel();
                        System.out.println("Subes a nivel " + alumno.getNivel());
                        System.out.println("Los examenes seran mas dificiles a partir de ahora...");
                    } else if (alumno.getConocimiento() >= ataqueEnemigo) {
                        // Apruebas por conocimiento
                        System.out.println("Has aprobado gracias a tu conocimiento.");
                        int monedasGanadas = profesor.darMonedas();
                        alumno.setMonedas(alumno.getMonedas() + monedasGanadas);
                        System.out.println("Ganas " + monedasGanadas + " monedas.");
                        alumno.subirNivel();
                        System.out.println("Subes a nivel " + alumno.getNivel());
                        System.out.println("Los examenes seran mas dificiles a partir de ahora...");

                        // Jefe final
                        if (alumno.getNivel() == 5) {
                            Profesor jefeFinal = new Profesor("JEFE FINAL - Director");
                            jefeFinal.setDificultadExamen(20);
                            System.out.println("\nHas alcanzado el nivel 5!");
                            System.out.println("Te enfrentas al examen final del Director.");
                            // TODO : combate jefe
                        }
                    } else {
                        // Suspendes
                        int daño = ataqueEnemigo - alumno.getDefensa() - alumno.getConocimiento();
                        if (daño < 1) daño = 1; // mínimo 1 de daño
                        alumno.setEnergia(alumno.getEnergia() - daño);
                        System.out.println("Has suspendido... pierdes " + daño + " puntos de energia.");
                        System.out.println("Barra de energia: " + alumno.mostrarBarraEnergia());
                        if (alumno.getEnergia() <= 0) {
                            System.out.println("Tu energia ha llegado a 0. Has perdido el curso!");
                            jugando = false;
                        }
                    }
                    break;

                case 2: // Tienda
                    realizarCompra(sc, alumno);
                    break;
                case 3: // Estadísticas
                    System.out.println("\n---------- ESTADISTICAS JUGADOR ----------");
                    System.out.println(alumno);
                    System.out.println("Barra de energia: " + alumno.mostrarBarraEnergia());
                    break;

                case 4: // Salir
                    jugando = false;
                    System.out.println("Gracias por jugar. Hasta la proxima evaluacion!");
                    break;

                default:
                    System.out.println("Opción no valida.");
            }
        }
        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Presentarse a examen");
        System.out.println("2. Prepararse (tienda)");
        System.out.println("3. Consultar tus estadisticas");
        System.out.println("4. Salir");
        System.out.print("Elige una opcion: ");
    }

    public static void mostrarTienda() {
        System.out.println("\n--- TIENDA DEL ALUMNO ---");
        System.out.println("1. Chuleta (+3 conocimiento) - 2 monedas");
        System.out.println("2. Estudiar (+5 conocimiento) - 3 monedas");
        System.out.println("3. Pedir ayuda a un companero (+2 conocimiento) - 1 moneda");
        System.out.println("4. Bebida energetica (+5 energia) - 2 monedas");
        System.out.println("5. Cafe (+3 energia) - 1 moneda");
        System.out.println("6. Apuntes organizados (+2 defensa) - 2 moneda");
        System.out.print("Elige una opcion: ");
    }


    public static void animacionExamen() {
        try {
            for (int i = 0; i <= 3; i++) {
                StringBuilder animacion = new StringBuilder("Escribiendo respuestas");
                for (int j = 0; j < i; j++) animacion.append(".");
                for (int j = i; j < 3; j++) animacion.append(" ");
                System.out.println(animacion.toString());
                Thread.sleep(500);
            }
            System.out.println("Entrega del examen!\n");
        } catch (InterruptedException e) {
            System.out.println("Error en la animación.");
        }
    }
    
    public static Alumno iniciarJuego(Scanner sc) {
        System.out.println("Bienvenido al curso escolar...");
        System.out.print("Introduce tu nombre: ");
        String nombreAlumno = sc.nextLine();

        Alumno alumno = new Alumno(nombreAlumno);
        alumno.calcularConocimientoInicial();

        System.out.println("Tu conocimiento inicial es: " + alumno.getConocimiento());
        System.out.println("Quieres volver a calcular tu conocimiento por 1 moneda? (s/n)");
        String opcion = sc.nextLine();
        if (opcion.equalsIgnoreCase("s") && alumno.getMonedas() > 0) {
            alumno.setMonedas(alumno.getMonedas() - 1);
            alumno.calcularConocimientoInicial();
            System.out.println("Nuevo conocimiento: " + alumno.getConocimiento());
        }
        return alumno;
    }
    
    public static void realizarCompra(Scanner sc, Alumno alumno) {
        mostrarTienda();
        int compra = sc.nextInt();
        switch (compra) {
            case 1: // Chuleta
                if (alumno.getMonedas() >= 2) {
                    alumno.setMonedas(alumno.getMonedas() - 2);
                    alumno.setConocimiento(alumno.getConocimiento() + 3);
                    System.out.println("\nHas conseguido una chuleta (+3 conocimiento).");
                } else System.out.println("\nNo tienes suficientes monedas.");
                break;
            case 2: // Estudiar
                if (alumno.getMonedas() >= 3) {
                    alumno.setMonedas(alumno.getMonedas() - 3);
                    alumno.setConocimiento(alumno.getConocimiento() + 5);
                    System.out.println("\nHas estudiado duro (+5 conocimiento).");
                } else System.out.println("\nNo tienes suficientes monedas.");
                break;
            case 3: // Ayuda de compañero
                if (alumno.getMonedas() >= 1) {
                    alumno.setMonedas(alumno.getMonedas() - 1);
                    alumno.setConocimiento(alumno.getConocimiento() + 2);
                    System.out.println("\nUn companero te ayuda (+2 conocimiento).");
                } else System.out.println("\nNo tienes suficientes monedas.");
                break;
            case 4: // Bebida energética
                if (alumno.getMonedas() >= 2) {
                    alumno.setMonedas(alumno.getMonedas() - 2);
                    alumno.setEnergia(alumno.getEnergia() + 5);
                    System.out.println("\nHas tomado una bebida energetica (+5 energia).");
                } else System.out.println("\nNo tienes suficientes monedas.");
                break;
            case 5: // Café
                if (alumno.getMonedas() >= 1) {
                    alumno.setMonedas(alumno.getMonedas() - 1);
                    alumno.setEnergia(alumno.getEnergia() + 3);
                    System.out.println("\nHas tomado un cafe (+3 energia).");
                } else System.out.println("\nNo tienes suficientes monedas.");
                break;
            case 6: // Apuntes organizados
                if (alumno.getMonedas() >= 2) {
                    alumno.setMonedas(alumno.getMonedas() - 2);
                    alumno.setDefensa(alumno.getDefensa() + 2);
                    System.out.println("\nHas conseguido apuntes organizados (+2 defensa).");
                } else System.out.println("\nNo tienes suficientes monedas.");
                break;
            default:
                System.out.println("\nOpcion no valida.");
        }
    }
}

