/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producao;

import animal.Animal;
import fazenda.Fazenda;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import util.DAOFactory;

/**
 *
 * @author Rafael
 */
public class ProducaoRn {

    private ProducaoDAO producaoRn;

    public ProducaoRn() {
        this.producaoRn = DAOFactory.criarproducaoDao();
    }

    public Producao carregar(Integer idproducao) {
        return this.producaoRn.carregar(idproducao);
    }

    public void salvar(Producao producao) {
        Integer idanimal = producao.getIdProducao();
        if (idanimal == null || idanimal == 0) {
            this.producaoRn.salvar(producao);
        } else {
            this.producaoRn.atualizar(producao);
        }
    }

    public void excluir(Producao producao) {
        this.producaoRn.excluir(producao);
    }

    public List<Producao> listar(Fazenda fazenda) {
        return this.producaoRn.listar(fazenda);
    }

    public List<Producao> listarAll() {
        return this.producaoRn.listarAll();
    }

    public List<Producao> listarAnimal(Fazenda fazenda, Animal animal) {
        return this.producaoRn.listarAnimal(fazenda, animal);
    }

    public double totalProducao(Fazenda fazenda) {

        return this.producaoRn.totalProducao(fazenda);
    }

    public double totalProducaoAno(Fazenda fazenda) {
        Calendar anoSel = Calendar.getInstance();
        anoSel.set(Calendar.MONTH, 0);
        anoSel.set(Calendar.DAY_OF_MONTH, 1);
        Date data1 = anoSel.getTime();
        Calendar anoSe2 = Calendar.getInstance();
        anoSe2.set(Calendar.MONTH, 12);
        anoSe2.set(Calendar.DAY_OF_MONTH, 0);
        Date data2 = anoSe2.getTime();
        System.out.println("" + anoSel);
        return this.producaoRn.totalProducaoAno(fazenda,data1,data2);
    }

    public double totalProducaoAnimal(Fazenda fazenda, Animal animal) {

        return this.producaoRn.totalProducaoAnimal(fazenda, animal);
    }

}
