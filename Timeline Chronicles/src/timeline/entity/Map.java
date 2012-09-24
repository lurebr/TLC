/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import timeline.core.GameParameter;
import timeline.entity.atributes.Localizacao;
import timeline.entity.behavior.isDrawable;
import timeline.enumerators.eDirecao;

/**
 *
 * @author Desenv01
 */
public class Map implements isDrawable{
    
    private ArrayList<Block> blocos;
    private int[] movimento;
    public Localizacao spawnLocation;
    public Localizacao endLocation;
    
    public Map(int[][] mapa, int[]movimento){
        spawnLocation = new Localizacao();
        endLocation = new Localizacao();
        blocos = new ArrayList<Block>();
        
        this.movimento = movimento;
        
        for (int i=0;i<mapa.length;i++){
            for(int x=0;x<mapa[i].length;x++){
                Block b = new Block(mapa[i][x],i,x);
                switch(mapa[i][x]){
                    case 3:
                        spawnLocation.setX(x*GameParameter.SPRITE_WIDTH);
                        spawnLocation.setY(i*GameParameter.SPRITE_HEIGHT);
                    case 4:
                        endLocation.setX(x*GameParameter.SPRITE_WIDTH);
                        endLocation.setY(i*GameParameter.SPRITE_HEIGHT);
                }
                blocos.add(b);
            }
        }
    }
    
    @Override
    public void draw(Graphics g) {
        for(Block b : blocos){
           b.draw(g); 
        }
    }
    
     public int[] getCaminho(){
        return this.movimento;
    }
}
