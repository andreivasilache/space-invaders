import entities.Coordinates;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Character extends Coordinates {
    public int width, height;
    public String imgSource;
    private JFrame frameInstance;
    private Image processedImg;
    private int lifes;
    boolean isVisible;

    public Character(int width, int height, int x, int y, boolean isVisible, String imgSource, JFrame frameInstance, int lifes){
        super(x, y);

        this.width = width;
        this.height= height;
        this.lifes = lifes;

        this.isVisible = isVisible;
        this.imgSource = imgSource;
        this.frameInstance = frameInstance;

        try{
            Image img = ImageIO.read(new File(imgSource));
            processedImg = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Character(int width, int height,  boolean isVisible,  String imgSource){
        // initialize with 0, the values will be updated later, during runtime.
        super(0, 0);
        this.width = width;
        this.height= height;
        this.isVisible = isVisible;
        this.imgSource = imgSource;
    }

    public boolean areCoordinatesValid(int coordinate, String coordinateName){
        return coordinate >= 0 && (coordinateName.contentEquals("x")  && (coordinate <= frameInstance.getWidth() - width)
                || coordinateName.contentEquals("y") && coordinate <= frameInstance.getHeight());
    }

    public void moveLeft(){
        int newCoordinates = getX() - 10;
        if(areCoordinatesValid(newCoordinates, "x")){
            this.setX(newCoordinates);
        }
    }

    public void moveRight(){
        int newCoordinates = getX() + 10;
        if(areCoordinatesValid(newCoordinates, "x")){
            this.setX(newCoordinates);
        }
    }

    public int getWidth(){
        return  this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void setWidth(int width){
        this.width = width;
    }




    public Image getProcessedImg(){
        return this.processedImg;
    }
}
