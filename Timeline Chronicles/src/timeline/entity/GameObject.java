/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity;

import java.awt.geom.Dimension2D;
import timeline.Image.Animacao;
import timeline.entity.atributes.Atributo;
import timeline.entity.atributes.Dimensao;
import timeline.entity.atributes.Localizacao;

/**
 *
 * @author Desenv01
 */
public abstract class GameObject {
    public Localizacao localizacao = new Localizacao();
    public Dimensao tamanho = new Dimensao();
    public Atributo atributo = new Atributo();
    protected Animacao animacao;
    
    public abstract void update(); 
}
