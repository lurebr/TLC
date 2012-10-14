/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Entidade.Behavior;

import Timeline.Enumerador.EnumDirecao;

/**
 *
 * @author Desenv01
 */
public interface isWalkable {
    public void move();
    public void move(EnumDirecao direcao);
}
