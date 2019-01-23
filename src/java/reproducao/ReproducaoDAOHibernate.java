/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reproducao;

import fazenda.Fazenda;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/*
 *
 * @author Rafael
 */
public class ReproducaoDAOHibernate implements ReproducaoDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Reproducao reproducao) {
        this.session.save(reproducao);

    }

    @Override
    public void atualizar(Reproducao reproducao) {
        this.session.update(reproducao);
    }

    @Override
    public void excluir(Reproducao reproducao) {
        this.session.delete(reproducao);
    }

    @Override
    public Reproducao carregar(Integer idReproducao) {
        return (Reproducao) this.session.get(Reproducao.class, idReproducao);
    }

    @Override
    public List<Reproducao> listarAll() {
        return this.session.createCriteria(Reproducao.class).list();
    }

    @Override
    public List<Reproducao> listar(Fazenda fazenda) {
        Criteria criteria = this.session.createCriteria(Reproducao.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        return criteria.list();
    }
  @Override
    public List<Reproducao> listarfSucesso(Fazenda fazenda, Boolean femeaSucesso) {

      Criteria criteria = this.session.createCriteria(Reproducao.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.eq("femeaSucesso", femeaSucesso));
        return criteria.list();
    }
  
  @Override
    public List<Reproducao> listarAparaDignosticoConfirma(java.util.Date inicio, java.util.Date fim,Fazenda fazenda) {

      Criteria criteria = this.session.createCriteria(Reproducao.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.between("diaCruzamento", inicio, fim));
        return criteria.list();
    }
  
  @Override
    public List<Reproducao> listarAparaParir(java.util.Date inicio, java.util.Date fim,Fazenda fazenda, Boolean femeaSucesso) {

      Criteria criteria = this.session.createCriteria(Reproducao.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.between("diaCruzamento", inicio, fim));
        criteria.add(Restrictions.eq("femeaSucesso", femeaSucesso));
        return criteria.list();
    }
  @Override
    public List<Reproducao> listarAporTipo(Fazenda fazenda, Boolean femeaSucesso, String tipo) {

      Criteria criteria = this.session.createCriteria(Reproducao.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.eq("femeaSucesso", femeaSucesso));
        criteria.add(Restrictions.eq("tipo", tipo));
        return criteria.list();
    }

}
