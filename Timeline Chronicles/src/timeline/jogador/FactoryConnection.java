/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.jogador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Glauber
 */
public class FactoryConnection {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/tlcteste","root","");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
}
