package com.fangshuo.codefactory.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
* Copyright: Copyright (c) 2018 Jun_Zhou
* 
* @ClassName: JDBCHelper.java
* @Description: 通过JDBC访问数据库的工具类;
* 
* @version: v1.0.0
* @author: JunZhou
* @Email: 1769676159@qq.com
* @Site: CERNO
* @date: 2018年10月23日 下午9:42:24
 */
public class JDBCHelper {
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        String URL="jdbc:mysql://localhost:3306/generator-demo?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String USER="root";
        String PASSWORD="fangshuoit";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from stu");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}
