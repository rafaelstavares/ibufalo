/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;




import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/*
 *
 * @author Rafael
 */
public class UsuarioDAOHibernate implements UsuarioDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Usuario usuario) {
        this.session.save(usuario);
       
    }

    public void atualizar(Usuario usuario) {
        this.session.update(usuario);
    }

    public void excluir(Usuario usuario) {
        this.session.delete(usuario);
    }

    public Usuario carregar(Integer idUsuario) {
        return (Usuario) this.session.get(Usuario.class, idUsuario);
    }



    public List<Usuario> listar() {
        return this.session.createCriteria(Usuario.class).list();
    }
    
    public Usuario buscarPorLogin(String login){
    String hql = "select u from Usuario u where u.login = :login";
    Query consulta = this.session.createQuery(hql);
    consulta.setString("login", login);
    return (Usuario)consulta.uniqueResult();
    }
}
