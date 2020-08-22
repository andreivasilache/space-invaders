import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoardListener extends KeyAdapter {
   public void keyPressed(KeyEvent event){
       int keyCode = event.getKeyCode();

       if (keyCode == event.VK_LEFT || keyCode == event.VK_A) {
           System.out.println("Left");
       }
       if (keyCode == event.VK_RIGHT || keyCode == event.VK_D) {
           System.out.println("Right");
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
}
