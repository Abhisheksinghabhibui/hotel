package in.abhi.backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class JCON {
    private JCON(){

    }
    private static Connection con;
    static{
        try{
            String url= "jdbc:postgresql://localhost:5432/hotel_db";
        String username="postgres";
        String password="2244";
        con =DriverManager.getConnection(url, username, password);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getconn(){
        return con;
    }
}
