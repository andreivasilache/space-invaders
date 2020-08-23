import javax.swing.*;

public class BoardUI extends JFrame {
    private String boardTitle;
    private int width, height;

    public JFrame frame;
    public JPanel gamePanel;

   public BoardUI(String boardTitle, int width, int height){
        this.boardTitle = boardTitle;
        this.width  = width;
        this.height = height;
    }

    public void initBoard() {
        frame = new JFrame(boardTitle);
//        frame.setFocusable(true);

//        gamePanel = new JPanel();
//        gamePanel.setLayout(new FlowLayout());

//        frame.add(gamePanel);
//        frame.setBackground(Color.black);

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame(){
       return frame;
    }
    public JPanel getGamePanel(){
       return gamePanel;
    }

}
