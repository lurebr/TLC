/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core.internalMenu.gameControls;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.swing.JOptionPane;
import timeline.core.GameMain;
import timeline.core.enumState;
import timeline.entity.Tower;

/**
 *
 * @author Desenv01
 */
public class ControlerGameControls<T> implements ActionListener {
    
    private GameControl tela;
    private ArrayList<T> listaTorres;
    public ControlerGameControls(ArrayList<T> shop){
        this.listaTorres = shop;
        iniciaTela();
        addListener();
        iniciaJogador();
        iniciaLoja();
        
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
    private void iniciaJogador(){
        tela.lblGold.setText(Integer.toString(GameMain.jogador.getGold()));
        tela.lblNomeUsuario.setText(GameMain.jogador.getNick());
    }
    private void iniciaTela() {
        tela = new GameControl();
        tela.setBackground(Color.red);
        tela.setVisible(true);
    }

    private void addListener() {
        tela.btnPausar.addActionListener(this);
        tela.btnSair.addActionListener(this);
    }

    public GameControl getTela() {
        return tela;
    }

    private void iniciaLoja() {
        
    }
    
}
