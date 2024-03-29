/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Sound;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javazoom.jl.player.Player;

/**
 *
 * @author Lennon
 */
public class JLayerSoundPlayer implements ISoundPlayer {
    private Player player;   
    private static boolean playing;
    
    @Override
    public void tocar(String caminho) {
            FileInputStream fis;
            BufferedInputStream bis;
            File mp3File;
            //"C:/Users/Glauber/Documents/NetBeansProjects/TesteMP3Song/src/resource/menu.mp3"
            try { mp3File = new File(caminho);
            fis = new FileInputStream(mp3File);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            playing = true;
            
            ExecutorService es = Executors.newFixedThreadPool(3);
            final Future future = es.submit(new Callable() {
                    public Object call() throws Exception {
                        player.play();
                        return null;
                    }
                });
//            Executors.callable(player.play());

            }
            catch (Exception e) {
                    System.out.println("Problema ao tocar!");
                    e.printStackTrace();
            }
    }

    @Override
    public void parar() {
        if (playing){
            player.close();
            playing = false;
        }
    }

    @Override
    public void tocarEfeito(String caminho) {
            final Player playerEffect;    
            FileInputStream fis;
            BufferedInputStream bis;
            File mp3File;
             
            try { mp3File = new File(caminho);
                fis = new FileInputStream(mp3File);
                bis = new BufferedInputStream(fis);
                playerEffect = new Player(bis);

                ExecutorService es = Executors.newFixedThreadPool(3);
                final Future future = es.submit(new Callable() {
                        public Object call() throws Exception {
                            playerEffect.play();
                            return null;
                        }
                    });
    //            Executors.callable(player.play());

            }
            catch (Exception e) {
                    System.out.println("Problema ao tocar!");
                    e.printStackTrace();
            }
    }
}
