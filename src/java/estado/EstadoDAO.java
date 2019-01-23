/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estado;

import java.util.List;

/**
 *
 * @author Rafael
 */
public interface EstadoDAO {



    public Estados carregar(Integer idEstado);

    public List<Estados> listarAll();
    

}
