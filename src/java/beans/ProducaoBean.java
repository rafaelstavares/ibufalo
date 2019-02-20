/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import animal.Animal;
import animal.AnimalRn;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import producao.Producao;
import producao.ProducaoRn;
import util.ContextoUtil;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "producaoBean")
@RequestScoped
public class ProducaoBean {

    private Producao producao = new Producao();
    private Animal animal;
    private List<Producao> lista;
    private List<Producao> listaAnimais;
    private String destinoSalvar;

    public String novo() {
        this.destinoSalvar = "listar";
        this.producao = new Producao();

        return "/producao/producao";
    }

    public String teste() {

        return "/producao/producao_teste_1";
    }

    public String editar() {

        return "/producao/producao_cad";
    }

    public String salvar() {

        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        producao.setFazenda(contextoBean.getFazendaAtiva());
        ProducaoRn producaoRN = new ProducaoRn();
        producaoRN.salvar(producao);

        return "/producao/inicioP?faces-redirect=true";
    }

    public String anoAtual() {
        Calendar anoAtual = Calendar.getInstance();
        return "" + anoAtual.get(Calendar.YEAR);
    }

    public String excluir() {
        ProducaoRn producaoRn = new ProducaoRn();
        producaoRn.excluir(producao);
        producao = new Producao();
        this.lista = null;

        return null;
    }

    public double somaProducao() {
        Double resultado;

        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ProducaoRn producaoRn = new ProducaoRn();
        resultado = producaoRn.totalProducao(contextoBean.getFazendaAtiva());

        return resultado;
    }

    public double somaProducaoAno() {

        Double resultado;

        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ProducaoRn producaoRn = new ProducaoRn();
        resultado = producaoRn.totalProducaoAno(contextoBean.getFazendaAtiva());

        return resultado;
    }

    public String somaProducaoAnimal(int id) {
        String msg = "não possui produção";
        Double resultado;
        AnimalRn ani = new AnimalRn();
        animal = ani.carregar(id);
        try {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            ProducaoRn producaoRn = new ProducaoRn();
            resultado = producaoRn.totalProducaoAnimal(contextoBean.getFazendaAtiva(), this.animal);
            if (resultado != null) {
                NumberFormat formatarFloat = new DecimalFormat("0.00");
                String nu = formatarFloat.format(resultado);

                return nu;
            } else {

                msg = "não possui produção";
                return msg;
            }
        } catch (Exception e) {
        }

        return msg;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }
//lista

    public List<Producao> getLista() {
        if (this.lista == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();

            ProducaoRn producaoRn = new ProducaoRn();
            this.lista = producaoRn.listar(contextoBean.getFazendaAtiva());
        }
        return lista;
    }

    public List<Producao> getListaAnimais() {

        ContextoBean contextoBean = ContextoUtil.getContextoBean();

        ProducaoRn producaoRn = new ProducaoRn();
        this.listaAnimais = producaoRn.listarAnimal(contextoBean.getFazendaAtiva(), animal);

        return listaAnimais;
    }

    //metodos sets
    public void setLista(List<Producao> lista) {
        this.lista = lista;
    }

    public void setListaAnimais(List<Producao> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
}
