package cn.njtech;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("---------------TestServlet doGet");

        //resp.getWriter().print("Hi from TestServlet doGet method");
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        if(!name.equals("niit") && !pwd.equals("niit")){
            resp.getWriter().println("Failure login");
            System.out.println("Failure login");
        }

        if(name.equals("niit") && pwd.equals("niit")){
            resp.getWriter().println("Success login");
            System.out.println("Success login");
        }
    }

}
