import java.sql.*;
public class Connect{
 public static void main(String[] args){
  try{
   Class.forName("oracle.jdbc.OracleDriver");
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@218.248.0.7:1521:rdbms"," it20737038","vasavi'");
   Statement stmt=con.createStatement();
   ResultSet rs=stmt.executeQuery("select * from EXAMPLE");
   while(rs.next())  
    System.out.println(rs.getString(1)+" "+rs.getString(2));
   con.close();
  }
  catch(Exception e){
   System.out.println(e);
  }
 }
}