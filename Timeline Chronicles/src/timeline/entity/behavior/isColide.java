/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity.behavior;

import java.awt.geom.Dimension2D;
import timeline.entity.atributes.Dimensao;
import timeline.entity.atributes.Localizacao;

/**
 *
 * @author Desenv01
 */
public interface isColide {
    public boolean colide(isColide obj);
    public Localizacao getLocalizacao();
    public Dimensao getTamanho();
}
