package com.proyecto;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 * La clase {@code EnviarCorreo} permite enviar correos electrónicos utilizando el protocolo SMTP de Gmail.
 *
 * <p>Utiliza autenticación mediante una cuenta de Gmail y configura una sesión segura usando TLS.</p>
 *
 * <p><b>Importante:</b> Es necesario habilitar el acceso de aplicaciones menos seguras o generar una contraseña
 * de aplicación desde la configuración de seguridad de la cuenta de Google.</p>
 *
 * @author Daniela Bozza
 */
public class EnviarCorreo {
    /**
     * Envía un correo electrónico a un destinatario específico con un asunto y un cuerpo de mensaje.
     *
     * @param destinatario Dirección de correo electrónico del destinatario.
     * @param asunto Asunto del mensaje de correo.
     * @param cuerpo Contenido textual del mensaje.
     */
    public static void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        final String remitente = "mdanielabozzav@gmail.com";
        final String password = "vtce wbho jsxl xzwz";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
    
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, password);
            }
        });
    
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
    
            Transport.send(message);
            System.out.println("Correo enviado exitosamente a " + destinatario);
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
            }
        }
    }
