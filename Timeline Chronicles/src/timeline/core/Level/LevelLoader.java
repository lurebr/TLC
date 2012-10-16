/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.Core.Level;

import Timeline.Entidade.Map;

/**
 *
 * @author Lennon
 */
public class LevelLoader {
    private static LevelLoader levelLoader;
    private Level level;
    private MinionSpawner spawner;
    private Store store;
    private Map mapa;
    
    private LevelLoader(){}
    
    public void LevelStart(int idLevel){
        level = levelBuilder.carregaLevel(idLevel);
        iniciaLevel();
    }

    private void iniciaLevel() {
        spawner = new MinionSpawner(100, level.getMinions());
        store = new Store(level.getTowers());
        mapa = level.getMapa();
    }
    
    public Level getLevel(){
        return this.level;
    } 
    public MinionSpawner getSpawner(){
        return this.spawner;
    }
    public Store getStore(){
        return this.store;
    }
    public Map getMap(){
        return this.mapa;
    }
    
    public static LevelLoader getInstance(){
        if (levelLoader == null)
            levelLoader = new LevelLoader();
        return levelLoader;
    }
}
