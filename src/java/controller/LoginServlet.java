/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.entity.Reader;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.cequre.Role;
import model.entity.cequre.User;
import model.session.BookFacade;
import model.session.ReaderFacade;
import model.session.RoleFacade;
import model.session.UserFacade;
import tools.PassEncrypt;


@WebServlet(name = "LoginServlet",loadOnStartup = 1, urlPatterns = {
    "/login",
    "/enter",
    "/logout",
    "/newReader",
    "/registration",
    "/listBooks",
   
    
})
public class LoginServlet extends HttpServlet {

    @EJB private ReaderFacade readerFacade;
    @EJB private RoleFacade roleFacade;
    @EJB private UserFacade userFacade;
    @EJB private BookFacade bookFacade;
    private PassEncrypt pe = new PassEncrypt();
    
    @Override
    public void init() throws ServletException {
        super.init();
        if(userFacade.count()>0) return;
        Role role = new Role();
        role.setRoleName("ADMIN");
        roleFacade.create(role);
        User user = new User();
        user.setLogin("admin");
        String salt = pe.getSalt();
        String encryptPassword = pe.getEncryptedPass("admin", salt);
        user.setPassword(encryptPassword);
        user.setSalt(salt);
        Reader reader = new Reader();
        reader.setFirstname("Ivan");
        reader.setLastname("Ivanov");
        reader.setPhone("56545566666");
        readerFacade.create(reader);
        user.setReader(reader);
        user.getRoles().add(role);
        
        role = new Role();
        role.setRoleName("EMPLOYEE");
        roleFacade.create(role);
        user.getRoles().add(role);
        
        role = new Role();
        role.setRoleName("USER");
        roleFacade.create(role);
        user.getRoles().add(role);
        userFacade.create(user);
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/login":
                request.getRequestDispatcher("/WEB-INF/readers/login.jsp").forward(request, response);
                break;
            case "/enter":
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                User user = userFacade.findByLogin(login);
                if(user == null){
                    request.setAttribute("info", "Нет такого пользователя или неправильный пароль");
                    request.getRequestDispatcher("/login").forward(request, response);
                    break;
                }
                String encryptPassword = pe.getEncryptedPass(password, user.getSalt());
                if(!encryptPassword.equals(user.getPassword())){
                    request.setAttribute("info", "Нет такого пользователя или неправильный пароль");
                    request.getRequestDispatcher("/login").forward(request, response);
                    break;
                }
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                request.setAttribute("info", "Привет "+ user.getReader().getFirstname()+"!");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/logout":
                if(request.getSession(false) != null){
                    request.getSession(false).invalidate();
                }
                request.setAttribute("info", "Вы вышли");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/newReader":
                request.getRequestDispatcher("/WEB-INF/readers/createReader.jsp").forward(request, response);
                break;
            case "/registration":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                login = request.getParameter("login");
                password = request.getParameter("password");
                Reader reader = new Reader();
                reader.setFirstname(firstname);
                reader.setLastname(lastname);
                reader.setPhone(phone);
                readerFacade.create(reader);
                user = new User();
                user.setLogin(login);
                //Шифрование пароля
                String salt = pe.getSalt();
                encryptPassword = pe.getEncryptedPass(password, salt);
                //---
                user.setPassword(encryptPassword);
                user.setSalt(salt);
                user.setReader(reader);
                Role roleUser = roleFacade.findRoleByName("USER");
                user.getRoles().add(roleUser);
                userFacade.create(user);
                //request.setAttribute("listReaders", readerFacade.findAll());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listBooks":
                request.setAttribute("listBooks", bookFacade.findAll());
                request.getRequestDispatcher("/WEB-INF/books/listBooks.jsp").forward(request, response);
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
