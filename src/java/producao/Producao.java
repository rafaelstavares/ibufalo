/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producao;

import animal.Animal;
import fazenda.Fazenda;
import funcionarios.Funcionarios;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "producao")
public class Producao implements Serializable {

    @Id
    @GeneratedValue
    private Integer idProducao;
    @ManyToOne
    @JoinColumn(name = "Animal_idAnimal", nullable = false)
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "Funcionarios_idFuncionarios", nullable = false)
    private Funcionarios funcionarios;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date diaProducao;
    private float quantidade;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fazenda_idfazenda", nullable = false)
    private Fazenda fazenda;

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

   

    public Integer getIdProducao() {
        return idProducao;
    }

    public void setIdProducao(Integer idProducao) {
        this.idProducao = idProducao;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Date getDiaProducao() {
        return diaProducao;
    }

    public void setDiaProducao(Date diaProducao) {
        this.diaProducao = diaProducao;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public Producao() {
    }

    public Producao(Integer idProducao, Animal animal, Funcionarios funcionarios, Date diaProducao, float quantidade) {
        this.idProducao = idProducao;
        this.animal = animal;
        this.funcionarios = funcionarios;
        this.diaProducao = diaProducao;
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.idProducao != null ? this.idProducao.hashCode() : 0);
        hash = 59 * hash + (this.animal != null ? this.animal.hashCode() : 0);
        hash = 59 * hash + (this.funcionarios != null ? this.funcionarios.hashCode() : 0);
        hash = 59 * hash + (this.diaProducao != null ? this.diaProducao.hashCode() : 0);
        hash = 59 * hash + Float.floatToIntBits(this.quantidade);
        hash = 59 * hash + (this.fazenda != null ? this.fazenda.hashCode() : 0);
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
        final Producao other = (Producao) obj;
        if (this.idProducao != other.idProducao && (this.idProducao == null || !this.idProducao.equals(other.idProducao))) {
            return false;
        }
        if (this.animal != other.animal && (this.animal == null || !this.animal.equals(other.animal))) {
            return false;
        }
        if (this.funcionarios != other.funcionarios && (this.funcionarios == null || !this.funcionarios.equals(other.funcionarios))) {
            return false;
        }
        if (this.diaProducao != other.diaProducao && (this.diaProducao == null || !this.diaProducao.equals(other.diaProducao))) {
            return false;
        }
        if (Float.floatToIntBits(this.quantidade) != Float.floatToIntBits(other.quantidade)) {
            return false;
        }
        if (this.fazenda != other.fazenda && (this.fazenda == null || !this.fazenda.equals(other.fazenda))) {
            return false;
        }
        return true;
    }
}
