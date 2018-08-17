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
@WebServlet("/MobileTest")
public class Servlet_Mobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
    * @see HttpServlet#HttpServlet()
     */
  public Servlet_Mobile() {
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
    /* 设置响应头允许ajax跨域访问 */  
    response.setHeader("Access-Control-Allow-Origin", "*");  
    /* 星号表示所有的异域请求都可以接受， */  
    response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
   
    //获取微信小程序get的参数值并打印
    String[] array = {"yubei", "yuzhong", "jiulongpo", "shapingba","jiangbei","nanan"};
    String[] array2 = {"CT", "CMCC", "CUCC"};
    String[] array3 = {"Month_1", "Month_2", "Month_3", "Month_4", "Month_5", "Month_6", "Month_7", "Month_8", "Month_9", "Month_10", "Month_11", "Month_12"};
    String areaName = array[Integer.parseInt(request.getParameter("areaName"))];
    String radioPicker = array2[Integer.parseInt(request.getParameter("radioPicker"))];
    String month = array3[Integer.parseInt(request.getParameter("month"))-1];
    String incame = request.getParameter("incame");
    String userNum = request.getParameter("userNum");
    
    System.out.println("areaName="+areaName+" ,radioPicker="+radioPicker+" ,month="+month+" ,incame="+incame);
    Writer out = response.getWriter(); 
    String sql ="update mobile set "+month+"="+incame+",M_userPer="+userNum+" where carrieroperator = '"+radioPicker+"' and area = '"+areaName+"'";
    out.write(SqlOperate(sql));
    out.flush();
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String SqlOperate(String sql) {
		String result = SqlOperator.getInstance().operate(1,sql).toString();
		System.out.println(result);
		return result;
	}
	
  
}

