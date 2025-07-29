package PawPlus_Veterinaria;
import java.util.*;

public class PawPlus {
    private Map<String, String> respuestas;
    private List<String> saludos;
    private List<String> despedidas;
    private Scanner scanner;
    private String nombreUsuario;

    public PawPlus() {
        scanner = new Scanner(System.in);
        inicializarRespuestas();
        inicializarSaludos();
        inicializarDespedidas();
    }

    private void inicializarRespuestas() {
        respuestas = new HashMap<>();

        // Respuestas básicas
        respuestas.put("como estas", "¡Estoy funcionando perfectamente! ¿Cómo puedo ayudarte con tu mascota?");
        respuestas.put("que tal", "¡Todo bien por aquí! ¿En qué puedo asistirte hoy?");
        respuestas.put("tu nombre", "Soy VetBot, el asistente virtual de Veterinaria PawPlus_Veterinaria.PawPlus.");
        respuestas.put("quien eres", "Soy VetBot, tu asistente virtual de PawPlus_Veterinaria.PawPlus, la mejor veterinaria para tu mascota.");
        respuestas.put("ayuda", "Puedo ayudarte con información sobre servicios, citas, emergencias y cuidado de mascotas.");
        respuestas.put("gracias", "¡De nada! Siempre es un placer ayudar a cuidar de las mascotas.");

        // Servicios veterinarios
        respuestas.put("servicios", "En PawPlus_Veterinaria.PawPlus ofrecemos: Medicina Interna, Cirugía General, Emergencias, Odontología, Dermatología, Oftalmología, Peluquería y Guardería.");
        respuestas.put("medicina interna", "En PawPlus_Veterinaria.PawPlus, nuestro servicio de Medicina Interna atiende consultas generales y diagnósticos para tu mascota.");
        respuestas.put("cirugia", "PawPlus_Veterinaria.PawPlus cuenta con Cirugía General y Cirugías Especializadas realizadas por veterinarios expertos.");
        respuestas.put("emergencia", "¡PawPlus_Veterinaria.PawPlus atiende emergencias! Si es urgente, ven inmediatamente o llama para orientación.");
        respuestas.put("odontologia", "En PawPlus_Veterinaria.PawPlus ofrecemos limpieza dental y tratamientos odontológicos especializados para mascotas.");
        respuestas.put("dermatologia", "En PawPlus_Veterinaria.PawPlus tratamos problemas de piel, alergias y enfermedades dermatológicas en mascotas.");
        respuestas.put("oftalmologia", "PawPlus_Veterinaria.PawPlus cuida la salud ocular de tu mascota con especialistas en oftalmología veterinaria.");
        respuestas.put("peluqueria", "En PawPlus_Veterinaria.PawPlus ofrecemos servicios de peluquería y estética para mantener a tu mascota limpia y hermosa.");
        respuestas.put("guarderia", "PawPlus_Veterinaria.PawPlus cuenta con servicio de guardería para cuidar tu mascota cuando no puedas estar con ella.");

        // Citas y consultas
        respuestas.put("cita", "Para agendar una cita en PawPlus_Veterinaria.PawPlus, necesito saber qué servicio necesitas y tu disponibilidad.");
        respuestas.put("citas", "En PawPlus_Veterinaria.PawPlus puedes agendar citas para consultas, cirugías, peluquería o guardería.");
        respuestas.put("horario", "PawPlus_Veterinaria.PawPlus atiende de lunes a sábado. Contacta para horarios específicos.");
        respuestas.put("precio", "Los precios en PawPlus_Veterinaria.PawPlus varían según el servicio. Te recomiendo llamar para una cotización exacta.");
        respuestas.put("costos", "Los costos en PawPlus_Veterinaria.PawPlus dependen del tipo de consulta o tratamiento. Contáctanos para información detallada.");

        // Información sobre mascotas
        respuestas.put("vacunas", "Es importante mantener las vacunas al día. Podemos revisar el historial de vacunación de tu mascota.");
        respuestas.put("desparasitar", "La desparasitación regular es esencial. Consulta sobre el programa adecuado para tu mascota.");
        respuestas.put("esterilizar", "Ofrecemos servicios de esterilización. Es importante para la salud y control poblacional.");
        respuestas.put("castrar", "La castración previene enfermedades y mejora el comportamiento. Pregunta por nuestros servicios.");

        // Emergencias comunes
        respuestas.put("vomito", "Si tu mascota vomita repetidamente, trae inmediatamente o llama para orientación de emergencia.");
        respuestas.put("diarrea", "La diarrea persistente puede ser seria. Consulta pronto, especialmente si hay sangre.");
        respuestas.put("no come", "Si tu mascota no come por más de 24 horas, es recomendable una consulta veterinaria.");
        respuestas.put("letargico", "El letargo puede indicar enfermedad. Observa otros síntomas y consulta si persiste.");

        // Contacto y transporte
        respuestas.put("contacto", "Puedes contactar a PawPlus_Veterinaria.PawPlus por teléfono, WhatsApp o visitarnos directamente en nuestra clínica.");
        respuestas.put("transporte", "PawPlus_Veterinaria.PawPlus ofrece servicio de transporte para mascotas en casos necesarios.");
        respuestas.put("ubicacion", "Visítanos en PawPlus_Veterinaria.PawPlus. Te esperamos para cuidar de tu mascota con el mejor servicio.");

        // Información específica de PawPlus_Veterinaria.PawPlus
        respuestas.put("pawplus", "PawPlus_Veterinaria.PawPlus es tu veterinaria de confianza, dedicada al cuidado integral de tu mascota.");
        respuestas.put("veterinaria", "En Veterinaria PawPlus_Veterinaria.PawPlus brindamos atención médica completa para tu mejor amigo.");
    }

