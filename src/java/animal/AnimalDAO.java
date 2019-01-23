/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import fazenda.Fazenda;
import java.util.List;

/**
 *
 * @author Rafael
 */
public interface AnimalDAO {

    public void salvar(Animal animal);

    public void atualizar(Animal animal);

    public void excluir(Animal animal);

    public Animal carregar(Integer idAnimal);

    public List<Animal> listarAll();

    public List<Animal> listar(Fazenda fazenda);
    
    public List<Animal> listarPesado(Fazenda fazenda);

    public List<Animal> listarSexo(String sexo, Fazenda fazenda);

    public List<Animal> listar1(java.util.Date inicio, java.util.Date fim, Fazenda fazenda);

    public List<Animal> listar2(java.util.Date inicio, java.util.Date fim, String sexo, Fazenda fazenda);

    public List<Animal> listarNascidaAno(Fazenda fazenda, int ano);

    public List<Animal> listarNascidaAnoSexo(String sexo, Fazenda fazenda, int ano);

    public List<Animal> listarNegativa( Fazenda fazenda);

    public List<Animal> listarSexoNegativa(String sexo, Fazenda fazenda);
}
