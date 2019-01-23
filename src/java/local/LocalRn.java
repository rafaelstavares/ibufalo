/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package local;



import fazenda.Fazenda;
import java.util.List;
import usuario.Usuario;
import util.DAOFactory;


/**
 *
 * @author Rafael
 */
public class LocalRn {

    private LocalDAO localRn;

    public LocalRn() {
        this.localRn = DAOFactory.criarlocalDao();
    }
    public Local carregar(Integer idlocal){
        return this.localRn.carregar(idlocal);
    }

    public void salvar (Local local){
        Integer idlocal = local.getIdlocal();
        if (idlocal==null||idlocal==0) {
            this.localRn.salvar(local);
        }else{
            this.localRn.atualizar(local);
        }
    }
    
    public void excluir(Local local){
         this.localRn.excluir(local);
    }
    public List<Local> listar(Usuario usuario){
        return this.localRn.listar(usuario);
    }
      public List<Local> listar(Fazenda fazenda){
        return this.localRn.listar(fazenda);
    }
    public List<Local> listarAll(){
        return this.localRn.listarAll();
    }
}
