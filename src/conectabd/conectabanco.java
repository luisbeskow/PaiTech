/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectabd;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author BESKOW-NOTE
 */
public class conectabanco {
    
   public static Connection conectabanco() throws ClassNotFoundException
   {
      try 
      {
          Class.forName("org.postgresql.Driver");
          Connection conecta = DriverManager.getConnection("jdbc.:postgresql://localhost:5432/Pai Tech","postgres","luis2306");
          return conecta;
          
      }
      
      catch(SQLException error)
      {
          JOptionPane.showMessageDialog(null, error);
          return null;
          
          
          
      }
       
       
       
       
   }
    
    
    
    
    
}
