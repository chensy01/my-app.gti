package mypack.Util;

import java.io.*;
import java.sql.*;

public class DbConnection{
	public static	IEnvProperties env;	

	private PreparedStatement pstmt = null;
	private static DbConnection db;
	private static Connection con;
	private DbConnection(){
	}

	public static DbConnection getInstance(){
		if(db == null){
			db = new DbConnection();
			env = EnvProperties.getInstance();
			String ip = env.getValue("database_ip");
			String port = env.getValue("port");
			String sid = env.getValue("sid");
			String username = env.getValue("username");
			String password = env.getValue("password");	
			try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			} catch (ClassNotFoundException e) {

				System.out.println("Where is your Oracle JDBC Driver?");
				e.printStackTrace();
				return null;

			}

			System.out.println("Oracle JDBC Driver Registered!");

			//Connection connection = null;

			try {
				System.out.println("ip = " + ip);
				System.out.println("port = " + port);
				System.out.println("sid = " + sid);
				System.out.println("username = " + username);
				System.out.println("password = " + password);


				con = DriverManager.getConnection(
					"jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid, username,
					password);

			} catch (SQLException e) {

				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return null;

			}	

			if (con != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
		}
		return db;
	}
	
	//public  Connection getConnection(){
	//		
	//}


	//执行插入、删除和更新操作  
    	synchronized public int execute(String sql) throws SQLException {  
        	this.pstmt = con.prepareStatement(sql);  
        	if(pstmt != null){  
            		int i =  pstmt.executeUpdate(sql);
					con.commit();
					return i;  
        	}else{  

        			return 0;
            		//Log log = LogFactory.getLog("mylog");  
            		//log.error("数据库插入数据出错");  
       		}  
	}


	/*  
    	//进行数据库查询操作  
    	*/ 
    	public ResultSet executeQuery(String sql){ 
        	//if(con == null) createConnection(); 
        	try{ 
            		Statement stmt = con.createStatement(); 
            		ResultSet rs = stmt.executeQuery(sql);
			return rs; 
        	}catch(SQLException e){ 
            		System.out.println("executeQueryError!"); 
            		System.out.println(e.getMessage()); 
            		return null; 
        	} 
        	//return rs; 
    	} 

	public void close() throws SQLException{
		con.commit();
		con.close();
		pstmt = null;
		con = null;
	}
		
	public static void main(String[] args) throws Exception{
		System.out.println("begin to work");
		ResultSet rs = DbConnection.getInstance().executeQuery("select * from v$session");
		
		DbConnection.getInstance().execute("insert into test values(\'1\')");
		System.out.println("end work");
		BufferedReader stdin =new BufferedReader(new InputStreamReader(System.in));
		//System.out.print("Enter a line:");
		System.out.println(stdin.readLine());
		//System.in.readLine();
		System.out.println("now i quit");
	}

}
