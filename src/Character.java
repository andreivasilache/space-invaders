import javax.swing.*;

public class Character extends Coordinates {
    private int width, height;
    private String imgSource;
    private Coordinates coordinates;
    private JFrame frameInstance;

    private AnimationPane animation;

    boolean isVisible;

    public Character(int width, int height, int x, int y, boolean isVisible, String imgSource, JFrame frameInstance){
        super(x, y);

        this.width = width;
        this.height= height;

        this.isVisible = isVisible;
        this.imgSource = imgSource;
        this.frameInstance = frameInstance;
        this.animation = new AnimationPane(imgSource,width, height,x, y);

        frameInstance.add(this.animation);
        frameInstance.setVisible(true);
    }

    public boolean areCoordonatesValid(int cooridnate, String coordinateName){
        return cooridnate > 0 && (coordinateName.contentEquals("x")  && (cooridnate < frameInstance.getWidth()- width)
                || coordinateName.contentEquals("y") && cooridnate < frameInstance.getHeight());
    }

    public void moveLeft(){
        int newCoordinates = getX() - 10;
        if(areCoordonatesValid(newCoordinates, "x")){
            setX(newCoordinates);
            animation.updateX(newCoordinates);
        }
    }

    public void moveRight(){
        int newCoordinates = getX() + 10;
        if(areCoordonatesValid(newCoordinates, "x")){
            setX(newCoordinates);
            animation.updateX(newCoordinates);
        }
    }

    public String getImgSource(){
        return this.imgSource;
    }
}
