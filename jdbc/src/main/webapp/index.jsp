<%@page import="java.sql.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>jdbc</title>
    </head>
    <body>
        <h2>读取数据库数据</h2>
        <%
            String Driver = "com.mysql.jdbc.Driver";
            Class.forName(Driver);
            String dbUrl = "jdbc:mysql://localhost:3306/stu";
            String name = "root";
            String pwd = "root";
            Connection conn = null;
            Statement stmt = null;
            ResultSet rst = null;
            try {
                conn = DriverManager.getConnection(dbUrl, name, pwd);
                stmt = conn.createStatement();
                String sql = "select * from stud";
                rst = stmt.executeQuery(sql);
                while (rst.next()) {

                    String ID = rst.getString(1);
                    String NAME = rst.getString(2);
                    String GRADE = rst.getString(3);
                    int SCORE = rst.getInt(4);
                    response.getWriter().print(ID + " ");
                    response.getWriter().print(NAME + " ");
                    response.getWriter().print(GRADE + " ");
                    response.getWriter().println(SCORE);
                    System.out.println(ID);
                    System.out.println(NAME);
                    System.out.println(GRADE);
                    System.out.println(SCORE);

                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                if (conn != null){
                    conn.close();
                    conn = null;
                }
                if (stmt != null){
                    stmt.close();
                    stmt = null;
                }
                if (rst != null){
                    rst.close();
                    rst = null;
                }
            }

        %>



    </body>

</html>
