/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Timeline.Imagem.Animacao;
import Timeline.Imagem.Imagem;
import Timeline.Entidade.Behavior.isDrawable;

/**
 *
 * @author Desenv01
 */
public class Block extends GameObject implements isDrawable {
    
    private int posX;
    private int posY;
    private int altura;
    private int largura;
    private boolean allowTower;

    
    public Block(int typeBlock,int posX, int posY, boolean allowTower){
        BufferedImage imagem = Imagem.getInstance().getResourceImage(getCaminho(typeBlock));

        super.animacao = new Animacao(imagem);
        this.altura = imagem.getHeight();
        this.largura = imagem.getWidth();
        this.posX = posX;
        this.posY = posY;
        this.allowTower = allowTower;
    }
    
    private String getCaminho(int i) {
        switch (i){
            case 1:
                return "Ressource/Object/Block/grass.png";
            case 2:
                return "Ressource/Object/Block/earth.png";
            case 3:
                return "Ressource/Object/Block/earth6.png";
            case 4:
                return "Ressource/Object/Block/earth6.png";
            case 5:
                return "Ressource/Object/Block/earth2.png";
            case 6:
                return "Ressource/Object/Block/earth3.png";
            case 7:
                return "Ressource/Object/Block/earth4.png";
            case 8:
                return "Ressource/Object/Block/earth5.png";
            case 9:
                return "Ressource/Object/Block/earth6.png"; 
            case 10:
                return "Ressource/Object/Block/earth7.png";
            case 11:
                return "Ressource/Object/Block/earth8.png";
            case 12:
                return "Ressource/Object/Block/TreeBot.png";
            case 13:
                return "Ressource/Object/Block/TreeTop.png";
            case 14:
                return "Ressource/Object/Block/deadTreeBot.png";
            case 15:
                return "Ressource/Object/Block/deadTreeTop.png";
            case 16:
                return "Ressource/Object/Block/rock2.png";
            case 17:
                return "Ressource/Object/Block/rock3.png";
            case 18:
                return "Ressource/Object/Block/moitaNaMoita.png";
            case 19:
                return "Ressource/Object/Block/moitaNaMoitinha.png";
            default:
                return "";
        }
    }
    
    @Override
    public void update(double delta) {
    }

    @Override
    public void draw(Graphics g) {
        super.animacao.draw(g, posY*altura, posX * largura);
    }

    /**
     * @return the allowTower
     */
    public boolean isAllowTower() {
        return allowTower;
    }

    
}
