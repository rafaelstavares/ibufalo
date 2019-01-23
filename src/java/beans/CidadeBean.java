/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import cidade.CidadeRn;
import cidade.Cidades;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author asus
 */
@ManagedBean
@RequestScoped
public class CidadeBean {

    /**
     * Creates a new instance of CidadeBean
     */
    public CidadeBean() {
    }
    private Cidades cidade;
    private List<Cidades> listaCidades;

    public Cidades getCidade() {
        return cidade;
    }

    public void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    public List<Cidades> getListaCidades() {
        if (this.listaCidades == null) {
            CidadeRn cidadeRN = new CidadeRn();
            this.listaCidades = cidadeRN.listarAll();
        }
        return this.listaCidades;
    }

    public void setListaCidades(List<Cidades> listaCidades) {
        this.listaCidades = listaCidades;
    }
    
}
