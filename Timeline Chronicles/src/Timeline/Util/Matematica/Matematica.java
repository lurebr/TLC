/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Util.Matematica;

import Timeline.Entidade.Atributo.Atributo;
import Timeline.Enumerador.EnumElemento;
import java.util.Random;

/**
 *
 * @author Lennon
 */
public class Matematica {
    private static Matematica matematica;
    
    private Matematica(){}
    
    public int getRandom(int valorMin, int valorMax){
        int valorTotal;
    
        Random r = new Random();
        valorTotal = r.nextInt (valorMax- valorMin) + valorMin;
        return valorTotal;
    }
    
    public static Matematica getInstance(){
     if (matematica == null)
         matematica = new Matematica();
      return matematica;
    }

   /* public int CalculaDano(int dano) {
        return dano;
    } */

    public int CalculaDano(int dano, Atributo atributo) {
        int danoTotal;
        if(CalculaEvasion(atributo.getEvasion())){
            
            return 0;
        }
        danoTotal = Math.abs(dano - atributo.getArmadura().getArmadura(EnumElemento.normal));
        
        return danoTotal;
        
    }
    
    public boolean CalculaEvasion(int evasion){
        int i;
        Random r = new Random();
        i = r.nextInt(100)+1;
       
        if(i  <= evasion){
          
            return true;
            
        }
        
        return false;
    }
}
