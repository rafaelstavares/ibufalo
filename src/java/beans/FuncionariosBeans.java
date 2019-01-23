package beans;

import funcionarios.Funcionarios;
import funcionarios.FuncionariosRn;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import util.ContextoUtil;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "funcionariosBean")
@RequestScoped
public class FuncionariosBeans {

    private Funcionarios funcionarios = new Funcionarios();
    private List<Funcionarios> lista;
    private String destinoSalvar;

    public String novo() {
        this.destinoSalvar = "listar";
        this.funcionarios = new Funcionarios();

        return "/funcionarios/funcionarios";
    }

    public String editar() {
        FuncionariosRn fazendaRn = new FuncionariosRn();
        ContextoBean co = new ContextoBean();
        fazendaRn.carregar(co.getUsuarioLogado().getIdUsuario());
        return "/funcionarios/funcionarios1";
    }

    public String salvar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.funcionarios.setFazenda(contextoBean.getFazendaAtiva());
        FuncionariosRn funcionariosRN = new FuncionariosRn();
        funcionariosRN.salvar(this.funcionarios);
        this.funcionarios = new Funcionarios();
        this.lista = null;
        return "/funcionarios/listar?faces-redirect=true";
    }

    public String excluir() {
        FuncionariosRn funcionariosRn = new FuncionariosRn();
        funcionariosRn.excluir(funcionarios);
        funcionarios = new Funcionarios();
        this.lista = null;

        return "/funcionarios/listar?faces-redirect=true";
    }

    public String atualizar() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.funcionarios.setFazenda(contextoBean.getFazendaAtiva());
        FuncionariosRn funcionariosRn = new FuncionariosRn();
        funcionariosRn.atualizar(this.funcionarios);

        return "/funcionarios/funcionarios?faces-redirect=true";
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String totalFuncionarios() {
        String msg = "";

        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        FuncionariosRn animalRn = new FuncionariosRn();
        return msg + animalRn.listar(contextoBean.getFazendaAtiva()).size();
    }

    public List<Funcionarios> getLista() {
        if (this.lista == null) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            FuncionariosRn funcionariosRn = new FuncionariosRn();
            this.lista = funcionariosRn.listar(contextoBean.getFazendaAtiva());
        }

        return lista;
    }

    public void setLista(List<Funcionarios> lista) {
        this.lista = lista;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }

}
