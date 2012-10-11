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
public interface isAttackable {
    public void calculaDano(int dano);
    public Localizacao getLocalizacao();
    public Dimensao getTamanho(); 
    public boolean isAlive();
}
