/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.ResultSet;

/**
 *
 * @author Lennon
 */
public class Database {
 
    public boolean Executar(String sql) {
        return DatabaseFactory.getInsertDatabase().Executar(sql);
    }

    
    public ResultSet Buscar(String sql) {
        return DatabaseFactory.getSearchDatabase().Buscar(sql);
    }
    
}
