/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Behavior;

import Timeline.Entidade.Atributo.Dano;
import Timeline.Entidade.Atributo.Tamanho;
import Timeline.Entidade.Atributo.Posicao;

/**
 *
 * @author Desenv01
 */
public interface isAttack {
    public Dano getDamage();
    public Posicao getLocalizacao();
    public Tamanho getTamanho(); 
}
