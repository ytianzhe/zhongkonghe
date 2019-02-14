package com.xinhai.org.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.org.xinhai.sql.SqlMethods;

import jdk.nashorn.internal.parser.JSONParser;

/**
 * Servlet implementation class GetInfo
 */
@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		 this.doPost(request, response);
//		String type=null;
//		String storagetext=null;
//		String systemdate=null;
//		type=request.getParameter("type");
//		storagetext= request.getParameter("text");
//		Date day=new Date();    
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		systemdate=df.format(day);
//		System.out.println(systemdate);   
//		System.out.println(type+""+storagetext);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		    int type=0;
		    String text=null;		   
		    String msg=null;
		   response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");

	        /**
	         * 接收json
	         */
	        BufferedReader reader = request.getReader();
	        String json = reader.readLine();
	        System.out.println(json);
	        reader.close();    
	      // JSONObject obj = JSONObject.parseObject(json); 
	       // System.out.println("json: "+json);
	        try{
	        	 JSONObject jsonObject = JSON.parseObject(json);
//	        	 System.out.println(jsonObject.getInteger("type")+":"+jsonObject.getString("text"));
	        	 type=jsonObject.getInteger("type");
	        	 text=jsonObject.getString("text");
	        	 System.out.println(type+""+text); 	 	
	        	 Date date = new Date();     
	        	 Timestamp timestamp = new Timestamp(date.getTime());
	        	// SqlMethods.insertInfo(type, text, timestamp);
	        	 msg= InsertInfo(request, response, type, text, timestamp);
	        	// msg="insert succeed";
	        	 System.out.println(msg);
	        	
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	}
	
	private String InsertInfo(HttpServletRequest request,
			HttpServletResponse response, int type,String text,Date timestamp)
			throws ServletException, SQLException {
		String msg=null;
		//System.out.println("执行查询操作");
		SqlMethods.insertInfo(type, text, timestamp);
		msg="insert succeed";
		// return message;
		return msg;

	}

}