    private void inicializarSaludos() {
        saludos = Arrays.asList(
                "¡Hola! Soy VetBot de PawPlus_Veterinaria.PawPlus, ¿cómo puedo ayudarte con tu mascota?",
                "¡Bienvenido a PawPlus_Veterinaria.PawPlus! ¿En qué puedo asistirte hoy?",
                "¡Saludos! Soy el asistente de PawPlus_Veterinaria.PawPlus, estoy aquí para ayudarte.",
                "¡Hola! ¿Necesitas información sobre los servicios de PawPlus_Veterinaria.PawPlus?"
        );
    }

    private void inicializarDespedidas() {
        despedidas = Arrays.asList(
                "¡Hasta luego! Gracias por elegir PawPlus_Veterinaria.PawPlus para cuidar de tu mascota.",
                "¡Adiós! En PawPlus_Veterinaria.PawPlus siempre estaremos aquí para tu mascota.",
                "¡Nos vemos! Recuerda que PawPlus_Veterinaria.PawPlus es tu veterinaria de confianza.",
                "¡Que estés bien! PawPlus_Veterinaria.PawPlus cuida de tu mascota como si fuera nuestra."
        );
    }

    public void iniciarConversacion() {
        System.out.println("=== PAWPLUS VETERINARIA - VETBOT ===");
        System.out.println(obtenerSaludoAleatorio());
        System.out.print("¿Cuál es tu nombre? ");
        nombreUsuario = scanner.nextLine();
        System.out.println("¡Hola " + nombreUsuario + "! Puedes preguntarme sobre los servicios de PawPlus_Veterinaria.PawPlus, citas o cuidado de mascotas.");
        System.out.println("Escribe 'salir' para terminar la conversación.\n");

        String entrada;
        while (true) {
            System.out.print(nombreUsuario + ": ");
            entrada = scanner.nextLine().trim();

            if (esSalida(entrada)) {
                System.out.println("VetBot: " + obtenerDespedidaAleatoria());
                break;
            }

            String respuesta = procesarMensaje(entrada);
            System.out.println("VetBot: " + respuesta + "\n");
        }
    }

    private String procesarMensaje(String mensaje) {
        mensaje = mensaje.toLowerCase().trim();

        // Verificar si es un saludo
        if (esSaludo(mensaje)) {
            return obtenerSaludoAleatorio() + " " + nombreUsuario + "!";
        }

        // Buscar respuesta exacta
        for (String clave : respuestas.keySet()) {
            if (mensaje.contains(clave)) {
                return respuestas.get(clave);
            }
        }

        // Respuesta por defecto
        return obtenerRespuestaDefault();
    }

    private boolean esSaludo(String mensaje) {
        String[] saludosComunes = {"hola", "buenas", "saludos", "hey", "buenos dias", "buenas tardes", "buenas noches"};
        for (String saludo : saludosComunes) {
            if (mensaje.contains(saludo)) {
                return true;
            }
        }
        return false;
    }

    private boolean esSalida(String mensaje) {
        String[] salidasComunes = {"salir", "adios", "bye", "hasta luego", "chao", "nos vemos", "exit"};
        mensaje = mensaje.toLowerCase();
        for (String salida : salidasComunes) {
            if (mensaje.equals(salida)) {
                return true;
            }
        }
        return false;
    }

    private String obtenerSaludoAleatorio() {
        Random random = new Random();
        return saludos.get(random.nextInt(saludos.size()));
    }

    private String obtenerDespedidaAleatoria() {
        Random random = new Random();
        return despedidas.get(random.nextInt(despedidas.size()));
    }

    private String obtenerRespuestaDefault() {
        String[] respuestasDefault = {
                "Interesante. ¿Es algo relacionado con la salud de tu mascota?",
                "¿Podrías ser más específico sobre el servicio veterinario que necesitas?",
                "No estoy seguro de entender. ¿Necesitas información sobre algún servicio en particular?",
                "Puedo ayudarte con servicios veterinarios, citas, emergencias o cuidado de mascotas. ¿Qué necesitas?",
                "¿Tu consulta es sobre medicina, cirugía, peluquería o guardería para tu mascota?"
        };

        Random random = new Random();
        return respuestasDefault[random.nextInt(respuestasDefault.length)];
    }

    // Método para agregar nuevas respuestas (útil para personalización)
    public void agregarRespuesta(String clave, String respuesta) {
        respuestas.put(clave.toLowerCase(), respuesta);
    }

    // Método para agregar múltiples respuestas
    public void agregarRespuestas(Map<String, String> nuevasRespuestas) {
        for (Map.Entry<String, String> entrada : nuevasRespuestas.entrySet()) {
            respuestas.put(entrada.getKey().toLowerCase(), entrada.getValue());
        }
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
