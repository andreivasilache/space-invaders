import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Animator extends JPanel {
    private Core gameCore;

    public Animator(Core gameCore){
        this.gameCore = gameCore;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<Character> render = gameCore.getAllElementsToBeRendered();
        for(int i=0; i<render.size(); i++){
            if(render.get(i).isVisible){
                g.drawImage(render.get(i).getProcessedImg(), render.get(i).getX(), render.get(i).getY(), render.get(i).getWidth(), render.get(i).getHeight(), null);
                repaint(render.get(i).getX(), render.get(i).getY(), render.get(i).getWidth(), render.get(i).getHeight());
            }
        }
    }
}
