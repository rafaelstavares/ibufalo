/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bezerro;

import animal.Animal;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "bezerro")
public class Bezerro implements BaseEntity, Serializable {

    @Id
    @GeneratedValue
    private Integer idBezerro;
    @ManyToOne
    @JoinColumn(name = "pai_idAnimal", nullable = false)
    private Animal PaiAnimal;
    private String nome;
    @Temporal(javax.persistence.TemporalType.DATE)
    @JoinColumn(name = "Data_nascimento", nullable = false)
    private Date datanascimento;
    private float peso;
    @ManyToOne
    @JoinColumn(name = "mae_idAnimal", nullable = false)
    private Animal MaeAnimal;
@ManyToOne
@OnDelete(action = OnDeleteAction.CASCADE)
@JoinColumn(name = "idUsuario", nullable = false)
private Usuario usuario;
    
      private static final long serialVersionUID = 1L;
  
    @Override
     public Long getId() {  
        return new Long(idBezerro); }
    
    public Bezerro() {
    }

    public Bezerro(Integer idBezerro, Animal PaiAnimal, String nome, Date datanascimento, float peso, Animal MaeAnimal) {
        this.idBezerro = idBezerro;
        this.PaiAnimal = PaiAnimal;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.peso = peso;
        this.MaeAnimal = MaeAnimal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdBezerro() {
        return idBezerro;
    }

    public void setIdBezerro(Integer idBezerro) {
        this.idBezerro = idBezerro;
    }

    public Animal getPaiAnimal() {
        return PaiAnimal;
    }

    public void setPaiAnimal(Animal PaiAnimal) {
        this.PaiAnimal = PaiAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Animal getMaeAnimal() {
        return MaeAnimal;
    }

    public void setMaeAnimal(Animal MaeAnimal) {
        this.MaeAnimal = MaeAnimal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.idBezerro != null ? this.idBezerro.hashCode() : 0);
        hash = 97 * hash + (this.PaiAnimal != null ? this.PaiAnimal.hashCode() : 0);
        hash = 97 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 97 * hash + (this.datanascimento != null ? this.datanascimento.hashCode() : 0);
        hash = 97 * hash + Float.floatToIntBits(this.peso);
        hash = 97 * hash + (this.MaeAnimal != null ? this.MaeAnimal.hashCode() : 0);
        hash = 97 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
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
        final Bezerro other = (Bezerro) obj;
        if (this.idBezerro != other.idBezerro && (this.idBezerro == null || !this.idBezerro.equals(other.idBezerro))) {
            return false;
        }
        if (this.PaiAnimal != other.PaiAnimal && (this.PaiAnimal == null || !this.PaiAnimal.equals(other.PaiAnimal))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.datanascimento != other.datanascimento && (this.datanascimento == null || !this.datanascimento.equals(other.datanascimento))) {
            return false;
        }
        if (Float.floatToIntBits(this.peso) != Float.floatToIntBits(other.peso)) {
            return false;
        }
        if (this.MaeAnimal != other.MaeAnimal && (this.MaeAnimal == null || !this.MaeAnimal.equals(other.MaeAnimal))) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

   
    
}
