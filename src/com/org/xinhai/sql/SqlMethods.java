package com.org.xinhai.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.org.xinhai.until.ConnectionFactory;

/**
 * @author Tony
 * @version 创建时间：2018年5月28日 下午1:19:11
 * @ClassName 类名称
 * @Description 类描述
 */
public class SqlMethods {

	public static void insertInfo(int type, String text, Date date) {
		// List<Question> lessonList = new ArrayList<Question>();
		//String ExamineeName = null;
		// ConnectionFactory conn = new ConnectionFactory();
		Connection conn = ConnectionFactory.makeConnection();
		Statement stmt = null;
		//String msg=null;
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO zhongkonghe(type,text,createtime) VALUES " + "('" + type + "', '" + text + "','"+ date + "')";// sql语句拼接
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	return msg;

	}
public static void main(String[] args) {
//	 String Time1=null;
//	 Date day=new Date();    
//	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	 Time1=df.format(day);
//	SearchExamineeName(1, "aa", Time1);
//	Date date=new Date();
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();     
	Timestamp timestamp = new Timestamp(date.getTime());
//	try {
//		 date = sdf.parse(sdf.format(new Date()));
//		
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	System.out.println(timestamp);
	insertInfo(1, "aa", timestamp);
}

}
