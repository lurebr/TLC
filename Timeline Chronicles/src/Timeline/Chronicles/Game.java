/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Chronicles;

import Timeline.Core.Menu.ExternalMenu.ControlerExternalMenu;
import Timeline.Core.Menu.ExternalMenu.DefaultExternalMenu;
import Timeline.Jogador.Jogador;


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
