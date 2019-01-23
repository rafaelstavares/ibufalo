/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cidade;



import estado.Estados;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/*
 *
 * @author Rafael
 */
public class CidadeDAOHibernate implements CidadeDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();;

    public void setSession(Session session) {
        this.session = session;
    }

   

    public Cidades carregar(Integer idCidades) {
        return (Cidades) this.session.get(Cidades.class, idCidades);
    }

    public List<Cidades> listar(Estados estados) {
        Criteria criteria = this.session.createCriteria(Cidades.class);
        criteria.add(Restrictions.eq("cod_estados", estados));
        return criteria.list();
    }
     public List<Cidades> listarAll() {
        return this.session.createCriteria(Cidades.class).list();
    }
    
}
