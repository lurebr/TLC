/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Sound;

/**
 * 
 * @author Lennon
 */
public interface ISoundPlayer {
	public void tocar(String caminho);

	public void parar();

	public void tocarEfeito(String caminho);
}
