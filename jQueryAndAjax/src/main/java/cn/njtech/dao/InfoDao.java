package cn.njtech.dao;

import cn.njtech.entity.City;
import cn.njtech.entity.Province;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class InfoDao {
    public List<Province> getProvinces() {
        List<Province> myList = new ArrayList<>();
        String Driver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/province";
        String userName = "root";
        String password = "root";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(dbURL, userName, password);
            String sql = "select id, name from province";
            pstmt = conn.prepareStatement(sql);
            rst = pstmt.executeQuery();
            while (rst.next()) {
                Province province = new Province();
                province.setId(rst.getInt(1));
                province.setName(rst.getString(2));
                myList.add(province);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                    conn = null;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(pstmt != null){
                try {
                    pstmt.close();
                    pstmt = null;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(rst != null){
                try {
                    rst.close();
                    rst = null;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return myList;
    }


    public List<City> getCities(Integer provinceId) {
        List<City> myList = new ArrayList<>();
        String Driver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/province";
        String userName = "root";
        String password = "root";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        City city = null;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(dbURL, userName, password);
            String sql = "select id, name, provinceId from city where provinceId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, provinceId);
            rst = pstmt.executeQuery();
            while (rst.next()) {
                city = new City();
                city.setId(rst.getInt(1));
                city.setName(rst.getString(2));
                city.setProvinceId(rst.getInt(3));
                myList.add(city);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                    conn = null;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(pstmt != null){
                try {
                    pstmt.close();
                    pstmt = null;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(rst != null){
                try {
                    rst.close();
                    rst = null;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return myList;
    }
}
