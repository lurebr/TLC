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
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JFrame;
import Timeline.Core.Menu.DebugPane;
import Timeline.Entidade.GameObject;
import Timeline.Entidade.Tower;
import java.awt.Color;
import Timeline.Core.Level.LevelLoader;
import Timeline.Core.Sound.Player.SoundFactory;
import Timeline.Jogador.Jogador;
import Timeline.Util.Componente.PintaTexto;
import Timeline.Util.Cursor.CursorFactory;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Desenv01
 */
public class GameMain extends JFrame {
    
   private static GameMain gameMain;
    
   public static long fps;
   public static int frameCount;
   public static GamePanel gamePanel = new GamePanel();

   //public static testMenu gameMenu;
   public  EnumEstado state;
   //public  DebugPane debug = new DebugPane();
     
   public static CopyOnWriteArrayList<GameObject> objetos;
   public static Mouse mouse;
   public static Jogador jogador;
   public static PintaTexto pintaTexto;
   public static int time;
   
    private GameMain(){ 
    }
    
    private void initialize(){

      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setSize(1024,768);
      this.setVisible(true);
      setLoading(this.getGraphics());
      SoundFactory.getSoundPlayer().tocar("Ressource/Sound/game.mp3");  

      CarregaComponentes();
       
      CursorFactory.getCursor().mudarCursor(this);
                  
       AddListerner();
   
       objetos = new CopyOnWriteArrayList<>();
    
       setGameState(EnumEstado.iniciandoLevel);
       rodarGameLoop();
       pintaTexto = new PintaTexto();
       this.setBackground(Color.yellow);
        
    }
    
    private void CarregaComponentes(){
        Container cp = getContentPane();
        GridBagConstraints cons = new GridBagConstraints();  
        GridBagLayout layout = new GridBagLayout();  
        cp.setLayout(layout);
        cons.fill = GridBagConstraints.BOTH;
        cons.weightx = 1;
        cons.insets = new Insets(10,10,10,10);
      
      //ArrayList<Tower> towers = new ArrayList<Tower>();
      //Tower t = new Tower("", 10);
      //towers.add(t);
      
      
      
      //cons.gridy = 1;   
     // cons.gridx = 0;  
     // cons.weighty = 100;
     // cp.add(debug, cons);
      cons.gridy = 2;  
      cons.gridx = 0;  
      cons.weighty = 600;
      cp.add(gamePanel, cons);
    //  cons.gridy = 3;  
     // cons.gridx = 0;  
     // cons.weighty = 1;
     // cp.add(gameMenu.getTela(), cons);
    }
    
    private void AddListerner(){
      mouse = new Mouse();
      gamePanel.addMouseListener(mouse);
      gamePanel.addMouseMotionListener(mouse);
    }
    
    private void update(double delta){
       LevelLoader.getInstance().update(delta);
        for(GameObject obj: objetos){
            obj.update(delta);
        }
    }
    
    private void draw(){
        gamePanel.draw();
        //debug.draw();
    }
    
    public static GameMain getInstance(){
        if(gameMain == null){
            gameMain = new GameMain();
        }
        return gameMain;
    }
   
   private void gameLoop()
   {      
      long tempoUltimoUpdate;
      long tempoUltimoFrame = 0;

      tempoUltimoUpdate = System.nanoTime();

      
      while (state != EnumEstado.gameover)
      {
          long tempoAgora = System.nanoTime();
          long duracaoUpdate = tempoAgora - tempoUltimoUpdate;
          tempoUltimoUpdate = tempoAgora;
          double delta = duracaoUpdate / ((double)Parametro.TEMPO_IDEAL);

          tempoUltimoFrame += duracaoUpdate;
          fps++;
          System.out.println(tempoUltimoFrame);

         switch(state){
             case pause:
                 break;
             case jogando:
                    update(delta);
                    draw();     
                    try {Thread.sleep((tempoUltimoFrame-System.nanoTime() + Parametro.TEMPO_IDEAL)/1000000 );} catch(Exception e) {System.out.println(e.getMessage());}                  
                break;
             case iniciandoLevel:
                carregarLevel(jogador.getLevel());
                break;
         }

         
          if (tempoUltimoFrame >= 1000000000)
          {
             this.setTitle("Tower Defense - "+ "FPS: "+fps+" time:" + time);
             tempoUltimoFrame = 0;
             time++;
             fps = 0;
          }
          
          if(this.state== EnumEstado.gameover){
              exibeMensagemGameOver();
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
        if(jogador.getGold() >= 10 ){
            if(LevelLoader.getInstance().getMap().getBlock(posx, posy).isAllowTower()){
                
                Tower t = new Tower("Ressource/Object/Tower/tower.png",posx, posy);
                t.atributo.setDanoMinimo(10);
                t.atributo.setDanoMaximo(65);
                objetos.add(t);
                jogador.setGold(jogador.getGold() - 10);
            }else{
                JOptionPane.showMessageDialog(null, "Não permitido torre neste bloco");
            }
        }
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

    private void exibeMensagemGameOver() {
        JOptionPane.showMessageDialog(null, "Game Over!");
    }

}
