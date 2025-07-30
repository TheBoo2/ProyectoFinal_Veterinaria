package ProyectoVet;

import java.util.*;

public class RespuestaEngine {
    public Map<String, List<String>> categoriasKeywords;
    public Map<String, String> respuestas;
    public List<String> saludos;
    public List<String> despedidas;
    public Random random;

    // NUEVO: Para simulación de citas
    public List<String> horariosDisponibles;
    public List<String> serviciosVeterinarios;
    public Map<String, String> citasAgendadas; // Para simular persistencia

    public RespuestaEngine() {
        this.categoriasKeywords = new HashMap<>();
        this.respuestas = new HashMap<>();
        this.saludos = new ArrayList<>();
        this.despedidas = new ArrayList<>();
        this.random = new Random();

        // NUEVO: Inicializar simulación de citas
        this.horariosDisponibles = new ArrayList<>();
        this.serviciosVeterinarios = new ArrayList<>();
        this.citasAgendadas = new HashMap<>();

        cargarKeywords();
        cargarRespuestas();
        cargarSaludos();
        cargarDespedidas();
        cargarHorariosDisponibles();
        cargarServiciosVeterinarios();
    }

    public void cargarKeywords() {
        // Horarios - todas las formas de preguntar por horarios
        categoriasKeywords.put("horario", Arrays.asList(
                "horario", "hora", "cuándo", "abierto", "cerrado",
                "atienden", "atención", "abre", "cierra", "disponible"
        ));

        // Servicios - diferentes formas de preguntar por servicios
        categoriasKeywords.put("servicios", Arrays.asList(
                "servicios", "ofrece", "hacen", "qué", "tratamientos",
                "especialidades", "atiende", "puede"
        ));

        // Medicina - términos médicos y relacionados
        categoriasKeywords.put("medicina", Arrays.asList(
                "medicina", "interno", "estómago", "riñón", "corazón",
                "enfermo", "mal", "raro", "síntomas", "consulta"
        ));

        // Cirugía
        categoriasKeywords.put("cirugia", Arrays.asList(
                "cirugía", "operación", "operar", "quirúrgico",
                "intervención", "cirujano"
        ));

        // Emergencias
        categoriasKeywords.put("emergencia", Arrays.asList(
                "emergencia", "urgente", "grave", "inmediato",
                "rápido", "ahora", "ya", "crítico"
        ));

        // Citas - aquí implementaremos la simulación
        categoriasKeywords.put("cita", Arrays.asList(
                "cita", "turno", "agendar", "reservar", "appointment",
                "programar", "cuando", "disponibilidad"
        ));

        // Precios
        categoriasKeywords.put("precio", Arrays.asList(
                "precio", "costo", "cuánto", "valor", "cotización",
                "tarifa", "pagar", "cobran"
        ));

        // Vacunas
        categoriasKeywords.put("vacunas", Arrays.asList(
                "vacuna", "vacunas", "inmunización", "esquema",
                "calendario", "prevención"
        ));
    }

