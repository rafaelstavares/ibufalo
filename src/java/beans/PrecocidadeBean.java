/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import precocidade.Precocidade;
import precocidade.PrecocidadeRn;
import util.ContextoUtil;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "precocidadeBean")
@RequestScoped
public class PrecocidadeBean {
    
       private Precocidade precocidade = new Precocidade();
    private List<Precocidade> lista;
    private String destinoSalvar;

                  public String novo() {
        this.destinoSalvar = "listar";
        this.precocidade = new Precocidade();
        
        return "/precocidade/precocidade";
    }

      public String editar() {
       
        return "/public/usuario";
    }

    public String salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.precocidade.setUsuario(contextoBean.getUsuarioLogado());
        PrecocidadeRn producaoRN = new PrecocidadeRn();
        producaoRN.salvar(this.precocidade);
        return this.destinoSalvar;
    }

    public String excluir() {
        PrecocidadeRn precocidadeRn = new PrecocidadeRn();
        precocidadeRn.excluir(precocidade);
        this.lista = null;

        return null;
    }   
    
    
    public Precocidade getPrecocidade() {
        return precocidade;
    }

    public void setPrecocidade(Precocidade precocidade) {
        this.precocidade = precocidade;
    }

    public List<Precocidade> getLista() {
           if (this.lista == null) {
               ContextoBean contextoBean = ContextoUtil.getContextoBean();
            PrecocidadeRn precocidadeRn = new PrecocidadeRn();
            this.lista = precocidadeRn.listar(contextoBean.getUsuarioLogado());
        }
        return lista;
    }

    public void setLista(List<Precocidade> lista) {
        this.lista = lista;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
}
