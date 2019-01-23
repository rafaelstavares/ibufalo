/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cidade;


import estado.Estados;
import java.util.List;

/**
 *
 * @author Rafael
 */
public interface CidadeDAO {

  
    public Cidades carregar (Integer idfazenda);
    public List<Cidades> listar(Estados estados);
    public List<Cidades> listarAll();

}
