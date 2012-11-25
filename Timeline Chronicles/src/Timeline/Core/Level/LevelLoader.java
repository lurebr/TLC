/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core.Level;

import Timeline.Core.GameMain;
import Timeline.Entidade.Map;
import java.awt.Container;
import java.awt.GridBagConstraints;

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
    
    private LevelLoader(){}
    
    public void LevelStart(int idLevel){
        level = levelBuilder.carregaLevel(idLevel);
        iniciaLevel();
    }

    private void iniciaLevel() {
        spawner = new MinionSpawner(700, level.getMinions(), level.getTempoSpawn());
        
        if (store == null){
            store = new ControlerStore(level.getTowers());
            Container cp = GameMain.getInstance().getContentPane();
            GridBagConstraints cons = new GridBagConstraints();
            cons.gridy = 3;  
            cons.gridx = 0;  
            cons.weighty = 1;
            cp.add(store.getTela(),cons);
        }else{
            store.AtualizarLoja(level.getTowers());
        }
        mapa = level.getMapa();
        
    }
    
    public Level getLevel(){
        return this.level;
    } 
    public MinionSpawner getSpawner(){
        return this.spawner;
    }
    public ControlerStore getStore(){
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
