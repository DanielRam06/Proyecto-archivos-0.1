import java.io.Serializable;

public class PerfilJugador implements Serializable {
    private String nombre;
    private int juegosJugados;
    private int juegosGanados;
    private int juegosPerdidos;

    public PerfilJugador(String nombre) {
        this.nombre = nombre;
        this.juegosJugados = 0;
        this.juegosGanados = 0;
        this.juegosPerdidos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getJuegosJugados() {
        return juegosJugados;
    }

    public int getJuegosGanados() {
        return juegosGanados;
    }
    public int getJuegosPerdidos() {
        return juegosPerdidos;
    }

    public void incrementarJuegosJugados() {
        juegosJugados++;
    }

    public void incrementarJuegosGanados() {
        juegosGanados++;
    }
    public void incrementarJuegosPerdidos() {
        juegosPerdidos++;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nJuegos jugados: " + juegosJugados + "\nJuegos ganados: " + juegosGanados+ "\nJuegos Perdidos: " + juegosPerdidos;
    }
}