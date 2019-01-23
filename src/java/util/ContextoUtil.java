/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.ContextoBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rafael
 */
public class ContextoUtil {
  public static  ContextoBean getContextoBean(){
  FacesContext context = FacesContext.getCurrentInstance();
  ExternalContext external = context.getExternalContext();
  HttpSession session = (HttpSession)external.getSession(true);
  ContextoBean contextoBean = (ContextoBean) session.getAttribute("contextoBean");
  return contextoBean;
  }
}
