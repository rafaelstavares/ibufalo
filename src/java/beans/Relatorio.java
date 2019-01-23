/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import animal.Animal;
import animal.AnimalRn;
import fazenda.Fazenda;
import fazenda.FazendaRn;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import usuario.Usuario;
import util.ContextoUtil;
import util.UtilException;

/**
 *
 * @author rafael
 */
@ManagedBean(name = "relatorioBeans")
@RequestScoped
public class Relatorio {

    public Relatorio() {
    }
       
    public void imprimeRelatorio() throws JRException, IOException, SQLException {
      FazendaRn oi = new FazendaRn();
      Usuario user = new Usuario();
       ContextoBean contextoBean = ContextoUtil.getContextoBean();
        user= contextoBean.getUsuarioLogado();
 List<Fazenda> listFarm;
 listFarm = oi.listar(user);
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listFarm);  
      //  String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath( "WEB-INF/relatorios/report2.jasper" );  
     InputStream content = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("WEB-INF/relatorios/fazenda.jasper");
        
         Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("parame", beanCollectionDataSource);
       
        JasperPrint jasperPrint = JasperFillManager.fillReport(content, parameters, new JREmptyDataSource());  
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
         httpServletResponse.setContentType("application/pdf");
         httpServletResponse.addHeader("Content-disposition", "inline; filename=\"fazenda.pdf\"");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();  
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();  
      
    
    
    }
        public void imprimeRelatorioAnimal() throws JRException, IOException, SQLException {
   
        AnimalRn animal = new AnimalRn();
        Fazenda oi = new Fazenda();
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        oi= contextoBean.getFazendaAtiva();
        List<Animal> listaAnimal;
        listaAnimal = animal.listar(oi);
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaAnimal);
      InputStream content = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("WEB-INF/relatorios/report5.jasper");

        Map paramentos = new HashMap();

        JasperPrint jasperPrint = JasperFillManager.fillReport(content, paramentos, beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        
        httpServletResponse.setContentType("application/pdf");
       httpServletResponse.addHeader("Content-disposition", "inline; filename=\"arquivo.pdf\"");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

      FacesContext.getCurrentInstance().responseComplete();
    }
     Connection getConexao() throws UtilException {
        java.sql.Connection conexao = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/tcc");
            conexao = (java.sql.Connection) ds.getConnection();
        } catch (NamingException e) {
            throw new UtilException("Não foi possível encontrar o nome da conexão do banco.", e);
        } catch (SQLException e) {
            throw new UtilException("Ocorreu um erro de SQL.", e);
        }
        return conexao;
    }
}

