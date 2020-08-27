//import javax.swing.*;

import entities.LevelsENUM;

import javax.swing.*;

public class Enemies extends  Character {
    private int speed;
    private int numberOfEnemies;
    private int animationDirection = 1;

    private JFrame frameInstance;
    private LevelsENUM.LEVELS level;

    public Enemies(int width, int height, int speed, int numberOfEnemies, LevelsENUM.LEVELS level, JFrame frameInstance) {
        super(width, height, true, "assets/enemy.jpg");

        this.frameInstance = frameInstance;
        this.numberOfEnemies = numberOfEnemies;

        this.speed = speed;
        this.level = level;
    }

    Character[] enemies = new Character[numberOfEnemies];

    public void initEnemies(Character[] uninitializedCharacters) {
        int screenWidth = frameInstance.getWidth();
        int screenHeight = frameInstance.getHeight();
        int spaceBewteen = 30;

        int xInit = screenWidth * 1/4;
        int yInit = screenHeight * 1/10;

        int currentX = xInit;
        int currentY = yInit;

        this.enemies = uninitializedCharacters;

        for(int i = 1; i<=numberOfEnemies; i++){
            System.out.println("" + currentX +" "+ currentY);
            if(currentX > (screenWidth - xInit - getWidth())){
                currentX = xInit;
                currentY += spaceBewteen;
            }
            uninitializedCharacters[i] = new Character(getWidth(), getHeight(), currentX , currentY, true, "assets/enemy.jpg", frameInstance);
            currentX += spaceBewteen;
        }
    }
}
