/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core.Sound.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
import timeline.core.Sound.iSoundPlayer;

/**
 *
 * @author Lennon
 */
public class jLayerSoundPlayer implements iSoundPlayer {

    @Override
    public void tocar(String caminho) {
            Player player;    
            FileInputStream fis;
            BufferedInputStream bis;
            File mp3File;
            //"C:/Users/Glauber/Documents/NetBeansProjects/TesteMP3Song/src/resource/menu.mp3"
            try { mp3File = new File(caminho);
            fis = new FileInputStream(mp3File);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            player.play();
            }
            catch (Exception e) {
                    System.out.println("Problema ao tocar!");
                    e.printStackTrace();
            }
    }
}
