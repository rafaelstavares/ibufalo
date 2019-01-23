/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import animal.Animal;
import animal.AnimalRn;
import fazenda.Fazenda;
import fazenda.FazendaRn;
import java.util.List;
import javax.faces.bean.*;
import javax.faces.context.*;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import usuario.Usuario;
import usuario.UsuarioRn;

/**
 *
 * @author Rafael
 */

@ManagedBean(name = "contextoBean")
@SessionScoped
public class ContextoBean {

    private Usuario usuarioLogado = null;
    private Fazenda fazendaAtiva = null;
  

    public Usuario getUsuarioLogado() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String login = external.getRemoteUser();
        if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getLogin())) {
            if (login != null) {
                UsuarioRn usuarioRn = new UsuarioRn();
                this.usuarioLogado = usuarioRn.bucarPorLogin(login);
                this.fazendaAtiva = null;
            }
        }
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Fazenda getFazendaAtiva() {
        if (this.fazendaAtiva == null) {
            Usuario usuario = this.getUsuarioLogado();
            FazendaRn fazendaRn = new FazendaRn();
            this.fazendaAtiva = fazendaRn.buscarfavorita(usuario);
            if (this.fazendaAtiva == null) {
                List<Fazenda> fazendas = fazendaRn.listar(usuario);
                if (fazendas != null) {
                    for (Fazenda fazenda : fazendas) {
                        this.fazendaAtiva = fazenda;
                        break;
                    }
                }
            }
        }
        return fazendaAtiva;
    }
public void ativafazenda(){
   FacesContext fc = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

session.setAttribute("ID_USUARIO", this.fazendaAtiva.getNome());
                
     
}


 public void setAtivafazenda(Fazenda fazendaAtiva) {
        this.fazendaAtiva = fazendaAtiva;
    }



    public void setFazendaAtiva(ValueChangeEvent event) {                                                                                                                                                                                                                                                                                                                                         
        Integer fazenda = (Integer) event.getNewValue();
        FazendaRn fazendaRn = new FazendaRn();
        this.fazendaAtiva = fazendaRn.carregar(fazenda);

    }
}
