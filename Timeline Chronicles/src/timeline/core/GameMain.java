/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline.core;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import timeline.Image.Image;
import timeline.core.menu.ControlerGameMenu;
import timeline.entity.GameObject;
import timeline.entity.Map;
import timeline.entity.Minion;
import timeline.entity.Tower;
import timeline.entity.behavior.isDrawable;

/**
 *
 * @author Desenv01
 */
public class GameMain extends JFrame {
    
   private static GameMain gameMain;
    
   public static int fps;
   public static int frameCount;
   public static GamePanel gamePanel = new GamePanel();
   public static ControlerGameMenu gameMenu;
   public static enumState state;
   public static Map mapa;
   public static ArrayList<GameObject> objetos;
   public static Mouse mouse;
   BufferStrategy strategy;
           
    private GameMain(){
        initialize();
    }
    
    private void initialize(){
      
      this.setUndecorated(true);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setSize(800, 600);
      
      Container cp = getContentPane();
      cp.setLayout(new GridLayout(2,0));
      
      
      gameMenu = new ControlerGameMenu();
      cp.add(gamePanel, BorderLayout.PAGE_START);
      cp.add(gameMenu.getTela(), BorderLayout.PAGE_END);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point cursorHotSpot = new Point(0,0);
        BufferedImage cursor =  Image.getInstance().getResourceImage("resource/system/cursor/cursor.png");
        Cursor c = toolkit.createCustomCursor(cursor,cursorHotSpot,"Cursor");
        this.setCursor(c);
        
      this.setVisible(true);
      this.createBufferStrategy(2);
      strategy = getBufferStrategy();
      
      mouse = new Mouse();
      this.addMouseListener(mouse);
      this.addMouseMotionListener(mouse);
      
        carregarLevel(1);
        rodarGameLoop();
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
        Graphics g = strategy.getDrawGraphics();
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, 200, 200);
        
        mapa.draw(g);
        for(GameObject obj: objetos){
            if(obj instanceof isDrawable){
                isDrawable objd = (isDrawable) obj;   
                objd.draw(g);
            }
        }
        drawMouse(g2d);
        g2d.dispose();
        strategy.show();
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
            try {Thread.sleep(1);} catch(Exception e) {} 
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

    public void setState(enumState enumState) {
        this.state = enumState;
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
        objetos = new ArrayList<GameObject>();
        
    }
    
    private int timespawn=200;
    private int numMinion=200;
    
    private void minionSpawner(){
        if (numMinion==0){return;}
        if(timespawn == 200){
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
        
        g2d.drawImage(Image.getInstance().getResourceImage("resource/object/tower/tower.png"),posx,posy,null);
        
        System.out.println(MouseInfo.getPointerInfo().getLocation().y);
    }
    
    public void addTower(int posx, int posy){
        posx = Math.round(posx/32)*32;
        posy = Math.round(posy/32)*32;
        Tower t = new Tower("resource/object/tower/tower.png",posx, posy);
        objetos.add(t);
    }

}
