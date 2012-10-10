/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JFrame;
import timeline.Image.Image;
import timeline.core.internalMenu.gameControls.ControlerGameControls;
import timeline.core.internalMenu.DebugPane;
import timeline.entity.GameObject;
import timeline.entity.Map;
import timeline.entity.Minion;
import timeline.entity.Tower;
import timeline.jogador.Jogador;

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
   public static enumState state;
   public static DebugPane debug = new DebugPane();
   public static Map mapa;
     
   public static CopyOnWriteArrayList<GameObject> objetos;
   public static Mouse mouse;
   public static Jogador jogador;
           
    private GameMain(){
        
    }
    
    private void initialize(){
      
      this.setUndecorated(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //setIgnoreRepaint(true);
      setResizable(false);
      setSize(800, 600);
      
      CarregaComponentes();
      CarregaCursor();
        
       this.setVisible(true);
      // this.createBufferStrategy(2);
      // strategy = this.getBufferStrategy();
      
        AddListerner();
        carregarLevel(1);
        rodarGameLoop();
    }
    
    private void CarregaCursor(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point cursorHotSpot = new Point(0,0);
        BufferedImage cursor =  Image.getInstance().getResourceImage("resource/system/cursor/cursor.png");
        Cursor c = toolkit.createCustomCursor(cursor,cursorHotSpot,"Cursor");
        this.setCursor(c);
    }
    
    private void CarregaComponentes(){
      Container cp = getContentPane();
      cp.setLayout(new GridLayout(3,0));
      
      ArrayList<Tower> towers = new ArrayList<Tower>();
      Tower t = new Tower("", 10);
      towers.add(t);
      gameMenu = new ControlerGameControls<Tower>(towers);
      
      //gameMenu = new testMenu();
      cp.add(debug);
      cp.add(gamePanel, BorderLayout.NORTH);
      cp.add(gameMenu.getTela(), BorderLayout.SOUTH);
      
    }
    
    private void AddListerner(){
      mouse = new Mouse();
      gamePanel.addMouseListener(mouse);
      gamePanel.addMouseMotionListener(mouse);
    }
    
    private void update(){
        minionSpawner();
        
        for(GameObject obj: objetos){
            if(obj instanceof Minion){
                Minion objM = (Minion) obj;
                objM.update();
            }
            if(obj instanceof Tower){
                Tower objT = (Tower) obj;
                objT.update();
            }
        }
    }
    
    private void draw(){
       // Graphics g = strategy.getDrawGraphics();
       // Graphics2D g2d = (Graphics2D)g;
        gamePanel.draw();
      //  drawMouse(g2d);
        //gameMenu.paintComponents(g);
       // g2d.dispose();
       // strategy.show();
    }
    
    public static GameMain getInstance(){
        if(gameMain == null){
            gameMain = new GameMain();
        }
        return gameMain;
    }
   
   
   
   private void gameLoop()
   {      
      while (state != enumState.gameover)
      {  
         if (state != enumState.pause)
         {
            update();
            draw();
            try {Thread.sleep(80);} catch(Exception e) {System.out.println(e.getMessage());} 
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

    public void setGameState(enumState enumState) {
        this.state = enumState;
        debug.draw();
    }
    public enumState getGameState() {
        return this.state;
    }
    
    public void carregarLevel(int level){
        switch(level){
            case 1:
                carregarlevel1();
                break;
            default:
                break;
        }
    }

    private void carregarlevel1() {
        int levelmapa[][] = {{1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                             {1,1,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,2,2,2,2,2,1,1,1,1,1,1,1,1,1},  
                             {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,2,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1}};
        
         int levelcaminho[] = {2,4,4,4,2,2,2,2,2,2,2,1,1,1,1,1,1,1,4,4,4,4,4,2,2,2,2,2,2,2,4,4,4,4,4,4,4,4,1,1,1,1,1,1,1,4,4,4,4,3,3,3,3,2,2,2,2,2,2,2,4,4,4,4,2,2,2,2};
       
        
        mapa = new Map(levelmapa, levelcaminho);
        objetos = new CopyOnWriteArrayList<GameObject>();
        
    }
    
    private int timespawn=500;
    private int numMinion=200;
    
    private void minionSpawner(){
        if (numMinion==0){return;}
        if(timespawn == 500){
            Minion m = new  Minion("resource/object/minion/minion.gif", mapa.getCaminho(), mapa.spawnLocation.getX(),mapa.spawnLocation.getY());
            objetos.add(m);
            timespawn = 0;
            numMinion--;   
        }
        timespawn++;
    }

    private void drawMouse(Graphics2D g2d) {
        int mx = MouseInfo.getPointerInfo().getLocation().x;
        int my = MouseInfo.getPointerInfo().getLocation().y;
        g2d.drawString("mx: " + mx + " my: " + my,0, 100);
        int posx = Math.round(mx/32)*32;
        int posy = Math.round(my/32)*32;
        
        //g2d.drawImage(Image.getInstance().getResourceImage("resource/object/tower/tower.png"),posx,posy,null);
        
       // System.out.println(MouseInfo.getPointerInfo().getLocation().y);
    }
    
    public void addTower(int posx, int posy){
        posx = Math.round(posx/32)*32;
        posy = Math.round(posy/32)*32;
        Tower t = new Tower("resource/object/tower/tower.png",posx, posy);
        objetos.add(t);
    }

    public void GameStart(Jogador jogador) {
        this.jogador = jogador;
        initialize();
        setGameState(enumState.start);
    }

}
