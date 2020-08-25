import entities.Coordinates;

import javax.swing.*;

public class Character extends Coordinates {
    public int width, height,x,y;
    public String imgSource;
    private JFrame frameInstance;

//    private AnimationPane animation;

    boolean isVisible;

    public Character(int width, int height, int x, int y, boolean isVisible, String imgSource, JFrame frameInstance){
        super(x, y);

        this.width = width;
        this.height= height;

        this.isVisible = isVisible;
        this.imgSource = imgSource;
        this.frameInstance = frameInstance;
//        this.animation = new AnimationPane(imgSource,width, height,x, y);

//        frameInstance.add(this.animation);
//        frameInstance.setVisible(true);
    }

    public boolean areCoordinatesValid(int coordinate, String coordinateName){
        return coordinate > 0 && (coordinateName.contentEquals("x")  && (coordinate < frameInstance.getWidth()- width)
                || coordinateName.contentEquals("y") && coordinate < frameInstance.getHeight());
    }

    public void moveLeft(){
        int newCoordinates = getX() - 10;
        if(areCoordinatesValid(newCoordinates, "x")){
            setX(newCoordinates);
//            animation.updateX(newCoordinates);
        }
    }

    public void moveRight(){
        int newCoordinates = getX() + 10;
        if(areCoordinatesValid(newCoordinates, "x")){
            setX(newCoordinates);
//            animation.updateX(newCoordinates);
        }
    }

    public String getImgSource(){
        return this.imgSource;
    }
}
