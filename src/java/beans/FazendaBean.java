/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import fazenda.Fazenda;
import fazenda.FazendaRn;

import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.StreamedContent;
import util.ContextoUtil;
import util.RelatorioUtil;
import util.UtilException;

/**
 *
 * @author Rafael
 */
@ManagedBean(name = "fazendaBean")
@RequestScoped
public class FazendaBean {
private StreamedContent arquivoRetorno;
private int tipoRelatorio;

    private Fazenda selecionada = new Fazenda();
    FazendaRn oi = new FazendaRn();
    private List<Fazenda> lista = null;
private String destinoSalvar = null;

        public String novo() {
        this.destinoSalvar = "listar";
        this.selecionada = new Fazenda();

        return "/fazenda/fazenda";
    }
      
   

        

           public String novoFazenda() {
      ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.selecionada.setUsuario(contextoBean.getUsuarioLogado());
        FazendaRn fazendaRn = new FazendaRn();
        if (fazendaRn.listar(contextoBean.getUsuarioLogado()).size()>=2) {         
         this.destinoSalvar = "/publico/erro-fazenda?faces-redirect=true";
         return this.destinoSalvar; 
        }
        else   {
             this.destinoSalvar = "/fazenda/fazenda-cadastro?faces-redirect=true"; 
          return this.destinoSalvar;
        }
    }  
        
    public String salvar() {
        
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.selecionada.setUsuario(contextoBean.getUsuarioLogado());
        FazendaRn fazendaRn = new FazendaRn();
     
        if (fazendaRn.listar(contextoBean.getUsuarioLogado()).size()>=3) {
           
         this.destinoSalvar = "/publico/erro-fazenda?faces-redirect=true";
         return this.destinoSalvar; 
        }
        else   {
             this.destinoSalvar = "/publico/inicio?faces-redirect=true";
          fazendaRn.salvar(this.selecionada); 
          return this.destinoSalvar;
        }
         
    }
    
    
    /*
     metodo de aviso de piquete não cadastrado
     */


   	public StreamedContent getArquivoRetorno() {
		FacesContext context = FacesContext.getCurrentInstance();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		String usuario = contextoBean.getUsuarioLogado().getLogin();
		String nomeRelatorioJasper = "fazenda";
		String nomeRelatorioSaida = usuario + "_fazenda";
		RelatorioUtil relatorioUtil = new RelatorioUtil();
		HashMap parametrosRelatorio = new HashMap();
		parametrosRelatorio.put("usuario", contextoBean.getUsuarioLogado().getIdUsuario());
		try {
                    
			this.arquivoRetorno = relatorioUtil.geraRelatorio(parametrosRelatorio, nomeRelatorioJasper, nomeRelatorioSaida, this.tipoRelatorio);
		} catch (UtilException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		} 
		return this.arquivoRetorno;
	}
        

        
        

	public void setArquivoRetorno(StreamedContent arquivoRetorno) {
		this.arquivoRetorno = arquivoRetorno;
	}

	public int getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(int tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	} 
    
    public String editar() {
        FazendaRn fazendaRn = new FazendaRn();
        ContextoBean co =  new ContextoBean();
        fazendaRn.carregar(co.getUsuarioLogado().getIdUsuario());
        return "/fazenda/fazenda-editar";
    }

    public void excluir() {
        FazendaRn fazendaRn = new FazendaRn();
        fazendaRn.excluir(this.selecionada);
        this.lista = null;
       
        
    }
    
    
 public void delete(Fazenda item)  {
        // DAO save the delete
        FazendaRn fazendaRn = new FazendaRn();
        fazendaRn.excluir(item);
    }
   
   
     public String cancela() {
     
        return "/publico/inicio";
    }
     
 public String atualizar() {
    ContextoBean contextoBean = ContextoUtil.getContextoBean();
        this.selecionada.setUsuario(contextoBean.getUsuarioLogado());
      
     
        FazendaRn fazendaRn = new FazendaRn();
        fazendaRn.atualizar(this.selecionada);
        
        return "/publico/inicio";
    }

public void tornaFavorita() {
        FazendaRn fazendaRn = new FazendaRn();
        fazendaRn.tonarfavorita(this.selecionada);
        this.selecionada = new Fazenda();
    }

    public Fazenda getSelecionada() {
        return selecionada;
    }

    public void setSelecionada(Fazenda selecionada) {
        this.selecionada = selecionada;
    }

    public List<Fazenda> getLista() {
        if (this.lista == null) { 
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            FazendaRn fazendaRn = new FazendaRn();
            this.lista = fazendaRn.listar(contextoBean.getUsuarioLogado());
        }
        
        return lista;
    }
     public List<Fazenda> getListaAll() {
        if (this.lista == null) { 
            FazendaRn fazendaRn = new FazendaRn();
            this.lista = fazendaRn.listarAll();
        }
        
        return lista;
    }
 public void setListaAll(List<Fazenda> lista) {
        this.lista = lista;
    }
    public void setLista(List<Fazenda> lista) {
        this.lista = lista;
    }
    
}