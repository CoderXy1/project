package com.coder.dao;
import java.sql.*;

public class SqlBean {
 
    //JDBC连接
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://47.103.60.221:3306/hr?useSSL=false";
 
    //用户名和密码
    static final String USER = "root";
    static final String PASS = "123456";
    
    public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver"); //加载驱动
            return DriverManager.getConnection(DB_URL,USER,PASS);		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
