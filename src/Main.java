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


        BoardUI boardUI = new BoardUI("Space Invaders", width, height);
        boardUI.initBoard();
        frameInstance = boardUI.getFrame();

        Core gameCore = new Core(frameInstance);
        gameCore.initAllElements();

        Animator animator = new Animator(gameCore);
        frameInstance.add(animator);
        frameInstance.setVisible(true);

        Timer time = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameCore.animateEnemieBots();
                gameCore.animateBullets();
            }
        });
        time.start();

        Character player = gameCore.getPlayer();
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
                    player.shoot();
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

