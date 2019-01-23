/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import fazenda.Fazenda;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import local.Local;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import util.BaseEntity;

/**
 *
 * @author Rafael
 */
@Entity(name = "animal")
public class Animal implements BaseEntity, Serializable {

    @Id
    @GeneratedValue
    private Integer idAnimal;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fazenda_idfazenda", nullable = false)
    private Fazenda fazenda;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "local_idlocal", nullable = false)
    private Local local;
    private String numeroAnimal;
    private String nome;
    private String raca;
    private float peso;
    private String sexo;
    private String nomePai;
    private String nomeMae;
    private String nomeAvo;
    private Boolean ativaFemea;
    private String tipoBaixa;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataBaixa;
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    private static final long serialVersionUID = 1L;

    @Override
    public Long getId() {
        return new Long(idAnimal);
    }

    public Animal() {
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getNumeroAnimal() {
        return numeroAnimal;
    }

    public void setNumeroAnimal(String numeroAnimal) {
        this.numeroAnimal = numeroAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomeAvo() {
        return nomeAvo;
    }

    public void setNomeAvo(String nomeAvo) {
        this.nomeAvo = nomeAvo;
    }

    public Boolean getAtivaFemea() {
        return ativaFemea;
    }

    public void setAtivaFemea(Boolean ativaFemea) {
        this.ativaFemea = ativaFemea;
    }

    public String getTipoBaixa() {
        return tipoBaixa;
    }

    public void setTipoBaixa(String tipoBaixa) {
        this.tipoBaixa = tipoBaixa;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.idAnimal != null ? this.idAnimal.hashCode() : 0);
        hash = 67 * hash + (this.fazenda != null ? this.fazenda.hashCode() : 0);
        hash = 67 * hash + (this.local != null ? this.local.hashCode() : 0);
        hash = 67 * hash + (this.numeroAnimal != null ? this.numeroAnimal.hashCode() : 0);
        hash = 67 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 67 * hash + (this.raca != null ? this.raca.hashCode() : 0);
        hash = 67 * hash + Float.floatToIntBits(this.peso);
        hash = 67 * hash + (this.sexo != null ? this.sexo.hashCode() : 0);
        hash = 67 * hash + (this.nomePai != null ? this.nomePai.hashCode() : 0);
        hash = 67 * hash + (this.nomeMae != null ? this.nomeMae.hashCode() : 0);
        hash = 67 * hash + (this.nomeAvo != null ? this.nomeAvo.hashCode() : 0);
        hash = 67 * hash + (this.ativaFemea != null ? this.ativaFemea.hashCode() : 0);
        hash = 67 * hash + (this.tipoBaixa != null ? this.tipoBaixa.hashCode() : 0);
        hash = 67 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 67 * hash + (this.dataNascimento != null ? this.dataNascimento.hashCode() : 0);
        hash = 67 * hash + (this.dataBaixa != null ? this.dataBaixa.hashCode() : 0);
        
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
        final Animal other = (Animal) obj;
        if (this.idAnimal != other.idAnimal && (this.idAnimal == null || !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        if (this.fazenda != other.fazenda && (this.fazenda == null || !this.fazenda.equals(other.fazenda))) {
            return false;
        }
        if (this.local != other.local && (this.local == null || !this.local.equals(other.local))) {
            return false;
        }
        if ((this.numeroAnimal == null) ? (other.numeroAnimal != null) : !this.numeroAnimal.equals(other.numeroAnimal)) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.raca == null) ? (other.raca != null) : !this.raca.equals(other.raca)) {
            return false;
        }
        if (Float.floatToIntBits(this.peso) != Float.floatToIntBits(other.peso)) {
            return false;
        }
        if ((this.sexo == null) ? (other.sexo != null) : !this.sexo.equals(other.sexo)) {
            return false;
        }
        if ((this.nomePai == null) ? (other.nomePai != null) : !this.nomePai.equals(other.nomePai)) {
            return false;
        }
        if ((this.nomeMae == null) ? (other.nomeMae != null) : !this.nomeMae.equals(other.nomeMae)) {
            return false;
        }
        if ((this.nomeAvo == null) ? (other.nomeAvo != null) : !this.nomeAvo.equals(other.nomeAvo)) {
            return false;
        }
        if (this.ativaFemea != other.ativaFemea && (this.ativaFemea == null || !this.ativaFemea.equals(other.ativaFemea))) {
            return false;
        }
        if (this.dataBaixa != other.dataBaixa && (this.dataBaixa == null || !this.dataBaixa.equals(other.dataBaixa))) {
            return false;
        }
        if ((this.tipoBaixa == null) ? (other.tipoBaixa != null) : !this.tipoBaixa.equals(other.tipoBaixa)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.dataNascimento != other.dataNascimento && (this.dataNascimento == null || !this.dataNascimento.equals(other.dataNascimento))) {
            return false;
        }
        return true;
    }

   
}
