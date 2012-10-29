/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade;

import java.awt.Graphics;
import java.util.ArrayList;
import Timeline.Core.Parametro;
import Timeline.Entidade.Atributo.Posicao;
import Timeline.Entidade.Behavior.isDrawable;
import Timeline.Enumerador.EnumDirecao;

/**
 *
 * @author Desenv01
 */
public class Map implements isDrawable{
    
    private ArrayList<Block> blocos;
    private int[] movimento;
    private Posicao spawnLocation;
    private Posicao endLocation;
    
    public Map(int[][] mapa, int[]movimento){
        spawnLocation = new Posicao();
        endLocation = new Posicao();
        blocos = new ArrayList<Block>();
        
        this.movimento = movimento;
        
        for (int i=0;i<mapa.length;i++){
            for(int x=0;x<mapa[i].length;x++){
                Block b = new Block(mapa[i][x],i,x);
                switch(mapa[i][x]){
                    case 3:
                        spawnLocation.setX(x*Parametro.SPRITE_WIDTH);
                        spawnLocation.setY(i*Parametro.SPRITE_HEIGHT);
                    case 4:
                        endLocation.setX(x*Parametro.SPRITE_WIDTH);
                        endLocation.setY(i*Parametro.SPRITE_HEIGHT);
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

    /**
     * @return the spawnLocation
     */
    public Posicao getSpawnLocation() {
        System.out.println("Spawn:" + spawnLocation.toString());
        return spawnLocation;
    }

    /**
     * @return the endLocation
     */
    public Posicao getEndLocation() {
        System.out.println("EndSpawn:" + spawnLocation.toString());
        return endLocation;
    }

}