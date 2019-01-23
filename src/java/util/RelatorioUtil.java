/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Rafael
 */
public class RelatorioUtil {

    public static final int RELATORIO_PDF = 1;
    public static final int RELATORIO_EXCEL = 2;
    public static final int RELATORIO_HTML = 3;
    public static final int RELATORIO_PLANILHA_OPEN_OFFICE = 4;

    public StreamedContent geraRelatorio(HashMap parametrosRelatorio, String nomeRelatorioJasper, String nomeRelatorioSaida, int tipoRelatorio) throws UtilException {
        StreamedContent arquivoRetorno = null;

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Connection conexao = this.getConexao();
            String caminhoRelatorio = context.getExternalContext().getRealPath("/relatorios");
            String caminhoArquivoJasper = caminhoRelatorio + File.separator + nomeRelatorioJasper + ".jasper";
            String caminhoArquivoRelatorio = null;

            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject(caminhoArquivoJasper);
            JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, parametrosRelatorio, conexao);
            JRExporter tipoArquivoExportado = null;
            String extensaoArquivoExportado = "";
            File arquivoGerado = null;

            switch (tipoRelatorio) {
                case RelatorioUtil.RELATORIO_PDF:
                    tipoArquivoExportado = new JRPdfExporter();
                    extensaoArquivoExportado = "pdf";
                    break;
                case RelatorioUtil.RELATORIO_HTML:
                    tipoArquivoExportado = new JRHtmlExporter();
                    extensaoArquivoExportado = "html";
                    break;
                case RelatorioUtil.RELATORIO_EXCEL:
                    tipoArquivoExportado = new JRXlsExporter();
                    extensaoArquivoExportado = "xls";
                    break;
                case RelatorioUtil.RELATORIO_PLANILHA_OPEN_OFFICE:
                    tipoArquivoExportado = new JROdsExporter();
                    extensaoArquivoExportado = "ods";
                    break;
                default:
                    tipoArquivoExportado = new JRPdfExporter();
                    extensaoArquivoExportado = "pdf";
                    break;
            }
            caminhoArquivoRelatorio = caminhoRelatorio + File.separator + nomeRelatorioSaida + "." + extensaoArquivoExportado;
            arquivoGerado = new java.io.File(caminhoArquivoRelatorio);
            tipoArquivoExportado.setParameter(JRExporterParameter.JASPER_PRINT, impressoraJasper);
            tipoArquivoExportado.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
            tipoArquivoExportado.exportReport();
            arquivoGerado.deleteOnExit();

            InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
            arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/" + extensaoArquivoExportado, nomeRelatorioSaida + "." + extensaoArquivoExportado);
        } catch (JRException e) {
            throw new UtilException("Não foi possível gerar o relatório.", e);
        } catch (FileNotFoundException e) {
            throw new UtilException("Arquivo do relatório não encontrado.", e);
        }
        return arquivoRetorno;
    }
 
     private Connection getConexao() throws UtilException {
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
    
    /*
    private Connection getConexao() throws UtilException {

        java.sql.Connection conexao = null;
        try {
          conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tcc", "root", "root");
       }catch(SQLException e){
           System.out.println("eroo"+e.getMessage());
        } 
        return conexao;
    } */ 
    
/*
    public static void main(String[] args) {
        RelatorioUtil oi = new RelatorioUtil();
        Connection ui = null;
                try{
                ui = oi.getConexao();
                    System.out.println("conexao com sucesso");
                } catch (Exception ex) {
                    System.out.println("erro conexao >>>"+ex.getMessage());
        }
    }
  */  

}
