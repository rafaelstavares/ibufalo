/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fazenda;


import java.util.List;
import usuario.Usuario;
import util.DAOFactory;

/**
 *
 * @author Rafael
 */
public class FazendaRn {

    private FazendaDAO fazendaDao;

    public FazendaRn() {
        this.fazendaDao = DAOFactory.criarfazendaDao();
    }
    
    public Fazenda carregar(Integer idfazenda){
        return this.fazendaDao.carregar(idfazenda);
    }
    
    public void salvar (Fazenda fazenda){
        Integer idfazenda = fazenda.getIdfazenda();
        if (idfazenda==null||idfazenda==0) {
            this.fazendaDao.salvar(fazenda);
        }else{
            this.fazendaDao.atualizar(fazenda);
        }
    }
    
    public void excluir(Fazenda fazenda){
         this.fazendaDao.excluir(fazenda);
    }
    
    public List<Fazenda> listar(Usuario usuario){ 
        return this.fazendaDao.listar(usuario);
    }
    public void atualizar (Fazenda fazenda){
         this.fazendaDao.atualizar(fazenda);
    }
     public List<Fazenda> listarAll(){ 
        return this.fazendaDao.listarAll();
    }

}
