/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producao;




import animal.Animal;
import fazenda.Fazenda;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/*
 *
 * @author Rafael
 */
public class ProducaoDAOHibernate implements ProducaoDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Producao producao) {
        this.session.save(producao);
       
    }

    @Override
    public void atualizar(Producao producao) {
        this.session.update(producao);
    }

    @Override
    public void excluir(Producao producao) {
        this.session.delete(producao);
    }

    @Override
    public Producao carregar(Integer idproducao) {
        return (Producao) this.session.get(Producao.class, idproducao);
    }
    @Override
    public List<Producao> listarAll() {
        return this.session.createCriteria(Producao.class).list();
    }
    @Override
 public List<Producao> listar(Fazenda fazenda) {
        Criteria criteria = this.session.createCriteria(Producao.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        return criteria.list();
    }
  @Override
 public List<Producao> listarAnimal(Fazenda fazenda, Animal animal) {
        Criteria criteria = this.session.createCriteria(Producao.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        return criteria.list();
    }
  
   @Override
 public float totalProducao(Fazenda fazenda) {
        Criteria criteria = this.session.createCriteria(Producao.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
       Float somaIdades =
                    (Float) criteria.setProjection(Projections.sum("quantidade")).uniqueResult();
       return somaIdades;
    }
       @Override
 public float totalProducaoAnimal(Fazenda fazenda, Animal animal) {
        Criteria criteria = this.session.createCriteria(Producao.class);
        criteria.add(Restrictions.eq("animal", animal));
        criteria.add(Restrictions.eq("fazenda", fazenda));
       Float somaIdades =
                    (Float) criteria.setProjection(Projections.sum("quantidade")).uniqueResult();
       return somaIdades;
    }
}
