/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estado;

import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/*
 *
 * @author Rafael
 */
public class EstadoDAOHibernate implements EstadoDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    ;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Estados carregar(Integer cod_estados) {
        return (Estados) this.session.get(Estados.class, cod_estados);
    }

    @Override
    public List<Estados> listarAll() {
        return this.session.createCriteria(Estados.class).list();
    }

   
}
