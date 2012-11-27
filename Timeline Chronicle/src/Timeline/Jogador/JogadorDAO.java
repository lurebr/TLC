/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Jogador;

import Timeline.Jogador.Jogador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Glauber
 */
public class JogadorDAO {
    FactoryConnection c;
    Connection con;
    Statement stm;
    ResultSet res;
    
    public JogadorDAO() throws SQLException{
        c = new FactoryConnection();
        con = c.getConnection();
        stm = con.createStatement();
    }
    
    /**
     *
     * @param jogador
     */
    public void cadastrarJogador(Jogador j) throws SQLException{
        stm.execute("insert into jogador(nick,gold,level) values(" + "'" + j.getNick() + "'," + j.getGold() + "," + j.getLevel() + ") ");
    }
    
    public void excluiJogador(Jogador j) throws SQLException{
        stm.execute("delete from jogador where id = " + j.getId() +" ");
    }
    
    public void atualizaJogador(Jogador j) throws SQLException{
        stm.execute("update jogador set nick = " + "'" + j.getNick() + "'," + j.getGold() + "," + j.getLevel() + " where id = " + j.getId());
    }
    
    public void pesquisaJogador(Jogador j) throws SQLException{
        res = stm.executeQuery("select * from jogador where id = " + j.getId());
    }
    
    public static void main(String[] args) throws SQLException {
        JogadorDAO jog = new JogadorDAO();
        Jogador j = new Jogador();
        
        j.setGold(2);
        j.setNick("apapap");
        j.setLevel(3);
        
        jog.cadastrarJogador(j);
    }



}