    public void cargarRespuestas() {
        respuestas.put("servicios", "PawPlus ofrece: Medicina, Cirugía, Emergencias, Odontología, Dermatología, Peluquería y Guardería.");
        respuestas.put("medicina", "Atendemos problemas internos: estómago, riñones, corazón. Si tu mascota está rara, consúltanos.");
        respuestas.put("cirugia", "Realizamos cirugías generales y especializadas con veterinarios expertos.");
        respuestas.put("emergencia", "Atendemos emergencias 24/7. Si es urgente, ven inmediatamente.");
        // CAMBIADO: No generamos la respuesta aquí, se hace dinámicamente
        respuestas.put("cita", "DINAMICA"); // Marcador especial
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

    // MEJORADO: Sistema de búsqueda con respuestas dinámicas
    public String buscarRespuesta(String mensaje) {
        mensaje = mensaje.toLowerCase();

        // Buscar en cada categoría
        for (String categoria : categoriasKeywords.keySet()) {
            List<String> keywords = categoriasKeywords.get(categoria);

            // Verificar si alguna palabra clave coincide
            for (String keyword : keywords) {
                if (mensaje.contains(keyword)) {
                    String respuesta = respuestas.get(categoria);

                    // NUEVO: Si es una respuesta dinámica, generarla ahora
                    if ("DINAMICA".equals(respuesta) && "cita".equals(categoria)) {
                        return generarRespuestaCita();
                    }

                    return respuesta;
                }
            }
        }

        // Si no encuentra nada, respuesta por defecto más amigable
        return "No estoy seguro de entender tu consulta. ¿Preguntas sobre servicios, horarios, citas o precios? ¡Puedo ayudarte con eso!";
    }

    public boolean esSaludo(String mensaje) {
        mensaje = mensaje.toLowerCase();
        return mensaje.contains("hola") || mensaje.contains("buenas") ||
                mensaje.contains("saludos") || mensaje.contains("buenos días") ||
                mensaje.contains("buenas tardes");
    }

    public String getSaludoAleatorio() {
        return saludos.get(random.nextInt(saludos.size()));
    }

    public String getDespedidaAleatoria() {
        return despedidas.get(random.nextInt(despedidas.size()));
    }

    // ======================== SIMULACIÓN DE CITAS ========================

    public void cargarHorariosDisponibles() {
        horariosDisponibles.add("Mañana 9:00 AM");
        horariosDisponibles.add("Mañana 11:30 AM");
        horariosDisponibles.add("Mañana 2:00 PM");
        horariosDisponibles.add("Mañana 4:30 PM");
        horariosDisponibles.add("Pasado mañana 8:00 AM");
        horariosDisponibles.add("Pasado mañana 10:00 AM");
        horariosDisponibles.add("Pasado mañana 3:00 PM");
        horariosDisponibles.add("Viernes 9:30 AM");
        horariosDisponibles.add("Viernes 1:00 PM");
        horariosDisponibles.add("Sábado 10:00 AM");
    }

    public void cargarServiciosVeterinarios() {
        serviciosVeterinarios.add("Consulta General");
        serviciosVeterinarios.add("Vacunación");
        serviciosVeterinarios.add("Cirugía");
        serviciosVeterinarios.add("Emergencia");
        serviciosVeterinarios.add("Odontología");
        serviciosVeterinarios.add("Dermatología");
        serviciosVeterinarios.add("Peluquería");
    }

    // MEJORADO: Respuesta más compacta para evitar problemas de formato
    public String generarRespuestaCita() {
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("¡Perfecto! Te ayudo a agendar una cita.\n\n");
        respuesta.append("SERVICIOS DISPONIBLES:\n");

        for (int i = 0; i < Math.min(4, serviciosVeterinarios.size()); i++) {
            respuesta.append((i + 1)).append(". ").append(serviciosVeterinarios.get(i)).append("\n");
        }

        respuesta.append("\nHORARIOS DISPONIBLES:\n");
        List<String> horariosLimitados = horariosDisponibles.subList(0, Math.min(4, horariosDisponibles.size()));
        for (String horario : horariosLimitados) {
            respuesta.append("• ").append(horario).append("\n");
        }

        respuesta.append("\n¿Qué servicio y horario prefieres?");
        return respuesta.toString();
    }

    public String simularAgendarCita(String servicio, String horario) {
        String numeroCita = "PW" + (1000 + random.nextInt(9000));
        citasAgendadas.put(numeroCita, servicio + " - " + horario);

        return String.format(
                "¡Cita agendada exitosamente!\n\n" +
                        "Número de cita: %s\n" +
                        "Servicio: %s\n" +
                        "Fecha y hora: %s\n" +
                        "Ubicación: PawPlus Veterinaria\n\n" +
                        "Llega 10 minutos antes. Para cambios, menciona tu número de cita.",
                numeroCita, servicio, horario
        );
    }

    public String consultarCita(String numeroCita) {
        if (citasAgendadas.containsKey(numeroCita)) {
            String detalles = citasAgendadas.get(numeroCita);
            return String.format(
                    "Cita encontrada: %s\n" +
                            "Detalles: %s\n" +
                            "Estado: Confirmada",
                    numeroCita, detalles
            );
        } else {
            return "No encuentro esa cita. ¿Podrías verificar el número? Formato: PW####";
        }
    }

    public boolean esConsultaCita(String mensaje) {
        mensaje = mensaje.toLowerCase();
        return (mensaje.contains("cita") && mensaje.contains("pw")) ||
                mensaje.contains("número") || mensaje.contains("consultar");
    }

    public boolean esSolicitudCita(String mensaje) {
        mensaje = mensaje.toLowerCase();
        List<String> palabrasCita = Arrays.asList("cita", "turno", "agendar", "reservar", "programar");
        return palabrasCita.stream().anyMatch(mensaje::contains);
    }
}