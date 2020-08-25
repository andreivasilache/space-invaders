import entities.UIElement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// https://stackoverflow.com/questions/14432816/how-to-move-an-image-animation

public class Animator extends JPanel {
//    String ImgSource;
//    int width, height, x, y;
//    Image finalImg;
    Character[] toBeRendered;

    public Animator(Character[] toBeRendered){
        this.toBeRendered = toBeRendered;
//        this.ImgSource = ImgSource;
//        this.width = width;
//        this.height = height;
//        this.x = x;
//        this.y = y;

//        try{
//            Image img = ImageIO.read(new File(ImgSource));
//            img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
//
//            finalImg = img;
//        } catch (IOException e){
//            e.printStackTrace();
//        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i=0; i<this.toBeRendered.length; i++){
            try{
                Image img = ImageIO.read(new File(this.toBeRendered[i].imgSource));
                img = img.getScaledInstance(this.toBeRendered[i].width, this.toBeRendered[i].height, Image.SCALE_DEFAULT);

                g.drawImage(img, this.toBeRendered[i].x, this.toBeRendered[i].y, this.toBeRendered[i].width, this.toBeRendered[i].height, null);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }

//    public void repaint(){
//        repaint();
//    }

//    public void updateX(int newX){
//        x = newX;
//        repaint();
//    }
//
//    public  void  updateY(int to){
//        y += to;
//    }
}
