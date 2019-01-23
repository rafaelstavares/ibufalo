/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package precocidade;

import bezerro.Bezerro;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import usuario.Usuario;

/**
 *
 * @author Rafael
 */
@Entity
@Table (name = "precocidade")
public class Precocidade implements Serializable {

    @Id
    @GeneratedValue
    private Integer idPrecocidade;
    @ManyToOne
    @JoinColumn(name = "Bezerro_idBezerro", nullable = false)
    private Bezerro bezerro;
    @JoinColumn(name="Data_precocidade")
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date data_precocidade;
@ManyToOne
@OnDelete(action = OnDeleteAction.CASCADE)
@JoinColumn(name = "idUsuario", nullable = false)
private Usuario usuario;
    public Precocidade() {
    }

    public Precocidade(Integer idPrecocidade, Bezerro bezerro, Date data_precocidade) {
        this.idPrecocidade = idPrecocidade;
        this.bezerro = bezerro;
        this.data_precocidade = data_precocidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdPrecocidade() {
        return idPrecocidade;
    }

    public void setIdPrecocidade(Integer idPrecocidade) {
        this.idPrecocidade = idPrecocidade;
    }

    public Bezerro getBezerro() {
        return bezerro;
    }

    public void setBezerro(Bezerro bezerro) {
        this.bezerro = bezerro;
    }

    public Date getData_precocidade() {
        return data_precocidade;
    }

    public void setData_precocidade(Date data_precocidade) {
        this.data_precocidade = data_precocidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.idPrecocidade != null ? this.idPrecocidade.hashCode() : 0);
        hash = 43 * hash + (this.bezerro != null ? this.bezerro.hashCode() : 0);
        hash = 43 * hash + (this.data_precocidade != null ? this.data_precocidade.hashCode() : 0);
        hash = 43 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Precocidade other = (Precocidade) obj;
        if (this.idPrecocidade != other.idPrecocidade && (this.idPrecocidade == null || !this.idPrecocidade.equals(other.idPrecocidade))) {
            return false;
        }
        if (this.bezerro != other.bezerro && (this.bezerro == null || !this.bezerro.equals(other.bezerro))) {
            return false;
        }
        if (this.data_precocidade != other.data_precocidade && (this.data_precocidade == null || !this.data_precocidade.equals(other.data_precocidade))) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    
}
