/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level.Fabricas;

import Timeline.Entidade.Atributo.Atributo;
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
        Atributo atb = null;
        switch(id){
            case 1:
                atb = new Atributo(10, 35, 500, 1600, 0, 20, 100, 0);
                tower = new Tower("/Object/Tower/tower.png",0, 0, atb);
        }
                
        return tower;
    }
    
}
