/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estado;

import java.io.Serializable;
import javax.persistence.*;
import util.BaseEntity;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "estados")
public class Estados implements BaseEntity, Serializable {

    @Id
    private Integer cod_estados;
    private String sigla;
    private String nome;

    
      private static final long serialVersionUID = 1L;
  
    @Override
     public Long getId() {  
        return new Long(cod_estados); }
    
    public Estados() {
    }

    public Estados(Integer cod_estados, String sigla, String nome) {
        this.cod_estados = cod_estados;
        this.sigla = sigla;
        this.nome = nome;
    }

    public Integer getCod_estados() {
        return cod_estados;
    }

    public void setCod_estados(Integer cod_estados) {
        this.cod_estados = cod_estados;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.cod_estados != null ? this.cod_estados.hashCode() : 0);
        hash = 41 * hash + (this.sigla != null ? this.sigla.hashCode() : 0);
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
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
        final Estados other = (Estados) obj;
        if ((this.sigla == null) ? (other.sigla != null) : !this.sigla.equals(other.sigla)) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.cod_estados != other.cod_estados && (this.cod_estados == null || !this.cod_estados.equals(other.cod_estados))) {
            return false;
        }
        return true;
    }



   

   
   
    
}
