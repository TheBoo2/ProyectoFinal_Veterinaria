package ProyectoVet;

import java.util.*;

public class RespuestaEngine {
    public Map<String, String> respuestas;
    public List<String> saludos;
    public List<String> despedidas;
    public Random random;

    public RespuestaEngine() {
        this.respuestas = new HashMap<>();
        this.saludos = new ArrayList<>();
        this.despedidas = new ArrayList<>();
        this.random = new Random();
        cargarRespuestas();
        cargarSaludos();
        cargarDespedidas();
    }

    public void cargarRespuestas() {
        respuestas.put("servicios", "PawPlus ofrece: Medicina, Cirugía, Emergencias, Odontología, Dermatología, Peluquería y Guardería.");
        respuestas.put("medicina", "Atendemos problemas internos: estómago, riñones, corazón. Si tu mascota está rara, consúltanos.");
        respuestas.put("cirugia", "Realizamos cirugías generales y especializadas con veterinarios expertos.");
        respuestas.put("emergencia", "Atendemos emergencias 24/7. Si es urgente, ven inmediatamente.");
        respuestas.put("cita", "Para agendar cita necesito saber qué servicio necesitas y tu disponibilidad.");
        respuestas.put("precio", "Los precios varían según el servicio. Llama para cotización exacta.");
        respuestas.put("horario", "Atendemos lunes a sábado 7AM-8PM. Emergencias 24 horas.");
        respuestas.put("vacunas", "Mantenemos esquemas de vacunación para perros y gatos al día.");
        respuestas.put("gracias", "¡De nada! En PawPlus cuidamos tu mascota.");
    }

    public void cargarSaludos() {
        saludos.add("¡Hola! Soy el asistente de PawPlus. ¿Cómo puedo ayudarte?");
        saludos.add("¡Bienvenido a PawPlus! ¿En qué puedo asistirte?");
        saludos.add("¡Saludos! ¿Necesitas ayuda con tu mascota?");
    }

    public void cargarDespedidas() {
        despedidas.add("¡Hasta luego! Gracias por elegir PawPlus.");
        despedidas.add("¡Adiós! PawPlus siempre aquí para tu mascota.");
        despedidas.add("¡Nos vemos! PawPlus cuida tu mejor amigo.");
    }

    public String buscarRespuesta(String mensaje) {
        mensaje = mensaje.toLowerCase();

        for (String clave : respuestas.keySet()) {
            if (mensaje.contains(clave)) {
                return respuestas.get(clave);
            }
        }
        return "No estoy seguro. ¿Puedes ser más específico sobre el servicio que necesitas?";
    }

    public boolean esSaludo(String mensaje) {
        mensaje = mensaje.toLowerCase();
        return mensaje.contains("hola") || mensaje.contains("buenas") || mensaje.contains("saludos");
    }
}

