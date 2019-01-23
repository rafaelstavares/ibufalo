/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estado;



import java.util.List;
import util.DAOFactory;


/**
 *
 * @author Rafael
 */
public class EstadoRn {
private EstadoDAO estadoDao;

    public EstadoRn() {
        this.estadoDao = DAOFactory.criarEstadoDao();
    }

 
    public Estados carregar(Integer idEstado){
        return this.estadoDao.carregar(idEstado);
    }



    public List<Estados> listarAll(){
        return this.estadoDao.listarAll();
    }
}
