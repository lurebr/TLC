/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Atributo;

import Timeline.Enumerador.EnumElemento;
import java.util.HashMap;

/**
 *
 * @author Lennon
 */
public class Armadura {
    private HashMap<EnumElemento,Integer> armadura = new HashMap<EnumElemento,Integer> ();
    
    public int getArmadura(EnumElemento elemento){
        if(armadura.containsKey(elemento)){
            return armadura.get(elemento);
        }
        return 0;
    }
    public void setArmadura(EnumElemento elemento, int valor){
        armadura.put(elemento, valor);
    }
}
