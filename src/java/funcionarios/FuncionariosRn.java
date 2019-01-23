/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;



import fazenda.Fazenda;
import java.util.List;
import util.DAOFactory;


/**
 *
 * @author Rafael
 */
public class FuncionariosRn {
 private FuncionariosDAO funcionariosRn;

    public FuncionariosRn() {
        this.funcionariosRn = DAOFactory.criarfuncionariosDao();
    }
    public Funcionarios carregar(Integer idfuncionarios){
        return this.funcionariosRn.carregar(idfuncionarios);
    }

    public void salvar (Funcionarios funcionarios){
        Integer idfuncionarios = funcionarios.getIdFuncionarios();
        if (idfuncionarios==null||idfuncionarios==0) {
            this.funcionariosRn.salvar(funcionarios);
        }else{
            this.funcionariosRn.atualizar(funcionarios);
        }
    }
    
    public void excluir(Funcionarios funcionarios){
         this.funcionariosRn.excluir(funcionarios);
    }
     public void atualizar (Funcionarios funcionario){
         this.funcionariosRn.atualizar(funcionario);
    }
    public List<Funcionarios> listarAll(){
        return this.funcionariosRn.listarAll();
    }
    public List<Funcionarios> listar(Fazenda fazenda){
        return this.funcionariosRn.listar(fazenda);
    }
}
