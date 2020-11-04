package cn.njtech;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        if(name.equals("niit") && pwd.equals("niit")){
            //resp.getWriter().println("Success login");
            System.out.println("Success login");
//            resp.sendRedirect("succ.jsp");
            req.getRequestDispatcher("succ.jsp").forward(req, resp);
        } else {
            //resp.getWriter().println("Failure login");
            System.out.println("Failure login");
//            resp.sendRedirect("err.jsp");
            req.getRequestDispatcher("err.jsp").forward(req, resp);
        }

    }

}
