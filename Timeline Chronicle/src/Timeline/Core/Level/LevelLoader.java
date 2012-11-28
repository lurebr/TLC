/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level;

import Timeline.Core.GameMain;
import Timeline.Entidade.GameObject;
import Timeline.Entidade.Map;
import Timeline.Entidade.Minion;
import Timeline.Enumerador.EnumEstado;

/**
 * 
 * @author Lennon
 */
public class LevelLoader {
	private static LevelLoader levelLoader;
	private Level level;
	private MinionSpawner spawner;
	private ControlerStore store;
	private Map mapa;

	private LevelLoader() {
	}

	public void LevelStart(int idLevel) {
		level = levelBuilder.carregaLevel(idLevel);
		iniciaLevel();
	}

	private void iniciaLevel() {
		spawner = new MinionSpawner(700, level.getMinions(),
				level.getTempoSpawn());

		if (store == null) {
			store = new ControlerStore(level.getTowers());
		} else {
			store.AtualizarLoja(level.getTowers());
		}
		mapa = level.getMapa();

	}

	public Level getLevel() {
		return this.level;
	}

	public MinionSpawner getSpawner() {
		return this.spawner;
	}

	public ControlerStore getStore() {
		if (this.store == null) {
			store = new ControlerStore();
		}
		return this.store;
	}

	public Map getMap() {
		return this.mapa;
	}

	public static LevelLoader getInstance() {
		if (levelLoader == null)
			levelLoader = new LevelLoader();
		return levelLoader;
	}

	public void update(double delta) {
		if (isGameOver()) {
			GameMain.getInstance().setGameState(EnumEstado.gameover);
		} else {
			this.spawner.update(delta);
			this.store.update();
		}
	}

	private boolean isGameOver() {
		if (this.spawner.endSpawn() && !isMonsterSpawn()) {
			return true;
		}
		if (this.level.getVida() <= 0) {
			return true;
		}

		return false;
	}

	private boolean isMonsterSpawn() {
		for (GameObject obj : GameMain.objetos) {
			if (obj instanceof Minion) {
				return true;
			}
		}
		return false;
	}
}
