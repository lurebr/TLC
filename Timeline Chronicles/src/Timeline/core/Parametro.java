/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Timeline.Core;

/**
 *
 * @author Lennon
 */
public class Parametro {
//Game Loop
      public final static double GAME_HERTZ = 30.0;
      public final static double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
      public final static int MAX_UPDATES_BEFORE_RENDER = 5;
      public final static double TARGET_FPS = 60;
      public final static double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
      public static final int SPRITE_HEIGHT = 32;
      public static final int SPRITE_WIDTH = 32;
}
