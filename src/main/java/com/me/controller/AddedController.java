/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.me.controller;

import com.me.pojo.Item;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jaeline
 */
@WebServlet(name = "AddedController", urlPatterns = {"/store.do"})
public class AddedController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList<Item> totalList = new ArrayList<Item>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String task = request.getParameter("task");
        HttpSession session = request.getSession();

        if (task != null && task.equals("add")) {
            String[] name = request.getParameterValues("item");
            String[] price = request.getParameterValues("price");
            
            ArrayList<Item> addedList = new ArrayList<Item>();
            for (int i = 0; i < name.length; i++) {
                Item item = new Item();
                item.setName(name[i]);
                item.setPrice(Float.parseFloat(price[i]));
                addedList.add(item);
                totalList.add(item);
            }

            request.setAttribute("itemsadded", addedList);
            session.setAttribute("totalitems", totalList);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemadded.jsp");
            rd.forward(request, response);
        }
        
        else if(task != null && task.equals("delete")) {
            String[] deleting =request.getParameterValues("delete");
            
            ArrayList<Item> tbd = new ArrayList<Item>();
            for (String d: deleting) {
                for (Item i: totalList) {
                    if(i.getName().equals(d)) {
                        tbd.add(i);
                        break;
                    }
                }
            }
            totalList.removeAll(tbd);
            
            session.setAttribute("totalitems", totalList);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
            rd.forward(request, response);
        }
        
        else {
            session.setAttribute("totalitems", totalList);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
            rd.forward(request, response);
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
