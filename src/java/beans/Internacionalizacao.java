/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

        
/**
 *
 * @author Rafael
 */
@ManagedBean(name = "internacionalizacao")
@SessionScoped
public class Internacionalizacao {
    
    private String linguagem = "pt";
    private String pais = "BR";
    private ResourceBundle text;
    
    protected String getMessage(String key) {  
    UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();    
    Locale locale = viewRoot.getLocale();  
    text = ResourceBundle.getBundle("messages.messages", locale);  
    return text.getString(key);  
} 
    public  String mudarIdioma (){
    
        if (!"".equals(pais)) {
            this.mudarLocalidade(new Locale(linguagem, pais));
        } else {
            this.mudarLocalidade(new Locale(linguagem));
        }
    
    return null;
    }
    
    private void mudarLocalidade (Locale locale){
    FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    
    }
    
    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
