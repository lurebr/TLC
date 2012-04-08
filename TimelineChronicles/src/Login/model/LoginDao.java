/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.model;

import Database.Database;

/**
 *
 * @author Lennon
 */
public class LoginDao {
    Database database;
    String sql;
    public LoginDao(Database database){
        this.database = database;
    }
    
    public void InserirGenero(String genero){
        sql = "Insert into genero(GENERO) values ('" + genero + "')";
        database.Executar(sql);
    }
}
