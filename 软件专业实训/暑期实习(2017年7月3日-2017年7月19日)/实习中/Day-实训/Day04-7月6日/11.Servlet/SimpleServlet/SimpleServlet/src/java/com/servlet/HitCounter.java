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
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.text.DateFormat;

/**
 *
 * @author ibm
 */
public class HitCounter extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      static final String COUNTER_KEY="Counter";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        HttpSession session=request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int counter=1;
        Integer i=(Integer)session.getAttribute(COUNTER_KEY);
        if(i!=null)
        {
            counter=i.intValue()+1;
        }
        session.setAttribute(COUNTER_KEY,new Integer(counter));
        Date lastAccessed = new Date(session.getLastAccessedTime());
        Date sessionCreated = new Date(session.getCreationTime());
        DateFormat formatter =DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        
        
        try {
            //TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>会话计数器</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("你的会话id："+session.getId()+"<br>");
            out.println("会话创建时间："+formatter.format(sessionCreated)+"<br>");
             out.println("会话上次访问时间："+formatter.format(lastAccessed)+"<br>");
            out.println("会话期间你对页面发起："+counter+"次请求<br>");
            out.println("<h1>Servlet HitCounter at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            out.flush();
            //*/
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
