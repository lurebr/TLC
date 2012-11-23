/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level.Fabricas;

import Timeline.Entidade.Atributo.Posicao;
import Timeline.Entidade.Tower;
import java.util.ArrayList;

/**
 *
 * @author Lennon
 */
public class TowerFactory{
    
    private TowerFactory(){}
    
    public static Tower getTower(int id) {
        
        Tower tower = null;
        switch(id){
            case 1:
                tower = new Tower("Ressource/Object/Tower/tower.png",0, 0);
        }
                
        return tower;
    }
    
}
