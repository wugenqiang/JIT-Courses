/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 *
 * @author ibm
 */
public class CartServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        HashMap cart=(HashMap)session.getAttribute("cart");
        if(cart==null)
        {
            cart = new HashMap();
            cart.put("apple", "0");
            cart.put("banana", "0");
            cart.put("grape", "0");
            session.setAttribute("cart", cart);




        }
        response.setContentType("text/html;charset=GB2312");
        request.setCharacterEncoding("GB2312");
        PrintWriter out = response.getWriter();
        String apple_amount=request.getParameter("apple_amount");
        String banana_amount=request.getParameter("banana_amount");
        String grape_amount=request.getParameter("grape_amount");
        String appleAmount = (String)cart.get("apple");
        String bananaAmount = (String)cart.get("banana");
        String grapeAmount = (String)cart.get("grape");
        int new_apple_amount = Integer.parseInt(appleAmount,10)+Integer.parseInt(apple_amount,10);
        int new_banana_amount = Integer.parseInt(bananaAmount,10)+Integer.parseInt(banana_amount,10);
        int new_grape_amount = Integer.parseInt(grapeAmount,10)+Integer.parseInt(grape_amount,10);
        cart.put("apple",String.valueOf(new_apple_amount));
        cart.put("banana",String.valueOf(new_banana_amount));
        cart.put("grape",String.valueOf(new_grape_amount));

        try {
           out.println("<HTML><HEAD><TITLE>");
	    out.println("购物车内容");
	    out.println("</TITLE></HEAD>");
	    out.println("<BODY>");
	    out.println("<H1>你的购物车里有</H1>"+
	    		new_apple_amount+"斤苹果 "+new_banana_amount+"斤香蕉 "
				+new_grape_amount+"斤葡萄");
	    out.println("<HR>");


	    out.print("<HR><p><A HREF=\"");
	    out.print(response.encodeURL("catalog"));
	    out.println("\">回到水果店</A></p>");
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
