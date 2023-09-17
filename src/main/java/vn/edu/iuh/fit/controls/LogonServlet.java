package vn.edu.iuh.fit.controls;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.daos.UserDAO;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.wwwlabweek01.HelloServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(urlPatterns = {"/logon"})
public class LogonServlet extends HelloServlet {
    private UserDAO dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            HttpSession session = req.getSession(true);
            dao = new UserDAO(session);
            String username = req.getParameter("Username");
            String password = req.getParameter("Password");
            boolean kq = dao.logon(username, password);
            if (!kq) {
                out.println("<h1> Invalid username or password <h1>");
            } else {
                Object obj = session.getAttribute("ds");
                if (obj == null) {
                    User user = (User) session.getAttribute("user");
                    out.println(user);
                } else {
                    List<User> lst = (ArrayList<User>) obj;
                    lst.forEach(u -> {
                        out.println(u);
                    });
                }
            }
            ArrayList<User> list = (ArrayList<User>) session.getAttribute("ds");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
