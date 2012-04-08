/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.Controler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import Database.Database;
import Login.GUI.Login;
import Login.model.LoginDao;

/**
 *
 * @author Lennon
 */
public class ControlerLogin implements ActionListener {
    private Login tela;
    private Database database;
    LoginDao loginDao;
    
    public ControlerLogin(){
        tela = new Login();
        addListener();
        database = new Database();
        loginDao = new LoginDao(database);
    }
    
    public void addListener(){
        tela.btn_Logar.addActionListener(this);
    }
    public boolean iniciaLogin(){
        show();
        return true;
    }

    private void show() {
        tela.setVisible(true);
    }
    
    
    public void logar(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tela.btn_Logar){
            logar();
        }
    }
    


}
