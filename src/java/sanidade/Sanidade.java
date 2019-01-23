/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanidade;

import animal.Animal;
import java.io.Serializable;
import javax.persistence.*;
import local.Local;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import usuario.Usuario;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "sanidade")
public class Sanidade implements Serializable {

    @Id
    @GeneratedValue
    private Integer idSanidade;
    @ManyToOne
    @JoinColumn(name = "Animal_idAnimal", nullable = false)
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "Lote_Id_lugar", nullable = false)
    private Local local;
    private String vacina;
    private String vermefugo;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Sanidade() {
    }

    public Sanidade(Integer idSanidade, Animal animal, Local local, String vacina, String vermefugo) {
        this.idSanidade = idSanidade;
        this.animal = animal;
        this.local = local;

        this.vacina = vacina;
        this.vermefugo = vermefugo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdSanidade() {
        return idSanidade;
    }

    public void setIdSanidade(Integer idSanidade) {
        this.idSanidade = idSanidade;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String getVermefugo() {
        return vermefugo;
    }

    public void setVermefugo(String vermefugo) {
        this.vermefugo = vermefugo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.idSanidade != null ? this.idSanidade.hashCode() : 0);
        hash = 89 * hash + (this.animal != null ? this.animal.hashCode() : 0);
        hash = 89 * hash + (this.local != null ? this.local.hashCode() : 0);
        hash = 89 * hash + (this.vacina != null ? this.vacina.hashCode() : 0);
        hash = 89 * hash + (this.vermefugo != null ? this.vermefugo.hashCode() : 0);
        hash = 89 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
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
        final Sanidade other = (Sanidade) obj;
        if (this.idSanidade != other.idSanidade && (this.idSanidade == null || !this.idSanidade.equals(other.idSanidade))) {
            return false;
        }
        if (this.animal != other.animal && (this.animal == null || !this.animal.equals(other.animal))) {
            return false;
        }
        if (this.local != other.local && (this.local == null || !this.local.equals(other.local))) {
            return false;
        }
        if ((this.vacina == null) ? (other.vacina != null) : !this.vacina.equals(other.vacina)) {
            return false;
        }
        if ((this.vermefugo == null) ? (other.vermefugo != null) : !this.vermefugo.equals(other.vermefugo)) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }
}
