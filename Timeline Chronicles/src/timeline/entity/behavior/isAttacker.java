/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity.behavior;

import timeline.entity.atributes.Atributo;
import timeline.entity.atributes.Dimensao;
import timeline.entity.atributes.Localizacao;

/**
 *
 * @author Desenv01
 */
public interface isAttacker {
    public boolean attack(isAttackable alvo);
    public Localizacao getLocalizacao();
    public Dimensao getTamanho(); 
    public Atributo getAtributo();
}
