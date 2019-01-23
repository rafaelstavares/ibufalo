/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

import fazenda.Fazenda;
import java.util.List;


/**
 *
 * @author Rafael
 */
public interface FuncionariosDAO {

    public void salvar(Funcionarios funcionarios);

    public void atualizar(Funcionarios funcionarios);

    public void excluir(Funcionarios funcionarios);

    public Funcionarios carregar(Integer idfuncionarios);

    public List<Funcionarios> listarAll();
    public List<Funcionarios> listar(Fazenda fazenda);
}
