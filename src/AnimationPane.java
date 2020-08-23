import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// https://stackoverflow.com/questions/14432816/how-to-move-an-image-animation

public class AnimationPane extends JPanel {
    String ImgSource;
    int width, height, x, y;
    Image finalImg;

    public AnimationPane(String ImgSource, int width, int height, int x, int y){
        this.ImgSource = ImgSource;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        try{
            Image img = ImageIO.read(new File(ImgSource));
            img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);

            finalImg = img;
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(finalImg, x, y, width, height, null);
    }

    public void updateX(int newX){
        x = newX;
        repaint();
    }

    public  void  updateY(int to){
        y += to;
    }
}
