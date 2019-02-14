package com.org.xinhai.until;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	/**
	 * 连接数据库zhongkonghe
	 * @return
	 */
	
	public static Connection makeConnection(){
		 try {
			 Connection conn = null;
		        //加载数据库驱动类
			 	//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        Class.forName("com.mysql.jdbc.Driver").newInstance();
		        //数据库连接URL
		       /// String url = "jdbc:sqlserver://192.168.0.5;DatabaseName=XHA8";
		      String  url = "jdbc:mysql://localhost:3306/zhongkonghe?useUnicode=true&characterEncoding=utf-8&useSSL=false"; 
		        
		        //数据库用户名
		        String user = "root";
		        //数据库密码
		        String password = "1234";
		        //根据数据库参数取得一个数据库连接
		     conn = DriverManager.getConnection(url, user, password);
		     return conn;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static void main(String[] arg){
		Connection makeConnection = makeConnection();
		System.err.println(makeConnection);
			
		}

}
