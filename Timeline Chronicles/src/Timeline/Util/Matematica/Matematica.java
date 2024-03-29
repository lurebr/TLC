/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Util.Matematica;

import Timeline.Entidade.Atributo.Atributo;
import Timeline.Entidade.Atributo.Dano;
import Timeline.Enumerador.EnumElemento;
import java.util.Random;
import Timeline.Entidade.Behavior.isColide;
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

    public int calculaDano(int dano) {
        return dano;
    }

    public int calculaDano(Dano dano, Atributo atributo) {
        int danoTotal;
        if(CalculaEvasion(atributo.getEvasion())){
            
            return 0;
        }
        danoTotal = Math.abs(dano.getDanoProjetil() - atributo.getArmadura().getArmadura(EnumElemento.normal));
        return danoTotal;
    }
    
    public boolean colidir(isColide obj1, isColide obj2){
       if(obj1.getLocalizacao().getX() >= obj2.getLocalizacao().getX() &&  obj1.getLocalizacao().getX() <= obj2.getLocalizacao().getX() + obj2.getTamanho().getWidth() && 
           obj1.getLocalizacao().getY() >= obj2.getLocalizacao().getY() &&  obj1.getLocalizacao().getY() <= obj2.getLocalizacao().getY() + obj2.getTamanho().getHeight()){
            return true;
        }else{
           return false;
        }
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
