/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.Chronicles;

import timeline.Core.menu.ExternalMenu.ControlerExternalMenu;
import timeline.Core.menu.ExternalMenu.DefaultExternalMenu;
import timeline.Jogador.Jogador;

/**
 *
 * @author Desenv01
 */
public class Game {

    public static Jogador jogador; 
    
    public Game() {
        if (logar()) {
            fakejogador();
            ControlerExternalMenu menu = new ControlerExternalMenu(jogador);
        }
    }

    public void fakejogador(){
        jogador = new Jogador();
        jogador.setGold(100);
        jogador.setLevel(1);
        jogador.setNick("Lure");
    }
    public static void main(String[] args) {
        new Game();
    }

    public boolean logar() {
        return true;
    }

}
