/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level;

import Timeline.Entidade.Map;
import Timeline.Entidade.Minion;
import Timeline.Entidade.Tower;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import Timeline.Core.Level.EnumLevel;
import Timeline.Core.Level.Fabricas.LevelFactory;
import Timeline.Core.Level.Fabricas.MapFactory;
import Timeline.Core.Level.Fabricas.MinionFactory;
import Timeline.Core.Level.Fabricas.TowerFactory;

/**
 *
 * @author Lennon
 */
public class levelBuilder {
    
    private levelBuilder(){}
    
    public static Level carregaLevel(int idLevel) {
        
        Map mapa = null;
        ArrayList<Minion> listMinion = new ArrayList<>();
        ArrayList<Tower> listTower = new ArrayList<>();
        
        HashMap<EnumLevel, ArrayList<Integer>> level = LevelFactory.getLevel(idLevel);
        
        int i;
        int vida;
        
        Set<EnumLevel> chaves = level.keySet();        
        for(EnumLevel chave : chaves){
            i = 0;
            switch(chave){
                case mapa:
                    int index = level.get(chave).get(0);
                    mapa = MapFactory.getMap(index);
                case minion:
                    ArrayList<Integer> minions = level.get(chave);

                    for(Integer minion : minions){
                        listMinion.add(i, MinionFactory.getMinion(minion));
                        i++;
                    }
                    break;
                case torre:                    
                    ArrayList<Integer> towers = level.get(chave);
                    for(Integer tower : towers){
                        Tower torre = TowerFactory.getTower(tower);
                        listTower.add(i, torre);
                        i++;
                    }
                    break;
                case evento:
                    break;  
                case vida:
                    vida = level.get(chave).get(0);
                    break;
            }
        }
        
        Level levelAtual = new Level(mapa, listTower, listMinion);
        return levelAtual;
    }
}
