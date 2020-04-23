package com.clps.oas.common.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EncodingFilter
 */
@WebFilter(filterName = "encodingFilter", urlPatterns = { "/*" }, initParams = { @javax.servlet.annotation.WebInitParam(name = "ENCODING", value = "UTF-8") })
public class EncodingFilter extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;
	private String encoding = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncodingFilter() {
        super();
    }

	/**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig arg0) throws javax.servlet.ServletException { 
    	encoding = arg0.getInitParameter("ENCODING");
		if (encoding == null || "".equals(encoding)) {
			encoding = "utf-8";
		}
    }

	/**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws java.io.IOException, javax.servlet.ServletException { 
    	arg0.setCharacterEncoding(encoding);
		arg1.setCharacterEncoding(encoding);
		arg2.doFilter(arg0, arg1);
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
