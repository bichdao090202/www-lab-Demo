package vn.edu.iuh.fit.daos;

import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.models.User;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class UserDAO {
    private Connection conn;
    private HttpSession session;

    public UserDAO(HttpSession session) throws Exception{
        Class.forName ("org.mariadb.jdbc.Driver");
        String s = "jdbc:mariadb://localhost:3306/logonDB";
        conn = DriverManager.getConnection(s,"root","");
        this.session = session;
    }
    public boolean logon(String username, String password) throws Exception {
        String sql = "select * from user where username = ? and pass_word = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String role = rs.getString("role");
            if(role.equalsIgnoreCase("admin")){
                Statement st =  conn.createStatement();
                ResultSet rsU = st.executeQuery("Select * from user");
                List<User> list = new ArrayList<>();
                while (rsU.next()){
                    User user = new User(
                            rsU.getString(1),rsU.getString(2),
                            rsU.getString(3),rsU.getString(4),rsU.getString(5));
                    list.add(user);
                }
                session.setAttribute("ds",list);
            }
            else{
                User user = new User(
                        rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5));
                session.setAttribute("user",user);
            }
            return true;

        }
        return false;
    }
}
