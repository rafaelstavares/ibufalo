/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fazenda;


import java.util.List;
import usuario.Usuario;

/**
 *
 * @author Rafael
 */
public interface FazendaDAO {

    public void salvar(Fazenda fazenda);
    public void atualizar(Fazenda fazenda);
    public void excluir(Fazenda fazenda);
    public Fazenda carregar (Integer idfazenda);
    public List<Fazenda> listar(Usuario usuario);
    public List<Fazenda> listarAll();
    public Fazenda buscarFazendafavorita(Usuario usuario);
}
