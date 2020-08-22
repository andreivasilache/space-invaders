public class Character extends  Coordinates {
    private int width, height;
    private String imgSource;
    private Coordinates coordinates;

    boolean isVisible;

    public Character(int width, int height, int x, int y, boolean isVisible, String imgSource){
        super(x, y);

        this.width = width;
        this.height= height;

        this.isVisible = isVisible;
        this.imgSource = imgSource;
    }

    public void moveLeft(){
        int currentX = getX();
        this.setX(currentX - this.width);
    }

    public  void moveRight(){
        int currentY = getY();
        this.setY(currentY + this.width);
    }

    public String getImgSource(){
        return this.imgSource;
    }
}
