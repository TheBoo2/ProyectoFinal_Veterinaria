package ProyectoVet;

import javax.swing.*;
import java.io.*;

public class ChatBotEngine {
    public RespuestaEngine RE;
    public Usuario usuario;
    public BufferedReader gafitas;

    public ChatBotEngine() {
        this.RE = new RespuestaEngine();
        this.usuario = new Usuario();
        this.gafitas = new BufferedReader(new InputStreamReader(System.in));
    }

    public String procesarMensaje(String mensaje, String nombreUsuario) {
        if (RE.esSaludo(mensaje)) {
            return obtenerSaludoInicial() + " " + nombreUsuario + "!";
        }
        return RE.buscarRespuesta(mensaje);
    }

    public boolean esSalida(String mensaje) {
        mensaje = mensaje.toLowerCase();
        return mensaje.equals("salir") || mensaje.equals("adios") || mensaje.equals("bye") || mensaje.equals("gracias");
    }

    public String obtenerSaludoInicial() {
        return RE.saludos.get(RE.random.nextInt(RE.saludos.size()));
    }

    public String obtenerDespedida() {
        return RE.despedidas.get(RE.random.nextInt(RE.despedidas.size()));
    }

    public String leerEntrada() {
        try {
            return gafitas.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public void cerrarGafitas() {
        try {
            gafitas.close();
        } catch (IOException e) {
            System.err.println("Error cerrando gafitas");
        }
    }

    public void cerrarVet() {
        Timer timer = new Timer(2000, e -> {
            cerrarGafitas();
            System.exit(0);
        });
        timer.setRepeats(false);
        timer.start();
    }

    public Usuario getUsuario() {
        return usuario;
    }
}