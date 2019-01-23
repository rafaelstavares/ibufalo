/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local;

import fazenda.Fazenda;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import usuario.Usuario;
import util.BaseEntity;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "local")
public class Local implements BaseEntity, Serializable {

    @Id
    @GeneratedValue
    private Integer idlocal;
    private int numeroLocal;
    private String nome;
    private String tamanho;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fazenda_idfazenda", nullable = false)
    private Fazenda fazenda;
    private String forragem;

    public Local() {
    }
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return new Long(idlocal);
    }

    public Integer getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(Integer idlocal) {
        this.idlocal = idlocal;
    }

    public int getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public String getForragem() {
        return forragem;
    }

    public void setForragem(String forragem) {
        this.forragem = forragem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.idlocal != null ? this.idlocal.hashCode() : 0);
        hash = 29 * hash + this.numeroLocal;
        hash = 29 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 29 * hash + (this.tamanho != null ? this.tamanho.hashCode() : 0);
        hash = 29 * hash + (this.fazenda != null ? this.fazenda.hashCode() : 0);
        hash = 29 * hash + (this.forragem != null ? this.forragem.hashCode() : 0);
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
        final Local other = (Local) obj;
        if (this.idlocal != other.idlocal && (this.idlocal == null || !this.idlocal.equals(other.idlocal))) {
            return false;
        }
        if (this.numeroLocal != other.numeroLocal) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.tamanho == null) ? (other.tamanho != null) : !this.tamanho.equals(other.tamanho)) {
            return false;
        }
        if (this.fazenda != other.fazenda && (this.fazenda == null || !this.fazenda.equals(other.fazenda))) {
            return false;
        }
        if ((this.forragem == null) ? (other.forragem != null) : !this.forragem.equals(other.forragem)) {
            return false;
        }
        return true;
    }
    
}
