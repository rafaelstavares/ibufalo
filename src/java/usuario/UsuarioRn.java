/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import util.DAOFactory;

/**
 *
 * @author Rafael
 */
public class UsuarioRn {

    private UsuarioDAO usuarioDao;
    private String emailFornecido;

    public UsuarioRn() {
        this.usuarioDao = DAOFactory.criarUsuarioDao();
    }

    public Usuario carregar(Integer idsanidade) {
        return this.usuarioDao.carregar(idsanidade);
    }

    public void salvar(Usuario usuario) {
        Integer idusuario = usuario.getIdUsuario();
        if (idusuario == null || idusuario == 0) {

            this.usuarioDao.salvar(usuario);
        } else {
            this.usuarioDao.atualizar(usuario);
        }
    }

    public void atualizar(Usuario usuario) {
        this.usuarioDao.atualizar(usuario);

    }

    public void excluir(Usuario usuario) {
        this.usuarioDao.excluir(usuario);
    }

    public List<Usuario> listar() {
        return this.usuarioDao.listar();
    }

    public Usuario bucarPorLogin(String login) {
        return this.usuarioDao.buscarPorLogin(login);
    }

    public Usuario bucarPorEmail(String email) {
        return this.usuarioDao.buscarPorEmail(email);
    }

    public void mandarEmail(String email) {

        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ibufaloufra@gmail.com", "Ucr7buf@");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {
            Usuario user = usuarioDao.carregar(usuarioDao.buscarPorEmail(email).getIdUsuario());
            emailFornecido = email;
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ibufaloufra@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(emailFornecido);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Recuperação login sistema UfraBull");//Assunto
            message.setText("Olá, " + user.getNome()+"\n"
            +"Usuário: "+user.getLogin()+"\n"
            +"Senha: "+user.getSenha());
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

            System.out.println("Feito!!!" + email);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
