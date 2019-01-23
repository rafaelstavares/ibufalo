/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cidade;


import estado.Estados;
import fazenda.*;
import java.util.List;
import usuario.Usuario;
import util.DAOFactory;

/**
 *
 * @author Rafael
 */
public class CidadeRn {

    private CidadeDAO MunicipoDao;

    public CidadeRn() {
        this.MunicipoDao = DAOFactory.criarCidadeDao();
    }
    
    public Cidades carregar(Integer idfazenda){
        return this.MunicipoDao.carregar(idfazenda);
    }
    
   
    public List<Cidades> listar(Estados estados){ 
        return this.MunicipoDao.listar(estados);
    }
    
     public List<Cidades> listarAll(){ 
        return this.MunicipoDao.listarAll();
    }
   
}
