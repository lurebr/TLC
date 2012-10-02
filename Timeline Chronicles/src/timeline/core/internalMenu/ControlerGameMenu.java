/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core.internalMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
            if(GameMain.getInstance().getGameState() == enumState.pause){
                GameMain.getInstance().setGameState(enumState.start);
            }else{
                GameMain.getInstance().setGameState(enumState.pause);
            }
        }else if (e.getSource() == tela.btnSair){
            GameMain.getInstance().setGameState(enumState.gameover);
        }else if (e.getSource() == tela.b1){
             JOptionPane.showMessageDialog(null,"oi");
            JOptionPane.showMessageDialog(null,GameMain.getInstance().getGameState().name());
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
