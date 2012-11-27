/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level;

import Timeline.Core.Componente.EnumEstadoMouse;
import Timeline.Core.Componente.Mouse;
import Timeline.Entidade.Behavior.isSelectable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.swing.JOptionPane;
import Timeline.Core.GameMain;
import Timeline.Enumerador.EnumEstado;
import Timeline.Entidade.Tower;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Desenv01
 */
public class ControlerStore implements ActionListener {
    
    private Store tela;
    private ArrayList<Tower> listaTorres;
    private Tower selectedTower;
    
    public ControlerStore(ArrayList<Tower> towers){
        this.listaTorres = towers;
        iniciaTela();
        addListener();
        iniciaJogador();
        iniciaLoja();
    }
    public ControlerStore(){
       // this.listaTorres = towers;
        iniciaTela();
        addListener();
        iniciaJogador();
        iniciaLoja();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tela.btnPausar){
            if(GameMain.getInstance().getGameState() == EnumEstado.pause){
                GameMain.getInstance().setGameState(EnumEstado.jogando);
            }else{
                GameMain.getInstance().setGameState(EnumEstado.pause);
            }
        }else if (e.getSource() == tela.btnSair){
            GameMain.getInstance().setGameState(EnumEstado.gameover);
        }else if (e.getSource() == tela.b1){
            try {
                selectedTower = (Tower) listaTorres.get(0).clone();
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }
            showSelectedTower(selectedTower);
        }
    }
    private void iniciaJogador(){
        tela.lblGold.setText(Integer.toString(GameMain.jogador.getGold()));
        tela.lblNomeUsuario.setText(GameMain.jogador.getNick());
    }
    private void iniciaTela() {
        tela = new Store();
        tela.setVisible(true);
    }

    private void addListener() {
        tela.btnPausar.addActionListener(this);
        tela.btnSair.addActionListener(this);
        tela.b1.addActionListener(this);
    }

    public Store getTela() {
        return tela;
    }

    private void iniciaLoja() {
        if(listaTorres != null){
            for(int i = 0;i<8 && i<listaTorres.size();i++){
                tela.b1.setIcon( new ImageIcon((Image)listaTorres.get(i).animacao.getImagem()));
            }
        }
    }

    void AtualizarLoja(ArrayList<Tower> towers) {
        this.listaTorres = towers;
        iniciaLoja();
    }

    private void showSelectedTower(Tower t) {
        GameMain.mouse.build(t);
    }
    
    public void update(){
        tela.lblGold.setText(Integer.toString(GameMain.jogador.getGold()));
        tela.lblLife.setText(Integer.toString(LevelLoader.getInstance().getLevel().getVida()));
    }

    public void Select(isSelectable s) {
       tela.lblStatusTower.setText(s.Select());
    }
    
}
