import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frameInstance;

        BoardUI boardUI = new BoardUI("Space Invaders", 800, 400);
        boardUI.init();

        boardUI.getFrame().addKeyListener(new KeyBoardListener());
        boardUI.draw(100, 100, 50,50, "assets/shooter.jpg");

    }
}

