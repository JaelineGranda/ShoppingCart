/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.me.controller;

import com.me.pojo.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "ItemController", urlPatterns = {"/store"})
public class ItemController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void init() {
        Item i1 = new Item();
        Item i2 = new Item();
        Item i3 = new Item();

        Item i4 = new Item();
        Item i5 = new Item();
        Item i6 = new Item();

        Item i7 = new Item();
        Item i8 = new Item();
        Item i9 = new Item();

        i1.setName("Macbook Pro");
        i1.setPrice(1500.98f);

        i2.setName("HP Pavilion");
        i2.setPrice(800.99f);

        i3.setName("Lenovo Thinkpad");
        i3.setPrice(1700.98f);

        i4.setName("I'm Going to Tell You a Secret by Madonna");
        i4.setPrice(26.99f);

        i5.setName("Baby One More Time by Britney Spears");
        i5.setPrice(10.95f);

        i6.setName("Justified by Justin Timberlake");
        i6.setPrice(9.97f);
        
        i7.setName("Java Servlet Programming");
        i7.setPrice(29.95f);

        i8.setName("Oracle Database Programming");
        i8.setPrice(48.97f);

        i9.setName("Java Web Services");
        i9.setPrice(27.98f);

        ArrayList<Item> compList = new ArrayList<Item>();
        compList.add(i1);
        compList.add(i2);
        compList.add(i3);
        
        ArrayList<Item> musicList = new ArrayList<Item>();
        musicList.add(i4);
        musicList.add(i5);
        musicList.add(i6);

        ArrayList<Item> bookList = new ArrayList<Item>();
        bookList.add(i7);
        bookList.add(i8);
        bookList.add(i9);

        ServletContext ctx = this.getServletContext();
        ctx.setAttribute("music", musicList);
        ctx.setAttribute("computers", compList);
        ctx.setAttribute("books", bookList);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String itemspage = request.getParameter("name");
        
        if (itemspage.equals("comps")) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/computers.jsp");
            rd.forward(request, response);
        }
        else if (itemspage.equals("books")) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/books.jsp");
            rd.forward(request, response);
        }
        else if (itemspage.equals("music")) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/music.jsp");
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
