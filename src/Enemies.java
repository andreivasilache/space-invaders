import entities.LevelsENUM;
import javax.swing.*;

public class Enemies extends  Character {
    private int numberOfEnemies;
    private boolean isMovingToRight = false;

    private JFrame frameInstance;
    private LevelsENUM.LEVELS level;

    private int screenWidth ;
    private int screenHeight;
    private int spaceBetween = 30;

    private int xInit;
    private int yInit;

    private int elementsPerRow = 0;
    private int lastCompleteRowElementIndex = 0;
    private int firstCompleteRowElementIndex = 0;

    public Enemies(int width, int height, int numberOfEnemies, LevelsENUM.LEVELS level, JFrame frameInstance) {
        super(width, height, true, "assets/enemy.jpg");

        this.frameInstance = frameInstance;
        this.numberOfEnemies = numberOfEnemies;

        this.level = level;

        screenWidth = frameInstance.getWidth();
        screenHeight = frameInstance.getHeight();
        xInit = screenWidth * 1/4;
        yInit = screenHeight * 1/10;
    }

    Character[] enemies = new Character[numberOfEnemies];

    public void initEnemies(Character[] uninitializedCharacters) {

        int currentX = xInit;
        int currentY = yInit;

        this.enemies = uninitializedCharacters;

        for(int i = 1; i<=numberOfEnemies; i++){
            if(currentX > (screenWidth - xInit - getWidth())){
                if(elementsPerRow == 0) elementsPerRow = i;
                lastCompleteRowElementIndex += elementsPerRow - 1;

                currentX = xInit;
                currentY += spaceBetween;
            }
            uninitializedCharacters[i] = new Character(getWidth(), getHeight(), currentX , currentY, true, "assets/enemy.jpg", frameInstance, 1);
            currentX += spaceBetween;
        }

        if(lastCompleteRowElementIndex == numberOfEnemies){
            firstCompleteRowElementIndex = lastCompleteRowElementIndex - elementsPerRow + 1;
        }else{
            firstCompleteRowElementIndex =  lastCompleteRowElementIndex+1;
        }

    }

    public void moveAllEnemies(){
        for(int i = 1; i<=numberOfEnemies; i++){
            if (isMovingToRight) {
                if(!enemies[lastCompleteRowElementIndex].areCoordinatesValid(enemies[lastCompleteRowElementIndex].getX() + spaceBetween, "x")){
                    isMovingToRight = !isMovingToRight;
                    break;
                } else{
                    enemies[i].moveRight();
                }
            } else {
                if(!enemies[firstCompleteRowElementIndex].areCoordinatesValid(enemies[firstCompleteRowElementIndex].getX() - spaceBetween, "x")){
                    isMovingToRight = !isMovingToRight;
                    enemies[firstCompleteRowElementIndex].moveRight();
                    break;
                } else{
                    enemies[i].moveLeft();
                }
            }
        }
    }
}
