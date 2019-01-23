/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import local.Local;
import local.LocalRn;
import util.ContextoUtil;


/**
 *
 * @author Rafael
 */
@ManagedBean(name = "localBean")
@RequestScoped
public class LocalBean {
    private Local local = new Local();
    private List<Local> lista;
    private String destinoSalvar;
    
     public String novo() {
        this.destinoSalvar = "local/listar.jsf";
        this.local = new Local();
        
        return "/local/local";
    }

      public String editar() {
          LocalRn localRN = new LocalRn();
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        localRN.carregar(contextoBean.getFazendaAtiva().getIdfazenda());
        return "/local/local1";
    }

    public String salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.local.setFazenda(contextoBean.getFazendaAtiva());
        LocalRn localRN = new LocalRn();
        localRN.salvar(this.local);
        this.local= new Local();
     
        return "/local/listar?faces-redirect=true";
    }

    public String avisoPirquete() {
        String msg;
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
      LocalRn local = new LocalRn();
        if (local.listar(contextoBean.getFazendaAtiva()).size()==0) {         
         msg = "<p>Você não tem <a href=\"../local/local.jsf\">Piquetes</a> cadastrado nessa fazenda.</p>\n" +
"        <a href=\"../local/local.jsf\"> <div class=\"btn btn-small btn-success\">Cadastrar</div></a>";
         return msg; 
        }
        else   {
             msg = ""; 
          return msg;
        }
           
    }

    public String excluir() {
        LocalRn usuarioRn = new LocalRn();
        usuarioRn.excluir(local);
        local =  new Local();
        this.lista = null;

        return "";
    } 
     
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

  

    public List<Local> getLista() {
         if (this.lista == null) {
             ContextoBean contextoBean = ContextoUtil.getContextoBean();
            LocalRn localRn = new LocalRn();
            this.lista = localRn.listar(contextoBean.getFazendaAtiva());
        }
        return lista;
    }

    public void setLista(List<Local> lista) {
        this.lista = lista;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
     
}
