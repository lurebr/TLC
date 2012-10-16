/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.Core.menu.ExternalMenu;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;       
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import timeline.Core.GameMain;
import timeline.Jogador.Jogador;

/**
 * 
 * @author Desenv01
 */
public class ControlerExternalMenu implements ActionListener {
    
    private DefaultExternalMenu tela;
    private Jogador jogador;
    private ControlerExternalMenu(){
    }

    public ControlerExternalMenu(Jogador jogador) {
        this.jogador = jogador;
        iniciaTela();
        addListener();
        //tocarMusica();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tela.btnIniciarJogo){
            gameStart();
         //   player.close();
        }else if(e.getSource() == tela.btnOpcoes){
            mostraTela("cOpcoes");
        }else if(e.getSource() == tela.btnVoltar){
            mostraTela("cPrincipal");
        }else if(e.getSource() == tela.btnSair){
            tela.dispose();
         //   player.close();
        }
    }

    private void iniciaTela() {
        tela = new DefaultExternalMenu();
        tela.setVisible(true);
    }

    private void addListener() {
        tela.btnCreditos.addActionListener(this);
        tela.btnIniciarJogo.addActionListener(this);
        tela.btnOpcoes.addActionListener(this);
        tela.btnVoltar.addActionListener(this);
        tela.btnSair.addActionListener(this);
    }

    public DefaultExternalMenu getTela() {
        return tela;
    }
    
    public void gameStart() {
       GameMain game = GameMain.getInstance();
       tela.setVisible(false);
       game.GameStart(jogador);
    }
    private void mostraTela(String nome){
        CardLayout card = (CardLayout) tela.pnlMenu.getLayout();
        card.show(tela.pnlMenu, nome);
    }
    
}
