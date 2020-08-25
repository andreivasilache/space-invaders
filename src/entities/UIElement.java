package entities;

public class UIElement extends Coordinates {

    public int x;
    public int y;
    public int width;
    public int height;
    public String imgSource;

    public UIElement(int x, int y, int width, int height, String imgSource){
        super(x, y);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.imgSource = imgSource;
    }
}
