/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinebank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import com.onlinebank.model.BankCommons;
import javax.servlet.http.HttpSession;



/**
 *
 * @author Robert Forde
 */
public class doRegister extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8401671129945189023L;

	/**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String u=request.getParameter("user");
        String p=request.getParameter("pass");
        String s=request.getParameter("security");
        String a=request.getParameter("answer");
        String d=request.getParameter("address");
        String e=request.getParameter("email");
        String m=request.getParameter("mobile");

        try{
            String sql = "insert into user_details(uname,upass,sec_question,answer,address,email,mobile) values('"+u+"','"+p+"','"+s+"','"+a+"','"+d+"','"+e+"','"+m+"')";
            BankCommons.update(sql);
        }catch(Exception ex) {
            out.println("Exception occurred while inserting data");
            ex.printStackTrace(out);
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("uname", u);
        
        RequestDispatcher rd = request.getRequestDispatcher("/doRegister.jsp");
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
