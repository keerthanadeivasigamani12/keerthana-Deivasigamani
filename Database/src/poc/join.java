package poc;
import java.sql.*;
public class join {
	

			public static void main(String[] args) throws SQLException {

				Connection myConn = null;
				Statement myStmt = null;
				ResultSet myRs = null;
				
				try {
					// 1. Get a connection to database
					myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poc", "root" , "Keerthi@123");
					
					System.out.println("Database connection successful!\n");
					
					// 2. Create a statement
					myStmt = myConn.createStatement();
					
					// 3. Execute SQL query
					myRs = myStmt.executeQuery("select student.Studentid,student.firstname,student.lastname,student.departmentid,student.joiningdate,department.departmentid,department.departmentname\r\n"
							+ "from student\r\n"
							+ "INNER JOIN department ON student.departmentid=department.departmentid;");
					
					// 4. Process the result set
					while (myRs.next()) {
						System.out.println(myRs.getInt("studentid") + " " + myRs.getString("firstname") + " " + myRs.getString("lastname") + " " + myRs.getString("departmentname") );
					}
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
				finally {
					if (myRs != null) {
						myRs.close();
					}
					
					if (myStmt != null) {
						myStmt.close();
					}
					
					if (myConn != null) {
						myConn.close();
					}
				}
			}

		}





