/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level.Fabricas;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.EnumMap;
import java.util.HashMap;
import Timeline.Core.Level.EnumLevel;

/**
 *
 * @author Lennon
 */
public class LevelFactory{
    
    private LevelFactory(){}
    
    public static HashMap<EnumLevel, ArrayList<Integer>> getLevel(int id) {
        
        HashMap<EnumLevel,ArrayList<Integer>> level = new HashMap<EnumLevel, ArrayList<Integer>>();
        
        //iniciamapa
        ArrayList<Integer> mapa = new ArrayList<Integer>();
        mapa.add(0);
        level.put(EnumLevel.mapa, mapa);
        
        //iniciaminion
        ArrayList<Integer> minions = new ArrayList<Integer>();
        
        for(int i=0;i>10;i++){
            minions.add(1);
        }
        level.put(EnumLevel.minion, minions);
        
        //iniciatorre
        
        ArrayList<Integer> torres = new ArrayList<Integer>();
        
        torres.add(1);
        level.put(EnumLevel.torre, torres);
        
        //iniciaevento
        level.put(EnumLevel.evento, new ArrayList<Integer>(1));
        return level;
    }
    
}
