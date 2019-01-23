/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.*;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


/**
 *
 * @author Rafael
 */
public class Filtro implements Filter {
private SessionFactory	sf;

	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException {

		try {

			this.sf.getCurrentSession().beginTransaction();

			chain.doFilter(servletRequest, servletResponse);

			this.sf.getCurrentSession().getTransaction().commit();
			this.sf.getCurrentSession().close();

		} catch (Throwable ex) {
			try {
				if (this.sf.getCurrentSession().getTransaction().isActive()) {
					this.sf.getCurrentSession().getTransaction().rollback();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
	}

  
}