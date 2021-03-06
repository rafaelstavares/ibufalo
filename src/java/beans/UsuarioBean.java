/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import usuario.Usuario;
import usuario.UsuarioRn;
import util.ContextoUtil;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    UsuarioRn usuarioRN = new UsuarioRn();
    private String confirmaSenha;
    private List<Usuario> lista = null;
    private String destinoSalvar = "/login.jsf";
    private boolean ro;

    public String novo() {
        this.destinoSalvar = "/WebApp/login.jsf";
        this.usuario = new Usuario();
        this.usuario.setAtivo(true);
        return "/publico/cadastro";
    }

    public String editar() {

        ContextoBean co = new ContextoBean();
        usuario = usuarioRN.carregar(co.getUsuarioLogado().getIdUsuario());

        return "/usuario/usuario_edit_1.jsf";
    }

    public String atualizar() {
        UsuarioRn usuarioRn = new UsuarioRn();
        ContextoBean co = ContextoUtil.getContextoBean();
        this.usuario.setIdUsuario(co.getUsuarioLogado().getIdUsuario());
        usuario.setPermissao("ROLE_X");
        usuarioRn.atualizar(this.usuario);

        return "/publico/inicio";
    }

    public boolean isRo(Usuario usuario) {
        if ("ROLE_ADMIN".equals(usuario.getPermissao())) {
            ro = true;
        } else {
            ro = false;
        }

        return ro;
    }

    public void setRo(boolean ro) {

        this.ro = ro;
    }

    public void atuaRole() {
        UsuarioRn user = new UsuarioRn();
        user.carregar(usuario.getIdUsuario());
        usuario.setPermissao("ROLE_ADMIN");
        user.atualizar(usuario);
    }

    public String salvar() {

        usuario.setPermissao("ROLE_X");
        Usuario user = new Usuario();
        Usuario user1 = new Usuario();
        UsuarioRn usuarioRN = new UsuarioRn();
        user = usuarioRN.bucarPorLogin(usuario.getLogin());
        user1 = usuarioRN.bucarPorEmail(usuario.getEmail());
        if (user == null && user1 == null) {
            usuarioRN.salvar(this.usuario);
            usuario = new Usuario();
            return destinoSalvar;
        } else {
            if (user == null && user1 != null) {
                this.destinoSalvar = "/cad-falha1?faces-redirect=true";
                return destinoSalvar;
            } else {
                this.destinoSalvar = "/cad-falha?faces-redirect=true";
               return destinoSalvar;
            }
         
        }

    }

    public void excluir() {
        UsuarioRn usuarioRN = new UsuarioRn();
        usuarioRN.excluir(this.usuario);
        this.lista = null;
    }

    public void carregar() {
        UsuarioRn usuarioRN = new UsuarioRn();
        ContextoBean co = new ContextoBean();
        usuarioRN.carregar(co.getUsuarioLogado().getIdUsuario());

    }

    public String ativar() {
        if (this.usuario.getAtivo()) {
            this.usuario.setAtivo(false);
        } else {
            this.usuario.setAtivo(true);
        }

        UsuarioRn usuarioRN = new UsuarioRn();
        usuarioRN.salvar(this.usuario);
        return null;
    }

    public List<Usuario> getLista() {
        if (this.lista == null) {
            UsuarioRn usuarioRN = new UsuarioRn();
            this.lista = usuarioRN.listar();
        }
        return this.lista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }

}
