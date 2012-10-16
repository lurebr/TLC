/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.Util.Matematica;

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
}
