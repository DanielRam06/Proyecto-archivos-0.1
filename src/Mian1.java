import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;


public class Mian1 {
	private static final String DIR_PERFILES = "perfiles/";

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    PerfilJugador jugador = null;
	    boolean salir = false;

	    while (!salir) {
	    	System.out.println("   =========================================================");
	    	System.out.println("  |           BIENVENIDO AL JUEGO ADIVINA QUIÉN             |");
	    	System.out.println("  |                                                         |");
	    	System.out.println("  ==========================================================");
	    	System.out.println("  |                                                         |");
	    	System.out.println("  |                 MENÚ PRINCIPAL:                         |");
	    	System.out.println("  |                                                         |");
	    	System.out.println("  |1. Crear perfil de jugador(si eres nuevo jugador)        |");
	    	System.out.println("  |2. Cargar perfil de jugador(para seguir jugando)         |");
	    	System.out.println("  |3. Ver estadísticas de un jugador                        |");
	    	System.out.println("  |  (busca tus estadisticas con tu nombre de jugador)      |");
	    	System.out.println("  |4. Iniciar a jugar(despues de crear o cargar tu perfil)  |");
	    	System.out.println("  |5. Salir del menu                                        |");
	    	System.out.println("  |                                                         |");
	    	System.out.println("  ==========================================================");
	    	System.out.print("Seleccione una opción (1-5): ");
	        int opcion = sc.nextInt();
	        sc.nextLine(); // Consume el salto de línea

	        switch (opcion) {
	            case 1:
	                System.out.print("Ingrese el nombre del jugador: ");
	                String nombre = sc.nextLine();
	                jugador = new PerfilJugador(nombre);
	                guardarPerfil(jugador);
	                break;
	            case 2:
	                System.out.print("Ingrese el nombre del jugador: ");
	                nombre = sc.nextLine();
	                jugador = cargarPerfil(nombre);
	                break;
	            case 3:
	                System.out.print("Ingrese el nombre del jugador: ");
	                nombre = sc.nextLine();
	                jugador = cargarPerfil(nombre);
	                if (jugador != null) {
	                    System.out.println(jugador);
	                }
	                break;
	            case 4:
	                if (jugador != null) {
	                    jugar(jugador);
	                } else {
	                    System.out.println("Debe cargar o crear un perfil de jugador antes de iniciar el juego.");
	                }
	                break;
	            case 5:
	                salir = true;
	                break;
	            default:
	                System.out.println("Opción no válida.");
	                break;
	        }
	    }
	}


        	    private static void guardarPerfil(PerfilJugador jugador) {
        	        try {
        	            File file = new File(DIR_PERFILES + jugador.getNombre() + ".txt");
        	            if (!file.getParentFile().exists()) {
        	                file.getParentFile().mkdirs();
        	            }
        	            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        	            oos.writeObject(jugador);
        	            oos.close();
        	        } catch (IOException e) {
        	            e.printStackTrace();
        	        }
        	    }

        	    private static PerfilJugador cargarPerfil(String nombre) {
        	        try {
        	            File file = new File(DIR_PERFILES + nombre + ".txt");
        	            if (file.exists()) {
        	                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        	                PerfilJugador jugador = (PerfilJugador) ois.readObject();
        	                ois.close();
        	                return jugador;
        	            } else {
        	                System.out.println("El perfil del jugador no existe, cree un perfil nuevo.");
        	            }
        	        } catch (IOException | ClassNotFoundException e) {
        	            e.printStackTrace();
        	        }
        	        return null;
        	    }

        	    public static void jugar(PerfilJugador jugador) {
        	        Scanner sc = new Scanner(System.in);
        	        Personas[] persona = new Personas[10];
        	        for (int i = 0; i < 10; i++) {
        	            persona[i] = new Personas() {};
        	        }
        	        // contadores de los atributos
        	        int espada = 0;
        	        int millonario = 0;
        	        int mamado = 0;
        	        int feo = 0;
        	        int sabeProgramar = 0;
        	        int estaCansado = 0;
        	        int estaEnfermo = 0;
        	        int estaTriste = 0;
        	        int estaFeliz = 0;
        	        
        	        System.out.println("JUEGO ADIVINA QUIEN? (JUGADORES)");
        	        System.out.printf("%-15s %-15s %-15s %-15s %-15s%n", "Nombre", "Caracteristica 1", "Caracteristica 2", "Caracteristica 3", "Caracteristica 4");


        	        for (Personas personas : persona) {
        	            System.out.printf("%-15s", personas.getNombre());
        	            List<String> atributos = personas.getAtributos();

        	            for (int i = 0; i < 4; i++) {
        	                if (i < atributos.size()) {
        	                    System.out.printf("%-15s", atributos.get(i));
        	                } else {
        	                    System.out.printf("%-18s", "");
        	                }
        	            }
        	            System.out.println();

        	            for (String atributo : atributos) {
        	                switch (atributo) {
        	                    case "Tiene Espada":
        	                        espada++;
        	                        break;
        	                    case "Es Millonario":
        	                        millonario++;
        	                        break;
        	                    case "Está Mamado":
        	                        mamado++;
        	                        break;
        	                    case "Está Feo":
        	                        feo++;
        	                        break;
        	                    case "Sabe Programar":
        	                        sabeProgramar++;
        	                        break;
        	                    case "Está Cansado":
        	                        estaCansado++;
        	                        break;
        	                    case "Está Enfermo":
        	                        estaEnfermo++;
        	                        break;
        	                    case "Está Triste":
        	                        estaTriste++;
        	                        break;
        	                    case "Está Feliz":
        	                        estaFeliz++;
        	                        break;
        	                }
        	            }
        	        }
        	        System.out.println();
        	        System.out.println("REPETICION DE ATRIBUTOS");
        	        System.out.println("El Atributo Tiene Espada se repite: " + espada);
        	        System.out.println("El Atributo es Millonario se repite: " + millonario);
        	        System.out.println("El Atributo está Mamado se repite: " + mamado);
        	        System.out.println("El Atributo está Feo se repite: " + feo);
        	        System.out.println("El Atributo Sabe programar se repite: " + sabeProgramar);
        	        System.out.println("El Atributo está cansado se repite: " + estaCansado);
        	        System.out.println("El Atributo está enfermo se repite: " + estaEnfermo);
        	        System.out.println("El Atributo está triste se repite: " + estaTriste);
        	        System.out.println("El Atributo está feliz se repite: " + estaFeliz);
        	        System.out.println();
        	        
        	     // Comienzo de la implementación del menú
        	        int personaSeleccionada = new Random().nextInt(persona.length);

        	        for (int i = 0; i < 3; i++) {
        	            System.out.println("Pregunta " + (i + 1) + ":");
        	            System.out.println("Seleccione un atributo para eliminar personas:");
        	            for (int j = 0; j < Personas.getCaracteristicasImportantes().size(); j++) {
        	                System.out.println((j + 1) + ". " + Personas.getCaracteristicasImportantes().get(j));
        	            }
        	            int atributoElegido = sc.nextInt() - 1;
        	            String atributo = Personas.getCaracteristicasImportantes().get(atributoElegido);
        	            List<Personas> personasRestantes = new ArrayList<>();
        	            for (Personas p : persona) {
        	                if (!p.tieneAtributo(atributo)) {
        	                    personasRestantes.add(p);
        	                }
        	            }
        	            persona = personasRestantes.toArray(new Personas[0]);
        	            personaSeleccionada = new Random().nextInt(persona.length); // Actualizar la persona seleccionada

        	            System.out.println("Personas restantes:");
        	            for (Personas p : persona) {
        	                StringBuilder atributosConcatenados = new StringBuilder();
        	                for (String atributoIndividual : p.getAtributos()) {
        	                    atributosConcatenados.append(atributoIndividual).append(", ");
        	                }
        	                atributosConcatenados.setLength(atributosConcatenados.length() - 2); // Eliminar la última coma y espacio
        	                System.out.println(p.getNombre() + ": " + atributosConcatenados);
        	            }
        	            System.out.println();
        	        }

        	        System.out.println("Ingrese el índice de la persona que cree que es la seleccionada (1-" + persona.length + "):");
        	        int indiceElegido = sc.nextInt() - 1;
        	        if (indiceElegido >= 0 && indiceElegido < persona.length && persona[indiceElegido].getNombre().equals(persona[personaSeleccionada].getNombre())) {
        	            System.out.println("¡Felicidades! Ha adivinado correctamente. La persona seleccionada es " + persona[indiceElegido].getNombre());
        	            jugador.incrementarJuegosJugados();
        	            jugador.incrementarJuegosGanados();
        	        } else {
        	            System.out.println("Lo siento, no ha adivinado correctamente. La persona seleccionada era " + persona[personaSeleccionada].getNombre());
        	            jugador.incrementarJuegosJugados();
        	            jugador.incrementarJuegosPerdidos();
        	        }
        	        guardarPerfil(jugador);
        	    }
}