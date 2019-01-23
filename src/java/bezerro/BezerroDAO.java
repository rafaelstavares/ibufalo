/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bezerro;

import java.util.List;
import usuario.Usuario;

/**
 *
 * @author Rafael
 */
public interface BezerroDAO {

    public void salvar(Bezerro bezerro);

    public void atualizar(Bezerro bezerro);

    public void excluir(Bezerro bezerro);

    public Bezerro carregar(Integer idBezerro);

    public List<Bezerro> listarAll();
    
    public List<Bezerro> listar(Usuario usuario);
}
