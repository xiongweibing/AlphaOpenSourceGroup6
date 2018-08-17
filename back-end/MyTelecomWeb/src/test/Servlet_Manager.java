package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ManagerTest")
public class Servlet_Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
    * @see HttpServlet#HttpServlet()
     */
  public Servlet_Manager() {
    super();
        // TODO Auto-generated constructor stub
  }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
//		// TODO Auto-generated method stub
//		response.getWriter().append("idontknow ").append(request.getContextPath());
//	  // TODO Auto-generated method stub
    
    response.setContentType("text/html;charset=utf-8");          
    /* ������Ӧͷ����ajax������� */  
    response.setHeader("Access-Control-Allow-Origin", "*");  
    /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
    response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
   
    //��ȡ΢��С����get�Ĳ���ֵ����ӡ
    Writer out = response.getWriter(); 
    out.write(SqlOperate());
    out.flush();
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String SqlOperate() {
		String result = SqlOperator.getInstance().operate(2,"").toString();
		System.out.println(result);
		return result;
	}
  
}

