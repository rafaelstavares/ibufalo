/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.util.List;

/**
 *
 * @author Rafael
 */
public interface UsuarioDAO {

    public void salvar(Usuario usuario);

    public void atualizar(Usuario usuario);

    public void excluir(Usuario usuario);

    public Usuario carregar(Integer idusuario);

    public List<Usuario> listar();
    
    public Usuario buscarPorLogin(String login);
}
