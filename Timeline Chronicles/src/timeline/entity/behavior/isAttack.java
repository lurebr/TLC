/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity.behavior;

import timeline.entity.atributes.Dimensao;
import timeline.entity.atributes.Localizacao;

/**
 *
 * @author Desenv01
 */
public interface isAttack {
    public int getDamage();
    public Localizacao getLocalizacao();
    public Dimensao getTamanho(); 
}
