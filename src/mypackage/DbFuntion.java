
package mypackage;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFuntion {
    Connection conn = null;
    public Connection connect_to_db(){
        
        try{
            Class.forName("org.postgresql.Driver");
            conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"crud", "postgres", "");
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
    Statement statement;
    public void insert_data(String name, int phone, String address){
        try{
            Class.forName("org.postgresql.Driver");
            conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"crud", "postgres", "swap2");
            String query = String.format("INSERT INTO c_table(name, phone, address) VALUES('%s', '%d', '%s');", name, phone, address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
//    public static void main(String[] args){
//        DbFuntion db = new DbFuntion();
//        db.connect_to_db("crud", "postgres", "swap2");
//    }
}


