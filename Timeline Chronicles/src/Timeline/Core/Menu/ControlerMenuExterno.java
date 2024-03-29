/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Menu;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;       
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import Timeline.Core.GameMain;
import Timeline.Jogador.Jogador;
import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;
import javax.swing.ImageIcon;
import javax.swing.plaf.IconUIResource;

/**
 * 
 * @author Desenv01 
 */
public class ControlerMenuExterno implements ActionListener {
    
    private MenuExterno tela;
    private Jogador jogador;
    private ControlerMenuExterno(){
    }

    public ControlerMenuExterno(Jogador jogador) {
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
        tela = new MenuExterno();
        tela.setVisible(true);
    }

    private void addListener() {
        tela.btnCreditos.addActionListener(this);
        tela.btnIniciarJogo.addActionListener(this);
        tela.btnOpcoes.addActionListener(this);
        tela.btnVoltar.addActionListener(this);
        tela.btnSair.addActionListener(this);
    }

    public MenuExterno getTela() {
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
