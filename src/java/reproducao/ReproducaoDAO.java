/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reproducao;

import fazenda.Fazenda;
import java.util.List;

/**
 *
 * @author Rafael
 */
public interface ReproducaoDAO {

    public void salvar(Reproducao reproducao);

    public void atualizar(Reproducao reproducao);

    public void excluir(Reproducao reproducao);

    public Reproducao carregar(Integer idReproducao);

    public List<Reproducao> listarAll();

    public List<Reproducao> listar(Fazenda fazenda);

    public List<Reproducao> listarfSucesso(Fazenda fazenda, Boolean femeaSucesso);

  
    public List<Reproducao> listarAparaDignosticoConfirma(java.util.Date inicio, java.util.Date fim, Fazenda fazenda);
    
     public List<Reproducao> listarAparaParir(java.util.Date inicio, java.util.Date fim,Fazenda fazenda, Boolean femeaSucesso);

     public List<Reproducao> listarAporTipo(Fazenda fazenda, Boolean femeaSucesso, String tipo);
}
