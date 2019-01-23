/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reproducao;

import fazenda.Fazenda;
import java.util.Date;
import java.util.List;
import util.DAOFactory;

/**
 *
 * @author Rafael
 */
public class ReproducaoRn {

    private ReproducaoDAO reproducaoRn;

    public ReproducaoRn() {
        this.reproducaoRn = DAOFactory.criarReproducaoDao();
    }

    public Reproducao carregar(Integer idReproducao) {
        return this.reproducaoRn.carregar(idReproducao);
    }

    public void salvar(Reproducao reproducao) {
        Integer idanimal = reproducao.getIdReproducao();
        reproducao.setFemeaSucesso(Boolean.FALSE);
        if (idanimal == null || idanimal == 0) {
            this.reproducaoRn.salvar(reproducao);
        } else {
            this.reproducaoRn.atualizar(reproducao);
        }
    }

    public void excluir(Reproducao reproducao) {
        this.reproducaoRn.excluir(reproducao);
    }

    public List<Reproducao> listarAll() {
        return this.reproducaoRn.listarAll();
    }

    public List<Reproducao> listar(Fazenda fazenda) {
        return this.reproducaoRn.listar(fazenda);
    }

    public List<Reproducao> listarfSucesso(Fazenda fazenda, Boolean femeaSucesso) {
        return this.reproducaoRn.listarfSucesso(fazenda, femeaSucesso);
    }


    public List<Reproducao> listarAparaDignosticoConfirma(Date inicio, Date fim, Fazenda fazenda) {

        return this.reproducaoRn.listarAparaDignosticoConfirma(inicio, fim, fazenda);
    }
    
     public List<Reproducao> listarAparaParir(Date inicio, Date fim,Fazenda fazenda, Boolean femeaSucesso){
         
     return this.reproducaoRn.listarAparaParir(inicio, fim, fazenda, femeaSucesso);
     }
     
     public List<Reproducao> listarAporTipo(Fazenda fazenda, Boolean femeaSucesso, String tipo){
         
     return this.reproducaoRn.listarAporTipo(fazenda, femeaSucesso, tipo);
     }
}
