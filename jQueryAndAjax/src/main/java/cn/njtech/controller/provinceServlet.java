package cn.njtech.controller;

import cn.njtech.dao.InfoDao;
import cn.njtech.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class provinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Province> provinces = new ArrayList<>();
        String json = "{}";
        InfoDao dao = new InfoDao();
        provinces = dao.getProvinces();
        ObjectMapper om = new ObjectMapper();
        json = om.writeValueAsString(provinces);
        response.setContentType("application/json; charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}
