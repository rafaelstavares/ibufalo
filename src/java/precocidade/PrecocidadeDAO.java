/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package precocidade;

import java.util.List;
import usuario.Usuario;

/**
 *
 * @author Rafael
 */
public interface PrecocidadeDAO {

    public void salvar(Precocidade precocidade);

    public void atualizar(Precocidade precocidade);

    public void excluir(Precocidade precocidade);

    public Precocidade carregar(Integer idPrecocidade);

    public List<Precocidade> listarAll();
    
    public List<Precocidade> listar(Usuario usuario);
}
