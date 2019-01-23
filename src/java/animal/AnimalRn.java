/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import fazenda.Fazenda;
import java.util.List;
import util.DAOFactory;

/**
 *
 * @author Rafael
 */
public class AnimalRn {

    private AnimalDAO animalDao;

    public AnimalRn() {
        this.animalDao = DAOFactory.criaranimalDao();
    }

    public Animal carregar(Integer idanimal) {
        return this.animalDao.carregar(idanimal);
    }

    public void salvar(Animal animal) {

        Integer idanimal = animal.getIdAnimal();
        if (idanimal == null || idanimal == 0) {
            this.animalDao.salvar(animal);

        } else {
            this.animalDao.atualizar(animal);
        }
    }
 public void atualizar(Animal animal) {
            this.animalDao.atualizar(animal);
        
    }
    public void excluir(Animal animal) {
        this.animalDao.excluir(animal);
    }

    public List<Animal> listar(Fazenda fazenda) {
        return this.animalDao.listar(fazenda);
    }

    public List<Animal> listarAll() {
        return this.animalDao.listarAll();
    }

    public List<Animal> listaSexo(String sexo, Fazenda fazenda) {

        return this.animalDao.listarSexo(sexo, fazenda);
    }

    public List<Animal> lista1(java.util.Date inicio, java.util.Date fim, Fazenda fazenda) {

        return this.animalDao.listar1(inicio, fim, fazenda);
    }

    public List<Animal> lista2(java.util.Date inicio, java.util.Date fim, String sexo, Fazenda fazenda) {

        return this.animalDao.listar2(inicio, fim, sexo, fazenda);
    }

    public List<Animal> listarNascidaAno(Fazenda fazenda, int ano) {

        return this.animalDao.listarNascidaAno(fazenda, ano);
    }

    public List<Animal> listarNascidaAnoSexo(String sexo, Fazenda fazenda, int ano) {

        return this.animalDao.listarNascidaAnoSexo(sexo, fazenda, ano);
    }

    public List<Animal> listarNegativa(Fazenda fazenda) {
        return this.animalDao.listarNegativa(fazenda);
    }

    public List<Animal> listarSexoNegativa(String sexo, Fazenda fazenda) {
        return this.animalDao.listarSexoNegativa(sexo, fazenda);
    }
}
