/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.Core.Level;

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

    public Level(Map mapa, ArrayList<Tower> towers, ArrayList<Minion> minions){
        this.mapa = mapa;
        this.towers = towers;
        this.minions = minions;
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
    
}
