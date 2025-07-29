package ProyectoVet;

import javax.swing.*;

public class VeterinariaGUI extends JFrame {

    Usuario user = new Usuario();
    private JPanel panel;
    private JButton enviarButton;
    private JTextField escribir;
    private JPanel titulo;
    private JTextArea chat;
    public boolean usuarioRegistrado;
    ChatBotEngine chatBot = new ChatBotEngine();

    public VeterinariaGUI() {
    }

    public void iniciar(){
        setTitle("PawPlus Veterinaria - ChatBot");
        setSize(800, 600);
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        configurarEventos();
        mostrarInicio();
    }

    public void configurarEventos() {
        enviarButton.addActionListener(e -> enviarMensaje());

        escribir.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (escribir.getText().equals("Escriba su mensaje")) {
                    escribir.setText("");
                }
            }
        });
    }

    public void enviarMensaje() {

        String mensaje = escribir.getText().trim();
        if (mensaje.isEmpty() || mensaje.equals("Escriba su mensaje")) return;

        // Mostrar mensaje usuario
        chat.append("Tú: " + mensaje + "\n");

        String respuesta;
        if (!usuarioRegistrado) {
            if (chatBot.esSalida(mensaje)) {
                respuesta = chatBot.obtenerDespedida();
                chat.append("Bot: " + respuesta + "\n\n");
                escribir.setText("Escriba su mensaje");
                chatBot.cerrarVet();

            } else {
                chatBot.getUsuario().setNombre(mensaje);
                usuarioRegistrado = true;
                respuesta = "¡Hola " + mensaje + "! Bienvenido a PawPlus. ¿En qué puedo ayudarte?";
                chat.append("Bot: " + respuesta + "\n\n");
                escribir.setText("Escriba su mensaje");
                chat.append("Bot: Estos son los temas en los que puedo ayudarte: \nServicios \nMedicina \nCirugia \nEmergencia \n Cita \n Precio \n Horario \n Vacunas\n\n");
                return;
            }

        } else {
            if (chatBot.esSalida(mensaje)) {
                respuesta = chatBot.obtenerDespedida();
                chat.append("Bot: " + respuesta + "\n\n");
                escribir.setText("Escriba su mensaje");
                chatBot.cerrarVet();
            } else {
                respuesta = chatBot.procesarMensaje(mensaje, chatBot.getUsuario().getNombre());
            }
        }

        chat.append("Bot: " + respuesta + "\n\n");
        escribir.setText("Escriba su mensaje");

        // Scroll al final
        chat.setCaretPosition(chat.getDocument().getLength());
    }

    public void mostrarInicio() {
        chat.append("=== PAWPLUS VETERINARIA ===\n");
        chat.append("Universidad Tecnológica - Proyecto Final\n");
        chat.append("Profesor: Rodrigo Yángüez\n");
        chat.append("Materia: Programación de Software I\n\n");
        chat.append(chatBot.obtenerSaludoInicial() + "\n");
        chat.append("¿Cuál es tu nombre?\n\n");
    }
}
