/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level;

import Timeline.Entidade.Minion;
import java.util.ArrayList;
import Timeline.Core.GameMain;
import Timeline.Core.Level.LevelLoader;

/**
 *
 * @author Lennon
 */
public class MinionSpawner {
    private int tempoSpawn;
    private int tempoAtual;
    private ArrayList<Minion> wave;
    private int minionCount;
    
    public MinionSpawner(int tempoSpawn, ArrayList<Minion> wave){
        this.tempoSpawn = tempoSpawn;
        this.tempoAtual = tempoSpawn;
        this.wave =wave;
        this.minionCount = 0;
    }
    
    public void update(double delta){
       if(minionCount < wave.size()){
            if(tempoAtual == tempoSpawn){
                spawn(wave.get(minionCount));
                minionCount++;
                tempoAtual = 0;
            }
           tempoAtual++;
       }
    }
    
    private void spawn(Minion minion) { 
        minion.setMovimento(LevelLoader.getInstance().getMap().getCaminho());
        minion.setPosicaoInicial(LevelLoader.getInstance().getMap().getSpawnLocation());
        GameMain.objetos.add(minion);
    }
    
    public String getTempoSpawn(){
        return "Tempo Spawn:" + tempoAtual + "/" + tempoSpawn;
    }
}
