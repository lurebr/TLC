/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core;

import timeline.core.ExternalMenu.ExternalMenu;
import timeline.jogador.Jogador;

/**
 *
 * @author Desenv01
 */
public class Game {

    public static Jogador jogador;
    
    public Game() {
        if (logar()) {
            ExternalMenu e = new ExternalMenu();
            e.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Game();
    }

    public boolean logar() {
        return true;
    }

}
