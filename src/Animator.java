import javax.swing.*;
import java.awt.*;

// https://stackoverflow.com/questions/14432816/how-to-move-an-image-animation

public class Animator extends JPanel {
    Character[] toBeRendered;

    public Animator(Character[] toBeRendered){
        this.toBeRendered = toBeRendered;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i=0; i<this.toBeRendered.length; i++){
            g.drawImage( this.toBeRendered[i].getProcessedImg(), this.toBeRendered[i].getX(), this.toBeRendered[i].getY(), this.toBeRendered[i].width, this.toBeRendered[i].height, null);
            repaint(this.toBeRendered[i].getX(), this.toBeRendered[i].getY(), this.toBeRendered[i].width, this.toBeRendered[i].height);
        }
    }
}
