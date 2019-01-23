/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reproducao;

import animal.Animal;
import fazenda.Fazenda;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import util.BaseEntity;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "reproducao")
public class Reproducao implements BaseEntity, Serializable {

    @Id
    @GeneratedValue
    private Integer idReproducao;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "pai_idAnimal")
    private Animal PaiAnimal;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date diaCruzamento;
    private String tipo;
    private String inseminador;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "mae_idAnimal")
    private Animal MaeAnimal;
   @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fazenda_idfazenda", nullable = false)
    private Fazenda fazenda;
    private Boolean femeaSucesso;

    public Reproducao() {
    }
     
    
    @Override
    public Long getId() {
        return new Long(idReproducao);
    }

    public Reproducao(Integer idReproducao, Animal PaiAnimal, Date diaCruzamento, String tipo, Animal MaeAnimal) {
        this.idReproducao = idReproducao;
        this.PaiAnimal = PaiAnimal;
        this.diaCruzamento = diaCruzamento;
        this.tipo = tipo;
        this.MaeAnimal = MaeAnimal;
    }

    public Boolean getFemeaSucesso() {
        return femeaSucesso;
    }

    public void setFemeaSucesso(Boolean femeaSucesso) {
        this.femeaSucesso = femeaSucesso;
    }

    
    public String getInseminador() {
        return inseminador;
    }

    public void setInseminador(String inseminador) {
        this.inseminador = inseminador;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public Integer getIdReproducao() {
        return idReproducao;
    }

    public void setIdReproducao(Integer idReproducao) {
        this.idReproducao = idReproducao;
    }

    public Animal getPaiAnimal() {
        return PaiAnimal;
    }

    public void setPaiAnimal(Animal PaiAnimal) {
        this.PaiAnimal = PaiAnimal;
    }

    public Date getDiaCruzamento() {
        return diaCruzamento;
    }

    public void setDiaCruzamento(Date diaCruzamento) {
        this.diaCruzamento = diaCruzamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Animal getMaeAnimal() {
        return MaeAnimal;
    }

    public void setMaeAnimal(Animal MaeAnimal) {
        this.MaeAnimal = MaeAnimal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.idReproducao != null ? this.idReproducao.hashCode() : 0);
        hash = 71 * hash + (this.PaiAnimal != null ? this.PaiAnimal.hashCode() : 0);
        hash = 71 * hash + (this.diaCruzamento != null ? this.diaCruzamento.hashCode() : 0);
        hash = 71 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 71 * hash + (this.MaeAnimal != null ? this.MaeAnimal.hashCode() : 0);
        hash = 71 * hash + (this.fazenda != null ? this.fazenda.hashCode() : 0);
        hash = 71 * hash + (this.inseminador != null ? this.inseminador.hashCode() : 0);
        hash = 71 * hash + (this.femeaSucesso != null ? this.femeaSucesso.hashCode() : 0);
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
        final Reproducao other = (Reproducao) obj;
        if (this.idReproducao != other.idReproducao && (this.idReproducao == null || !this.idReproducao.equals(other.idReproducao))) {
            return false;
        }
        if (this.PaiAnimal != other.PaiAnimal && (this.PaiAnimal == null || !this.PaiAnimal.equals(other.PaiAnimal))) {
            return false;
        }
        if (this.diaCruzamento != other.diaCruzamento && (this.diaCruzamento == null || !this.diaCruzamento.equals(other.diaCruzamento))) {
            return false;
        }
        if ((this.tipo == null) ? (other.tipo != null) : !this.tipo.equals(other.tipo)) {
            return false;
        }
        if (this.MaeAnimal != other.MaeAnimal && (this.MaeAnimal == null || !this.MaeAnimal.equals(other.MaeAnimal))) {
            return false;
        }
        if (this.fazenda != other.fazenda && (this.fazenda == null || !this.fazenda.equals(other.fazenda))) {
            return false;
        }
         if ((this.inseminador == null) ? (other.inseminador != null) : !this.inseminador.equals(other.inseminador)) {
            return false;
        }
         if ((this.femeaSucesso == null) ? (other.femeaSucesso != null) : !this.femeaSucesso.equals(other.femeaSucesso)) {
            return false;
        }
        return true;
    }

  
}
