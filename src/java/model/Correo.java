/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ezeta
 */
public class Correo {

        private String destino;
        private String asunto;
        private String mensajeCorreo;
        private String codigo;

        public String getDestino() {
            return destino;
        }

        public void setDestino(String destino) {
            this.destino = destino;
        }

        public String getAsunto() {
            return asunto;
        }

        public void setAsunto(String asunto) {
            this.asunto = asunto;
        }

        public String getMensajeCorreo() {
            return mensajeCorreo;
        }

        public void setMensajeCorreo(String mensajeCorreo) {
            this.mensajeCorreo = mensajeCorreo;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public Correo() {
            this.destino = "";
            this.asunto = "";
            this.mensajeCorreo = "";
        }

        public boolean enviarMail(String destinoMail, String asuntoMail, String mensajeMail) {

            try {
                //correo(cuenta propia de gmail) del usuario para mandar mails
                String usuarioCorreo = "ezeta506@gmail.com";
                String pass = "naturall";

                Properties p = new Properties();
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.setProperty("mail.smtp.starttls.enable", "true");
                p.setProperty("mail.smtp.port", "587");
                p.setProperty("mail.smtp.user", usuarioCorreo);
                p.setProperty("mail.smtp.auth", "true");

                Session session = Session.getDefaultInstance(p, null);
                BodyPart texto = new MimeBodyPart();
                texto.setText(mensajeMail);

                MimeMultipart m = new MimeMultipart();
                m.addBodyPart(texto);

                MimeMessage mensaje = new MimeMessage(session);
                mensaje.setFrom(new InternetAddress(usuarioCorreo));
                mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinoMail));
                mensaje.setSubject(asuntoMail);
                mensaje.setContent(m);

                Transport t = session.getTransport("smtp");
                t.connect(usuarioCorreo, pass);
                t.sendMessage(mensaje, mensaje.getAllRecipients());
                t.close();
                return true;

            } catch (Exception e) {
                return false;
            }
        }

    }
