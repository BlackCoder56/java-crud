
package mypackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFuntion {
    public Connection connect_to_db(String db_name, String user, String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+db_name, user, pass);
            if(conn!=null){
                System.out.println("Established");
            }else{
                System.out.println("Failed");
            }
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        return conn;
    }
    
//    public static void main(String[] args){
//        DbFuntion db = new DbFuntion();
//        db.connect_to_db("crud", "postgres", "swap2");
//    }
}


