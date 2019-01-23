/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bezerro;

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
public class BezerroDAOHibernate implements BezerroDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    ;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Bezerro bezerro) {
        this.session.save(bezerro);

    }

    public void atualizar(Bezerro bezerro) {
        this.session.update(bezerro);
    }

    public void excluir(Bezerro bezerro) {
        this.session.delete(bezerro);
    }

    public Bezerro carregar(Integer idBezerro) {
        return (Bezerro) this.session.get(Bezerro.class, idBezerro);
    }

    @Override
    public List<Bezerro> listarAll() {
        return this.session.createCriteria(Bezerro.class).list();
    }

    @Override
    public List<Bezerro> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(Bezerro.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return criteria.list();
    }
}
