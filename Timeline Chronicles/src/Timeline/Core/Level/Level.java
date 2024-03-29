/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level;

import Timeline.Entidade.Map;
import Timeline.Entidade.Minion;
import Timeline.Entidade.Tower;
import java.util.ArrayList;

/**
 *
 * @author Lennon
 */ 
public class Level {
    private Map mapa;
    private ArrayList<Tower> towers;
    private ArrayList<Minion> minions;
    private int vida;
    private int tempoSpawn;

    public Level(Map mapa, ArrayList<Tower> towers, ArrayList<Minion> minions,int vida,  int tempoSpawn){
        this.mapa = mapa;
        this.towers = towers;
        this.minions = minions;
        this.vida = vida;
        this.tempoSpawn = tempoSpawn;
    }
    
    
    /**
     * @return the mapa
     */
    public Map getMapa() {
        return mapa;
    }

    /**
     * @return the towers
     */
    public ArrayList<Tower> getTowers() {
        return towers;
    }

    /**
     * @param towers the towers to set
     */
    public void setTowers(ArrayList<Tower> towers) {
        this.towers = towers;
    }

    /**
     * @return the minions
     */
    public ArrayList<Minion> getMinions() {
        return minions;
    }

    /**
     * @param minions the minions to set
     */
    public void setMinions(ArrayList<Minion> minions) {
        this.minions = minions;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void DiminuiVida() {
        this.vida -= 1;
    }

   public void DiminuiVida(int qt) {
        this.vida -= qt;
    }

    /**
     * @return the tempoSpawn
     */
    public int getTempoSpawn() {
        return tempoSpawn;
    }

    /**
     * @param tempoSpawn the tempoSpawn to set
     */
    public void setTempoSpawn(int tempoSpawn) {
        this.tempoSpawn = tempoSpawn;
    }
    
}
