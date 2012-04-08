/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Util.iDatabase;

/**
 *
 * @author Lennon
 */
public class DatabaseFactory {

    private static iDatabase searchDatabase = null;
    private static iDatabase insertDatabase = null;

    private DatabaseFactory() {}

    public static iDatabase getSearchDatabase() {
        if (searchDatabase == null){
            conectar();
        }
        return searchDatabase;
    }
    public static iDatabase getInsertDatabase() {
        if (insertDatabase == null){
            conectar();
        }
        return insertDatabase;
    }
    
    private static void conectar(){
        searchDatabase = new Mysql("root", "", "movie","3306" ,"localhost");
        insertDatabase = new Mysql("root", "", "movieInsert","3306" ,"localhost");
    }
}
