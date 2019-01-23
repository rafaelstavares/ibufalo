/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.util.List;
import util.DAOFactory;

/**
 *
 * @author Rafael
 */
public class UsuarioRn {

   private UsuarioDAO usuarioDao;

    public UsuarioRn() {
        this.usuarioDao = DAOFactory.criarUsuarioDao();
    }
    public Usuario carregar(Integer idsanidade){
        return this.usuarioDao.carregar(idsanidade);
    }

    public void salvar (Usuario usuario){
        Integer idusuario = usuario.getIdUsuario();
        if (idusuario==null||idusuario==0) {
   
            this.usuarioDao.salvar(usuario);
        }else{
            this.usuarioDao.atualizar(usuario);
        }
    }
       public void atualizar (Usuario usuario){
        Integer idusuario = usuario.getIdUsuario();
        if (idusuario==null||idusuario==0) {
   
            this.usuarioDao.salvar(usuario);
        }else{
            this.usuarioDao.atualizar(usuario);
        }
    }
    public void excluir(Usuario usuario){
         this.usuarioDao.excluir(usuario);
    }
    public List<Usuario> listar(){
        return this.usuarioDao.listar();
    }
     public Usuario bucarPorLogin(String login){
    return this.usuarioDao.buscarPorLogin(login);
    }
}
