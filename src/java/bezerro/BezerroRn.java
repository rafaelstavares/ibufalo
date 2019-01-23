/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bezerro;



import java.util.List;
import usuario.Usuario;
import util.DAOFactory;


/**
 *
 * @author Rafael
 */
public class BezerroRn {
private BezerroDAO bezerroRn;

    public BezerroRn() {
        this.bezerroRn = DAOFactory.criarBezerroDao();
    }
    public Bezerro carregar(Integer idBezerro){
        return this.bezerroRn.carregar(idBezerro);
    }

    public void salvar (Bezerro bezerro){
        Integer idanimal = bezerro.getIdBezerro();
        if (idanimal==null||idanimal==0) {
            this.bezerroRn.salvar(bezerro);
        }else{
            this.bezerroRn.atualizar(bezerro);
        }
    }
    
    public void excluir(Bezerro bezerro){
         this.bezerroRn.excluir(bezerro);
    }
    public List<Bezerro> listarAll(){
        return this.bezerroRn.listarAll();
    }
   public List<Bezerro> listar(Usuario usuario){
        return this.bezerroRn.listar(usuario);
    }
}
