/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import animal.Animal;
import animal.AnimalRn;
import funcionarios.Funcionarios;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import local.Local;
import util.ContextoUtil;

/**
 *
 * @author PC-ASUS
 */
@ManagedBean
@RequestScoped
public class Notification {

    private List<Local> listaLocal;
    private List<Animal> listaAnimal;
    private List<Funcionarios> listaFuncionarios;

    public int listaNotification() {
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        AnimalRn animalRn = new  AnimalRn();
        listaAnimal = animalRn.listar(contextoBean.getFazendaAtiva());

    return listaAnimal.size();  
    }

}
