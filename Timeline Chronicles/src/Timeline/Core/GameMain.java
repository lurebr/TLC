/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core;


import Timeline.Enumerador.EnumEstado;
import java.awt.Graphics;
import Timeline.Core.GamePanel.GamePanel;
import Timeline.Core.Componente.Mouse;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JFrame;
import Timeline.Core.Menu.internalMenu.gameControls.ControlerGameControls;
import Timeline.Core.Menu.internalMenu.DebugPane;
import Timeline.Entidade.GameObject;
import Timeline.Entidade.Tower;
import java.awt.Color;
import Timeline.Core.Level.LevelLoader;
import Timeline.Jogador.Jogador;
import Timeline.Util.Cursor.CursorFactory;

/**
 *
 * @author Desenv01
 */
public class GameMain extends JFrame {
    
   private static GameMain gameMain;
    
   public static int fps;
   public static int frameCount;
   public static GamePanel gamePanel = new GamePanel();
   public static ControlerGameControls gameMenu;
   //public static testMenu gameMenu;
   public  EnumEstado state;
   public  DebugPane debug = new DebugPane();
     
   public static CopyOnWriteArrayList<GameObject> objetos;
   public static Mouse mouse;
   public static Jogador jogador;
   
    private GameMain(){ 
    }
    
    private void initialize(){
      
      //this.setUndecorated(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      //setSize(800, 824);
      setSize(1024,768);
      this.setVisible(true);
      setLoading(this.getGraphics());
            
      CarregaComponentes();
      CursorFactory.getCursor().mudarCursor(this);
        
       AddListerner();
       
       objetos = new CopyOnWriteArrayList<>();
       
       setGameState(EnumEstado.iniciandoLevel);
       rodarGameLoop();
    }
    
    private void CarregaComponentes(){
        Container cp = getContentPane();
        GridBagConstraints cons = new GridBagConstraints();  
        GridBagLayout layout = new GridBagLayout();  
        cp.setLayout(layout);
        cons.fill = GridBagConstraints.BOTH;
        cons.weightx = 1;
        cons.insets = new Insets(10,10,10,10);
      
      ArrayList<Tower> towers = new ArrayList<Tower>();
      Tower t = new Tower("", 10);
      towers.add(t);
      gameMenu = new ControlerGameControls<Tower>(towers);
      
      
      cons.gridy = 1;  
      cons.gridx = 0;  
      cons.weighty = 100;
      cp.add(debug, cons);
      cons.gridy = 2;  
      cons.gridx = 0;  
      cons.weighty = 600;
      cp.add(gamePanel, cons);
      cons.gridy = 3;  
      cons.gridx = 0;  
      cons.weighty = 1;
      cp.add(gameMenu.getTela(), cons);
      
    }
    
    private void AddListerner(){
      mouse = new Mouse();
      gamePanel.addMouseListener(mouse);
      gamePanel.addMouseMotionListener(mouse);
    }
    
    private void update(){
       LevelLoader.getInstance().getSpawner().update();
        
        for(GameObject obj: objetos){
            obj.update();
        }
    }
    
    private void draw(){
        gamePanel.draw();
        debug.draw();
    }
    
    public static GameMain getInstance(){
        if(gameMain == null){
            gameMain = new GameMain();
        }
        return gameMain;
    }
   
   private void gameLoop()
   {      
      while (state != EnumEstado.gameover)
      {  
          
         switch(state){
             case pause:
                 break;
             case jogando:
                update();
                draw();
                try {Thread.sleep(1);} catch(Exception e) {System.out.println(e.getMessage());}                  
                break;
             case iniciandoLevel:
                carregarLevel(jogador.getLevel());
                break;
         }

      }
      this.dispose();
   }
   
   public void rodarGameLoop()
   {
      Thread loop = new Thread()
      {
         public void run()
         {
            gameLoop();
         }
      };
      loop.start();
    }

    public void setGameState(EnumEstado enumState) {
        this.state = enumState;
        
    }
    
    public EnumEstado getGameState() {
        return this.state;
    }
    
    public void carregarLevel(int level){
        LevelLoader.getInstance().LevelStart(level);
        setGameState(EnumEstado.jogando);
        
    }

    
    public void addTower(int posx, int posy){
        posx = Math.round(posx/32)*32;
        posy = Math.round(posy/32)*32;
        Tower t = new Tower("Ressource/object/tower/tower.png",posx, posy);
        t.atributo.setDanoMinimo(10);
        t.atributo.setDanoMaximo(25);
        objetos.add(t);
    }

    public void GameStart(Jogador jogador) {
        this.jogador = jogador;
        initialize();
    }

    private void setLoading(Graphics graphics) {
        
        graphics.setColor(Color.black);
        graphics.drawRect(0, 0, Parametro.SCREEN_HEIGHT,Parametro.SCREEN_WIDTH);
        graphics.fillRect(0, 0, Parametro.SCREEN_HEIGHT,Parametro.SCREEN_WIDTH);
        graphics.setColor(Color.white);
        graphics.drawString("Loading...", Math.abs(Parametro.SCREEN_HEIGHT/2), Math.abs(Parametro.SCREEN_WIDTH/2));
        graphics.setColor(Color.black);
        
    }

}
