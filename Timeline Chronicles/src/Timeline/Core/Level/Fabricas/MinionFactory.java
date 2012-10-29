/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level.Fabricas;

import Timeline.Entidade.Atributo.Atributo;
import Timeline.Entidade.Minion;
import Timeline.Enumerador.EnumElemento;


/**
 *
 * @author Lennon
 */
public class MinionFactory{
    
    private MinionFactory(){}
    
    public static Minion getMinion(int id) {
        Minion minion = null;
       Atributo atb = new Atributo(1, 10, 100, 100, 0, 90);
        atb.getArmadura().setArmadura(EnumElemento.normal, 3);
        switch(id){
            case 0:
                minion = new Minion("ressource/object/minion/minion.gif", 10, 100, atb);
            case 1:
                minion = new Minion("ressource/object/minion/zombie.png", 10, 100, atb);
        }

        return minion;
    }
    
}