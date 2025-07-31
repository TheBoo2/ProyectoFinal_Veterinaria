package ProyectoVet;

import javax.swing.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ChatBotEngine {
    public RespuestaEngine RE;
    public Usuario usuario;
    public BufferedReader gafitas;
    private static final Logger logger = Logger.getLogger(ChatBotEngine.class.getName());

    public ChatBotEngine() {
        try {
            this.RE = new RespuestaEngine();
            this.usuario = new Usuario();
            this.gafitas = new BufferedReader(new InputStreamReader(System.in));
            logger.info("ChatBotEngine inicializado correctamente");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error inicializando ChatBotEngine", e);
            // Crear objetos por defecto para evitar NullPointerException
            this.RE = new RespuestaEngine();
            this.usuario = new Usuario();
            this.gafitas = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public String procesarMensaje(String mensaje, String nombreUsuario) {
        try {
            if (RE.esSaludo(mensaje)) {
                return obtenerSaludoInicial() + " " + nombreUsuario + "!";
            }

            return RE.buscarRespuesta(mensaje);

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error procesando mensaje: " + mensaje, e);
            return "Disculpa, tuve un problema procesando tu mensaje. ¿Puedes intentar de nuevo?";
        }
    }

    public boolean esSalida(String mensaje) {
        try {
            if (mensaje == null) return false;

            mensaje = mensaje.toLowerCase().trim();
            return mensaje.equals("salir") ||
                    mensaje.equals("adios") ||
                    mensaje.equals("adiós") ||
                    mensaje.equals("bye") ||
                    mensaje.equals("gracias") ||
                    mensaje.equals("chao") ||
                    mensaje.equals("exit");

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error verificando salida: " + mensaje, e);
            return false;
        }
    }

    public String obtenerSaludoInicial() {
        try {
            if (RE != null && RE.saludos != null && !RE.saludos.isEmpty()) {
                return RE.saludos.get(RE.random.nextInt(RE.saludos.size()));
            } else {
                return "¡Hola! Soy el asistente de PawPlus. ¿Cómo puedo ayudarte?";
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error obteniendo saludo inicial", e);
            return "¡Hola! Soy el asistente de PawPlus. ¿Cómo puedo ayudarte?";
        }
    }

    public String obtenerDespedida() {
        try {
            if (RE != null && RE.despedidas != null && !RE.despedidas.isEmpty()) {
                return RE.despedidas.get(RE.random.nextInt(RE.despedidas.size()));
            } else {
                return "¡Hasta luego! Gracias por elegir PawPlus.";
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error obteniendo despedida", e);
            return "¡Hasta luego! Gracias por elegir PawPlus.";
        }
    }

    public String leerEntrada() {
        try {
            if (gafitas != null) {
                String entrada = gafitas.readLine();
                return entrada != null ? entrada.trim() : "";
            } else {
                logger.warning("BufferedReader no inicializado");
                return "";
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error leyendo entrada del usuario", e);
            return "";
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error inesperado leyendo entrada", e);
            return "";
        }
    }

    public void cerrarGafitas() {
        try {
            if (gafitas != null) {
                gafitas.close();
                logger.info("BufferedReader cerrado correctamente");
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error cerrando BufferedReader", e);
            System.err.println("Error cerrando el lector de entrada: " + e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error inesperado cerrando BufferedReader", e);
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    public void cerrarVet() {
        try {
            Timer timer = new Timer(3000, e -> {
                try {
                    cerrarGafitas();
                    logger.info("Cerrando aplicación veterinaria");
                    System.exit(0);
                } catch (Exception ex) {
                    logger.log(Level.SEVERE, "Error durante cierre de aplicación", ex);
                    // Forzar cierre aunque haya error
                    System.exit(1);
                }
            });
            timer.setRepeats(false);
            timer.start();

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error configurando timer de cierre", e);
            // Cierre inmediato si hay error con el timer
            cerrarGafitas();
            System.exit(1);
        }
    }

    public Usuario getUsuario() {
        try {
            return usuario != null ? usuario : new Usuario();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error obteniendo usuario", e);
            return new Usuario();
        }
    }

    // Método para validar estado del engine
    public boolean estaInicializadoCorrectamente() {
        try {
            return RE != null &&
                    usuario != null &&
                    gafitas != null &&
                    RE.respuestas != null &&
                    RE.saludos != null &&
                    RE.despedidas != null;
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error verificando inicialización", e);
            return false;
        }
    }

    // Metodo para reinicializar en caso de error
    public void reinicializar() {
        try {
            logger.info("Reinicializando ChatBotEngine");
            this.RE = new RespuestaEngine();
            this.usuario = new Usuario();
            // No reinicializar gafitas para evitar problemas con System.in
            logger.info("Reinicialización completada");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error durante reinicialización", e);
        }
    }
}
