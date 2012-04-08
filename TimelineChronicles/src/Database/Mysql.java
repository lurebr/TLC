/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Util.iDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lennon
 */
public class Mysql implements iDatabase{

    Connection conn;
    
    public Mysql(String usuario, String senha, String database, String porta, String ip){
        Conectar(usuario, senha, database, porta, ip);
    }
    @Override
    public boolean Executar(String sql) {
        try {
           Statement stm = conn.createStatement();
           stm.executeUpdate(sql);
           return true;
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ResultSet Buscar(String sql) {
        
        ResultSet rs = null;
        try {
           Statement stm = conn.createStatement();
           rs = stm.executeQuery(sql);
           
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
        }
        return rs;
        
    }

    @Override
    public boolean Conectar(String usuario, String senha, String database, String porta, String ip) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + porta + "/" + database, usuario , senha );
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return false;
    }
 

}
