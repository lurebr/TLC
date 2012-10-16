/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Graphics;
import timeline.Core.GameMain;

/**
 *
 * @author Desenv01
 */
public class Ball {

    float x, y, lastX, lastY;
    int width, height;
    float xVelocity, yVelocity;
    float speed;

    public Ball() {
        width = (int) (Math.random() * 50 + 10);
        height = (int) (Math.random() * 50 + 10);
        x = (float) (Math.random() * (GameMain.gamePanel.getWidth() - width) + width / 2);
        y = (float) (Math.random() * (GameMain.gamePanel.getHeight() - height) + height / 2);
        lastX = x;
        lastY = y;
        xVelocity = (float) Math.random() * speed * 2 - speed;
        yVelocity = (float) Math.random() * speed * 2 - speed;
    }

    public void update() {
        lastX = x;
        lastY = y;

        x += xVelocity;
        y += yVelocity;

        if (x + width / 2 >= GameMain.gamePanel.getWidth()) {
            xVelocity *= -1;
            x = GameMain.gamePanel.getWidth() - width / 2;
            yVelocity = (float) Math.random() * speed * 2 - speed;
        } else if (x - width / 2 <= 0) {
            xVelocity *= -1;
            x = width / 2;
        }

        if (y + height / 2 >= GameMain.gamePanel.getHeight()) {
            yVelocity *= -1;
            y = GameMain.gamePanel.getHeight() - height / 2;
            xVelocity = (float) Math.random() * speed * 2 - speed;
        } else if (y - height / 2 <= 0) {
            yVelocity *= -1;
            y = height / 2;
        }
    }

    public void draw(Graphics g) {
    }
}
