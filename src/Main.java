import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args){
        JFrame frameInstance;
        JPanel gameInstance;
        int width = 900;
        int height = 600;
        int entityWidth = 50;
        int entityHeight = 50;

        BoardUI boardUI = new BoardUI("Space Invaders", width, height);
        boardUI.initBoard();
        frameInstance = boardUI.getFrame();

//        Character shooter = new Character(entityWidth, entityHeight, width/2, height - 100, true, "assets/shooter.jpg", frameInstance);
        Character[] enemies = new Character[2];
        enemies[0] = new Character(entityWidth, entityHeight, 500, 500, true, "assets/shooter.jpg", frameInstance);
        for(int i = 1; i<2; i++){
            enemies[i] = new Character(entityWidth, entityHeight, width/2 + entityWidth, height /2, true, "assets/enemy.jpg", frameInstance);
        }

        Animator animator = new Animator(enemies);

        Timer time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                Animator animator = new Animator(enemies);
//                animator.repaint();
//                System.out.println("done");
                frameInstance.add(animator);
                frameInstance.setVisible(true);
            }
        });
        time.start();

        frameInstance.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                super.keyPressed(event);
                int keyCode = event.getKeyCode();

                if (keyCode == event.VK_LEFT || keyCode == event.VK_A) {
//                    shooter.moveLeft();
                }
                if (keyCode == event.VK_RIGHT || keyCode == event.VK_D) {
//                    shooter.moveRight();
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

