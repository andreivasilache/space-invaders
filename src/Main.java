import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args){
        JFrame frameInstance;
        JPanel gameInstance;
        int width = 900;
        int height = 600;

        BoardUI boardUI = new BoardUI("Space Invaders", width, height);
        boardUI.initBoard();
        frameInstance = boardUI.getFrame();

        Character shooter = new Character(50, 50, width/2, height - 100, true, "assets/shooter.jpg",frameInstance);

        frameInstance.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                super.keyPressed(event);
                int keyCode = event.getKeyCode();

                if (keyCode == event.VK_LEFT || keyCode == event.VK_A) {
                    shooter.moveLeft();
                }
                if (keyCode == event.VK_RIGHT || keyCode == event.VK_D) {
                    shooter.moveRight();
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

