/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core.ExternalMenu;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import timeline.core.GameMain;
import timeline.jogador.Jogador;

/**
 *
 * @author Desenv01
 */
public class ControlerExternalMenu implements ActionListener {
    
    private ExternalMenu tela;
    private Jogador jogador;
    private ControlerExternalMenu(){
    }

    public ControlerExternalMenu(Jogador jogador) {
        this.jogador = jogador;
        iniciaTela();
        addListener();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tela.btnIniciarJogo){
            gameStart();
        }else if(e.getSource() == tela.btnOpcoes){
            mostraTela("cOpcoes");
        }else if(e.getSource() == tela.btnVoltar){
            mostraTela("cPrincipal");
        }else if(e.getSource() == tela.btnSair){
            tela.dispose();
        }
    }

    private void iniciaTela() {
        tela = new ExternalMenu();
        tela.setVisible(true);
    }

    private void addListener() {
        tela.btnCreditos.addActionListener(this);
        tela.btnIniciarJogo.addActionListener(this);
        tela.btnOpcoes.addActionListener(this);
        tela.btnVoltar.addActionListener(this);
        tela.btnSair.addActionListener(this);
    }

    public ExternalMenu getTela() {
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
