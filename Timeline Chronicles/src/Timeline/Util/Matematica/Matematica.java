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
        System.out.println("Dano:" + valorTotal);
        return valorTotal;
    }
    
    public static Matematica getInstance(){
     if (matematica == null)
         matematica = new Matematica();
      return matematica;
    }

    public int CalculaDano(int dano) {
        return dano;
    }

    public int CalculaDano(int dano, Atributo atributo) {
        int danoTotal;
        danoTotal = Math.abs(dano - atributo.getArmadura().getArmadura(EnumElemento.normal));
        return danoTotal;
    }
}
