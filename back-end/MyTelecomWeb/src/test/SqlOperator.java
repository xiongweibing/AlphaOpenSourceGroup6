package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Vector;

public class SqlOperator {
	private static  SqlOperator instance;
	public static synchronized SqlOperator getInstance(){
		if ( instance == null ){
			instance = new SqlOperator();
		}
		return instance; 
	}
	public String operate(int servlet,String sql) {
		String result = "";
		String str = "";
		switch(servlet) {
			case 0:
				str = this.read("select * from cq", 0).toString();
				str = str.replace('[', '{').replace(']', '}');
				str = str.substring(1,str.length()-1);
				str = "["+str+"]";
				result = str+",";
				
				str = this.read("select * from local_channel", 1).toString();
				str = str.replace('[', '{').replace(']', '}');
				str = str.substring(1,str.length()-1);
				str = "["+str+"]";
				result = result+str+",";
				
				str = this.read("select * from other_channel", 2).toString();
				str = str.replace('[', '{').replace(']', '}');
				str = str.substring(1,str.length()-1);
				str = "["+str+"]";
				result = result+str+",";
				
				str = this.read("select * from store_users", 3).toString();
				str = str.replace('[', '{').replace(']', '}');
				str = str.substring(1,str.length()-1);
				str = "["+str+"]";
				result = result+str+",";
				
				str = this.read("select * from mobile", 4).toString();
				str = str.replace('[', '{').replace(']', '}');
				str = str.substring(1,str.length()-1);
				str = "["+str+"]";
				result = result+str;
				
				result ="["+result+"]";
				break;
			case 1:
				this.write(sql);
				result = "success";
				break;
			case 2:
				
				break;
		}
		return result;
	}
	public void write(String sql){
		/****************************************************************************/
		String driverName="com.mysql.cj.jdbc.Driver";
		String dbURl="jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		String userName = "root";
		String userPwd = "admin";
		/****************************************************************************/
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		/********************************************************************************/
		try{
			//1.加载JBDC驱动程序，到JVM
			Class.forName(driverName);
			//2.建立连接
			ct = DriverManager.getConnection(dbURl,userName,userPwd);
		 //3.创建prepareStatement
			ps = ct.prepareStatement(sql);
			ps.executeUpdate();
		} 
		catch(Exception e){
			e.printStackTrace();
		} 
		finally{
			//关闭资源
			try{
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(ct != null){
					ct.close();
				}
			}catch(Exception e2){
			e2.printStackTrace();
			}	
		}
	}
	
	public Vector<Vector> read(String sql,int type){
		/********************************************************************************/
		String driverName="com.mysql.cj.jdbc.Driver";
		String dbURl="jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		String userName = "root";
		String userPwd = "admin";
		/********************************************************************************/
		Connection ct1 = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		Vector<Vector> rowData = new Vector<Vector>();
		/********************************************************************************/
		try{
			//1.加载JBDC驱动程序，到JVM
			Class.forName(driverName);
			//2.建立连接
			ct1 = DriverManager.getConnection(dbURl,userName,userPwd);
			//3.创建prepareStatement
			ps1 = ct1.prepareStatement(sql);
			rs1 = ps1.executeQuery();
			switch(type) {
				case 0://市概况：select * from cq
					while(rs1.next()){
						Vector row = new Vector();
						row.add("\"id\":"+rs1.getInt("id"));
						row.add("\"area\":"+"\""+rs1.getString("area")+"\"");
						row.add("\"tenement_num\":"+rs1.getInt("tenement_num"));
						row.add("\"population\":"+rs1.getInt("population"));
						row.add("\"FBI_num\":"+rs1.getInt("FBI_num"));
						row.add("\"broadband_num\":"+rs1.getInt("broadband_num"));
						row.add("\"IPTV_num\":"+rs1.getInt("IPTV_num"));
						row.add("\"otherIPTV_num\":"+rs1.getInt("otherIPTV_num"));
						rowData.add(row);
					}
					break;
				case 1://本地渠道：select * from Local_channel
					while(rs1.next()){
						Vector row = new Vector();
						row.add("\"id\":"+rs1.getInt("id"));
						row.add("\"channel_type\":"+"\""+rs1.getString("channel_type")+"\"");
						row.add("\"channel_num\":"+rs1.getInt("channel_num"));
						
						rowData.add(row);
					}
					break;
				case 2://异网渠道：select * from Other_channel;
					while(rs1.next()){
						Vector row = new Vector();
						row.add("\"id\":"+rs1.getInt("id"));
						row.add("\"carrieroperator\":"+"\""+rs1.getString("carrieroperator")+"\"");
						row.add("\"channel_num\":"+rs1.getInt("channel_num"));
						rowData.add(row);
					}
					break;
				case 3://存量用户：select * from store_users;
					while(rs1.next()){
						Vector row = new Vector();
						row.add("\"id\":"+rs1.getInt("id"));
						row.add("\"service_type\":"+"\""+rs1.getString("service_type")+"\"");
						row.add("\"user_num\":"+rs1.getInt("user_num"));
						rowData.add(row);
					}
					break;
				case 4:
					while(rs1.next()){
						Vector row = new Vector();
						row.add("\"id\":"+rs1.getInt("id"));
						row.add("\"area\":"+"\""+rs1.getString("area")+"\"");
						row.add("\"carrieroperator\":"+"\""+rs1.getString("carrieroperator")+"\"");
						DecimalFormat df = new DecimalFormat("##0.0"); 
						row.add("\"M_income\":"+df.format(rs1.getFloat("M_income")));
						row.add("\"M_userPer\":"+rs1.getFloat("M_userPer"));
						row.add("\"Month_1\":"+df.format(rs1.getFloat("Month_1")));
						row.add("\"Month_2\":"+df.format(rs1.getFloat("Month_2")));
						row.add("\"Month_3\":"+df.format(rs1.getFloat("Month_3")));
						row.add("\"Month_4\":"+df.format(rs1.getFloat("Month_4")));
						row.add("\"Month_5\":"+df.format(rs1.getFloat("Month_5")));
						row.add("\"Month_6\":"+df.format(rs1.getFloat("Month_6")));
						row.add("\"Month_7\":"+df.format(rs1.getFloat("Month_7")));
						row.add("\"Month_8\":"+df.format(rs1.getFloat("Month_8")));
						row.add("\"Month_9\":"+df.format(rs1.getFloat("Month_9")));
						row.add("\"Month_10\":"+df.format(rs1.getFloat("Month_10")));
						row.add("\"Month_11\":"+df.format(rs1.getFloat("Month_11")));
						row.add("\"Month_12\":"+df.format(rs1.getFloat("Month_12")));
						rowData.add(row);
					}
					break;
				default:
					break;
			}
		} 
		catch(Exception e){
			e.printStackTrace();
		} 
		finally{
			//关闭资源
			try{
				if(rs1 != null){
					rs1.close();
				}
				if(ps1 != null){
					ps1.close();
				}
				if(ct1 != null){
					ct1.close();
				}
			}catch(Exception e2){
			e2.printStackTrace();
			}	
		}
		return rowData;
	}
}
