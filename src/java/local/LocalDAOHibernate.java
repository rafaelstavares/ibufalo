/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local;




import fazenda.Fazenda;
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
public class LocalDAOHibernate implements LocalDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Local local) {
        this.session.save(local);
       
    }

    public void atualizar(Local local) {
        this.session.update(local);
    }

    public void excluir(Local local) {
        this.session.delete(local);
    }

    public Local carregar(Integer idlocal) {
        return (Local) this.session.get(Local.class, idlocal);
    }

    public List<Local> listarAll() {
        return this.session.createCriteria(Local.class).list();
    }
    public List<Local> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(Local.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return criteria.list();
    }
     public List<Local> listar(Fazenda fazenda) {
        Criteria criteria = this.session.createCriteria(Local.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        return criteria.list();
    }
}
