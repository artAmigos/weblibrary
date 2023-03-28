/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.entity.Author;
import model.entity.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Cover;
import model.entity.cequre.Role;
import model.entity.cequre.User;
import model.session.AuthorFacade;
import model.session.BookFacade;
import model.session.CoverFacade;
import model.session.ReaderFacade;
import model.session.RoleFacade;


@WebServlet(name = "EmployeeServlet", urlPatterns = {
    "/newBook",
    "/createBook",
    "/newAuthor",
    "/createAuthor",
    "/listReaders",
})
public class EmployeeServlet extends HttpServlet {

    @EJB private AuthorFacade authorFacade;
    @EJB private BookFacade bookFacade;
    @EJB private ReaderFacade readerFacade;
    @EJB private RoleFacade roleFacade;
    @EJB private CoverFacade coverFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
           HttpSession session = request.getSession(false);
        if(session == null){
            request.setAttribute("info", "У вас нет достаночного права. Авторизуйтесь!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        User authUser = (User) session.getAttribute("user");
        if(authUser==null){
            request.setAttribute("info", "У вас нет достаночного права. Авторизуйтесь!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        Role roleEmployee = roleFacade.findRoleByName("EMPLOYEE");
        if(!authUser.getRoles().contains(roleEmployee)){
            request.setAttribute("info", "У вас нет достаночного права. Авторизуйтесь!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        String path = request.getServletPath();
        switch (path) {
            case "/newBook":
                request.setAttribute("listAuthors", authorFacade.findAll());
                request.setAttribute("listCovers",coverFacade.findAll());
                request.getRequestDispatcher("/WEB-INF/books/createBook.jsp").forward(request, response);
                break;
            case "/createBook":
                String name = request.getParameter("name");
                String publishedYear = request.getParameter("publishedYear");
                String quantity = request.getParameter("quantity");
                String[] authors = request.getParameterValues("authors");
                List<Author> listBookAuthors = new ArrayList<>();
                for (int i = 0; i < authors.length; i++) {
                    listBookAuthors.add(authorFacade.find(new Long(authors[i])));
                }
                Book book = new Book();
                book.setName(name);
                book.setPublishedYear(Integer.parseInt(publishedYear));
                book.setQuantity(Integer.parseInt(quantity));
                book.setCount(book.getQuantity());
                book.setAuthors(listBookAuthors);
                String coverId = request.getParameter("coverId");
                Cover cover = coverFacade.find(Long.parseLong(coverId));
                book.setCover(cover);
                bookFacade.create(book);
                for (int i = 0; i < listBookAuthors.size(); i++) {
                    Author a = listBookAuthors.get(i);
                    a.getBooks().add(book);
                    authorFacade.edit(a);
                }
                request.setAttribute("listBooks", bookFacade.findAll());
                request.getRequestDispatcher("/WEB-INF/books/listBooks.jsp").forward(request, response);
                break;
            case "/newAuthor":
                request.getRequestDispatcher("/WEB-INF/authors/createAuthor.jsp").forward(request, response);
                break;
            case "/createAuthor":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                Author newAuthor = new Author();
                newAuthor.setFirstname(firstname);
                newAuthor.setLastname(lastname);
                authorFacade.create(newAuthor);
                request.getRequestDispatcher("/newBook").forward(request, response);
                break;
             
            case "/listReaders":
                request.setAttribute("listReaders", readerFacade.findAll());
                request.getRequestDispatcher("/WEB-INF/readers/listReaders.jsp").forward(request, response);
                break;    
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
