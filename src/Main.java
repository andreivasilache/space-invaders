import entities.LevelsENUM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args){
        JFrame frameInstance;

        int width = 850;
        int height = 600;
        int entityWidth = 25;
        int entityHeight = 25;
        int numberOfEnemies = 55;

        Character[] entities = new Character[numberOfEnemies + 1];

        BoardUI boardUI = new BoardUI("Space Invaders", width, height);
        boardUI.initBoard();
        frameInstance = boardUI.getFrame();

        Enemies enemyBots = new Enemies(entityWidth, entityHeight, numberOfEnemies, LevelsENUM.LEVELS.LEVEL_ONE, frameInstance);

        entities[0] = new Character(entityWidth, entityHeight, 500, 500, true, "assets/shooter.jpg", frameInstance, 3);
        enemyBots.initEnemies(entities);

        Animator animator = new Animator(entities);
        frameInstance.add(animator);
        frameInstance.setVisible(true);

        Timer time = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                 enemyBots.moveAllEnemies();
            }
        });
        time.start();

        Character player = entities[0];
        frameInstance.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                super.keyPressed(event);
                int keyCode = event.getKeyCode();

                if (keyCode == event.VK_LEFT || keyCode == event.VK_A) {
                    player.moveLeft();
                }
                if (keyCode == event.VK_RIGHT || keyCode == event.VK_D) {
                    player.moveRight();
                }
                if (keyCode == event.VK_UP || keyCode == event.VK_W) {
                    System.out.println("Up");
                }
                if (keyCode == event.VK_DOWN || keyCode == event.VK_S) {
                    System.out.println("Down");
                }
                if (keyCode == event.VK_ESCAPE) {
                    System.out.println("pause!");
                }
            }
        });
    }
}

