/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bezerro.Bezerro;
import bezerro.BezerroRn;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import util.ContextoUtil;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "bezerroBean")
@RequestScoped
public class BezerroBean {

    private Bezerro bezerro = new Bezerro();
    private List<Bezerro> lista;
    private String destinoSalvar;

    public String novo() {
        this.destinoSalvar = "listar";
        this.bezerro = new Bezerro();

        return "/bezerro/bezerro";
    }

    public String editar() {

        return "/public/usuario";
    }

    public String salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.bezerro.setUsuario(contextoBean.getUsuarioLogado());
        BezerroRn animalRN = new BezerroRn();
        animalRN.salvar(this.bezerro);
        return this.destinoSalvar;
    }

    public String excluir() {
        BezerroRn bezerroRn = new BezerroRn();
        bezerroRn.excluir(bezerro);
        this.lista = null;

        return null;
    }

    public Bezerro getBezerro() {
        return bezerro;
    }

    public void setBezerro(Bezerro bezerro) {
        this.bezerro = bezerro;
    }

    public List<Bezerro> getLista() {
           if (this.lista == null) {
               ContextoBean contextoBean = ContextoUtil.getContextoBean();
           BezerroRn animalRn = new BezerroRn();
            this.lista = animalRn.listar(contextoBean.getUsuarioLogado());
        }
        return lista;
    }

    public void setLista(List<Bezerro> lista) {
        this.lista = lista;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
}
