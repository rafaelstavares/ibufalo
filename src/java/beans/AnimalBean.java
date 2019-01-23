/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import animal.Animal;
import animal.AnimalRn;
import fazenda.Fazenda;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import local.Local;
import local.LocalRn;
import util.ContextoUtil;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "animalBean")
@RequestScoped
public class AnimalBean {

    private Animal animal = new Animal();
    private List<Animal> lista;
    private List<Animal> listaF;
    private List<Animal> listaM;
    private List<Animal> listaTotal_A_menos12m;
    private List<Animal> listaTotal_A_12e24m;
    private List<Animal> listaTotal_A_acima24m;
    private List<Animal> listaTotalNascidaAno;
    private List<Animal> listaNegativa;
    private List<Animal> listaFNegativa;
    private List<Animal> listaMNegativa;
    private List<Animal> listaProducao;
    private String destinoSalvar;
    private String sexo;
    private boolean value1;

    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }

    public String novo() {
        this.destinoSalvar = "listar";
        this.animal = new Animal();

        return "/animal/animal";
    }

    public String anoAtual() {
        Calendar anoAtual = Calendar.getInstance();
        return "" + anoAtual.get(Calendar.YEAR);
    }

    public String IdadeAnimalAMD(Date dataNas) {
        GregorianCalendar datanascimento = new GregorianCalendar();
        datanascimento.setTime(dataNas);
        Calendar anoAtual = Calendar.getInstance();
        Date atual = anoAtual.getTime();
        GregorianCalendar dataatual = new GregorianCalendar();
        dataatual.setTime(atual);
        GregorianCalendar dif = new GregorianCalendar();
        dif.setTimeInMillis(dataatual.getTimeInMillis() - datanascimento.getTimeInMillis());
        int ano = (dataatual.get(GregorianCalendar.YEAR) - datanascimento.get(GregorianCalendar.YEAR) - 1);
        if (ano < 0) {
            ano = 0;
        }
        int meses = dif.get(GregorianCalendar.MONTH);
        int dias = dif.get(GregorianCalendar.DAY_OF_MONTH) - 1;

        return ano + " Ano(s) " + meses + " Mese(s) " + dias + " Dia(s)";
    }

    public String anoAtual_1() {
        Calendar anoAtual = Calendar.getInstance();
        anoAtual.add(Calendar.YEAR, -1);
        return "" + anoAtual.get(Calendar.YEAR);
    }

    public String anoAtual_2() {
        Calendar anoAtual = Calendar.getInstance();
        anoAtual.add(Calendar.YEAR, -2);
        return "" + anoAtual.get(Calendar.YEAR);
    }

    public String anoAtual_3() {
        Calendar anoAtual = Calendar.getInstance();
        anoAtual.add(Calendar.YEAR, -3);
        return "" + anoAtual.get(Calendar.YEAR);
    }

    public String editar() {
        AnimalRn animalRn = new AnimalRn();
        ContextoBean co = new ContextoBean();
        animalRn.carregar(co.getUsuarioLogado().getIdUsuario());
        return "/animal/animal_edit";

    }

    public String visualizar() {
        AnimalRn animalRn = new AnimalRn();
        ContextoBean co = new ContextoBean();
        animalRn.carregar(co.getUsuarioLogado().getIdUsuario());
        return "/animal/animal-view";

    }

    public String editarBaixa() {
        AnimalRn animalRn = new AnimalRn();
        ContextoBean co = new ContextoBean();
        animalRn.carregar(co.getUsuarioLogado().getIdUsuario());
        return "/baixas/baixas_cadastro";

    }

    public String excluir() {
        AnimalRn animalRn = new AnimalRn();
        animalRn.excluir(animal);
        this.lista = null;

        return null;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.animal.setFazenda(contextoBean.getFazendaAtiva());
        this.animal.setAtivaFemea(true);
        AnimalRn animalRN = new AnimalRn();

        animalRN.salvar(this.animal);

        return "/animal/animal?faces-redirect=true";
    }

    public String salvarBaixa() {

        Calendar oi = Calendar.getInstance();
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.animal.setFazenda(contextoBean.getFazendaAtiva());
        this.animal.setDataBaixa(oi.getTime());
        this.animal.setAtivaFemea(true);

        AnimalRn animalRN = new AnimalRn();
        this.animal.setAtivaFemea(false);
        animalRN.salvar(this.animal);

        animal = new Animal();
        return "/baixas/baixas?faces-redirect=true";
    }

    public float porAnimaF() {
        float nu = 0;
        try {
            NumberFormat formatarFloat = new DecimalFormat("0.00");
            nu = (100 * totalFemea()) / totalAnimal();
             String nu2 = formatarFloat.format(nu);
            nu2 = nu2.replace(',', '.');
            nu = Float.parseFloat(nu2);
            return nu;

        } catch (Exception e) {
        }

        return nu;
    }

    public float porAnimaM() {
        float nu = 0;
        try {
            NumberFormat formatarFloat = new DecimalFormat("0.00");
            nu = (100 * totalMacho()) / totalAnimal();
            String nu2 = formatarFloat.format(nu);
            nu2 = nu2.replace(',', '.');
            nu = Float.parseFloat(nu2);
            return nu;
        } catch (Exception e) {
        }

        return nu;
    }

    public String Atualizar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.animal.setFazenda(contextoBean.getFazendaAtiva());
        this.animal.setAtivaFemea(true);
        AnimalRn animalRN = new AnimalRn();

        animalRN.atualizar(this.animal);

        animal = new Animal();
        return "/animal/animal_1?faces-redirect=true";
    }

    public void AtivaFema() {
        AnimalRn animalRn = new AnimalRn();
        animal.setAtivaFemea(true);
        animalRn.salvar(animal);
    }

    public int totalMacho() {

        sexo = "macho";
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        return animalRn.listaSexo(sexo, contextoBean.getFazendaAtiva()).size();
    }

    public int totalFemea() {

        sexo = "femea";
        AnimalRn animalRn = new AnimalRn();
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        return animalRn.listaSexo(sexo, contextoBean.getFazendaAtiva()).size();

    }

    public int totalAnimal() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();

        this.lista = animalRn.listar(contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int totalAnimalALL(Fazenda fazenda) {

        AnimalRn animalRn = new AnimalRn();

        this.lista = animalRn.listar(fazenda);

        return lista.size();

    }

    public int total_A_menos12m() {

        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.MONTH, -12);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.lista = animalRn.lista1(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int total_A_menos12m_Macho() {

        sexo = "macho";
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.MONTH, -12);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.lista = animalRn.lista2(c1.getTime(), c.getTime(), sexo, contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int total_A_menos12m_Femea() {

        sexo = "femea";
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -1);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.lista = animalRn.lista2(c1.getTime(), c.getTime(), sexo, contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int total_A_12e24m() {

        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -2);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.lista = animalRn.lista1(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int total_A_12e24m_Macho() {

        sexo = "macho";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -2);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.lista = animalRn.lista2(c1.getTime(), c.getTime(), sexo, contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int total_A_12e24m_Femea() {

        sexo = "femea";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -2);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.lista = animalRn.lista2(c1.getTime(), c.getTime(), sexo, contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int total_A_acima24m() {

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -24);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -35);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.lista = animalRn.lista1(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int total_A_acima24m_Macho() {

        sexo = "macho";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -24);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -35);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.lista = animalRn.lista2(c1.getTime(), c.getTime(), sexo, contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int total_A_acima24m_Femea() {

        sexo = "femea";
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -24);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -35);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.lista = animalRn.lista2(c1.getTime(), c.getTime(), sexo, contextoBean.getFazendaAtiva());

        return lista.size();

    }

    public int totalNascidaAno() {

        AnimalRn animalRn = new AnimalRn();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);

        ContextoBean contextoBean = ContextoUtil.getContextoBean();

        this.lista = animalRn.listarNascidaAno(contextoBean.getFazendaAtiva(), year);

        return lista.size();

    }

    public int totalNascidaAnoMacho() {
        sexo = "macho";
        AnimalRn animalRn = new AnimalRn();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);

        ContextoBean contextoBean = ContextoUtil.getContextoBean();

        this.lista = animalRn.listarNascidaAnoSexo(sexo, contextoBean.getFazendaAtiva(), year);

        return lista.size();

    }

    public int totalNascidaAnoFemea() {

        sexo = "femea";
        AnimalRn animalRn = new AnimalRn();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);

        ContextoBean contextoBean = ContextoUtil.getContextoBean();

        this.lista = animalRn.listarNascidaAnoSexo(sexo, contextoBean.getFazendaAtiva(), year);

        return lista.size();

    }

//lista de animais
    public List<Animal> getListaTotal_A_menos12m() {
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.MONTH, -12);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.listaTotal_A_menos12m = animalRn.lista1(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva());

        return listaTotal_A_menos12m;
    }

    public List<Animal> getListaTotal_A_12e24m() {

        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -2);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.listaTotal_A_12e24m = animalRn.lista1(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva());

        return listaTotal_A_12e24m;
    }

    public List<Animal> getListaTotal_A_acima24m() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -24);
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.YEAR, -35);
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.listaTotal_A_acima24m = animalRn.lista1(c1.getTime(), c.getTime(), contextoBean.getFazendaAtiva());

        return listaTotal_A_acima24m;
    }

    public List<Animal> getLista() {
        if (this.lista == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            AnimalRn animalRn = new AnimalRn();
            this.lista = animalRn.listar(contextoBean.getFazendaAtiva());
        }
        return lista;
    }

    public List<Animal> getListaTotalNascidaAno() {
        AnimalRn animalRn = new AnimalRn();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);

        ContextoBean contextoBean = ContextoUtil.getContextoBean();

        this.listaTotalNascidaAno = animalRn.listarNascidaAno(contextoBean.getFazendaAtiva(), year);

        return listaTotalNascidaAno;
    }

    public List<Animal> getListaF() {
        sexo = "femea";
        if (this.listaF == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            AnimalRn animalRn = new AnimalRn();
            this.listaF = animalRn.listaSexo(sexo, contextoBean.getFazendaAtiva());
        }
        return listaF;
    }

    public List<Animal> getListaM() {
        sexo = "macho";
        if (this.listaM == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            AnimalRn animalRn = new AnimalRn();
            this.listaM = animalRn.listaSexo(sexo, contextoBean.getFazendaAtiva());
        }
        return listaM;
    }

    public List<Animal> getListaNegativa() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new AnimalRn();
        this.listaNegativa = animalRn.listarNegativa(contextoBean.getFazendaAtiva());
        return listaNegativa;
    }

    public List<Animal> getListaFNegativa() {
        sexo = "femea";
        if (this.listaFNegativa == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            AnimalRn animalRn = new AnimalRn();
            this.listaFNegativa = animalRn.listarSexoNegativa(sexo, contextoBean.getFazendaAtiva());
        }
        return listaFNegativa;
    }

    public List<Animal> getListaMNegativa() {
        sexo = "macho";
        if (this.listaMNegativa == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            AnimalRn animalRn = new AnimalRn();
            this.listaMNegativa = animalRn.listarSexoNegativa(sexo, contextoBean.getFazendaAtiva());
        }
        return listaMNegativa;
    }

    public List<Animal> getListaAnimaisProducao() {
        if (this.listaProducao == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            AnimalRn animalRn = new AnimalRn();
            this.listaProducao = animalRn.listarPesado(contextoBean.getFazendaAtiva());
        }

        return listaProducao;
    }

    //metodos sets
    public void setListaTotalNascidaAno(List<Animal> listaTotalNascidaAno) {
        this.listaTotalNascidaAno = listaTotalNascidaAno;
    }

    public void setListaTotal_A_menos12m(List<Animal> listaTotal_A_menos12m) {
        this.listaTotal_A_menos12m = listaTotal_A_menos12m;
    }

    public void setListaTotal_A_acima24m(List<Animal> listaTotal_A_acima24m) {
        this.listaTotal_A_acima24m = listaTotal_A_acima24m;
    }

    public void setListaNegativa(List<Animal> listaNegativa) {
        this.listaNegativa = listaNegativa;
    }

    public void setListaFNegativa(List<Animal> listaFNegativa) {
        this.listaFNegativa = listaFNegativa;
    }

    public void setListaMNegativa(List<Animal> listaMNegativa) {
        this.listaMNegativa = listaMNegativa;
    }

    public void setListaTotal_A_12e24m(List<Animal> listaTotal_A_12e24m) {
        this.listaTotal_A_12e24m = listaTotal_A_12e24m;
    }

    public void setLista(List<Animal> lista) {
        this.lista = lista;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setListaF(List<Animal> listaF) {
        this.listaF = listaF;
    }

    public void setListaM(List<Animal> listaM) {
        this.listaM = listaM;
    }

}
