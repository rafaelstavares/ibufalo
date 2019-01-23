/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

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
@Table(name = "funcionarios")
public class Funcionarios implements BaseEntity, Serializable {

    @Id
    @GeneratedValue
    private Integer idFuncionarios;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fazenda_idfazenda", nullable = false)
    private Fazenda fazenda;
    private String Nome;
    private String Endereco;
    private String Telefone;
    private String rg;
    private String cpf;
    private String ctps;
    private String estadoCivil;
    private String funcao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataContrato;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDispenca;
    private float renumeracao;
    private int dependentes;
        @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    public Funcionarios() {
    }
    private static final long serialVersionUID = 1L;

    @Override
    public Long getId() {
        return new Long(idFuncionarios);
    }

    public Integer getIdFuncionarios() {
        return idFuncionarios;
    }

    public void setIdFuncionarios(Integer idFuncionarios) {
        this.idFuncionarios = idFuncionarios;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Date getDataDispenca() {
        return dataDispenca;
    }

    public void setDataDispenca(Date dataDispenca) {
        this.dataDispenca = dataDispenca;
    }

    public float getRenumeracao() {
        return renumeracao;
    }

    public void setRenumeracao(float renumeracao) {
        this.renumeracao = renumeracao;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.idFuncionarios != null ? this.idFuncionarios.hashCode() : 0);
        hash = 53 * hash + (this.fazenda != null ? this.fazenda.hashCode() : 0);
        hash = 53 * hash + (this.Nome != null ? this.Nome.hashCode() : 0);
        hash = 53 * hash + (this.Endereco != null ? this.Endereco.hashCode() : 0);
        hash = 53 * hash + (this.Telefone != null ? this.Telefone.hashCode() : 0);
        hash = 53 * hash + (this.rg != null ? this.rg.hashCode() : 0);
        hash = 53 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 53 * hash + (this.ctps != null ? this.ctps.hashCode() : 0);
        hash = 53 * hash + (this.estadoCivil != null ? this.estadoCivil.hashCode() : 0);
        hash = 53 * hash + (this.funcao != null ? this.funcao.hashCode() : 0);
        hash = 53 * hash + (this.dataContrato != null ? this.dataContrato.hashCode() : 0);
        hash = 53 * hash + (this.dataDispenca != null ? this.dataDispenca.hashCode() : 0);
        hash = 53 * hash + Float.floatToIntBits(this.renumeracao);
        hash = 53 * hash + this.dependentes;
        hash = 53 * hash + (this.dataNascimento != null ? this.dataNascimento.hashCode() : 0);
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
        final Funcionarios other = (Funcionarios) obj;
        if (this.idFuncionarios != other.idFuncionarios && (this.idFuncionarios == null || !this.idFuncionarios.equals(other.idFuncionarios))) {
            return false;
        }
        if (this.fazenda != other.fazenda && (this.fazenda == null || !this.fazenda.equals(other.fazenda))) {
            return false;
        }
        if ((this.Nome == null) ? (other.Nome != null) : !this.Nome.equals(other.Nome)) {
            return false;
        }
        if ((this.Endereco == null) ? (other.Endereco != null) : !this.Endereco.equals(other.Endereco)) {
            return false;
        }
        if ((this.Telefone == null) ? (other.Telefone != null) : !this.Telefone.equals(other.Telefone)) {
            return false;
        }
        if ((this.rg == null) ? (other.rg != null) : !this.rg.equals(other.rg)) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        if ((this.ctps == null) ? (other.ctps != null) : !this.ctps.equals(other.ctps)) {
            return false;
        }
        if ((this.estadoCivil == null) ? (other.estadoCivil != null) : !this.estadoCivil.equals(other.estadoCivil)) {
            return false;
        }
        if ((this.funcao == null) ? (other.funcao != null) : !this.funcao.equals(other.funcao)) {
            return false;
        }
        if (this.dataContrato != other.dataContrato && (this.dataContrato == null || !this.dataContrato.equals(other.dataContrato))) {
            return false;
        }
        if (this.dataDispenca != other.dataDispenca && (this.dataDispenca == null || !this.dataDispenca.equals(other.dataDispenca))) {
            return false;
        }
        if (Float.floatToIntBits(this.renumeracao) != Float.floatToIntBits(other.renumeracao)) {
            return false;
        }
        if (this.dependentes != other.dependentes) {
            return false;
        }
        if (this.dataNascimento != other.dataNascimento && (this.dataNascimento == null || !this.dataNascimento.equals(other.dataNascimento))) {
            return false;
        }
        return true;
    }

   
    
}
