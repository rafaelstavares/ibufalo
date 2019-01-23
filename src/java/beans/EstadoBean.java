/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import cidade.CidadeRn;
import cidade.Cidades;
import estado.EstadoRn;
import estado.Estados;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author asus
 */
@ManagedBean
@RequestScoped
public class EstadoBean implements Serializable {

    private Estados estado;
    private List<Estados> lista;
    private String destinoSalvar;
    


    /**
     * Creates a new instance of EstadoBean
     */
    public EstadoBean() {
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public List<Estados> getLista() {

        if (this.lista == null) {
            EstadoRn usuarioRN = new EstadoRn();
            this.lista = usuarioRN.listarAll();
        }
        return this.lista;
    }

    public void setLista(List<Estados> lista) {
        this.lista = lista;
    }

}
