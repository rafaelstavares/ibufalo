/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanidade;

import java.util.List;
import usuario.Usuario;

/**
 *
 * @author Rafael
 */
public interface SanidadeDAO {

    public void salvar(Sanidade local);

    public void atualizar(Sanidade local);

    public void excluir(Sanidade local);

    public Sanidade carregar(Integer idlocal);

    public List<Sanidade> listarAll();

    public List<Sanidade> listar(Usuario usuario);
}
