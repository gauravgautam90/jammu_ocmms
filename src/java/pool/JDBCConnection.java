package pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static JDBCConnection jdbc;

	public JDBCConnection() {
	}

	
	public static JDBCConnection getInstance() {
		if (jdbc == null) {
			jdbc = new JDBCConnection();
		}
		return jdbc;
	}

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		System.out.println("inside getConnection =======");
		String url;
		String userName;
		String password;

		url="jdbc:postgresql://10.25.121.212:5432/Jammu_OCMMS";
//		url="jdbc:postgresql://localhost:5432/JKPCB_Scrutiny"; 	//local pc
		//url="jdbc:postgresql://10.25.121.245:5432/UKPCB"; 	//test
	//	url="jdbc:postgresql://10.247.204.235:5432/UKPCB";	 //live
		userName="postgres";
//		password="NIC"; // local
		password="postgres";	 //live //test
		Connection con = null;
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url,userName, password);
		return con;
	}
}
