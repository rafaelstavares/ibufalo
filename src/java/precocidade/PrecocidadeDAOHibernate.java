/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package precocidade;




import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import usuario.Usuario;
import util.HibernateUtil;

/*
 *
 * @author Rafael
 */
public class PrecocidadeDAOHibernate implements PrecocidadeDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Precocidade precocidade) {
        this.session.save(precocidade);
       
    }

    public void atualizar(Precocidade precocidade) {
        this.session.update(precocidade);
    }

    public void excluir(Precocidade precocidade) {
        this.session.delete(precocidade);
    }

    public Precocidade carregar(Integer idPrecocidade) {
        return (Precocidade) this.session.get(Precocidade.class, idPrecocidade);
    }

    public List<Precocidade> listarAll() {
        return this.session.createCriteria(Precocidade.class).list();
    }
    
      public List<Precocidade> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(Precocidade.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return criteria.list();
    }
}
