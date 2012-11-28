/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Sound.Player;

import Timeline.Core.Sound.ISoundPlayer;
import Timeline.Core.Sound.JLayerSoundPlayer;

/**
 * 
 * @author Lennon
 */
public class SoundFactory {

	private static ISoundPlayer player;

	private SoundFactory() {
	}

	public static ISoundPlayer getSoundPlayer() {
		if (player == null) {
			player = new JLayerSoundPlayer();
		}
		return player;
	}
}
