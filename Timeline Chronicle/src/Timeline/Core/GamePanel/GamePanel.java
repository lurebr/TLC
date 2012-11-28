/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.GamePanel;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import Timeline.Core.GameMain;
import Timeline.Core.Level.LevelLoader;
import Timeline.Entidade.GameObject;
import Timeline.Entidade.Behavior.isDrawable;

/**
 * 
 * @author Desenv01
 */
public class GamePanel extends Canvas {

	private static final long serialVersionUID = 3263371214664650851L;
	
	BufferStrategy strategy;

	public GamePanel() {
		this.setVisible(true);
		this.setSize(800, 600);

	}

	public void draw() {

		if (strategy == null) {
			this.createBufferStrategy(2);
			strategy = this.getBufferStrategy();
		}

		Graphics2D g2d = (Graphics2D) strategy.getDrawGraphics();
		LevelLoader.getInstance().getMap().draw(g2d);

		// ArrayList<GameObject> clone = new
		// ArrayList<GameObject>(GameMain.objetos);

		for (GameObject obj : GameMain.objetos) {
			if (obj instanceof isDrawable) {
				isDrawable objd = (isDrawable) obj;
				objd.draw(g2d);
			}
		}

		GameMain.pintaTexto.drawTexto(g2d);

		g2d.dispose();
		strategy.show();
	}
}
