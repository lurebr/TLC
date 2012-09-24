/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import timeline.core.GameMain;
import timeline.core.enumState;

/**
 *
 * @author Desenv01
 */
public class ControlerGameMenu implements ActionListener {
    
    private GameMenu tela;

    public ControlerGameMenu(){
        iniciaTela();
        addListener();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tela.btnPausar){
            GameMain.getInstance().setState(enumState.pause);
        }else if (e.getSource() == tela.btnSair){
            GameMain.getInstance().setState(enumState.gameover);
        }
    }

    private void iniciaTela() {
        tela = new GameMenu();
        tela.setBackground(Color.red);
        //tela.setSize(500, 150);
        tela.setVisible(true);
        //tela.setSize();
    }

    private void addListener() {
        tela.btnPausar.addActionListener(this);
        tela.btnSair.addActionListener(this);
    }

    public GameMenu getTela() {
        return tela;
    }
    
}
