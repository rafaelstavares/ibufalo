/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.io.*;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {


    @Id
    @GeneratedValue  
    private Integer idUsuario;
    
    private String nome;
    private String email;
    @org.hibernate.annotations.NaturalId
    private String login;
    private String senha;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;
    private String celular;
    private Boolean ativo;
    private String permissao;


    public Usuario() {
    }

   private static final long serialVersionUID = 1L;
  
   
     public Long getId() {  
        return new Long(idUsuario); }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

 

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.idUsuario != null ? this.idUsuario.hashCode() : 0);
        hash = 89 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 89 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 89 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 89 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 89 * hash + (this.nascimento != null ? this.nascimento.hashCode() : 0);
        hash = 89 * hash + (this.celular != null ? this.celular.hashCode() : 0);
        hash = 89 * hash + (this.ativo != null ? this.ativo.hashCode() : 0);
        hash = 89 * hash + (this.permissao != null ? this.permissao.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario && (this.idUsuario == null || !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if (this.nascimento != other.nascimento && (this.nascimento == null || !this.nascimento.equals(other.nascimento))) {
            return false;
        }
        if ((this.celular == null) ? (other.celular != null) : !this.celular.equals(other.celular)) {
            return false;
        }
        if (this.ativo != other.ativo && (this.ativo == null || !this.ativo.equals(other.ativo))) {
            return false;
        }
        if ((this.permissao == null) ? (other.permissao != null) : !this.permissao.equals(other.permissao)) {
            return false;
        }
        return true;
    }

   
}
