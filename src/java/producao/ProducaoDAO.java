/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producao;

import animal.Animal;
import fazenda.Fazenda;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rafael
 */
public interface ProducaoDAO {

    public void salvar(Producao producao);

    public void atualizar(Producao producao);

    public void excluir(Producao producao);

    public Producao carregar(Integer idproducao);

    public List<Producao> listarAll();

    public List<Producao> listar(Fazenda fazenda);

    public List<Producao> listarAnimal(Fazenda fazenda, Animal animal);

    public double totalProducao(Fazenda fazenda);
    
    public double totalProducaoAno(Fazenda fazenda, Date in, Date fim);

    public double totalProducaoAnimal(Fazenda fazenda, Animal animal);
}
