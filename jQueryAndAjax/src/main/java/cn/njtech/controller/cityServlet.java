package cn.njtech.controller;

import cn.njtech.dao.InfoDao;
import cn.njtech.entity.City;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class cityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String provided = request.getParameter("provided");
        String json ="{}";
        if(provided != null && !"".equals(provided.trim())) {
            InfoDao dao = new InfoDao();
            List<City> cities = dao.getCities(Integer.valueOf(provided));
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(cities);
        }

        //下面这句话很重要！！！设值字符集
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
