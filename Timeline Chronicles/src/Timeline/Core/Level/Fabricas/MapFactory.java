/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level.Fabricas;

import Timeline.Entidade.Map;

/**
 *
 * @author Lennon
 */
public class MapFactory{
    
    private MapFactory(){}
    
    public static Map getMap(int id) {
        int levelmapa[][] = {{1,1,3,1,1,1,1,1,1,1,1,1,1,15,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,13},
                             {1,1,8,2,2,6,1,1,1,1,1,1,1,14,1,1,1,1,7,2,2,2,6,1,1,19,1,1,1,13,1,12},  
                             {1,1,1,1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,9,1,1,1,9,1,1,1,1,1,1,12,1,1},
                             {1,13,1,1,1,9,1,15,1,1,1,1,1,1,1,15,1,1,9,1,1,1,9,1,1,1,1,13,19,1,1,1},
                             {1,12,1,1,1,9,1,14,1,1,1,1,1,15,18,14,1,1,9,1,1,1,9,16,1,1,1,12,18,1,1,1},
                             {1,1,1,19,1,9,1,7,2,2,6,1,1,14,19,1,1,1,9,1,1,1,9,1,1,1,1,1,1,1,1,1},
                             {1,1,17,1,1,9,1,9,1,1,9,1,1,1,16,1,1,1,9,1,1,1,9,1,1,1,1,19,1,1,13,1},
                             {1,1,13,1,1,9,1,9,1,1,9,1,1,1,1,1,1,1,9,1,1,1,9,1,1,1,1,1,1,1,12,1},
                             {1,1,12,1,1,8,2,5,1,1,9,1,1,1,7,2,2,2,5,1,1,1,9,1,1,18,1,1,1,13,16,1},
                             {1,1,18,1,19,1,1,13,1,1,9,1,1,1,9,1,1,1,1,1,1,1,9,1,1,1,19,1,1,12,19,1},
                             {1,1,1,1,1,1,1,12,1,1,9,1,1,15,9,1,18,1,1,1,1,1,9,1,1,1,1,18,1,1,13,1},
                             {1,13,1,1,7,2,2,2,2,2,5,1,1,14,9,1,1,1,16,1,1,1,9,1,1,1,1,1,18,1,12,1},
                             {1,12,1,17,9,1,1,1,1,1,1,1,1,1,9,1,1,1,1,1,1,1,9,1,1,1,1,17,1,1,1,1},
                             {1,19,1,1,9,13,1,1,19,1,1,16,1,7,5,1,1,1,1,15,1,1,9,1,1,1,1,16,1,1,1,1},
                             {1,18,18,1,9,12,1,1,1,1,1,1,17,9,1,1,1,19,1,14,1,1,9,1,1,19,1,1,1,1,1,1},
                             {1,1,13,1,8,2,2,2,2,2,2,2,2,5,18,19,1,1,1,1,1,1,9,1,1,1,1,1,1,19,1,1},
                             {1,1,12,18,1,1,1,1,18,1,1,1,1,1,1,18,1,1,1,1,1,1,9,1,1,19,1,18,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,9,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1}};
        
       
     int visibilidade[][] = {{1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                             {1,1,2,2,2,2,1,1,1,1,1,1,1,2,1,1,1,1,2,2,2,2,2,1,1,2,1,1,1,2,1,2},  
                             {1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,2,1,1},
                             {1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1,1,2,1,1,1,2,1,1,1,1,2,2,1,1,1},
                             {1,2,1,1,1,2,1,2,1,1,1,1,1,2,2,2,1,1,2,1,1,1,2,2,1,1,1,2,2,1,1,1},
                             {1,1,1,2,1,2,1,2,2,2,2,1,1,2,2,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,2,1,1,2,1,2,1,1,2,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2,1,1,2,1},
                             {1,1,2,1,1,2,1,2,1,1,2,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,2,1},
                             {1,1,2,1,1,2,2,2,1,1,2,1,1,1,2,2,2,2,2,1,1,1,2,1,1,2,1,1,1,2,2,1},
                             {1,1,2,1,2,1,1,2,1,1,2,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,2,1,1,2,2,1},
                             {1,1,1,1,1,1,1,2,1,1,2,1,1,2,2,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,2,1},
                             {1,2,1,1,2,2,2,2,2,2,2,1,1,2,2,1,1,1,2,1,1,1,2,1,1,1,1,1,2,1,2,1},
                             {1,2,1,2,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1},
                             {1,2,1,1,2,2,1,1,2,1,1,2,1,2,2,1,1,1,1,2,1,1,2,1,1,1,1,2,1,1,1,1},
                             {1,2,2,1,2,2,1,1,1,1,1,1,2,2,1,1,1,2,1,2,1,1,2,1,1,2,1,1,1,1,1,1},
                             {1,1,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1},
                             {1,1,2,2,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,2,1,2,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1}};
        
         int levelcaminho[] = {2,4,4,4,2,2,2,2,2,2,2,4,4,1,1,1,4,4,4,2,2,2,2,2,2,3,3,3,3,3,3,2,2,2,2,4,4,4,4,4,4,4,4,4,1,1,4,1,1,1,1,1,4,4,4,4,1,1,1,1,1,1,1,4,4,4,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
       
        
        Map mapa = new Map(levelmapa, visibilidade, levelcaminho);
        return mapa;
    }
    
}
