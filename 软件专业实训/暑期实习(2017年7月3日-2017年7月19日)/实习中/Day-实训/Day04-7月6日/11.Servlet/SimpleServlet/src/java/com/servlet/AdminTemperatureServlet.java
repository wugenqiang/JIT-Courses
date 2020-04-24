/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;

/**
 *
 * @author ibm
 */
public class AdminTemperatureServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminTemperatureServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminTemperatureServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet 方法。单击左侧的 + 号以编辑代码。">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String temperature =(String) getServletContext().getAttribute("Temperature");
            if(temperature==null)
            {
                temperature = (String)getInitParameter("Temperature");
                getServletContext().setAttribute("Tempareture",temperature);
            }
            out.println("<HTML><HEAD><TITLE>气温更新 "
	                + "</TITLE></HEAD>");
	    out.println("<BODY><TABLE border=\"0\" width=\"100%\"><tr>");
	    out.println("<td align=\"left\" valign=\"bottom\">");
	    out.println("<H1>当前气温</H1></td></tr></TABLE>");

	    out.print("<FORM ACTION=\"");
	    out.println(response.encodeURL("adminTemperature"));
	    out.println("\" METHOD=\"POST\">");
	    out.println("当前气温（摄氏度）");
	    out.println("<INPUT TYPE=\"text\" NAME=\"temperature\" "
                + "VALUE="+temperature+">");
	    out.println("<INPUT TYPE=\"Submit\" NAME=\"btn_submit\" "
	                + "VALUE=\"更新\">");
	    out.println("</FORM></BODY></HTML>");
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        	response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String Temperature=request.getParameter("temperature");
       //		将更新后的气温信息放入上下文
		getServletConfig().getServletContext().setAttribute("Temperature",Temperature);
        out.println("<HTML><HEAD><TITLE>气温更新 "
	                + "</TITLE></HEAD>");
	    out.println("<BODY>");
	    out.println("当前气温："+Temperature+"摄氏度");

	    out.println("</BODY></HTML>");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
