/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.Core.Level.Fabricas;

import Timeline.Entidade.Atributo.Posicao;
import Timeline.Entidade.GameObject;
import Timeline.Entidade.Minion;
import java.util.ArrayList;
import javax.media.j3d.Leaf;

/**
 *
 * @author Lennon
 */
public class MinionFactory{
    
    private MinionFactory(){}
    
    public static Minion getMinion(int id) {
        Minion minion = null;
        switch(id){
            case 0:
                minion = new Minion("ressource/object/minion/minion.gif", 10, 100);
            case 1:
                minion = new Minion("ressource/object/minion/zombie.png", 10, 100);
        }

        return minion;
    }
    
}
