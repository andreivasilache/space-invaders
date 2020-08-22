import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoardUI extends JFrame {
    private String boardTitle;
    private int width, height;

    public JFrame frame;

   public BoardUI(String boardTitle, int width, int height){
        this.boardTitle = boardTitle;
        this.width  = width;
        this.height = height;
    }

    public void init() {
        frame = new JFrame(boardTitle);
        frame.setFocusable(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame.add(panel);

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame(){
       return frame;
    }


    public void draw( int x, int  y, int width, int height, String ImgSource){
       System.out.println(ImgSource);
        try{
            Image img = ImageIO.read(new File(ImgSource));
            img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
//            BorderLayout layout = new BorderLayout(x, y);
//            frame.getContentPane().add(new JLabel(new ImageIcon(img)), layout.SOUTH);

            Image finalImg = img;
            JPanel pane = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(finalImg, x, y, null);
                }
            };
            frame.add(pane);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
