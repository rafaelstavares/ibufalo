/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import fazenda.Fazenda;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/*
 *
 * @author Rafael
 */
public class AnimalDAOHibernate implements AnimalDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    ;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Animal animal) {
        this.session.save(animal);

    }

    @Override
    public void atualizar(Animal animal) {
        this.session.update(animal);
    }

    @Override
    public void excluir(Animal animal) {
        this.session.delete(animal);
    }

    @Override
    public Animal carregar(Integer idAnimal) {
        return (Animal) this.session.get(Animal.class, idAnimal);
    }

    @Override
    public List<Animal> listarAll() {
        return this.session.createCriteria(Animal.class).list();
    }

    @Override
    public List<Animal> listar(Fazenda fazenda) {
        Boolean ativaFemea = true;
        Criteria criteria = this.session.createCriteria(Animal.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.eq("ativaFemea", ativaFemea));
        return criteria.list();
    }

      @Override
    public List<Animal> listarPesado(Fazenda fazenda) {
        Boolean ativaFemea = true;
        Criteria criteria = this.session.createCriteria(Animal.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.eq("ativaFemea", ativaFemea));
        criteria.addOrder(Order.desc("peso"));
        return criteria.list();
    }
    
    @Override
    public List<Animal> listarSexo(String sexo, Fazenda fazenda) {
        Boolean ativaFemea = true;
        Criteria criteria = this.session.createCriteria(Animal.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.eq("sexo", sexo));
        criteria.add(Restrictions.eq("ativaFemea", ativaFemea));
        return criteria.list();
    }

    @Override
    public List<Animal> listar1(java.util.Date inicio, java.util.Date fim, Fazenda fazenda) {
        Boolean ativaFemea = true;
        Criteria criteria = this.session.createCriteria(Animal.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.between("dataNascimento", inicio, fim));
        criteria.add(Restrictions.eq("ativaFemea", ativaFemea));
        return criteria.list();
    }

    @Override
    public List<Animal> listar2(java.util.Date inicio, java.util.Date fim, String sexo, Fazenda fazenda) {
        Boolean ativaFemea = true;
        Criteria criteria = this.session.createCriteria(Animal.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.eq("sexo", sexo));
        criteria.add(Restrictions.between("dataNascimento", inicio, fim));
        criteria.add(Restrictions.eq("ativaFemea", ativaFemea));
        return criteria.list();
    }

    @Override
    public List<Animal> listarNascidaAno(Fazenda fazenda, int ano) {
        Calendar anoSel = Calendar.getInstance();
        anoSel.set(Calendar.YEAR, ano);
        Boolean ativaFemea = true;
        Query query = session.createQuery("from animal where fazenda_idfazenda = :fazenda and year(dataNascimento)=:ano1 and ativaFemea =:ativaFemea");
        query.setEntity("fazenda", fazenda);
        query.setInteger("ano1", anoSel.get(Calendar.YEAR));
        query.setBoolean("ativaFemea", ativaFemea);
        return query.list();
    }

    @Override
    public List<Animal> listarNascidaAnoSexo(String sexo, Fazenda fazenda, int ano) {
        Calendar anoSel = Calendar.getInstance();
        anoSel.set(Calendar.YEAR, ano);
        Boolean ativaFemea = true;
        Query query = session.createQuery("from animal where sexo =:sexo and fazenda_idfazenda = :fazenda and year(dataNascimento)=:ano1 and ativaFemea =:ativaFemea");
        query.setEntity("fazenda", fazenda);
        query.setString("sexo", sexo);
        query.setInteger("ano1", anoSel.get(Calendar.YEAR));
        query.setBoolean("ativaFemea", ativaFemea);
        return query.list();
    }
    
    
     @Override
    public List<Animal> listarNegativa(Fazenda fazenda) {
        Boolean ativaFemea = false;
        Criteria criteria = this.session.createCriteria(Animal.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.eq("ativaFemea", ativaFemea));
        return criteria.list();
    }

    @Override
    public List<Animal> listarSexoNegativa(String sexo, Fazenda fazenda) {
        Boolean ativaFemea = false;
        Criteria criteria = this.session.createCriteria(Animal.class);
        criteria.add(Restrictions.eq("fazenda", fazenda));
        criteria.add(Restrictions.eq("sexo", sexo));
        criteria.add(Restrictions.eq("ativaFemea", ativaFemea));
        return criteria.list();
    }
    

    
}
