/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Behavior;

import Timeline.Entidade.Atributo.Atributo;
import Timeline.Entidade.Atributo.Posicao;
import Timeline.Entidade.Atributo.Tamanho;

/**
 * 
 * @author Desenv01
 */
public interface isAttacker {
	public boolean attack(isAttackable alvo);

	public Posicao getLocalizacao();

	public Tamanho getTamanho();

	public Atributo getAtributo();
}
