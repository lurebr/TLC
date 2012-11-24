/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Chronicles;


import Timeline.Core.Menu.ControlerMenuExterno;
import Timeline.Jogador.Jogador;

/* Classe inicial do sistema que iniciará o login e o menu do jogo. 
 * 
 * @version 1.01
 */

public class Game {

    public static Jogador jogador; 

    public Game() {
        if (logar()) {
            fakejogador();
            videoIntro();
            ControlerMenuExterno menu = new ControlerMenuExterno(jogador);
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

    private void videoIntro() {
        
    }

}
