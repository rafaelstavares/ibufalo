/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package precocidade;

import java.util.List;
import usuario.Usuario;
import util.DAOFactory;
/**
 *
 * @author Rafael
 */
public class PrecocidadeRn {

    private PrecocidadeDAO precocidadeRn;

    public PrecocidadeRn() {
        this.precocidadeRn = DAOFactory.criarPrecocidadeDao();
    }
    public Precocidade carregar(Integer idPrecocidade){
        return this.precocidadeRn.carregar(idPrecocidade);
    }

    public void salvar (Precocidade precocidade){
        Integer idPrecocidade = precocidade.getIdPrecocidade();
        if (idPrecocidade==null||idPrecocidade==0) {
            this.precocidadeRn.salvar(precocidade);
        }else{
            this.precocidadeRn.atualizar(precocidade);
        }
    }
    public void excluir(Precocidade precocidade){
         this.precocidadeRn.excluir(precocidade);
    }
    public List<Precocidade> listar(Usuario usuario){
        return this.precocidadeRn.listar(usuario);
    }  
       public List<Precocidade> listarAll(){
        return this.precocidadeRn.listarAll();
    } 
}
