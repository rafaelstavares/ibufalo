/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fazenda;



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
public class FazendaDAOHibernate implements FazendaDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Fazenda fazenda) {
        this.session.saveOrUpdate(fazenda);
       
    }

    public void excluir(Fazenda fazenda) {
        this.session.delete(fazenda);
    }

    public Fazenda carregar(Integer idfazenda) {
        return (Fazenda) this.session.get(Fazenda.class, idfazenda);
    }

   public void atualizar(Fazenda fazenda) {
        this.session.update(fazenda);
    }


    public List<Fazenda> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(Fazenda.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return criteria.list();
    }
     public List<Fazenda> listarAll() {
        return this.session.createCriteria(Fazenda.class).list();
    }

}
