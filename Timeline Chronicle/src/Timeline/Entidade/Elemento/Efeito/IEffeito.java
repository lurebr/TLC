/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Elemento.Efeito;

import Timeline.Entidade.Behavior.isAttackable;

/**
 * 
 * @author Lennon
 */
public interface IEffeito {
	public void Executa(isAttackable objeto);

	public void setDamage(int Damage);
}
