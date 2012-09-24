/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.entity.behavior;

import timeline.enumerators.eDirecao;

/**
 *
 * @author Desenv01
 */
public interface isWalkable {
    public void move();
    public void move(eDirecao direcao);
}
