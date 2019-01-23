/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fazenda;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import usuario.Usuario;
import util.BaseEntity;
/**
 *
 * @author Rafael é 
 */
@Entity
@Table (name = "fazenda")
public class Fazenda implements BaseEntity, Serializable {

    @Id
    @GeneratedValue
    private Integer idfazenda;
    private String nome;
    private String nomeproprietario;
    private String endereco;
    private String telefone;
    private String email;
    private String estado;
    private String municipio;
    private String cnpj;
    private float areatotal;
    private float areapastagem;
   private float areapambiental;
    private float longitude;
    private float latitude;
@ManyToOne (targetEntity=usuario.Usuario.class)  
@OnDelete(action = OnDeleteAction.CASCADE)
@JoinColumn(name = "idUsuario", nullable = false)
private Usuario usuario;
private boolean favorita;

    public Fazenda() {
    }

  private static final long serialVersionUID = 1L;
  
    @Override
     public Long getId() {  
        return new Long(idfazenda); }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    
    public Integer getIdfazenda() {
        return idfazenda;
    }

    public void setIdfazenda(Integer idfazenda) {
        this.idfazenda = idfazenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeproprietario() {
        return nomeproprietario;
    }

    public void setNomeproprietario(String nomeproprietario) {
        this.nomeproprietario = nomeproprietario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public float getAreatotal() {
        return areatotal;
    }

    public void setAreatotal(float areatotal) {
        this.areatotal = areatotal;
    }

    public float getAreapastagem() {
        return areapastagem;
    }

    public void setAreapastagem(float areapastagem) {
        this.areapastagem = areapastagem;
    }

    public float getAreapambiental() {
        return areapambiental;
    }

    public void setAreapambiental(float areapambiental) {
        this.areapambiental = areapambiental;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.idfazenda != null ? this.idfazenda.hashCode() : 0);
        hash = 71 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 71 * hash + (this.nomeproprietario != null ? this.nomeproprietario.hashCode() : 0);
        hash = 71 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 71 * hash + (this.telefone != null ? this.telefone.hashCode() : 0);
        hash = 71 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 71 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 71 * hash + (this.municipio != null ? this.municipio.hashCode() : 0);
        hash = 71 * hash + (this.cnpj != null ? this.cnpj.hashCode() : 0);
        hash = 71 * hash + Float.floatToIntBits(this.areatotal);
        hash = 71 * hash + Float.floatToIntBits(this.areapastagem);
      hash = 71 * hash + Float.floatToIntBits(this.areapambiental);
        hash = 71 * hash + Float.floatToIntBits(this.longitude);
        hash = 71 * hash + Float.floatToIntBits(this.latitude);
        hash = 71 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        hash = 71 * hash + (this.favorita ? 1 : 0);
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
        final Fazenda other = (Fazenda) obj;
        if (this.idfazenda != other.idfazenda && (this.idfazenda == null || !this.idfazenda.equals(other.idfazenda))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.nomeproprietario == null) ? (other.nomeproprietario != null) : !this.nomeproprietario.equals(other.nomeproprietario)) {
            return false;
        }
        if ((this.endereco == null) ? (other.endereco != null) : !this.endereco.equals(other.endereco)) {
            return false;
        }
        if ((this.telefone == null) ? (other.telefone != null) : !this.telefone.equals(other.telefone)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.estado == null) ? (other.estado != null) : !this.estado.equals(other.estado)) {
            return false;
        }
        if ((this.municipio == null) ? (other.municipio != null) : !this.municipio.equals(other.municipio)) {
            return false;
        }
        if ((this.cnpj == null) ? (other.cnpj != null) : !this.cnpj.equals(other.cnpj)) {
            return false;
        }
        if (Float.floatToIntBits(this.areatotal) != Float.floatToIntBits(other.areatotal)) {
            return false;
        }
        if (Float.floatToIntBits(this.areapastagem) != Float.floatToIntBits(other.areapastagem)) {
            return false;
        }
    
        if (Float.floatToIntBits(this.areapambiental) != Float.floatToIntBits(other.areapambiental)) {
            return false;
        }
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(other.longitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        if (this.favorita != other.favorita) {
            return false;
        }
        return true;
    }



  
}
