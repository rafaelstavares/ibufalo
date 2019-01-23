/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanidade;




import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import reproducao.Reproducao;
import usuario.Usuario;
import util.HibernateUtil;

/*
 *
 * @author Rafael
 */
public class SanidadeDAOHibernate implements SanidadeDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Sanidade local) {
        this.session.save(local);
       
    }

    public void atualizar(Sanidade local) {
        this.session.update(local);
    }

    public void excluir(Sanidade local) {
        this.session.delete(local);
    }

    public Sanidade carregar(Integer idlocal) {
        return (Sanidade) this.session.get(Sanidade.class, idlocal);
    }


    public List<Sanidade> listarAll() {
        return this.session.createCriteria(Sanidade.class).list();
    }
    
        public List<Sanidade> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(Sanidade.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return criteria.list();
    }
}
