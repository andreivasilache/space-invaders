public class Bullet extends Character {
    int directionX;

    public Bullet(int width, int height,int x, int y,  boolean isVisible, String imgSource, int directionX) {
        super(width, height, x , y, isVisible, imgSource);
        this.directionX = directionX;
    }

    public void moveBullet(){
        int toBeIncreasedWith = 10 * directionX;
        int newCoordinates = getY() - toBeIncreasedWith;
        System.out.println(newCoordinates);
        this.setY(newCoordinates);
    }

}
