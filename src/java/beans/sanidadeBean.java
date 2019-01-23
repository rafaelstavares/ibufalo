/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sanidade.Sanidade;
import sanidade.SanidadeRn;
import util.ContextoUtil;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "sanidadeBean")
@RequestScoped
public class sanidadeBean {

    private Sanidade sanidade = new Sanidade();
    private List<Sanidade> lista;
   private String destinoSalvar;
    public String novo() {
        this.destinoSalvar = "listar";
        this.sanidade = new Sanidade();

        return "/sanidade/sanidade";
    }

    public String editar() {

        return "/public/usuario";
    }

    public String salvar() {
           ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.sanidade.setUsuario(contextoBean.getUsuarioLogado());
        SanidadeRn producaoRN = new SanidadeRn();
        producaoRN.salvar(this.sanidade);
        return this.destinoSalvar;
    }

    public String excluir() {
        SanidadeRn sanidadeRn = new SanidadeRn();
        sanidadeRn.excluir(sanidade);
        this.lista = null;

        return null;
    }

    public Sanidade getSanidade() {
        return sanidade;
    }

    public void setSanidade(Sanidade sanidade) {
        this.sanidade = sanidade;
    }

    public List<Sanidade> getLista() {
        if (this.lista == null) {
              ContextoBean contextoBean = ContextoUtil.getContextoBean();
            SanidadeRn sanidadeRn = new SanidadeRn();
            this.lista = sanidadeRn.listar(contextoBean.getUsuarioLogado());
        }
        return lista;
    }

    public void setLista(List<Sanidade> lista) {
        this.lista = lista;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
 
}
