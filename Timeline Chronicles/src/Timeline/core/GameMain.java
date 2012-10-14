/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core;


import Timeline.Enumerador.EnumEstado;
import Timeline.Core.GamePanel.GamePanel;
import Timeline.Core.Componente.Mouse;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JFrame;
import Timeline.Imagem.Imagem;
import Timeline.Core.Menu.InternalMenu.GameControls.ControlerGameControls;
import Timeline.Core.Menu.InternalMenu.DebugPane;
import Timeline.Entidade.GameObject;
import Timeline.Entidade.Map;
import Timeline.Entidade.Minion;
import Timeline.Entidade.Tower;
import Timeline.Jogador.Jogador;

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
   public static EnumEstado state;
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
      setSize(800, 824);
      
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
        BufferedImage cursor =  Imagem.getInstance().getResourceImage("resource/system/cursor/cursor.png");
        Cursor c = toolkit.createCustomCursor(cursor,cursorHotSpot,"Cursor");
        this.setCursor(c);
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
        minionSpawner();
        
        for(GameObject obj: objetos){
            //if(obj instanceof Minion){
            //    Minion objM = (Minion) obj;
            //    objM.update();
            //}
            //if(obj instanceof Tower){
            //    Tower objT = (Tower) obj;
            //    objT.update();
            //}
            obj.update();
        }
    }
    
    private void draw(){
       // Graphics g = strategy.getDrawGraphics();
       // Graphics2D g2d = (Graphics2D)g;
        gamePanel.draw();
        debug.draw();
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
      while (state != EnumEstado.gameover)
      {  
         if (state != EnumEstado.pause)
         {
            update();
            draw();
            try {Thread.sleep(80);} catch(Exception e) {System.out.println(e.getMessage());} 
         }else{
             System.out.println("Pausado");
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
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1}};
        
         int levelcaminho[] = {2,4,4,4,2,2,2,2,2,2,2,1,1,1,1,1,1,1,4,4,4,4,4,2,2,2,2,2,2,2,4,4,4,4,4,4,4,4,1,1,1,1,1,1,1,4,4,4,4,3,3,3,3,2,2,2,2,2,2,2,4,4,4,4,2,2,2,2,2,2,2,2,2,2};
       
        
        mapa = new Map(levelmapa, levelcaminho);
        objetos = new CopyOnWriteArrayList<GameObject>();
        
    }
    
    private int timespawn=100;
    private int numMinion=200;
    
    private void minionSpawner(){
        if (numMinion==0){return;}
        if(timespawn == 100){
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
        t.atributo.setDanoMinimo(10);
        t.atributo.setDanoMaximo(25);
        objetos.add(t);
    }

    public void GameStart(Jogador jogador) {
        this.jogador = jogador;
        initialize();
        setGameState(EnumEstado.start);
    }

}
