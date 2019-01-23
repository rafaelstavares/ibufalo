/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local;

import fazenda.Fazenda;
import java.util.List;
import usuario.Usuario;

/**
 *
 * @author Rafael
 */
public interface LocalDAO {

    public void salvar(Local local);

    public void atualizar(Local local);

    public void excluir(Local local);

    public Local carregar(Integer idlocal);
    public List<Local> listarAll();
    public List<Local> listar(Usuario usuario);
    public List<Local> listar(Fazenda fazenda);
}
