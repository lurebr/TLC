/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.ResultSet;

/**
 *
 * @author Lennon
 */
public interface iDatabase {
    public boolean Conectar(String usuario, String senha, String database, String porta, String ip);
    public boolean Executar(String sql);
    public ResultSet Buscar(String sql);
}
