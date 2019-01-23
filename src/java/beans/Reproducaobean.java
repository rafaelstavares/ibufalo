/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import reproducao.Reproducao;
import reproducao.ReproducaoRn;
import util.ContextoUtil;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "reproducaoBean")
@RequestScoped
public class Reproducaobean {

    private Reproducao reproducao = new Reproducao();
    private List<Reproducao> lista;
    private List<Reproducao> lista2;
    private List<Reproducao> listarAparaDignostico;
    private List<Reproducao> listarAparaparir;
    private List<Reproducao> listarA_1_3gestacao;
    private List<Reproducao> listarA_4_6gestacao;
    private List<Reproducao> listarA_7_10gestacao;
    private List<Reproducao> listarAConcepcaoNegativa;
    private List<Reproducao> listarAporTipoMn;
    private List<Reproducao> listarAporTipoIa;
    private List<Reproducao> listarAporTipoIatf;
    private String destinoSalvar;
    private boolean value1;
    private boolean value2;
    private int resultado;

    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }

    public boolean isValue2() {
        return value2;
    }

    public void setValue2(boolean value2) {
        this.value2 = value2;
    }

    public Reproducao getReproducao() {
        return reproducao;
    }

    public String novo() {
        this.destinoSalvar = "listar";
        this.reproducao = new Reproducao();

        return "/reproducao/reproducao";
    }

    public String editar() {

        return "/reproducao/reproducao_cad";
    }

    public String salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.reproducao.setFazenda(contextoBean.getFazendaAtiva());
        ReproducaoRn animalRN = new ReproducaoRn();
        animalRN.salvar(this.reproducao);
        return "/reproducao/reproducao";
    }

    public String excluir() {
        ReproducaoRn reproducaoRn = new ReproducaoRn();
        reproducaoRn.excluir(reproducao);
        this.lista = null;

        return null;
    }

    //inices zootecnicos
    public int taxaNatalidade() {

        try {


            this.resultado = (listarAparaparir.size() * 100) / lista.size();

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return this.resultado;
    }

    public int taxaNUmeroServicoConcepcao() {
        try {
            this.resultado = lista.size() / listarAparaparir.size();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return this.resultado;
    }

    public int taxamortalidade() {
        try {
            AnimalBean oi = new AnimalBean();
            this.resultado = (oi.getListaNegativa().size() * 100) / oi.totalAnimal();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

        return this.resultado;
    }

    public int taxaIa() {
        try {
            this.resultado = (getListarAporTipoIa().size() * 100) / lista2.size();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return this.resultado;
    }

    public int taxaMn() {

        try {
            this.resultado = (getListarAporTipoMn().size() * 100) / lista2.size();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return this.resultado;
    }

    public int taxaIatf() {
        try {
            this.resultado = (getListarAporTipoIatf().size() * 100) / lista2.size();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return this.resultado;
    }

    //lista de reproducao
    public List<Reproducao> getListarAporTipoMn() {
        String tipo = "Monta Natural";
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn animalRn = new ReproducaoRn();
        this.listarAporTipoMn = animalRn.listarAporTipo(contextoBean.getFazendaAtiva(), Boolean.TRUE, tipo);

        return listarAporTipoMn;
    }

    public List<Reproducao> getListarAporTipoIa() {
        String tipo = "Iseminação Artificial";
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn animalRn = new ReproducaoRn();
        this.listarAporTipoIa = animalRn.listarAporTipo(contextoBean.getFazendaAtiva(), Boolean.TRUE, tipo);

        return listarAporTipoIa;
    }

    public List<Reproducao> getListarAporTipoIatf() {
        String tipo = "Iseminação Artificial em tempo fixo";
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn animalRn = new ReproducaoRn();
        this.listarAporTipoIatf = animalRn.listarAporTipo(contextoBean.getFazendaAtiva(), Boolean.TRUE, tipo);


        return listarAporTipoIatf;
    }

    public List<Reproducao> getListarAparaDignostico() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -30);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_YEAR, -45);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn reproducaoRn = new ReproducaoRn();
        this.listarAparaDignostico = reproducaoRn.listarAparaDignosticoConfirma(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva());

        return listarAparaDignostico;
    }

    public List<Reproducao> getListarAparaparir() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -270);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_YEAR, -311);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn reproducaoRn = new ReproducaoRn();
        this.listarAparaparir = reproducaoRn.listarAparaParir(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva(), Boolean.TRUE);

        return listarAparaparir;
    }

    public List<Reproducao> getLista2() {

        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn animalRn = new ReproducaoRn();
        this.lista2 = animalRn.listarfSucesso(contextoBean.getFazendaAtiva(), Boolean.TRUE);


        return lista2;
    }

    public List<Reproducao> getLista() {

        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn animalRn = new ReproducaoRn();
        this.lista = animalRn.listar(contextoBean.getFazendaAtiva());

        return lista;
    }

    public List<Reproducao> getListarA_1_3gestacao() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.MONTH, -3);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn reproducaoRn = new ReproducaoRn();
        this.listarA_1_3gestacao = reproducaoRn.listarAparaParir(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva(), Boolean.TRUE);

        return listarA_1_3gestacao;
    }

    public List<Reproducao> getListarA_4_6gestacao() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -4);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.MONTH, -6);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn reproducaoRn = new ReproducaoRn();
        this.listarA_4_6gestacao = reproducaoRn.listarAparaParir(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva(), Boolean.TRUE);

        return listarA_4_6gestacao;
    }

    public List<Reproducao> getListarA_7_10gestacao() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -7);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.MONTH, -10);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn reproducaoRn = new ReproducaoRn();
        this.listarA_7_10gestacao = reproducaoRn.listarAparaParir(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva(), Boolean.TRUE);

        return listarA_7_10gestacao;
    }

    public List<Reproducao> getListarAConcepcaoNegativa() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -45);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -30);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        ReproducaoRn reproducaoRn = new ReproducaoRn();
        this.listarAConcepcaoNegativa = reproducaoRn.listarAparaParir(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva(), Boolean.FALSE);


        return listarAConcepcaoNegativa;
    }

    // metodos sets
    public void setListarAporTipoMn(List<Reproducao> listarAporTipoMn) {
        this.listarAporTipoMn = listarAporTipoMn;
    }

    public void setListarAporTipoIa(List<Reproducao> listarAporTipoIa) {
        this.listarAporTipoIa = listarAporTipoIa;
    }

    public void setListarAporTipoIatf(List<Reproducao> listarAporTipoIatf) {
        this.listarAporTipoIatf = listarAporTipoIatf;
    }

    public void setListarAConcepcaoNegativa(List<Reproducao> listarAConcepcaoNegativa) {
        this.listarAConcepcaoNegativa = listarAConcepcaoNegativa;
    }

    public void setListarA_1_3gestacao(List<Reproducao> listarA_1_3gestacao) {
        this.listarA_1_3gestacao = listarA_1_3gestacao;
    }

    public void setListarA_4_6gestacao(List<Reproducao> listarA_4_6gestacao) {
        this.listarA_4_6gestacao = listarA_4_6gestacao;
    }

    public void setListarA_7_10gestacao(List<Reproducao> listarA_7_10gestacao) {
        this.listarA_7_10gestacao = listarA_7_10gestacao;
    }

    public void setListarAparaDignostico(List<Reproducao> listarAparaDignostico) {
        this.listarAparaDignostico = listarAparaDignostico;
    }

    public void setReproducao(Reproducao reproducao) {
        this.reproducao = reproducao;
    }

    public void setListarAparaparir(List<Reproducao> listarAparaparir) {
        this.listarAparaparir = listarAparaparir;
    }

    public void setLista2(List<Reproducao> lista2) {
        this.lista2 = lista2;
    }

    public void setLista(List<Reproducao> lista) {
        this.lista = lista;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
}
