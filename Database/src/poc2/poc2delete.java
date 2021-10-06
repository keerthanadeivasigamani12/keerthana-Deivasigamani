package poc2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator; 
public class poc2delete {
    String index;
 public static void main(String[] args){
try {
//Class.forName("com.mysql.jdbc.Driver");
String dbUrl = "jdbc:mysql://localhost:3306/poc2";
String user = "root";
String pass = "Keerthi@123";
Connection myConn = null; Connection conn = DriverManager.getConnection(dbUrl, user, pass);
ResultSet Rs = null;
Statement Stmnt1 = conn.createStatement();
FileInputStream del = new FileInputStream("C:\\Users\\k.deivasigamani\\Downloads\\inputtoday.txt");
BufferedReader bf = new BufferedReader(new InputStreamReader(new DataInputStream(del)));
String value;
ArrayList token = new ArrayList();
while ((value = bf.readLine()) != null) {
token.add(value);
}
Iterator itr;
for (itr = token.iterator(); itr.hasNext(); ) {
String str = itr.next().toString();
String[] spliting = str.split("\t");
String  index=null;
index = spliting[0]; Rs = Stmnt1.executeQuery("select * from studentpoc2");
while(Rs.next()){

if(index.equals(Rs.getString("studentid"))){
    Stmnt1.executeUpdate("delete from studentpoc2 where studentid=35");    
    Stmnt1.executeUpdate("delete from studentpoc2 where studentid=45");
} }
}
System.out.println("deleted row 35 and 45 successfully!!!");
}
catch (Exception e) {
System.out.println(e);
}
 }}
