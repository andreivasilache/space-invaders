package entities;

public class Coordinates {
    private int x,  y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){ return this.y; }

    public void setX(int newValue){
        this.x = newValue;
    }

    public void setY(int newValue){ this.y = newValue; }
}
