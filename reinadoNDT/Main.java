package reinadondt;

import java.util.Scanner;

/**
 * Clase principal del RPG escolar.
 * Contiene el bucle de juego, la interacción con el alumno y los profesores,
 * así como los menús y la lógica para superar exámenes, comprar en la tienda
 * y enfrentarse al Director como jefe final.
 *
 * @author Eva Gallardo Romero
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que inicia el juego.
     * Controla el bucle de juego, mostrando menús y gestionando las elecciones
     * del jugador hasta que termina la partida.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombresProfesores = {"Casandra", "Miguel", "Guillermo", "Javier"};

        Alumno alumno = iniciarJuego(sc);

        boolean jugando = true;
        while (jugando) {
            mostrarMenu();
            int eleccion = sc.nextInt();
            
            switch (eleccion) {
                case 1: // Examen
                    int random = (int)(Math.random() * nombresProfesores.length);
                    Profesor profesor = new Profesor(nombresProfesores[random]);
                    profesor.generarExamen();

                    System.out.println("---------- INICIO DEL EXAMEN ----------");
                    System.out.println("El profesor " + profesor.getNombre() + " te ha puesto un examen.");
                    System.out.println("\n" + alumno);
                    System.out.println("\nDificultad del examen: " + profesor.getDificultadExamen() + "\n");

                    animacionExamen();

                    int ataqueEnemigo = profesor.getDificultadExamen();

                    if (alumno.getConocimiento() >= ataqueEnemigo) {
                        // Apruebas por conocimiento
                        System.out.println("Has aprobado gracias a tu conocimiento.");
                        int monedasGanadas = profesor.darMonedas();
                        alumno.setMonedas(alumno.getMonedas() + monedasGanadas);
                        System.out.println("Ganas " + monedasGanadas + " monedas.");
                        alumno.subirNivel();
                        System.out.println("Subes a nivel " + alumno.getNivel());
                        System.out.println("Los examenes seran mas dificiles a partir de ahora...");

                        // Jefe final
                        if (alumno.getNivel() >= 5) {
                            System.out.println("\nHas alcanzado el nivel 5!");
                            System.out.println("El Director te espera con el examen final...");
                            System.out.println("Quieres enfrentarte ahora o seguir preparandote?");
                            System.out.println("1. Enfrentarse al Director");
                            System.out.println("2. Seguir preparandome");

                            int decision = sc.nextInt();

                            if (decision == 1) {
                                Profesor jefeFinal = new Profesor("JEFE FINAL - Director");
                                jefeFinal.setDificultadExamen(20);
                                System.out.println("\nTe enfrentas al examen final del Director.");
                                animacionExamen();

                                int ataqueJefe = jefeFinal.getDificultadExamen();

                                if (alumno.getConocimiento() >= ataqueJefe) {
                                    System.out.println("Has aprobado el examen final gracias a tu conocimiento.");
                                    System.out.println("Has derrotado al Director y superado el curso!");
                                    jugando = false;
                                } else {
                                    int dañoBase = ataqueJefe;
                                    int reduccion = alumno.getDefensa();
                                    int dañoFinal = dañoBase - reduccion;
                                    if (dañoFinal < 1) dañoFinal = 1;

                                    alumno.setEnergia(alumno.getEnergia() - dañoFinal);
                                    if (reduccion > 0) {
                                        System.out.println("El examen iba a quitarte " + dañoBase +
                                                           " puntos de energia, pero gracias a tu defensa (" + reduccion +
                                                           ") solo pierdes " + dañoFinal + ".");
                                    } else {
                                        System.out.println("Has suspendido el examen final... pierdes " + dañoFinal + " puntos de energia.");
                                    }
                                    
                                    System.out.println("Barra de energia: " + alumno.mostrarBarraEnergia());

                                    if (alumno.getEnergia() <= 0) {
                                        System.out.println("Tu energia ha llegado a 0. El Director te ha derrotado...");
                                    } else {
                                        System.out.println("Aun te queda energia, pero no logras superar al Director, os tocara veros las caras el anio que viene");
                                    }
                                    jugando = false;
                                }
                            } else {
                                System.out.println("\nDecides esperar y seguir preparándote antes de enfrentarte al Director.");
                            }
                        }
                    } else {
                        int dañoBase = ataqueEnemigo;
                        int reduccion = alumno.getDefensa();
                        int dañoFinal = dañoBase - reduccion;
                        if (dañoFinal < 1) dañoFinal = 1;

                        alumno.setEnergia(alumno.getEnergia() - dañoFinal);
                        if (reduccion > 0) {
                            System.out.println("El examen iba a quitarte " + dañoBase +
                                               " puntos de energia, pero gracias a tu defensa (" + reduccion +
                                               ") solo pierdes " + dañoFinal + ".");
                        } else {
                            System.out.println("Has suspendido... pierdes " + dañoFinal + " puntos de energia.");
                        }
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
                case 3: // Estadisticas
                    System.out.println("\n---------- ESTADISTICAS JUGADOR ----------");
                    System.out.println(alumno);
                    System.out.println("Barra de energia: " + alumno.mostrarBarraEnergia());
                    break;
                case 4: // Salir
                    jugando = false;
                    System.out.println("Gracias por jugar. Hasta la proxima evaluacion!");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        sc.close();
    }

    /**
     * Muestra el menú principal con las opciones disponibles para el jugador.
     */
    public static void mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Presentarse a examen");
        System.out.println("2. Prepararse (tienda)");
        System.out.println("3. Consultar tus estadisticas");
        System.out.println("4. Salir");
        System.out.print("Elige una opcion: ");
    }

    /**
     * Muestra las opciones de la tienda del alumno,
     * donde puede gastar monedas para mejorar atributos.
     */
    public static void mostrarTienda() {
        System.out.println("\n--- TIENDA DEL ALUMNO ---");
        System.out.println("1. Chuleta (+3 conocimiento) - 2 monedas");
        System.out.println("2. Estudiar (+5 conocimiento) - 3 monedas");
        System.out.println("3. Pedir ayuda a un companero (+2 conocimiento) - 1 moneda");
        System.out.println("4. Bebida energetica (+5 energia) - 2 monedas");
        System.out.println("5. Cafe (+3 energia) - 1 moneda");
        System.out.println("6. Apuntes organizados (+2 defensa) - 2 monedas");
        System.out.print("Elige una opcion: ");
    }

    /**
     * Simula una animación de examen en la consola,
     * mostrando puntos suspensivos y pausas para dar sensación de progreso.
     */
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

    /**
     * Inicia el juego mostrando la introducción y solicitando el nombre del alumno.
     * Calcula el conocimiento inicial y permite recalcularlo gastando una moneda.
     *
     * @param sc Scanner para leer la entrada del usuario.
     * @return Alumno inicializado con nombre y atributos básicos.
     */
    public static Alumno iniciarJuego(Scanner sc) {
        System.out.println("======================================================");
        System.out.println("  ____  _            _                _     _         ");      
        System.out.println(" | __ )(_) ___ _ __ | |__   ___ _ __ (_) __| | ___    ");
        System.out.println(" |  _ \\| |/ _ \\ '_ \\| '_ \\ / _ \\ '_ \\| |/ _` |/ _ \\   ");
        System.out.println(" | |_) | |  __/ | | | |_) |  __/ | | | | (_| | (_) |  ");
        System.out.println(" |____/|_|\\___|_| |_|_.__/ \\___|_| |_|_|\\__,_|\\___/   ");
        System.out.println("                                                      ");
        System.out.println("                  AL CURSO EN NDT                     ");
        System.out.println("======================================================");
        System.out.println("Eres un alumno que acaba de comenzar el de DAM.");
        System.out.println("Tu objetivo pasar el curso escolar, sobreviviendo a examenes");
        System.out.println("para ello tendras que mejorar tus conocimientos y tu defensa,");
        System.out.println("y reunir suficientes monedas para prepararte.");
        System.out.println();
        System.out.println("Cada profesor te pondrá un examen con dificultad aleatoria.");
        System.out.println("- Si tu CONOCIMIENTO es mayor o igual, apruebas.");
        System.out.println("- Si fallas, perderás ENERGIA.");
        System.out.println("- Tu DEFENSA reduce la cantidad de energía perdida en los suspensos.");
        System.out.println();
        System.out.println("Puedes gastar monedas en la TIENDA para mejorar:");
        System.out.println("  Conocimiento, Energia o Defensa.");
        System.out.println("Recuerda: tu energia maxima es 20.");
        System.out.println();
        System.out.println("Al subir de nivel, los examenes seran mas duros.");
        System.out.println("Si alcanzas el nivel 5, te enfrentaras al JEFE FINAL:");
        System.out.println("el Director, con un examen definitivo.");
        System.out.println();
        System.out.println("Podras superar el curso y derrotar al Director?");
        System.out.println("Que empiece la aventura academica!");
        System.out.println("==============================================");

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

    /**
     * Permite al alumno realizar una compra en la tienda,
     * mejorando sus atributos a cambio de monedas.
     *
     * @param sc Scanner para leer la entrada del usuario.
     * @param alumno Alumno que realiza la compra.
     */
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
            case 5: // Cafe
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

