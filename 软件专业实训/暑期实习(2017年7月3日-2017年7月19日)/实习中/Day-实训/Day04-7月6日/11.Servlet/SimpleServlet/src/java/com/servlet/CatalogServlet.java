/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author ibm
 */
public class CatalogServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        int itemCount=0;
        HashMap cart=(HashMap)session.getAttribute("cart");
        if(cart!=null)
        {
            itemCount=cart.size();
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<HTML><HEAD><TITLE>简单购物车 "
	                + "Example</TITLE></HEAD>");
	    out.println("<BODY><TABLE border=\"0\" width=\"100%\"><tr>");
	    out.println("<td align=\"left\" valign=\"bottom\">");
	    out.println("<H1>欢迎来到开心水果店购物</H1></td></tr></TABLE><HR>");

	    out.print("<FORM ACTION=\"");
	    out.println(response.encodeURL("cart"));
	    out.println("\" METHOD=\"POST\">");
	    out.println("<TABLE CELLSPACING=\"5\" CELLPADDING=\"5\"><TR>");
	    out.println("<TD ALIGN=\"center\"><B>种类</B></TD>");
	    out.println("<TD ALIGN=\"center\"><B>单价</B></TD>");
	    out.println("<TD ALIGN=\"center\"><B>数量</B></TD></TR><TR>");
	    out.println("<TD ALIGN=\"center\">"+"苹果"+"</TD>");
	    out.println("<TD ALIGN=\"center\">"+"5.5"+"</TD>");
	    out.println("<TD ALIGN=\"center\">");
	    out.println("<INPUT  NAME=\"apple_amount\""
	                + " ></TD></TR><TR>");

	    out.println("<TD ALIGN=\"center\">"+"香蕉"+"</TD>");
	    out.println("<TD ALIGN=\"center\">"+"4.5"+"</TD>");
	    out.println("<TD ALIGN=\"center\">");
	    out.println("<INPUT  NAME=\"banana_amount\""
	                + "></TD></TR><TR>");

	    out.println("<TD ALIGN=\"center\">"+"葡萄"+"</TD>");
	    out.println("<TD ALIGN=\"center\">"+"3.6"+"</TD>");
	    out.println("<TD ALIGN=\"center\">");
	    out.println("<INPUT  NAME=\"grape_amount\""
	                + "></TD></TR>");

	    out.println("</TABLE><HR>");
	    out.println("<INPUT TYPE=\"Submit\" NAME=\"btn_submit\" "
	                + "VALUE=\"放入购物车\">");
	    out.println("</FORM></BODY></HTML>");

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
        processRequest(request, response);
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
        processRequest(request, response);
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
