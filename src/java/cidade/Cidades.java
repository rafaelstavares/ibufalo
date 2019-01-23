/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cidade;

import estado.Estados;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import util.BaseEntity;
/**
 *
 * @author Rafael é 
 */
@Entity
@Table (name = "cidades")
public class Cidades implements BaseEntity, Serializable {

    @Id
    @GeneratedValue
    private Integer cod_cidades;
    private String nome;
    private String cep;
@ManyToOne (targetEntity=estado.Estados.class)  
@OnDelete(action = OnDeleteAction.CASCADE)
@JoinColumn(name = "cod_estados", nullable = false)
private Estados estados_cod_estados;


    public Cidades() {
    }

  private static final long serialVersionUID = 1L;
  
    @Override
     public Long getId() {  
        return new Long(cod_cidades); }

    public Integer getCod_cidades() {
        return cod_cidades;
    }

    public void setCod_cidades(Integer cod_cidades) {
        this.cod_cidades = cod_cidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estados getEstados_cod_estados() {
        return estados_cod_estados;
    }

    public void setEstados_cod_estados(Estados estados_cod_estados) {
        this.estados_cod_estados = estados_cod_estados;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.cod_cidades != null ? this.cod_cidades.hashCode() : 0);
        hash = 67 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 67 * hash + (this.cep != null ? this.cep.hashCode() : 0);
        hash = 67 * hash + (this.estados_cod_estados != null ? this.estados_cod_estados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidades other = (Cidades) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.cep == null) ? (other.cep != null) : !this.cep.equals(other.cep)) {
            return false;
        }
        if (this.cod_cidades != other.cod_cidades && (this.cod_cidades == null || !this.cod_cidades.equals(other.cod_cidades))) {
            return false;
        }
        if (this.estados_cod_estados != other.estados_cod_estados && (this.estados_cod_estados == null || !this.estados_cod_estados.equals(other.estados_cod_estados))) {
            return false;
        }
        return true;
    }

  


 

  



  
}
