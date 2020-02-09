

package test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Saravana
 */
public class Testing {
    
    public static void main(String[] args) {
        
        Connection connection = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            
            connection = DriverManager.getConnection("jdbc:sqlite:scorecard.sqlite");
            
        }catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        
        System.out.println("Database opened successfully!");
        
    }
    
}
