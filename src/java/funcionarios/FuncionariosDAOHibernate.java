/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;




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
public class FuncionariosDAOHibernate implements FuncionariosDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Funcionarios funcionarios) {
        this.session.save(funcionarios);
       
    }

    @Override
    public void atualizar(Funcionarios funcionarios) {
        this.session.update(funcionarios);
    }

    @Override
    public void excluir(Funcionarios funcionarios) {
        this.session.delete(funcionarios);
    }

    @Override
    public Funcionarios carregar(Integer idfuncionarios) {
        return (Funcionarios) this.session.get(Funcionarios.class, idfuncionarios);
    }


    @Override
    public List<Funcionarios> listarAll() {
        return this.session.createCriteria(Funcionarios.class).list();
    }
      public List<Funcionarios> listar(Fazenda fazenda) {
        Criteria criteria = this.session.createCriteria(Funcionarios.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        return criteria.list();
    }
}
