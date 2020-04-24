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
import javax.servlet.http.Cookie;

/**
 *
 * @author ibm
 */
public class CookieTrackServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         Cookie cookie=null;
            Cookie[] cookies = request.getCookies();
            boolean newCookie =false;
            if(cookies!=null)
            {
                boolean flag=false;
                for(int i=0;i<cookies.length;i++)
                {
                    if(cookies[i].getName().equals("VisitTimes"))
                    {
                        String v = cookies[i].getValue();
                        int value = Integer.parseInt(v)+1;
                        cookies[i].setValue(Integer.toString(value));
                        response.addCookie(cookies[i]);
                        flag =true;
                        cookie=cookies[i];
                    }
                    
                }

            }

            if(cookie==null)
            {
                newCookie = true;
                int maxAge=-1;
                cookie=new Cookie("VisitTimes","1");
                cookie.setPath(request.getContextPath());
                cookie.setMaxAge(maxAge);
                response.addCookie(cookie);
            }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cookie 跟踪会话</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CookieServlet at " + request.getContextPath () + "</h1>");
            out.println("<h2>你好 </h2>");
            out.println("欢迎你第"+cookie.getValue()+"次访问本页面<br>");
            out.println("</body>");
            out.println("</html>");
            out.flush();
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
