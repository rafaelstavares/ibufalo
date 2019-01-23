/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import usuario.UsuarioRn;

/**
 *
 * @author PC-ASUS
 */
@ManagedBean
@RequestScoped
public class RecuperarEmail {
String emailRecuperar;

    public String getEmailRecuperar() {
        return emailRecuperar;
    }

    public void setEmailRecuperar(String emailRecuperar) {
        this.emailRecuperar = emailRecuperar;
    }
    /**
     * Creates a new instance of RecuperarEmail
     */
    public RecuperarEmail() {
    }
    public String recuperarEmail() {
        UsuarioRn usuarioRN = new UsuarioRn();

        if (usuarioRN.bucarPorEmail(emailRecuperar)==null) {
            System.out.println("não existe");
        emailRecuperar="";
            return "falhaEmail?faces-redirect=true";
        }
        else{
            usuarioRN.mandarEmail(emailRecuperar);
            return "index?faces-redirect=true";
        }
    
    }


    

}
