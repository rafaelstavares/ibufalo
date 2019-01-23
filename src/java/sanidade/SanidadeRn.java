/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanidade;



import java.util.List;
import usuario.Usuario;
import util.DAOFactory;


/**
 *
 * @author Rafael
 */
public class SanidadeRn {

      private SanidadeDAO sanidadeRn;

    public SanidadeRn() {
        this.sanidadeRn = DAOFactory.criarsanidadeDao();
    }
    public Sanidade carregar(Integer idsanidade){
        return this.sanidadeRn.carregar(idsanidade);
    }

    public void salvar (Sanidade sanidade){
        Integer idsanidade = sanidade.getIdSanidade();
        if (idsanidade==null||idsanidade==0) {
            this.sanidadeRn.salvar(sanidade);
        }else{
            this.sanidadeRn.atualizar(sanidade);
        }
    }
    
    public void excluir(Sanidade sanidade){
         this.sanidadeRn.excluir(sanidade);
    }
    public List<Sanidade> listarAll(){
        return this.sanidadeRn.listarAll();
    }
    public List<Sanidade> listar(Usuario usuario){
        return this.sanidadeRn.listar(usuario);
    }
}
